select * from emp;

select ename as 사원명,job as 업무,sal as 급여,comm as 수당 from emp;

select distinct job from emp;


select ename,sal,sal*12 as 연봉 from emp;
select ename,sal,comm,sal+comm from emp;
select ename,sal,comm,sal+nvl(comm,0) from emp;

select ename ,nvl(mgr,empno)mgr from EMP;

select ename ,nvl(to_char(mgr),'없음')mgr from EMP;

select ename,mgr,'sql' from emp;

select ename,sal,comm,sal+nvl(comm,0) as 지급액 from emp;
select ename,sal,comm,sal+nvl(comm,0)||'원' as 지급액 from emp;

select ename||job||hiredate,deptno from emp;

select sysdate from emp;
select sysdate from dept;
select sysdate from dual;
select sysdate,3+7+8 from dual;

select * from emp;
select * from emp where sal>3000;

select * from emp where job = 'MANAGER';
select * from emp where upper(job) = upper('manager');
select * from emp where upper(job) != upper('manager');

select * from emp where hiredate > '81/05/01';

select * from emp where sal>2000 and sal < 3000;

select * from emp where DEPTNO = 10 or DEPTNO = 20;
select * from emp where DEPTNO in(10,20);

select * from emp where DEPTNO != 10 and DEPTNO != 20;
select * from emp where DEPTNO <> all(10,20); // all any  는 다른 연산자랑 같이 써야함


select * from dept;

select * from dept where deptno = 20 and loc = 'DALLAS';

select * from dept where deptno = 20 or deptno = 10;
select * from dept where (deptno,loc) in ((20,'DALLAS'),(30,'CHICAGO'));


select * from emp where job like 'S%';
select * from emp where ename like '%M%';
select * from emp where upper(ename) like '%'||upper('m')||'%';


select * from emp where hiredate like '82%';
select * from emp where hiredate between '82/01/01'and '82/12/31';  // between 은 앞뒤 포함

select * from emp where comm is null;
select * from emp where comm is not null;

select * from emp order by deptno;
select * from emp order by deptno desc;
select * from emp order by 5;
select * from emp order by 5,deptno;

select ename,sal,comm,sal+nvl(comm,0) as total from emp
where sal+nvl(comm,0)>2000
order by total;

select sysdate from dual;

select sysdate , to_char(sysdate,'YY') from dual;
select sysdate , to_char(sysdate,'YYYY') from dual;


select to_char(hiredate,'MM') from emp;
select to_char(hiredate,'day') from emp;

INSERT INTO EMP VALUES
(9998,'java_01','CLERK',7782,to_date(sysdate,'dd-mm-yyyy'),900,NULL,10);

select * from emp where empno = 9997;

rollback;
select * from emp where empno = 9998;

INSERT INTO EMP VALUES
(9997,'java_01','CLERK',7782,to_date(sysdate,'dd-mm-yyyy'),900,NULL,70);

INSERT INTO EMP VALUES
(9998,'java_01','CLERK',7782,to_date('05/13/19','mm-dd-yyyy'),900,NULL,70);


select deptno , round(avg(sal),2) , count(*)
from emp
group by deptno

select * from EMP where lower(ename) like '%'||'j'||'%';
select * from EMP where lower(ename) like '%j%';

select * from EMPLOYEES;

select count(*) as 소속부하직원수 , m.employee_id as 관리자사번, m.first_name as 관리자이름
from EMPLOYEES e , EMPLOYEES m
where e.manager_id = m.employee_id
group by m.employee_id;


select count(*), e.manager_id , m.first_name
from EMPLOYEES e, EMPLOYEES m
where e.manager_id = m.employee_id
group by e.manager_id,m.first_name
having count(*) >= 8


select employee_id , first_name,job_title
from EMPLOYEES , JOBS
where EMPLOYEES.job_id = JOBS.job_id
and upper(job_title) like upper('%a%') or upper(job_title) like upper('%b%');


select * from EMPLOYEES;
select * from JOBS;














