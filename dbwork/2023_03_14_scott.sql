--emp ���̺� ��ü �÷� ��ȸ(�����Ͱ� ��ȸ��)
select * from emp;--����Ʈ ���� ���� emp
--emp ���̺� �ִ� ���������� ���(���� ������ �ѹ���)
select DISTINCT job from emp;--����Ʈ �ߺ����� �� ���� emp
--col�� ��Ī�� ����(��Ī�� ū����ǥ, �� �ܿ� ��������ǥ)
select ename as "�����" , job as "����" from emp;
--��Ī�� ���� �߰��� ������ ������ " ��������(as�� �׳� ���� ����)
select ename "���� �����", job ���� from emp;
--���� : empno�� 7369, 7566 �ΰ��� �����͸� Ȯ��
select * from emp where empno=7369 or empno=7566;
--SMITH,WARD �� ������ ���
select * from emp where ename='SMITH' or ename='WARD';
--in������(or �����ڷ� ��ȸ�ϴ� ��� or������ �Ⱦ��� ����)
select * from emp where ename in ('SMITH','WARD','SCOTT','FORD');
--emp 7369 7654 7788 7876
select * from emp where empno in (7369,7654,7788,7876);
--and������
select ename,job,sal,comm from emp where sal>=1500 and sal<=3000;
--���� sql���� between ���� ��ȸ ����
select ename,job,sal,comm from emp where sal between 1500 and 3000;
--������ manager�� ��� �� sal�� 2000�̻��� ���
select * from emp where job='MANAGER' and sal>=2000;
--comm�� null�� ��츸 ���
select * from emp where comm is null;--(comm='null')�� �ƴϴ�. ���� ���� �ƿ� ���°�
--comm�� null�� �ƴѰܿ� ���
select * from emp where comm is not null;
--ename �� A�� �����ϴ� ������ ��ȸ
select * from emp where ename like 'A%';
--ename �� s�� ������ ������ ��ȸ
select * from emp where ename like '%S';
--ename �� a�� s�� �����ϴ� ������ ��ȸ
select * from emp where ename like 'A%' or ename like 'S%';
--ename �� 2��°�� 3��° ��¥�� a�� ��� ��ȸ
select * from emp where ename like '_A%' or ename like '__A%';
--job�� manager �� analyst �߿� sal�� 2500�� ����� ��ȸ
select * from emp where (JOB='MANAGER' OR JOB='ANALYST') AND SAL>=2500;
--in���� ����
select * from emp where JOB IN ('MANAGER','ANALYST') AND SAL>=2500;
--scott�� ������ ���� ������ �޴� ����� ��ȸ(����Ʈ�ȿ�����Ʈ ������ subquery �� �θ���)
select * from emp where sal=(select sal from emp where ename='SCOTT');
--allen�� ������ ���� ������ ���� ����� ��ȸ
select * from emp where job=(select job from emp where ename='ALLEN');
--console�� ��� �� ���̺���� dual
--ppt 48p �����Լ�-�����Լ�
select abs(-6),abs(6) from dual; --abs:���밪, ������ ���
select ceil(2.35),ceil(2.11) from dual;--������ �ø��� ������ ��ȯ
select floor(2.35),floor(2.11) from dual;--������ ������ ������ ��ȯ
select round(2.356,1),round(2.22,1) from dual;--�Ҽ��� 1°�ڸ� ���� ���Ѵ�(�ݿø�)
select trunc(2.356,1),trunc(2.22,1) from dual;--�Ҽ��� 1°�ڸ����� ���Ѵ�(�ݳ���)
select round(235678,-1),round(235678,-2) from dual;--235680, 235700(1���ڸ��� �ø�, 10���ڸ��� �ø�)
select power(2,3),power(3,4) from dual;--������ ���ϱ�
select mod(7,2),mod(10,2) from dual;--������ ���ϱ� 1,0
--ppt 49p �����Լ�-���ڿ�ó���Լ�
select concat('JAVA','SPRING') from dual;--���ڿ� ��ġ��
select 'JAVA' || 'SPRING' FROM DUAL;--�� �Ʒ� ����(��ġ��)
select ename||'���� ������ '||job||'�Դϴ�' message from emp;--message �� col�̸�(��Ī)
select ename||'���� ������ '||sal||'�Դϴ�' sal from emp;--���ڿ� ��ġ��� ||�߿�

select initcap(ename) from emp;--ù���ڸ� �빮�ڷ� ���
select upper(ename) , lower(ename) from emp;--�빮��, �ҹ��ڷ� ��ȯ �� ���

select lpad('happy',10,'*')from dual;--Ư�� ���ڷ� ����ĭ ���ʿ� ä���
select rpad('happy',10,'+')from dual;--Ư�� ���ڷ� ����ĭ �����ʿ� ä���
select ename,lpad(sal,10,'0') sal from emp;
--���ڿ� ��or���� n��° ����  n���� ���
select substr('Happy Day',3,3),substr('Happy Day',-3,3)from dual;--ppy, day
--ename���� �� 2���ڸ� ��� �� *3�� �ٿ��� ����ϱ�
select substr(ename,1,2)||'***'ename from emp;--ename�� ��1��°���� 2��° ������ ��� �� ���ڿ�***�̶� ��ħ
select rpad(substr(ename,1,2),5,'*')from emp;--ename�� ��1��°���� 2��° ������ ��� �� �� ��5���� �� ������ *�� ä���
--length ���̱��ϱ�
select ename||'���� ���� ���̴� '||length(ename)||'�����Դϴ�' �޼��� from emp;
--replace : ��ġ
select replace('Hello Kitty','t','*')from dual;--���ڿ��� t�� *��
--instr:Ư�� ���ڿ��� ��ġ ���ϱ�
select instr('Good Day','Day') from dual;--6��°���� day �߰�
select instr('Good Day','happy') from dual;--������ 0

select '*'||trim('    hello    ')||'*' from dual;--trim ���� ���� ����
select '*'||ltrim('    hello    ')||'*' from dual;--���� ���� ����
select '*'||rtrim('    hello    ')||'*' from dual;--������ ���� ����

select sysdate ��¥ from dual;--sysdate �� ���� ��¥ ���ϱ�
select sysdate+1 from dual;--���ϳ�¥
select sysdate+7 from dual;--�����ϵ�
select to_char(sysdate,'yyyy-mm-dd') today from dual;--2023-03-14
select to_char(sysdate,'yyyy-mm-dd am hh:mi:ss') today from dual; --03:22:04//am�̳�pm �ϰų� �ٿ��� �������� ��µ�
select to_char(2345678,'L999,999,999') from dual;--L�� �� ������ ȭ��� �ڵ�.9�� ������ŭ �ڸ���//2,345,678
select to_char(2345678,'$000,000,000') from dual;--0�� ������ŭ �ڸ����� ����ϸ鼭 ���ڸ����� 0//002,234,678
select to_char(2.3,'0.00') from dual;--2.30//���°� 0���� ä��

--nvl : �ΰ��ϰ�� Ư�� ������ ���(mysql ������ ifnull)
select nvl(mgr,1000),nvl(comm,0)from emp;--mgr�� ���� null�϶� 1000����,com���� null�϶� 0����
select sal+comm from emp;--comm�� null�� ��� ���ϸ� ����� null
--comm�� null�� ��� 10���� ���
select sal+nvl(comm,10) pay from emp;
--decode:�������� ���� �ٸ��� ���
select ename,deptno,decode(deptno,10,'����',20,'������',30,'��⵵',40,'���ֵ�') from emp;--ename����ϰ� deptno����ϰ� 
                                                                                     --deptno�� 10�϶� 20�϶� ��� �ٸ��� ���
--order ������� ���
select ename,sal from emp order by ename asc;--������ �ڿ� �ٴ´�. asc�� ��������(��������)
select ename,sal from emp order by sal desc;--desc�� ��������. 
--������ ���, ���� �����ϰ�� ������ ��������
select ename,job,sal from emp order by job,sal desc;--job���� asc�� �����Ȱ�
--sal�� �������� ��� �� sal�� ����° ����ϹǷ� ����ȣ 3���� ����(�׷��� �����ϸ� col�̸����� �Ұ�)
select ename,job,sal from emp order by 3;
--���� 1500~3000 ������ ����ϴµ� �̸��� ��������
select ename,sal from emp where sal BETWEEN 1500 and 3000 order by ename;

--�׷��Լ� : ppt 57
--count,max,min,sum,avg
select count(*) from emp;--emp�� ������ ����
select max(sal) from emp;
select min(sal) from emp;
select sum(sal) from emp;
select round(avg(sal),-1) from emp;--1�� �������� �ݿø�//���� avg�� round�� ���� ��

--group�� �Լ� ����
--�� ������ �ο����� sal�� ���
select job ����,count(*) �ο���,round(avg(sal),-1) ��տ��� from emp group by job;

--���� Ŀ�������� �ο����� �����ͺ��� ���
select job ����,count(*) �ο���,round(avg(sal),-1) ��տ��� from emp group by job order by 2;

--���� Ŀ�������� ������ �ο����� 3�� �̻��� �����͸� ���
--�׷��Լ��� �̿��ؼ� ������ ��Ÿ������ having
select job ����,count(*) �ο���,round(avg(sal),-1) ��տ��� from emp group by job having count(*)>=3 order by 2;

--�� �������� �ο����� �ְ���, ���������� ���(������ ��������)
select job ����, count(*) �ο���,max(sal) �ְ���, min(sal) ��������
            from emp group by job order by 1;--1�÷� ��ȣ ��� ���� �ص� ��
            
--���� �������� �ݾ׾տ� ȭ�� ������ ���̰� 3�ڸ����� �ĸ� �߰�
select job ����, count(*) �ο���,to_char(max(sal),'L999,999') �ְ���, to_char(min(sal),'L999,999') ��������
            from emp group by job order by 1;
            
--1. emp���̺��� ename a�� s�� �����ϴ»�� ���(��ҹ��� �������)
select * from emp where upper(ename) like 'A%' or upper(ename) like 'S%';

--2. emp���̺��� ename ���� �ι�° ���ڰ� 'A' �λ�� ���
select * from emp where ename like '_A%';

--3. job ���� ���� �������ϰ�� �ѹ����� ����Ͻÿ�
select distinct job from emp;

--4. job �������� �ο����� ���Ͻÿ�
select job,count(*) from emp group by job;

--5. job �������� sal �� ��ձ޿��� ���Ͻÿ�
select job,round(avg(sal),-1) from emp group by job;

--6. job �������� sal �� �ִ밪�� �ּҰ��� ���Ͻÿ�
select job,max(sal), min(sal) from emp group by job;

--7. deptno �� 10�ΰ�� 'ȫ����'
   --20 �ΰ�� '���ߺ�' 30�ΰ�� '������' �μ��� ���Ͽ�
   --ename, �μ� �� ����Ͻÿ�
select ename,deptno,decode(deptno,10,'ȫ����',20,'���ߺ�',30,'������') from emp;

--8. �޿�(sal)�� sal �� ��պ��� �� ���� ����� ename �� sal �� ����Ͻÿ�
select ename,sal from emp where sal>(select avg(sal) from emp);

--9. hiredate ���� ���� 5���� ����� ename �� hiredate �� ����Ͻÿ�
select ename,hiredate from emp where to_char(hiredate,'MM')='05';
select ename,hiredate from emp where to_char(hiredate,'MM')=5;

--10. SCOTT �� �޿��� �����ϰų� �� ���� �޴� ������ �޿��� ����϶�
select ename,sal from emp where sal>=(select sal from emp where ename='SCOTT');

--select �׷���� ���� ������ �÷�1, �׷���̺��� ������ �� from ��𿡼��������� gourp by �׷����� ���� �÷��� having �����߰�;

--selct ����Ұ� from ���̺�� where ����;





