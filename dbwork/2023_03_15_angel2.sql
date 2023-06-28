--����
--���̺� ���� (student) : num����(5),name���ڿ�(10),height����(5,1),java����(3) �⺻��10,spring����(3) �⺻��10, ban���ڿ�(20)
create table student(
num number(5),
name varchar(10),
height number(5,1),
java number(3) default 10,
spring number(3) default 10,
ban varchar(20)
);
select * from student;


--������ ���� seq_stu �⺻(1����1������), nocache �߰�
create SEQUENCE seq_stu nocache;
select * from seq;
--��������
--num�� primary key �߰�
alter table student add CONSTRAINT student_pk_num primary key(num);
--java,spring�� 1���� 100�� �����ϵ��� check���� �߰�
alter table student add CONSTRAINT student_ck_java check(java>=1 and java<=100);
alter table student add CONSTRAINT student_ck_spring check(spring>=1 and spring<=100);
--ban�� '�޴Թ�','�޴Թ�','���Թ�'�� �߰��Ҽ� �ֶǷ� check�߰�
alter table student add constraint student_ck_ban check (ban in('�޴Թ�','�޴Թ�','���Թ�'));

--5�� ������ �߰�
insert into student (num,name,java,height,ban) values (seq_stu.nextval,'������',09,167.5,'�޴Թ�');
insert into student values (seq_stu.nextval,'��ȿ��',178.6,67,88,'�޴Թ�');
insert into student values (seq_stu.nextval,'�踻��',155.6,100,90,'���Թ�');
insert into student values (seq_stu.nextval,'����',165.9,55,67,'�޴Թ�');
insert into student values (seq_stu.nextval,'��ö��',179.1,90,86,'�޴Թ�');

--num�� 17�� ����� java������ 99��, ban�� '�޴Թ�' ���� ����
update student set java=99, ban='�޴Թ�' where num=17;
--num�� 19�� ����� Ű�� 188.9�� ����
update student set height=188.9 where num=19;
--num�� 16�� ����� ������ ����
delete from student where num=16;
--��ȸ �̸� �� �ڹ� ������ ���� ���
select name �̸�, ban ��, java �ڹ�, spring ������, java+spring ����, (java+spring)/2 ��� from student order by ���� desc;

commit;

--DB ����ȭ(Normalization)
--����ȭ��? �Ѹ���� db������ �޸𸮸� �������� �ʱ� ���ؼ� � ���̺��� �ĺ��ڸ� ������ �������� ���̺�� ������ ������ ����ȭ ��� �Ѵ�
--����ȭ�� ������ ���̽��� �ߺ��� �ּ�ȭ �ǵ��� ����� �����ͺ��̽� �̴�.
--���� : �޸𸮸� �����Ҽ� �ִ�. ����ȭ�� �ý������� ���ؼ� ������ ���ϴ�
--���� : ��ȸ������ �ſ� ���� �ý����� ��쿡�� ���̺� ���� join������ �ݺ������� �̷����� ������ �������� �ӵ��� �ʾ����� �ִ�.

--student�� num�� �ܺ�Ű�� ���� ���ο� ���̺� stuinfo�� ����� ����
--�ܺ�Ű�� ���̺� ������ �����ص� �ǰ� �ϴ� ���� �� ���̺� �������� �߰��ص� �ȴ�
--ppt29
create table stuinfo(
    idx number(5) constraint info_pk_idx PRIMARY key,
    num number(5),
    addr varchar2(20),
    hp varchar2(15)
);
select * from stuinfo;

--�ܺ�Ű �������� �߰�
--stuinfo�� num�� student �� num���� ������ �ֵ��� ����
alter table stuinfo add constraint info_fk_num foreign key(num) REFERENCES student(num); --stu�� Ű�� �����ͼ� info�� 

--stuinfo�� num�� ���� 3�� �߰��ߴٸ� student ���̺��� num=3�� �����ʹ� �����Ҽ� ����
--�� �������� �߰��� on delete cascade�� �߰����� ���� �θ����̺��� num=3�� ������ ������
--stuinfo�� num=3�� ��� �����ʹ� �ڵ� ����

--sutinfo�� ������ �߰��ϤӤ�
insert into stuinfo values (seq_stu.nextval,17,'����� ������','010-2222-3333');
--student�� ���� 2���� �߰��غ��� :���Ἲ ��������(ANGEL.INFO_FK_NUM)�� ����Ǿ����ϴ�- �θ� Ű�� �����ϴ� - �����߻�
insert into stuinfo values (seq_stu.nextval,16,'����� ������','010-2222-3333');
--4���߰�
insert into stuinfo values (seq_stu.nextval,18,'����� ������','010-2222-3333');
insert into stuinfo values (seq_stu.nextval,15,'���ֵ� �ֿ���','010-7777-8888');
commit;

--��ȸ
--���� ��ȸ�� �� ��� ��� ������ �� �� ����.
select * from stuinfo;
--join���� �� ���̺��� ���ؼ� �ʿ��� ������ �����ͺ���. ppt43p
--inner join �Ǵ� equi join�̶�� �Ѵ�. ���� num���� ���� ��쿡�� �����´�.
select sd.num ������, sd.name �л���, sd.height Ű, sd.ban ��, si.addr �ּ�, si.hp �ڵ���, sd.java �ڹ�, sd.spring ������
from student sd, stuinfo si --��Ī�ذ�
where sd.num=si.num; --stu�� �ѹ��� info�� �ѹ��� ������

--�̶� ���� ���̺� ���������� �����ִ� �÷��� �����ϰ�� �տ� ���̺�� ���� ����(name,height,ban,addr,hp�� �� ���̺��� �����Ѱ͵��̶� sd. si. ������ �Ƚᵵ��//�׷��� �׳� ���ִ°� ����)
select sd.num ������, name �л���, height Ű, ban ��, addr �ּ�, hp �ڵ���, java �ڹ�, spring ������
from student sd, stuinfo si --��Ī�ذ�
where sd.num=si.num; --stu�� �ѹ��� info�� �ѹ��� ������

--outer join ���� �߰����� ���� �����͸� ã�ƺ���
--sub���̺��ʿ�(+)
select sd.num ������, name �л���, height Ű, ban ��, addr �ּ�, hp �ڵ���, java �ڹ�, spring ������
from student sd, stuinfo si --��Ī�ذ�
where sd.num=si.num(+); --sub���̺��ʿ� +//������ ��ȸ

select sd.num ������, name �л���, height Ű, ban ��, addr �ּ�, hp �ڵ���, java �ڹ�, spring ������
from student sd, stuinfo si --��Ī�ذ�
where sd.num=si.num(+) and addr is null; --sub���̺��ʿ� +//�߰����� ������(null)�� ���´�

--student ���̺��� num=1�� �����͸� �����غ��� : ORA-02292: ���Ἲ ��������(ANGEL.INFO_FK_NUM)�� ����Ǿ����ϴ�- �ڽ� ���ڵ尡 �߰ߵǾ����ϴ�
--�� ��� ���� ������ �ϰ������ stuinfo�� �����͸� ���� ���� �� student�� �����͸� ������ �� �ִ�
delete from student where num=15;

--sub ���̺��� num=15�� ���� ���� �� �θ����̺��� num=15�� �����غ���
delete from stuinfo where num=15;
delete from student where num=15;

--���̺� ���Ž� �������̺��� ���� ���� �� �θ����̺� ����
drop table stuinfo;
drop table student;


-------------------------------------------------------------------------------------------------------------------------------------
--�̹����� �θ� ���̺��� ����Ÿ ������ ���� ���̺��� ����Ÿ�� �ڵ����� �����ǵ���
--�ܺ�Ű�� �����غ���
--������ ����
create SEQUENCE seq_shop;
--shop,cart
create table shop(
    sang_no number(3) CONSTRAINT shop_pk_no PRIMARY key,
    sang_name varchar2(30),
    sang_price number(10)
);
--�ܺ�Ű ������ on delete cascade �� ������ �θ����̺� ���� �� �ڽ� ���̺� �߰���
--����Ÿ�� ���� ������
create table cart (
    cart_no number(3) constraint cart_pk_no primary key,
    sang_no number(3),
    cnt number(3),
    cartday date,
    constraint cart_fk_no foreign key(sang_no) references shop(sang_no) on delete cascade
);

--5���� ��ǰ ���
insert into shop values (seq_shop.nextval,'���콺',12000);
insert into shop values (seq_shop.nextval,'����',19000);
insert into shop values (seq_shop.nextval,'û����',25000);
insert into shop values (seq_shop.nextval,'üũ��Ʈ',99000);
insert into shop values (seq_shop.nextval,'Ƽ����',11000);
commit;

--3���� ��ǰ�� īƮ�� ��ƺ���
insert into cart values (seq_shop.nextval,2,3,sysdate);
insert into cart values (seq_shop.nextval,3,1,'2023-01-13');
insert into cart values (seq_shop.nextval,5,3,sysdate);
commit;

--��ȸ
--sang_no ��ǰ��ȣ, ��ǰ��, �ܰ�(ȭ�� ������ �ĸ�), ����, ������(��4-��2-��2 �������� ���)
select sp.sang_no ��ǰ��ȣ, sp.sang_name ��ǰ��, to_char(sp.sang_price,'L999,999') �ܰ�, ct.cnt ����, to_char(ct.cartday,'yyyy-mm-dd') ������
from shop sp, cart ct --��Ī�ذ�
where sp.sang_no=ct.sang_no;

--cart�� ����� ���� ��ǰ�� ��ǰ��ȣ�� ��ǰ�� ���
select sp.sang_no ��ǰ��ȣ, sp.sang_name ��ǰ��
from shop sp, cart ct --��Ī�ذ�
where sp.sang_no=ct.sang_no(+) and ct.cnt is null;

--����Ȯ��(2,3,5 ��ǰ�� cart�� �������)
--shop�� 2�� 3�� ��ǰ�� ���� �� cart ���̺��� Ȯ���غ�����
delete from shop where sang_no=2 or sang_no=3;

--���� ������ ��� ���̺�� �������� �������ּ���
drop SEQUENCE seq_shop;
drop sequence seq_stu;
drop sequence seq1;
drop sequence seq3;

drop table cart;
drop table shop;
drop table person;

--------------------------------------------------------------------------------------------------------------------------

--seq_food ������
create SEQUENCE seq_food;
--restaurant ���̺�
--food_num�⺻Ű, food_name���ڿ�(30), food_price����(7)
create table restaurant(
    food_num number(3) CONSTRAINT table_pk_num PRIMARY key,
    food_name varchar2(30),
    food_price number(7)
);
--resorder���̺�
--order_num�⺻Ű, order_name���ڿ�(20) food_num->restaurant�� food_num�� �ܺ�Ű�� ����(on delete cascade), 
--order_day��¥Ÿ��(���೯¥), jumun_day��¥Ÿ��(���糯¥����), inwon����(3)
create table resorder(
    order_num number(3) constraint resorder_pk_num primary key,
    order_name varchar2(20),
    food_num number(3),
    order_day date,
    jumun_day date default sysdate,
    inwon number(3),
    constraint resorder_fk_num foreign key(food_num) references restaurant(food_num) on delete cascade
);

--1.������ �߰��ϱ�
--���İ�Ƽ23000,���캺����11000,������19000,����Ƣ��10000,¥���5000
insert into restaurant values(seq_food.nextval,'���İ�Ƽ',23000);
insert into restaurant values(seq_food.nextval,'���캺����',11000);
insert into restaurant values(seq_food.nextval,'������',19000);
insert into restaurant values(seq_food.nextval,'����Ƣ��',10000);
insert into restaurant values(seq_food.nextval,'¥���',5000);
--2.�ֹ����̺�
--�̻�� ���İ�Ƽ�ֹ� ������2023-11-20 �ֹ���:����ð���� �ο���:4
--��ȣ�� ���캺�����ֹ� ������ 2023-12-25 �ֹ���:����ð���� �ο���:3
--��ȣ�� �������ֹ� ������ 2023-12-20 �ֹ���:����ð���� �ο���:3
--�̿��� ���İ�Ƽ�ֹ� ������ 2023-05-11 �ֹ���:����ð���� �ο���:2
insert into resorder values(seq_food.nextval,'�̻��',1,'2023-11-20',sysdate,4);
insert into resorder values(seq_food.nextval,'��ȣ��',2,'2023-12-25',sysdate,3);
insert into resorder values(seq_food.nextval,'��ȣ��',3,'2023-12-20',sysdate,3);
insert into resorder values(seq_food.nextval,'�̿���',1,'2023-05-11',sysdate,2);
--3.���
--�ֹ��� ������ ���ĸ� ���İ��� �ֹ���(��-��-�� ��:��) �ο���
select order_name �ֹ���, order_day ������, food_name ���ĸ�, to_char(food_price,'L999,999') ����, to_char(jumun_day,'YYYY-MM-DD HH:MI') �ֹ���, inwon �ο���
from restaurant rt, resorder od
where rt.food_num=od.food_num;
--4.������� �޴��� ������ ���� �� ���� ���̺����� �����Ǿ����� Ȯ���ϱ�
delete from restaurant  where food_num=3;