--PLSQL ������ ���̺�� ������ ������ ����
CREATE SEQUENCE SEQ_TEST NOCACHE;--1���� 1�� �����ϴ� ������(CACHE SIZE:0)
CREATE TABLE SHOP(
    NUM NUMBER(3) CONSTRAINT SHOP_PK_NUM PRIMARY KEY,
    SANGPUM VARCHAR2(30),
    SU NUMBER(3),
    DAN NUMBER(7),
    TODAY DATE
);

--�⺻ ������ 5�� �߰�
INSERT INTO SHOP VALUES (SEQ_TEST.NEXTVAL, 'û����', 2, 19000, SYSDATE);
INSERT INTO SHOP VALUES (SEQ_TEST.NEXTVAL, '�����', 1, 21000, SYSDATE);
INSERT INTO SHOP VALUES (SEQ_TEST.NEXTVAL, '������', 1, 23000, SYSDATE);
INSERT INTO SHOP VALUES (SEQ_TEST.NEXTVAL, 'Ƽ����', 3, 27000, SYSDATE);
INSERT INTO SHOP VALUES (SEQ_TEST.NEXTVAL, '���콺', 2, 32000, SYSDATE);
COMMIT;

--PL-SQL : SQL �� ������ ��Ҹ� �߰��ؼ� ���α׷����Ѱ��� PLSQL�̶�� �Ѵ�
--DECLARE
--  ��������,
--BEGIN
-- ���� ��� �Ǵ� ������
--	DBMS_OUTPUT.PUT_LINE(); ������¸�ɾ�(�ڹ� PLITNLN������)
--END;

--SET SERVEROUTPUT ON --�ܼ�â���� ����� ������ �ϱ�. �⺻���� OFF
--SET SERVEROUTPUT OFF --�ܼ�â���� ����� �ȳ����� �ϱ�

DECLARE
    V_NO NUMBER(4,1);--4�ڸ� ����,�Ҽ������� ���ڸ��� �����͸� �ְڴ�
BEGIN
    V_no:=10;--�� ����
	DBMS_OUTPUT.PUT_LINE('���ڴ�'||v_no||'�Դϴ�');--���
END;
/


--shop���� Ư�� ��ǰ ���� ������
DECLARE
    v_sangpum varchar2(30);
    v_su number(3);
    v_dan number(7);
    v_num number(3):=1;--�˻��ؼ� ������ num��
BEGIN
    select  sangpum,su,dan
    into v_sangpum, v_su, v_dan --�޾ƿ� ������
    from shop where num=v_num;
    
	DBMS_OUTPUT.PUT_LINE(v_num||'�� ��ǰ ����');
    DBMS_OUTPUT.PUT_LINE('��ǰ�� : '||v_sangpum);
    DBMS_OUTPUT.PUT_LINE('���� : '||v_su);
    DBMS_OUTPUT.PUT_LINE('�ܰ� : '||v_dan);
    DBMS_OUTPUT.PUT_LINE('�ѱݾ� : '||v_su*v_dan);
END;
/

--���� �ڵ带 �����ؼ� ��ǰ������ �˻��ؼ� �����͸� ����Ͻÿ�
DECLARE
    v_sangpum varchar2(30):='û����';
    v_su number(3);
    v_dan number(7);
    v_num number(3);
BEGIN
    select  num,su,dan
    into v_num, v_su, v_dan --�޾ƿ� ������
    from shop where sangpum=v_sangpum;
    
	DBMS_OUTPUT.PUT_LINE(v_sangpum||'��ǰ ����');
    DBMS_OUTPUT.PUT_LINE('�������� : '||v_num);
    DBMS_OUTPUT.PUT_LINE('���� : '||v_su);
    DBMS_OUTPUT.PUT_LINE('�ܰ� : '||v_dan);
    DBMS_OUTPUT.PUT_LINE('�ѱݾ� : '||v_su*v_dan);
END;
/

--���ǹ�
/*
    if ���ǽ� then
        ����1;
    else
        ����2;
    end if;
    
--�������ǹ�
    if ���ǽ�1 then
        ����1;
    elsif ���ǽ�2 then
        ����2;
    ..........
    else
        ����n;
    end if;
*/
--Ư���⵵���ϱ�
DECLARE
    v_year number(4):=2023;
    v_mod number(2):=mod(v_year,12);--�⵵�� 12�� ���� ������
    v_ddi varchar(10);--�츦 ���ؼ� ����
BEGIN
    if v_mod=0 then v_ddi:='������';
    elsif v_mod=1 then v_ddi:='��';
    elsif v_mod=2 then v_ddi:='��';
    elsif v_mod=3 then v_ddi:='����';
    elsif v_mod=4 then v_ddi:='��';
    elsif v_mod=5 then v_ddi:='��';
    elsif v_mod=6 then v_ddi:='ȣ����';
    elsif v_mod=7 then v_ddi:='�䳢';
    elsif v_mod=8 then v_ddi:='��';
    elsif v_mod=9 then v_ddi:='��';
    elsif v_mod=10 then v_ddi:='��';
    else v_ddi:='��';
    end if;
	DBMS_OUTPUT.PUT_LINE(v_year||'�����'||v_ddi||'�Դϴ�');
END;
/
--�⵵�� Ű����� �Է� �޾Ƽ� �츦 �˾ƺ��� �ֵ��� �����ϱ�
accept k_year prompt '�⵵ 4�ڸ��� �Է��� �ּ���';--Ű �Է°� ����
DECLARE
    v_year number(4):='&k_year';--Ű����� �Է¹��� accept ������ ��������� ����
    v_mod number(2):=mod(v_year,12);--�⵵�� 12�� ���� ������
    v_ddi varchar(10);--�츦 ���ؼ� ����
BEGIN
    if v_mod=0 then v_ddi:='������';
    elsif v_mod=1 then v_ddi:='��';
    elsif v_mod=2 then v_ddi:='��';
    elsif v_mod=3 then v_ddi:='����';
    elsif v_mod=4 then v_ddi:='��';
    elsif v_mod=5 then v_ddi:='��';
    elsif v_mod=6 then v_ddi:='ȣ����';
    elsif v_mod=7 then v_ddi:='�䳢';
    elsif v_mod=8 then v_ddi:='��';
    elsif v_mod=9 then v_ddi:='��';
    elsif v_mod=10 then v_ddi:='��';
    else v_ddi:='��';
    end if;
	DBMS_OUTPUT.PUT_LINE(v_year||'�����'||v_ddi||'�Դϴ�');
END;
/

--���ڸ� �Է¹޾� 12�Է½� 12�� ¦���Դϴ�, 11�Է½� 11�� Ȧ���Դϴ�
accept k_num prompt '���ڸ� �Է����ּ���';
DECLARE
    v_su number(5):='&k_num';
BEGIN
   if mod(v_su,2)=0 then
	DBMS_OUTPUT.PUT_LINE(v_su||'�� ¦���Դϴ�');
    else
    DBMS_OUTPUT.PUT_LINE(v_su||'�� Ȧ���Դϴ�');
    end if;
END;
/

/*
    �ݺ���
    loop
        ��ɵ�;
        exit when;--break������
    end loop;

*/

--������
--accept k_dan prompt '���ڸ� �Է����ּ���';
DECLARE
    v_dan number(5):='&k_dan';
    v_idx number(1):=1;
BEGIN
    DBMS_OUTPUT.PUT_LINE('**['||v_dan||'��]**');
    loop
        DBMS_OUTPUT.PUT_LINE(v_dan||'x'||v_idx||'='||v_dan*v_idx);
        v_idx:=v_idx+1;--i++������
        exit when v_idx>9;
    end loop;
END;
/

/*
    �Ǵٸ� ���ǹ�case --switch������
    
    ���� :=
        case ǥ����
            when ��1 then ���1
            when ��2 then ���2
            when ��3 then ���3
            else ���4
        end;
*/

DECLARE
    v_grade char(1):='B';
    v_msg varchar(15);
BEGIN
    v_msg:=
        case v_grade
            when 'A' then 'Excellent!!'
            when 'B' then 'Very Good!!'
            when 'C' then 'Good!!'
            else 'Try!'
        end;
        DBMS_OUTPUT.PUT_LINE(v_grade||'������'||v_msg);
END;
/

--exceptionó��(���������� ó��)
DECLARE
    v_sangpum varchar2(30):='&k_sang';--Ű����� �Է½� ������ ��ǰ��
    v_su number(3);
    v_dan number(7);
    v_num number(3);
BEGIN
    select  num,su,dan
    into v_num, v_su, v_dan --�޾ƿ� ������
    from shop where sangpum=v_sangpum;
    
	DBMS_OUTPUT.PUT_LINE(v_sangpum||'��ǰ ����');
    DBMS_OUTPUT.PUT_LINE('�������� : '||v_num);
    DBMS_OUTPUT.PUT_LINE('���� : '||v_su);
    DBMS_OUTPUT.PUT_LINE('�ܰ� : '||v_dan);
    DBMS_OUTPUT.PUT_LINE('�ѱݾ� : '||v_su*v_dan);
    
    --����Ŭ���� ����ó�� �ϴ� ���
    exception
        when NO_DATA_FOUND then --�����̸�
        DBMS_OUTPUT.PUT_LINE(v_sangpum||'�� DB�� ����');
        when TOO_MANY_ROWS then
        DBMS_OUTPUT.PUT_LINE(v_sangpum||'�� ������ ����');
    when OTHERS then
        DBMS_OUTPUT.PUT_LINE('���ܹ߻���');
END;
/

--shop ���̺� ����
--shop ���̺� color Į���� �߰��ϰ� �⺻���� 'green'
alter table shop add color varchar2(20) default 'green';
--3�� pink�� ����, 5���� yellow�� ����
update shop set color='pink' where num=3;
update shop set color='yellow' where num=5;
--������ �߰�:�ߺ��� ��ǰ�� �־����
insert into shop values (seq_test.nextval,'���콺',1,19000,sysdate,'orange');
insert into shop values (seq_test.nextval,'�ݹ���',3,34000,sysdate,'blue');
insert into shop values (seq_test.nextval,'���̽�Ƽ����',4,7000,sysdate,'gray');
insert into shop values (seq_test.nextval,'������û����',2,99000,sysdate,'darkblue');
commit;

/*
    for �ݺ���
    for ������ in [reverse] ���۰�..������ loop
        �ݺ���ų�����;
    end loop;
*/
DECLARE
    v_bdan number(5):= '&k_bdan';
    v_num number(2);
BEGIN
	DBMS_OUTPUT.PUT_LINE(v_bdan||'��');
    for v_num in 1..9 loop
    DBMS_OUTPUT.PUT_LINE(v_bdan||'x'||v_num||'='||v_bdan*v_num);
    end loop;
END;
/
--db�� Ÿ���� �����ϴ� ���
--db�� �����͸� ���ڵ� ������ �������� ���
DECLARE
    v_sang shop.sangpum%type :='Ƽ����';--db�� sangpum Ÿ���� ����(�ٲ���� ������)//shop�̶�� ���̺���sangpum�̶�� �÷��� Ÿ���� ������
    v_shop angel.shop%rowtype; --���ڵ������ �����͸� �б� ���� ����//angel������ shop�̶�� ���̺��� row�� ��� ������
BEGIN
    select *
    into v_shop
    from shop
    where sangpum=v_sang;
    
	DBMS_OUTPUT.PUT_LINE('��ǰ��:'||v_shop.sangpum);
    DBMS_OUTPUT.PUT_LINE('����:'||v_shop.color);
    DBMS_OUTPUT.PUT_LINE('����:'||v_shop.su);
    DBMS_OUTPUT.PUT_LINE('�ܰ�:'||v_shop.dan);
    DBMS_OUTPUT.PUT_LINE('������:'||v_shop.today);
END;
/
 /*
    ���� ���ڵ� ��ȸ��
    cursorĿ����
    is
    select ����; --select ��ȸ�� ����� cursor �� ����
    
    for ���ڵ�� in Ŀ���� loop
    ���;
    end loop;
 */
 
DECLARE
    cursor s1
    is
    select * from shop order by dan desc;
    
    v_cnt number(5);
    
BEGIN
	DBMS_OUTPUT.PUT_LINE('��ȣ    ��ǰ�� ����  ����  �ܰ�  ������');
    for s in s1 loop --*������ 
    DBMS_OUTPUT.PUT_LINE(s.num||'   '||s.sangpum||' '||s.color||'   '||s.su||'  '||s.dan||' '||s.today);
    end loop;
    
    select count(*) into v_cnt from shop;--shop���κ��� count���� v_cnt�� �����´�
    DBMS_OUTPUT.PUT_LINE('�� '||v_cnt||'���� ��ǰ�� �ֽ��ϴ�');
END;
/
 
/*
    Ű����� ��ǰ�� �Ϻθ� �Է¹޾� �ش� ��ǰ���� ����Ͻÿ�
    
    ���� '����'��� �Է� �� �� �װ��� ��ǰ�� �ֽ��ϴ�
    
    ��ǰ�� : û����
    ���� : yellow
    �ܰ� : 23000
    .
    .
    .
    ���� �������
    ���� ��ǰ�� ��Ͽ� �����ϴ� ���
*/

DECLARE
    v_serach shop.sangpum%type := '&sang';
    
    cursor s1
    is
--    select * from shop where sangpum like '%'||v_serach||'%';
    select * from shop where instr(sangpum, v_serach) > 0;
    -- instr(sangpum, v_serach) --��ǰ�߿� ã�°��� ��������� 1 ���� �� ū ���� ���
    
    v_cnt number(5);
    
BEGIN
    --�ϴ� �˻� �ܾ ���Ե� ��ǰ �������� ���ϱ�
    select count(*) into v_cnt from shop where sangpum like '%'||v_serach||'%';
    
    if v_cnt=0 then
        DBMS_OUTPUT.PUT_LINE(v_serach||' ��ǰ�� ��Ͽ� �����ϴ�');
    else    
         DBMS_OUTPUT.PUT_LINE('�� '||v_cnt||'���� ��ǰ�� �ֽ��ϴ�');
         
    for s in s1 loop --*������ s
        DBMS_OUTPUT.PUT_LINE('��ǰ�� :'||s.sangpum);
        DBMS_OUTPUT.PUT_LINE('���� :'||s.color);
        DBMS_OUTPUT.PUT_LINE('�ܰ� :'||TRIM(to_char(s.dan,'L999,999')));
        DBMS_OUTPUT.PUT_LINE('----------------------');
    end loop;
    end if;
    
END;
/
/*
���ν���(procedure)
:���ν����� Ư�� �۾��� �����ϴ� ������ ���� ���α׷�����
����Ÿ���̽��� ����Ǵ� ��ü�̴�
�ݺ��Ǵ� �ڵ尰�� ��� ���ν����� �����صξ��ٰ� ȣ���ؼ�
���ุ �ϸ� �ǹǷ� ���뼺�� ����
 
����

create : ���� ����, ���� �̸��� ������ ���� �߻�
create or replace : ���� ����, ���� �̸��� ������ �����

create [or replace] procedure ���ν�����
   [�Ķ���� ��� ����ŸŸ��,....]
    is
        ���� ����
    begin
        �ڵ�;
    end;
/
 
ȣ��:   exec ���ν�����
            	exec ���ν�����(��..)
*/

--���ο� ���ν��� ����
create or replace PROCEDURE mytest
    is
    begin
    
        DBMS_OUTPUT.PUT_LINE('ù ���ν��� ����');
    end;
/

--mytest ���ν��� ȣ��
exec mytest;

--�������� ����ϴ� ���ν��� ����
create or replace PROCEDURE gugu(dan number)--������ ������ dan�� numberŸ������ �޴´�
    is
    begin
       
        if dan<2 or dan>9 then
            DBMS_OUTPUT.PUT_LINE('�߸��� �����Դϴ�');
        else
        for a in 1..9 loop
         DBMS_OUTPUT.PUT_LINE('**'||dan||'��**');
        DBMS_OUTPUT.PUT_LINE(' ');
            DBMS_OUTPUT.PUT_LINE(dan||'x'||a||'='||dan*a);
        end loop;
        end if;
    end;
/

--gugu����
exec gugu(5);
exec gugu(9);
exec gugu(15);

--shop�� ��ǰ�� �߰��ϴ� ���ν���
create or replace PROCEDURE addshop(
    sangpum shop.sangpum%type/*shop��sangpum�� Ÿ���� ����*/,
    su shop.su%type,
    dan shop.dan%type,
    color shop.color%type
)
    is
    begin
        DBMS_OUTPUT.PUT_LINE('shop db�� '||sangpum||'�����͸� �߰��մϴ�');
        insert into shop  values (seq_test.nextval,sangpum,su,dan,sysdate,color);
        DBMS_OUTPUT.PUT_LINE(sql%rowcount||'���� ��ǰ�� �߰��Ǿ����ϴ�');--����üũ
        commit;
    end;
/

--��ǰ�߰�
exec addshop('����',1,200000,'white');

/*
    exec searchsangpum('���콺');
    
    ��ǰ�� ����  �ܰ�
    ---------------
    ���콺 yellow 33000
    ���콺 orange 11000
    
    �� 2�� �˻�
    
    �������
        ���콺 ���� ��ǰ�� �����ϴ�
*/
create or replace PROCEDURE searchsangpum(v_sang shop.sangpum%type)
    is
    cursor s1 --���������
    is
    select * from shop where sangpum like '%'||v_sang||'%';
    v_cnt number(3);
    
    begin
    select count(*) into v_cnt
    from shop where sangpum like '%'||v_sang||'%';
        if v_cnt=0 then
        DBMS_OUTPUT.PUT_LINE(v_sang||'���� ��ǰ�� �����ϴ�');
        else
        DBMS_OUTPUT.PUT_LINE(v_sang||' ��ǰ�� �� '||v_cnt||'�� ��ȸ��');
        DBMS_OUTPUT.PUT_LINE(' ');
        DBMS_OUTPUT.PUT_LINE('   ��ǰ�� ����  �ܰ�');
        DBMS_OUTPUT.PUT_LINE('====================');
            
        for s in s1 loop
        DBMS_OUTPUT.PUT_LINE(s.sangpum||'   '||s.color||'   '||s.dan);
        end loop;
        end if;
    end;
/
exec searchsangpum('���콺');
exec searchsangpum('�縻');
exec searchsangpum('����');

