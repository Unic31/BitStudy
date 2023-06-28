--문제
--테이블 생성 (student) : num숫자(5),name문자열(10),height숫자(5,1),java숫자(3) 기본값10,spring숫자(3) 기본값10, ban문자열(20)
create table student(
num number(5),
name varchar(10),
height number(5,1),
java number(3) default 10,
spring number(3) default 10,
ban varchar(20)
);
select * from student;


--시퀀스 생성 seq_stu 기본(1부터1씩증가), nocache 추가
create SEQUENCE seq_stu nocache;
select * from seq;
--제약조건
--num에 primary key 추가
alter table student add CONSTRAINT student_pk_num primary key(num);
--java,spring은 1부터 100만 가능하도록 check제약 추가
alter table student add CONSTRAINT student_ck_java check(java>=1 and java<=100);
alter table student add CONSTRAINT student_ck_spring check(spring>=1 and spring<=100);
--ban은 '햇님반','달님반','별님반'만 추가할수 있또록 check추가
alter table student add constraint student_ck_ban check (ban in('햇님반','달님반','별님반'));

--5개 데이터 추가
insert into student (num,name,java,height,ban) values (seq_stu.nextval,'김진아',09,167.5,'햇님반');
insert into student values (seq_stu.nextval,'이효리',178.6,67,88,'달님반');
insert into student values (seq_stu.nextval,'김말자',155.6,100,90,'별님반');
insert into student values (seq_stu.nextval,'이진',165.9,55,67,'달님반');
insert into student values (seq_stu.nextval,'이철수',179.1,90,86,'햇님반');

--num이 17인 사람의 java점수를 99로, ban을 '달님반' 으로 수정
update student set java=99, ban='달님반' where num=17;
--num이 19인 사람의 키를 188.9로 수정
update student set height=188.9 where num=19;
--num이 16인 사람의 데이터 삭제
delete from student where num=16;
--조회 이름 반 자바 스프링 총점 평균
select name 이름, ban 반, java 자바, spring 스프링, java+spring 총점, (java+spring)/2 평균 from student order by 총점 desc;

commit;

--DB 정규화(Normalization)
--정규화란? 한마디로 db서버의 메모리를 낭비하지 않기 위해서 어떤 테이블을 식별자를 가지는 여러개의 테이블로 나누는 과정을 정규화 라고 한다
--정규화된 데이터 베이스는 중복이 최소화 되도록 설계된 데이터베이스 이다.
--장점 : 메모리를 절약할수 있다. 구조화된 시스템으로 인해서 관리가 편하다
--단점 : 조회비율이 매우 높은 시스템의 경우에는 테이블 간의 join연산이 반복적으로 이뤄지기 때문에 질의응답 속도가 늦어질수 있다.

--student의 num을 외부키로 갖는 새로운 테이블 stuinfo를 만들어 보자
--외부키는 테이블 생성시 설정해도 되고 일단 생성 후 테이블 수정으로 추가해도 된다
--ppt29
create table stuinfo(
    idx number(5) constraint info_pk_idx PRIMARY key,
    num number(5),
    addr varchar2(20),
    hp varchar2(15)
);
select * from stuinfo;

--외부키 제약조건 추가
--stuinfo의 num은 student 의 num값만 넣을수 있도록 설정
alter table stuinfo add constraint info_fk_num foreign key(num) REFERENCES student(num); --stu의 키를 가져와서 info에 

--stuinfo의 num에 만약 3을 추가했다면 student 테이블에서 num=3인 데이터는 삭제할수 없다
--단 제약조건 추가시 on delete cascade를 추가했을 경우는 부모테이블의 num=3인 데이터 삭제시
--stuinfo의 num=3인 모든 데이터는 자동 삭제

--sutinfo에 데이터 추가하ㅣㄱ
insert into stuinfo values (seq_stu.nextval,17,'서울시 강남구','010-2222-3333');
--student에 없는 2번을 추가해보자 :무결성 제약조건(ANGEL.INFO_FK_NUM)이 위배되었습니다- 부모 키가 없습니다 - 오류발생
insert into stuinfo values (seq_stu.nextval,16,'서울시 강동구','010-2222-3333');
--4번추가
insert into stuinfo values (seq_stu.nextval,18,'서울시 강동구','010-2222-3333');
insert into stuinfo values (seq_stu.nextval,15,'제주도 애월읍','010-7777-8888');
commit;

--조회
--각각 조회를 할 경우 모든 정보를 알 수 없다.
select * from stuinfo;
--join으로 두 테이블을 합해서 필요한 정보를 가져와보자. ppt43p
--inner join 또는 equi join이라고 한다. 서로 num값이 같을 경우에만 가져온다.
select sd.num 시퀀스, sd.name 학생명, sd.height 키, sd.ban 반, si.addr 주소, si.hp 핸드폰, sd.java 자바, sd.spring 스프링
from student sd, stuinfo si --별칭준것
where sd.num=si.num; --stu의 넘버와 info의 넘버가 같으면

--이때 양쪽 테이블에 공통적으로 갖고있는 컬럼을 제외하고는 앞에 테이블명 생략 가능(name,height,ban,addr,hp는 각 테이블의 고유한것들이라 sd. si. 같은거 안써도됨//그래도 그냥 써주는게 좋음)
select sd.num 시퀀스, name 학생명, height 키, ban 반, addr 주소, hp 핸드폰, java 자바, spring 스프링
from student sd, stuinfo si --별칭준것
where sd.num=si.num; --stu의 넘버와 info의 넘버가 같으면

--outer join 으로 추가되지 않은 데이터를 찾아보자
--sub테이블쪽에(+)
select sd.num 시퀀스, name 학생명, height 키, ban 반, addr 주소, hp 핸드폰, java 자바, spring 스프링
from student sd, stuinfo si --별칭준것
where sd.num=si.num(+); --sub테이블쪽에 +//모조리 조회

select sd.num 시퀀스, name 학생명, height 키, ban 반, addr 주소, hp 핸드폰, java 자바, spring 스프링
from student sd, stuinfo si --별칭준것
where sd.num=si.num(+) and addr is null; --sub테이블쪽에 +//추가되지 않은것(null)만 나온다

--student 테이블의 num=1인 데이터를 삭제해보자 : ORA-02292: 무결성 제약조건(ANGEL.INFO_FK_NUM)이 위배되었습니다- 자식 레코드가 발견되었습니다
--이 경우 만약 삭제를 하고싶으면 stuinfo의 데이터를 먼저 삭제 후 student의 데이터를 삭제할 수 있다
delete from student where num=15;

--sub 테이블의 num=15을 먼저 삭제 후 부모테이블의 num=15를 삭제해보자
delete from stuinfo where num=15;
delete from student where num=15;

--테이블 제거시 서브테이블을 먼저 제거 후 부모테이블 제거
drop table stuinfo;
drop table student;


-------------------------------------------------------------------------------------------------------------------------------------
--이번에는 부모 테이블의 데이타 삭제시 서브 테이블의 데이타도 자동으로 삭제되도록
--외부키를 설정해보자
--시퀀스 생성
create SEQUENCE seq_shop;
--shop,cart
create table shop(
    sang_no number(3) CONSTRAINT shop_pk_no PRIMARY key,
    sang_name varchar2(30),
    sang_price number(10)
);
--외부키 설정시 on delete cascade 를 붙히면 부모테이블 삭제 시 자식 테이블에 추가된
--데이타도 같이 삭제됨
create table cart (
    cart_no number(3) constraint cart_pk_no primary key,
    sang_no number(3),
    cnt number(3),
    cartday date,
    constraint cart_fk_no foreign key(sang_no) references shop(sang_no) on delete cascade
);

--5개의 상품 등록
insert into shop values (seq_shop.nextval,'블라우스',12000);
insert into shop values (seq_shop.nextval,'조끼',19000);
insert into shop values (seq_shop.nextval,'청바지',25000);
insert into shop values (seq_shop.nextval,'체크코트',99000);
insert into shop values (seq_shop.nextval,'티셔츠',11000);
commit;

--3개의 제품을 카트에 담아보자
insert into cart values (seq_shop.nextval,2,3,sysdate);
insert into cart values (seq_shop.nextval,3,1,'2023-01-13');
insert into cart values (seq_shop.nextval,5,3,sysdate);
commit;

--조회
--sang_no 상품번호, 상품명, 단가(화폐 단위에 컴마), 수량, 구입일(년4-월2-일2 형식으로 출력)
select sp.sang_no 상품번호, sp.sang_name 상품명, to_char(sp.sang_price,'L999,999') 단가, ct.cnt 수량, to_char(ct.cartday,'yyyy-mm-dd') 구입일
from shop sp, cart ct --별칭준것
where sp.sang_no=ct.sang_no;

--cart에 담기지 않은 상품의 상품번호와 상품명 출력
select sp.sang_no 상품번호, sp.sang_name 상품명
from shop sp, cart ct --별칭준것
where sp.sang_no=ct.sang_no(+) and ct.cnt is null;

--삭제확인(2,3,5 상품이 cart에 담겨있음)
--shop의 2번 3번 상품을 삭제 후 cart 테이블을 확인해보세요
delete from shop where sang_no=2 or sang_no=3;

--오늘 연습한 모든 테이블과 시퀀스를 제거해주세요
drop SEQUENCE seq_shop;
drop sequence seq_stu;
drop sequence seq1;
drop sequence seq3;

drop table cart;
drop table shop;
drop table person;

--------------------------------------------------------------------------------------------------------------------------

--seq_food 시퀸스
create SEQUENCE seq_food;
--restaurant 테이블
--food_num기본키, food_name문자열(30), food_price숫자(7)
create table restaurant(
    food_num number(3) CONSTRAINT table_pk_num PRIMARY key,
    food_name varchar2(30),
    food_price number(7)
);
--resorder테이블
--order_num기본키, order_name문자열(20) food_num->restaurant의 food_num을 외부키로 설정(on delete cascade), 
--order_day날짜타입(예약날짜), jumun_day날짜타입(현재날짜저장), inwon숫자(3)
create table resorder(
    order_num number(3) constraint resorder_pk_num primary key,
    order_name varchar2(20),
    food_num number(3),
    order_day date,
    jumun_day date default sysdate,
    inwon number(3),
    constraint resorder_fk_num foreign key(food_num) references restaurant(food_num) on delete cascade
);

--1.데이터 추가하기
--스파게티23000,새우볶음밥11000,전복죽19000,새우튀김10000,짜장면5000
insert into restaurant values(seq_food.nextval,'스파게티',23000);
insert into restaurant values(seq_food.nextval,'새우볶음밥',11000);
insert into restaurant values(seq_food.nextval,'전복죽',19000);
insert into restaurant values(seq_food.nextval,'새우튀김',10000);
insert into restaurant values(seq_food.nextval,'짜장면',5000);
--2.주문테이블
--이상아 스파게티주문 예약일2023-11-20 주문일:현재시간등록 인원수:4
--강호동 새우볶음밥주문 예약일 2023-12-25 주문일:현재시간등록 인원수:3
--강호동 전복죽주문 예약일 2023-12-20 주문일:현재시간등록 인원수:3
--이영자 스파게티주문 예약일 2023-05-11 주문일:현재시간등록 인원수:2
insert into resorder values(seq_food.nextval,'이상아',1,'2023-11-20',sysdate,4);
insert into resorder values(seq_food.nextval,'강호동',2,'2023-12-25',sysdate,3);
insert into resorder values(seq_food.nextval,'강호동',3,'2023-12-20',sysdate,3);
insert into resorder values(seq_food.nextval,'이영자',1,'2023-05-11',sysdate,2);
--3.출력
--주문자 예약일 음식명 음식가격 주문일(연-월-일 시:분) 인원수
select order_name 주문자, order_day 예약일, food_name 음식명, to_char(food_price,'L999,999') 가격, to_char(jumun_day,'YYYY-MM-DD HH:MI') 주문일, inwon 인원수
from restaurant rt, resorder od
where rt.food_num=od.food_num;
--4.레스토랑 메뉴중 전복죽 삭제 후 예약 테이블에서도 삭제되었는지 확인하기
delete from restaurant  where food_num=3;