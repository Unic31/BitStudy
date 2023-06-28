--연습용 계정 생성 --한줄실행 ctrl+enter
create user c##scott identified by a12324;
--오라클 최신버전은 계정 앞에 c##을 붙여서 생성해야 한다
--그런데 c##을 안붙이고 생성하려면 아래 코드 추가 후 생성하면 된다
alter session set "_ORACLE_SCRIPT"=true
--위의 c##scott제거
drop user c##scott;
--scott 라는 계정 생성하기
create user scott identified by a1234;
--기본권한주기
grant connect, resource to scott;