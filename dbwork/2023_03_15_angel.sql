--ppt23 ������ table
--table ���� (person) : ��ȣ �̸� ���� ���� ���� ��¥
create table person(
    num number(3) primary key,--�÷��̸�,Ÿ��(�뷮,�ڸ���), �Ȱ��� ������ �ȵǸ鼭 null�� ������� ����(����ũ)
    name varchar2(15) not null,--null�� ��� ��������(������ �� �־����)
    age number(3),--���ָ� null��
    gender varchar2(10) DEFAULT '����',--�� ���ָ� �⺻�� '����'
    city varchar2(15) DEFAULT '����',
    today date
);
select * from person;

--insert �÷� ������ �Ϻθ� �߰��� ���
insert into person (num,name,today) values (1,'ȫ�浿',sysdate);
--pk(primary key), nn(not null)�� ��� ���� �ȳ־��ָ� �����߻�-Ȯ��
insert into person (name,age,today) values ('��ö��',23,'2022-10-10');--����:ORA-01400: NULL�� ("ANGEL"."PERSON"."NUM") �ȿ� ������ �� �����ϴ�
--nn�Ӽ��� �� �÷��� ������ �־���� �Ѵ�, �̹����� num�� ���� �����͸� �־��

insert into person (num,name,age,today) values (1,'��ö��',23,'2022-10-10');--����:ORA-00001: ���Ἲ ���� ����(ANGEL.SYS_C008318)�� ����˴ϴ�
insert into person (num,name,age,today) values (2,'��ö��',23,'2022-10-10');--��¥���·� ���ڿ�ó�� �־��൵ �ȴ�
--�Ϻ� �÷��� �ƴ϶� ������� ��� �÷����� ���� ��� �÷� �� ���� ����
insert into person values(3,'��ȣ��',33,'����','���ֵ�','2021-12-25');
insert into person values(4,'��ȿ��',27,'����','�λ�','2023-01-25');
insert into person values(5,'������',45,'����','�ϻ�',sysdate);
insert into person values(6,'����',39,'����','����','2022-05-10');
insert into person values(7,'������',19,'����','����','2020-11-22');
insert into person values(8,'��ȣ��',41,'����','�뱸',sysdate);
insert into person values(9,'������',32,'����','�λ�','2019-09-25');
insert into person values(10,'��ȿ��',28,'����','���ֵ�','2021-12-11');
commit;--crud�� �ѹ� ����
select * from person;--select delete ���� from ��
--�������� age, city ����
update person set age=26, city='���ֵ�' where name='������';
--ȫ�浿�� ���� ����
update person set age=29 where name='ȫ�浿';
--������ today �� ���糯¥�� ����
update person set today=sysdate where name='����';
commit;
--delete : where ���� �Ⱦ��� ��ü ��� ������
delete from person;
--�ٽ� �츮��
rollback;--������ Ŀ�� ���� ������ �ѹ�
--������ �̿��ؼ� ����
delete from person where name='ȫ�浿';
--�ϾƱ� 30�� �̸��ΰ�� ����
delete from person where age<30;

--���̺� ������ �����ϴ� ����
--���̺� �÷� �߰�(alter:��������)
alter table person add score number(3) default 50;

--��� �߰��� score �÷� ����
alter table person drop column score;

--�÷� Ÿ�� ����
alter table person modify city varchar2(20);

--�÷��� ���� today-ipsaday�� ����
alter table person rename column today to ipsaday;--colum�� drop�� rename�ڿ��� �´�

--�������� ���� : name�� nn ���������� ����ִ�(�������� �̸��� ���༭ �⺻ �̸����� ���ִ�)SYS_C008317
alter table person drop constraint sys_c008317;

--ppt30
--name�� ���ο� ���������� �߰��غ���(unique)
alter table person add CONSTRAINT person_uq_name unique(name);

--�̸��� ���� �̸��� ������ ���� ������ �߻�
insert into person (num,name) values (11,'��ȣ��');

--gender�� '����','����'���� �����͸� ������ �������߻��ǵ��� check(���ǿ� �ٸ����� ����) ���������� �߰�'
alter table person add constraint person_ck_genger check (gender in ('����','����'));

--age�� 10~50���� �߰� �����ϵ���
alter table person add CONSTRAINt person_ck_age check(age>=10 and age<=50);

--�������ǿ� ����ǵ��� ���̸� �߰��غ���
insert into person (num,name,age) values (100,'�̻��',60);

--����
--pk���������� ���� �� person_pk_num �̶�� ���ο� ���������� �߰��غ���
alter table person drop constraint SYS_C008318;
alter table person add CONSTRAINT person_pk_num primary key(num);

--����2
--buseo ��� �÷��� �߰� varchar2(10) �⺻���� '������'
alter table person add buseo varchar2(10) DEFAULT'������';
--buseo �� �������� �߰� '������', 'ȫ����', '�λ��' 3���� �߰��� �����ϵ���
alter table person add CONSTRAINT person_ck_buseo check(buseo in ('������','ȫ����','�λ��'));

--����3 
--����, �̾����� ���� ������� ��� '�λ��'�� ������ ����
update person set buseo='�λ��' where name like '��%' or name like '��%';
--�ھ�, �达���� ���� ������� ��� 'ȫ����'�� ����
update person set buseo='ȫ����' where name like '��%' or name like '��%';

--����4
--���� ���� ������ �ο����� ��ճ���(����Ÿ��) ���ϱ�, �ο����� �����ͺ��� ���
select gender ����, count(*)�ο���, ceil(avg(age))��ճ��� from person group by gender order by 2 desc;
select gender ����, count(*)�ο���, round(avg(age),0)��ճ��� from person group by gender order by 2 desc;
--�μ����� �ο����� ��ճ��� ���ϱ�, �μ����� ������������ ���
select buseo, count(*), round(avg(age),0) from person group by buseo order by 1;

--������sequence �����ϴ� ��� ppt 78p
--���� ���� ����ϴ� �⺻ ������ : 1���� 1�� �����ϴ� ������
create SEQUENCE seq1;
create SEQUENCE seq2 start with 1 increment by 1;--���� ����
create sequence seq3 start with 10 increment by 5 nocache;--nocache : cache�� 0����//10���� 5��
create sequence seq4 maxvalue 100;--max���� 100������ �߻�
--������ ��ȸ
select * from seq;
--table ��ȸ
select * from tab;

--������ ����
drop sequence seq2;
drop sequence seq4;

--������ �߻� nextval, ���簪 currval
select seq1.nextval,seq3.nextval from dual;--�ݺ��ؼ� �����غ���

select seq1.currval,seq3.currval from dual;





