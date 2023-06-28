--emp 테이블 전체 컬럼 조회(데이터가 조회됨)
select * from emp;--셀렉트 모든거 프롬 emp
--emp 테이블에 있는 직업의종류 출력(같은 직업은 한번만)
select DISTINCT job from emp;--셀렉트 중복제외 잡 프롬 emp
--col명에 별칭을 지정(별칭은 큰따음표, 그 외엔 작은따음표)
select ename as "사원명" , job as "직업" from emp;
--별칭은 제목 중간에 공백이 없을시 " 생략가능(as는 그냥 생략 가능)
select ename "은행 사원명", job 직업 from emp;
--조건 : empno가 7369, 7566 두개의 데이터를 확인
select * from emp where empno=7369 or empno=7566;
--SMITH,WARD 의 데이터 출력
select * from emp where ename='SMITH' or ename='WARD';
--in연산자(or 연산자로 조회하는 경우 or여러개 안쓰고 가능)
select * from emp where ename in ('SMITH','WARD','SCOTT','FORD');
--emp 7369 7654 7788 7876
select * from emp where empno in (7369,7654,7788,7876);
--and연산자
select ename,job,sal,comm from emp where sal>=1500 and sal<=3000;
--위의 sql문을 between 으로 조회 가능
select ename,job,sal,comm from emp where sal between 1500 and 3000;
--직업이 manager인 사람 중 sal이 2000이상인 사람
select * from emp where job='MANAGER' and sal>=2000;
--comm이 null인 경우만 출력
select * from emp where comm is null;--(comm='null')이 아니다. 저건 값이 아예 없는거
--comm이 null이 아닌겨우 출력
select * from emp where comm is not null;
--ename 이 A로 시작하는 데이터 조회
select * from emp where ename like 'A%';
--ename 이 s로 끝나는 데이터 조회
select * from emp where ename like '%S';
--ename 이 a나 s로 시작하는 데이터 조회
select * from emp where ename like 'A%' or ename like 'S%';
--ename 의 2번째나 3번째 글짜가 a인 사람 조회
select * from emp where ename like '_A%' or ename like '__A%';
--job이 manager 나 analyst 중에 sal이 2500인 사람만 조회
select * from emp where (JOB='MANAGER' OR JOB='ANALYST') AND SAL>=2500;
--in으로 수정
select * from emp where JOB IN ('MANAGER','ANALYST') AND SAL>=2500;
--scott의 연봉과 같은 연봉을 받는 사람을 조회(셀렉트안에셀렉트 같은걸 subquery 라 부른다)
select * from emp where sal=(select sal from emp where ename='SCOTT');
--allen의 직업과 같은 직업을 가진 사람을 조회
select * from emp where job=(select job from emp where ename='ALLEN');
--console에 출력 시 테이블명을 dual
--ppt 48p 내장함수-숫자함수
select abs(-6),abs(6) from dual; --abs:절대값, 무조건 양수
select ceil(2.35),ceil(2.11) from dual;--무조건 올림한 정수로 반환
select floor(2.35),floor(2.11) from dual;--무조건 내림한 정수로 반환
select round(2.356,1),round(2.22,1) from dual;--소수점 1째자리 까지 구한다(반올림)
select trunc(2.356,1),trunc(2.22,1) from dual;--소수점 1째자리까지 구한다(반내림)
select round(235678,-1),round(235678,-2) from dual;--235680, 235700(1의자릿수 올림, 10의자릿수 올림)
select power(2,3),power(3,4) from dual;--지수승 구하기
select mod(7,2),mod(10,2) from dual;--나머지 구하기 1,0
--ppt 49p 내장함수-문자열처리함수
select concat('JAVA','SPRING') from dual;--문자열 합치기
select 'JAVA' || 'SPRING' FROM DUAL;--위 아래 같음(합치기)
select ename||'님의 직업은 '||job||'입니다' message from emp;--message 가 col이름(별칭)
select ename||'님의 연봉은 '||sal||'입니다' sal from emp;--문자열 합치기는 ||중요

select initcap(ename) from emp;--첫글자만 대문자로 출력
select upper(ename) , lower(ename) from emp;--대문자, 소문자로 변환 후 출력

select lpad('happy',10,'*')from dual;--특정 문자로 남는칸 왼쪽에 채우기
select rpad('happy',10,'+')from dual;--특정 문자로 남는칸 오른쪽에 채우기
select ename,lpad(sal,10,'0') sal from emp;
--문자열 앞or뒤의 n번째 부터  n글자 출력
select substr('Happy Day',3,3),substr('Happy Day',-3,3)from dual;--ppy, day
--ename에서 앞 2글자만 출력 후 *3개 붙여서 출력하기
select substr(ename,1,2)||'***'ename from emp;--ename을 앞1번째부터 2번째 까지만 출력 뒤 문자열***이랑 합침
select rpad(substr(ename,1,2),5,'*')from emp;--ename을 앞1번째부터 2번째 까지만 출력 한 뒤 총5글자 중 공백을 *로 채운다
--length 길이구하기
select ename||'님의 글자 길이는 '||length(ename)||'글자입니다' 메세지 from emp;
--replace : 대치
select replace('Hello Kitty','t','*')from dual;--문자열중 t를 *로
--instr:특정 문자열의 위치 구하기
select instr('Good Day','Day') from dual;--6번째에서 day 발견
select instr('Good Day','happy') from dual;--없으면 0

select '*'||trim('    hello    ')||'*' from dual;--trim 양쪽 공백 제거
select '*'||ltrim('    hello    ')||'*' from dual;--왼쪽 공백 제거
select '*'||rtrim('    hello    ')||'*' from dual;--오른쪽 공백 제거

select sysdate 날짜 from dual;--sysdate 가 현재 날짜 구하기
select sysdate+1 from dual;--내일날짜
select sysdate+7 from dual;--일주일뒤
select to_char(sysdate,'yyyy-mm-dd') today from dual;--2023-03-14
select to_char(sysdate,'yyyy-mm-dd am hh:mi:ss') today from dual; --03:22:04//am이나pm 암거나 붙여도 오전오후 출력됨
select to_char(2345678,'L999,999,999') from dual;--L은 그 지역의 화폐로 자동.9의 갯수만큼 자릿수//2,345,678
select to_char(2345678,'$000,000,000') from dual;--0의 갯수만큼 자릿수로 출력하면서 빈자릿수는 0//002,234,678
select to_char(2.3,'0.00') from dual;--2.30//남는걸 0으로 채움

--nvl : 널값일경우 특정 값으로 출력(mysql 에서는 ifnull)
select nvl(mgr,1000),nvl(comm,0)from emp;--mgr의 값이 null일때 1000으로,com값이 null일때 0으로
select sal+comm from emp;--comm이 null일 경우 더하면 결과도 null
--comm이 null일 경우 10으로 계산
select sal+nvl(comm,10) pay from emp;
--decode:값에따라 서로 다른값 출력
select ename,deptno,decode(deptno,10,'서울',20,'강원도',30,'경기도',40,'제주도') from emp;--ename출력하고 deptno출력하고 
                                                                                     --deptno가 10일때 20일때 등등 다른값 출력
--order 순서대로 출력
select ename,sal from emp order by ename asc;--오더는 뒤에 붙는다. asc는 오름차순(생략가능)
select ename,sal from emp order by sal desc;--desc는 내림차순. 
--직업순 출력, 같은 직업일경우 연봉의 내림차순
select ename,job,sal from emp order by job,sal desc;--job뒤의 asc가 생략된것
--sal의 오름차순 출력 시 sal이 세번째 출력하므로 열번호 3으로 정렬(그래도 가능하면 col이름으로 할것)
select ename,job,sal from emp order by 3;
--연봉 1500~3000 까지만 출력하는데 이름의 오름차순
select ename,sal from emp where sal BETWEEN 1500 and 3000 order by ename;

--그룹함수 : ppt 57
--count,max,min,sum,avg
select count(*) from emp;--emp의 데이터 갯수
select max(sal) from emp;
select min(sal) from emp;
select sum(sal) from emp;
select round(avg(sal),-1) from emp;--1원 단위에서 반올림//보통 avg는 round랑 많이 씀

--group별 함수 적용
--각 직업별 인원수와 sal의 평균
select job 직업,count(*) 인원수,round(avg(sal),-1) 평균연봉 from emp group by job;

--위의 커리문에서 인원수가 작은것부터 출력
select job 직업,count(*) 인원수,round(avg(sal),-1) 평균연봉 from emp group by job order by 2;

--위의 커리문에서 직업별 인원수가 3명 이상인 데이터만 출력
--그룹함수를 이용해서 조건을 나타낼때는 having
select job 직업,count(*) 인원수,round(avg(sal),-1) 평균연봉 from emp group by job having count(*)>=3 order by 2;

--각 직업별로 인원수와 최고연봉, 최저연봉을 출력(직업의 오름차순)
select job 직업, count(*) 인원수,max(sal) 최고연봉, min(sal) 최저연봉
            from emp group by job order by 1;--1컬럼 번호 대신 직업 해도 됨
            
--위의 퀴리문에 금액앞에 화폐 단위를 붙이고 3자리마다 컴마 추가
select job 직업, count(*) 인원수,to_char(max(sal),'L999,999') 최고연봉, to_char(min(sal),'L999,999') 최저연봉
            from emp group by job order by 1;
            
--1. emp테이블에서 ename a나 s로 시작하는사람 출력(대소문자 상관없음)
select * from emp where upper(ename) like 'A%' or upper(ename) like 'S%';

--2. emp테이블에서 ename 에서 두번째 글자가 'A' 인사람 출력
select * from emp where ename like '_A%';

--3. job 에서 같은 직업군일경우 한번씩만 출력하시오
select distinct job from emp;

--4. job 종류별로 인원수를 구하시오
select job,count(*) from emp group by job;

--5. job 종류별로 sal 의 평균급여를 구하시오
select job,round(avg(sal),-1) from emp group by job;

--6. job 종류별로 sal 의 최대값과 최소값을 구하시오
select job,max(sal), min(sal) from emp group by job;

--7. deptno 가 10인경우 '홍보부'
   --20 인경우 '개발부' 30인경우 '관리부' 부서를 구하여
   --ename, 부서 를 출력하시오
select ename,deptno,decode(deptno,10,'홍보부',20,'개발부',30,'관리부') from emp;

--8. 급여(sal)가 sal 의 평균보다 더 높은 사람만 ename 과 sal 을 출력하시오
select ename,sal from emp where sal>(select avg(sal) from emp);

--9. hiredate 에서 월이 5월인 사람만 ename 과 hiredate 를 출력하시오
select ename,hiredate from emp where to_char(hiredate,'MM')='05';
select ename,hiredate from emp where to_char(hiredate,'MM')=5;

--10. SCOTT 의 급여와 동일하거나 더 많이 받는 사원명과 급여를 출력하라
select ename,sal from emp where sal>=(select sal from emp where ename='SCOTT');

select 출력할것 from 어디에서가져올지 where 




