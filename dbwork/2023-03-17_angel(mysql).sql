 -- sawon 에 제약조건 추가하기
-- score 는 0~100만 추가 가능하도록 제약조건 추가
alter table sawon add constraint sawon_ck_score check (score between 0 and 100);
-- gender 에  '남자','여자'만 가능하도록 check 조건 추가
alter table sawon add constraint sawon_ck_gender check (gender in ('남자','여자'));

-- mysql 에서 제약조건 확인하기
select * from information_schema.table_constraints where table_name='sawon';

-- 데이터 추가
insert into sawon values (null,'이상이',78,'여자','홍보부');
insert into sawon (name,score,gender) values ('강호동',89,'남자');
insert into sawon values (null,'이효리',100,'여자','인사부');
insert into sawon values (null,'유재석',99,'남자','교육부');
insert into sawon values (null,'강민호',69,'남자','인사부');


-- 쿼리문 연습하기
-- 강씨 성을 가진 사람의 인원수 구하기
select count(*) from sawon where name like '강%';
-- 평균 점수보다 높은 사람 출력하기
select * from sawon where score>(select avg(score) from sawon);
-- 부서별 인원수와 평균점수 최고점수 최저점수 구하기(제목도 수정)
select buseo 부서명 ,count(*) 인원수, round(avg(score),-1) 평균점수, max(score) 최고점수, min(score) 최저점수 from sawon group by buseo;
-- 인사부에서 이씨성을 가진사람이 누가 있는지 출력
select * from sawon where buseo='인사부' and name like '이%';
-- 이효리의 부서를 '교육부'로 수정
update sawon set buseo='교육부' where name='이효리';

-- join 연습할 서브 테이블 생성 sawoninfo idx,num(외부키), addr,hp,age 컬럼 - 부모테이블 데이터 삭제시 
-- 서브테이블 데이터 자동 삭제하려면 제약조건 뒤에 on delete cascade 추가
create table sawoninfo(
	idx smallint auto_increment primary key,
    num int,
    addr varchar(30),
    hp varchar(20),
	age smallint,
    constraint info_fk_num foreign key(num) references sawon(num)
);
desc sawoninfo;
-- 제약조건도 확인
select * from information_schema.table_constraints where table_name='sawoninfo';
-- sawoninfo에 데이터 추가(반드시 sawon 의 num에 있는 값만 넣을수 있다)
insert into sawoninfo values (null,2,'강남구','0102222-3333',35);
insert into sawoninfo values (null,1,'강서구','0105656-3333',31);
insert into sawoninfo values (null,4,'영등포구','0101212-3333',28);
insert into sawoninfo values (null,5,'강동구','0109999-3333',25);

-- sawoninfo 데이터 확인
select * from sawoninfo;

-- sawon 테이블과 join 으로 사원정보 모두 출력하기
-- join 방법1(오라클)
select
sawon.num,name,gender,buseo,age,hp,addr,score
from sawon,sawoninfo info -- 별칭설정
where sawon.num=info.num ;

-- 컬럼명 대신 * 가능
select * from sawon, sawoninfo info where sawon.num=info.num;

-- join 방법2(mysql 
select sawon.num,name,gender,buseo,age,hp,addr,score
from sawon
inner join sawoninfo on sawon.num=sawoninfo.num; -- where대신 on쓰는 느낌

-- 기존 외부키 제약조건 제거하고 다시 주기(이번에는 on delete cascade 추가)
alter table sawoninfo drop CONSTRAINT info_fk_num;
alter table sawoninfo add CONSTRAINT info_fk_num foreign key(num) references sawon(num) on delete cascade;

-- on delete cascade : sawon 에서 2번 데이터 삭제시 sawoninfo에서도 삭제됨
delete from sawon where num=2;
-- join 으로 다시 데이터 다시 확인
select sawon.num,name,gender,buseo,age,hp,addr,score
from sawon
inner join sawoninfo on sawon.num=sawoninfo.num;

-- mysql 함수들 연습
select now() from dual; -- 현재 날짜와 시간
select year(now()) from dual; -- 2023 년도만 추출
select month(now()) from dual; -- 3 월만 추출
select monthname(now()) from dual; -- March 월 문자로 추출
select dayname(now()) from dual; -- Friday 요일을 문자로 추출
select dayofmonth(now()) from dual; -- 17 일 숫자 추출

-- 문자 함수
select concat('Happy','Day','!!') from dual; -- concat문자열 나열(갯수 상관없음. 오라클은 두개만됨)
select replace('Hello','e','*') from dual; -- 문자열 변경(대치)
select instr('Happy Day','Day') from dual; -- 문자가 어디서 시작했는지 위치찾기 자바의 indexof
select left('Bitcamp 701 Class',7) from dual; -- 왼쪽에서 7글자 추출 Bitcamp
select right('Bitcamp 701 Class',9) from dual; -- 오른쪽에서 9글자 추출 701 Class
select mid('Bitcamp 701 Class',9,3) from dual; -- 9번째부터 3글자 추출  701
select substring('Bitcamp 701 Class',9,3) from dual;  -- 9번째부터 3글자 추출 701
select concat('*',trim('	hello	'),'*') from dual; -- 양쪽 공백 제거
select concat('*',ltrim('	hello	'),'*') from dual; -- 왼쪽 공백 제거
select concat('*',rtrim('	hello	'),'*') from dual; -- 오른쪽 공백 제거
select ucase('Happy'),upper('Happy')from dual; -- 둘 다 대문자 변환(오라클은 upper)
select lcase('Happy'),lower('Happy')from dual; -- 둘 다 소문자 변환(오라클은 lower)
select reverse('Happy') from dual;

-- 숫자 함수
select ceiling(7.1),ceil(7.1) from dual; -- 무조건 올림(오라클은 ceil)
select floor(7.9) from dual; -- 무조건 내림
select round(7.47,1) from dual; -- 반올림
select mod(7,2) from dual; -- 나머지
select greatest(12,34,56,100,66) from dual; -- 가장 큰 숫자(오라클에도 있음)
select least(12,34,56,100,66) from dual; -- 가장 작은 숫자(오라클에도 있음)


select count(*) cnt from sawon, sawoninfo where sawon.num=sawoninfo.num;
select buseo  ,count(*) count, round(avg(score),-1) avgscore, max(score) maxscore, min(score) minscore from sawon group by buseo;












