--ppt23 페이지 table
--table 생성 (person) : 번호 이름 나이 성별 지역 날짜
create table person(
    num number(3) primary key,--컬럼이름,타입(용량,자릿수), 똑같은 데이터 안되면서 null값 허용하지 않음(유니크)
    name varchar2(15) not null,--null값 허용 하지않음(무조건 값 넣어야함)
    age number(3),--안주면 null값
    gender varchar2(10) DEFAULT '남자',--값 안주면 기본값 '남자'
    city varchar2(15) DEFAULT '서울',
    today date
);
select * from person;

--insert 컬럼 데이터 일부만 추가할 경우
insert into person (num,name,today) values (1,'홍길동',sysdate);
--pk(primary key), nn(not null)인 경우 값을 안넣어주면 오류발생-확인
insert into person (name,age,today) values ('강철수',23,'2022-10-10');--오류:ORA-01400: NULL을 ("ANGEL"."PERSON"."NUM") 안에 삽입할 수 없습니다
--nn속성이 들어간 컬럼은 무조건 넣어줘야 한다, 이번에는 num에 같은 데이터를 넣어보자

insert into person (num,name,age,today) values (1,'강철수',23,'2022-10-10');--오류:ORA-00001: 무결성 제약 조건(ANGEL.SYS_C008318)에 위배됩니다
insert into person (num,name,age,today) values (2,'강철수',23,'2022-10-10');--날짜형태로 문자열처럼 넣어줘도 된다
--일부 컬럼이 아니라 순서대로 모든 컬럼값을 넣을 경우 컬럼 명 생략 가능
insert into person values(3,'강호순',33,'여자','제주도','2021-12-25');
insert into person values(4,'이효리',27,'여자','부산','2023-01-25');
insert into person values(5,'김진수',45,'남자','일산',sysdate);
insert into person values(6,'이진',39,'여자','뉴욕','2022-05-10');
insert into person values(7,'박지윤',19,'여자','김포','2020-11-22');
insert into person values(8,'강호동',41,'남자','대구',sysdate);
insert into person values(9,'박지나',32,'여자','부산','2019-09-25');
insert into person values(10,'이효진',28,'여자','제주도','2021-12-11');
commit;--crud만 롤백 가능
select * from person;--select delete 에만 from 들어감
--박지나의 age, city 수정
update person set age=26, city='제주도' where name='박지나';
--홍길동의 나의 수정
update person set age=29 where name='홍길동';
--이진의 today 를 현재날짜로 수정
update person set today=sysdate where name='이진';
commit;
--delete : where 조건 안쓰면 전체 모두 삭제됨
delete from person;
--다시 살리기
rollback;--마지막 커밋 이후 까지만 롤백
--조건을 이용해서 삭제
delete from person where name='홍길동';
--니아기 30세 미만인경우 삭제
delete from person where age<30;

--테이블 구조를 수정하는 연습
--테이블에 컬럼 추가(alter:구조수정)
alter table person add score number(3) default 50;

--방금 추가한 score 컬럼 제거
alter table person drop column score;

--컬럼 타입 수정
alter table person modify city varchar2(20);

--컬럼명 변경 today-ipsaday로 변경
alter table person rename column today to ipsaday;--colum은 drop와 rename뒤에만 온다

--제약조건 제거 : name에 nn 제약조건이 들어있다(제약조건 이름을 안줘서 기본 이름으로 들어가있다)SYS_C008317
alter table person drop constraint sys_c008317;

--ppt30
--name에 새로운 제약조건을 추가해보자(unique)
alter table person add CONSTRAINT person_uq_name unique(name);

--이름에 같은 이름을 넣으면 이제 오류가 발생
insert into person (num,name) values (11,'강호동');

--gender에 '남자','여자'외의 데이터를 넣으면 오류가발생되도록 check(조건외 다른값은 에러) 제약조건을 추가'
alter table person add constraint person_ck_genger check (gender in ('남자','여자'));

--age에 10~50세만 추가 가능하도록
alter table person add CONSTRAINt person_ck_age check(age>=10 and age<=50);

--제약조건에 위배되도록 나이를 추가해보자
insert into person (num,name,age) values (100,'이상아',60);

--문제
--pk제약조건을 제거 후 person_pk_num 이라는 새로운 제약조건을 추가해보자
alter table person drop constraint SYS_C008318;
alter table person add CONSTRAINT person_pk_num primary key(num);

--문제2
--buseo 라는 컬럼을 추가 varchar2(10) 기본값을 '교육부'
alter table person add buseo varchar2(10) DEFAULT'교육부';
--buseo 에 제약조건 추가 '교육부', '홍보부', '인사부' 3개만 추가가 가능하도록
alter table person add CONSTRAINT person_ck_buseo check(buseo in ('교육부','홍보부','인사부'));

--문제3 
--강씨, 이씨성을 가진 사람들은 모두 '인사부'로 데이터 수정
update person set buseo='인사부' where name like '강%' or name like '이%';
--박씨, 김씨성을 가진 사람들은 모두 '홍보부'로 수정
update person set buseo='홍보부' where name like '박%' or name like '김%';

--문제4
--남자 여자 성별로 인원수와 평균나이(정수타입) 구하기, 인원수가 많은것부터 출력
select gender 성별, count(*)인원수, ceil(avg(age))평균나이 from person group by gender order by 2 desc;
select gender 성별, count(*)인원수, round(avg(age),0)평균나이 from person group by gender order by 2 desc;
--부서별로 인원수와 평균나이 구하기, 부서명의 오름차순으로 출력
select buseo, count(*), round(avg(age),0) from person group by buseo order by 1;

--시퀀스sequence 생성하는 방법 ppt 78p
--가장 많이 사용하는 기본 시퀀스 : 1부터 1씩 증가하는 시퀀스
create SEQUENCE seq1;
create SEQUENCE seq2 start with 1 increment by 1;--위와 같다
create sequence seq3 start with 10 increment by 5 nocache;--nocache : cache를 0으로//10부터 5씩
create sequence seq4 maxvalue 100;--max값이 100까지만 발생
--시퀀스 조회
select * from seq;
--table 조회
select * from tab;

--시퀀스 제거
drop sequence seq2;
drop sequence seq4;

--다음값 발생 nextval, 현재값 currval
select seq1.nextval,seq3.nextval from dual;--반복해서 실행해본다

select seq1.currval,seq3.currval from dual;





