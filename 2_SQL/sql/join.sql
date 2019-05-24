select
from
where
order by

select * from emp;
select ename,hiredate,to_char(hiredate,'YY') from emp;
select ename,hiredate,to_char(hiredate,'YY'),substr(hiredate,1,2) from emp;
select lower(ename),hiredate,to_char(hiredate,'YY'),substr(hiredate,1,2) from emp;

select round(5.55,1) from dual

INSERT INTO EMP VALUES
(9996,'kor%123','CLERK',7782,to_date(sysdate,'dd-mm-yyyy'),900,NULL,70);

select * from emp order by deptno;

select ename,deptno,sal,sal*1.1 from emp 
where deptno =10;
select ename,deptno,sal,sal*1.2 from emp 
where deptno =20;
select ename,deptno,sal,sal*1.3 from emp 
where deptno =30;

select ename,deptno,sal case 


select ename,deptno,sal, decode(deptno,10,sal*1.1,
									   20,sal*1.2)
from emp;


select ename,deptno,sal, decode(deptno,10,sal*1.1,
									   20,sal*1.2,
									   sal) as 수당
from emp;

select ename,nvl(to_char(mgr),'x')
from emp;

select ename,nvl2(mgr,'o','x')
from emp;

select * from dept;

select ename,job,dname,loc
from emp,dept
where emp.deptno = dept.deptno;

select ename,job,emp.deptno,loc
from emp,dept
where emp.deptno = dept.deptno;

select ename,job,d.dname,loc
from emp e,dept d
where e.deptno = d.deptno;

안시표준
사용할 테이블에 , 대신에 join으로   where를 on으로 

select ename,job,d.dname,loc
from emp e join dept d
on e.deptno = d.deptno;

=
select ename,job,d.dname,loc
from emp e inner join dept d
on e.deptno = d.deptno;


select ename,job,dname,sal
from emp e inner join dept d
on e.deptno = d.deptno
where e.sal>2000;

select ename,job,d.dname,sal
from emp e,dept d
where e.deptno = d.deptno
and sal>2000;


select ename,job,d.deptno,dname,loc
from emp e , dept d
where e.deptno(+) = d.deptno;

select ename,job,d.deptno,dname,loc
from emp e right outer join dept d
on e.deptno = d.deptno;

select ename,job,d.deptno,dname,loc
from emp e right join dept d
on e.deptno = d.deptno;

select * from SALGRADE;
select * from emp;



select ename,sal,grade
from emp,SALGRADE
where sal between losal and hisal;


select ename,sal,grade
from emp join SALGRADE
on sal between losal and hisal;

select e.ename 사원이름,m.ename 상사이름
from emp e,emp m
where e.mgr = m.empno(+);

select e.ename 사원이름,m.ename 상사이름
from emp e left join emp m
on e.mgr = m.empno;

select e.ename 사원이름,nvl(m.ename,'CEO') as 상사이름
from emp e left join emp m
on e.mgr = m.empno;

상사보다 입사일자가 빠른 사원
select e.ename 사원이름 , e.hiredate ,nvl(m.ename,'CEO') as 상사이름 , m.hiredate
from emp e left join emp m
on e.mgr = m.empno
where e.hiredate < m.hiredate;

상사보다 급여가 많은 사원
select e.ename 사원이름 , e.sal ,nvl(m.ename,'CEO') as 상사이름 , m.sal
from emp e left join emp m
on e.mgr = m.empno
where e.sal > m.sal;


select e.ename 사원이름 , e.sal ,nvl(m.ename,'CEO') as 상사이름 , m.sal
from emp e , emp m
where e.mgr = m.empno
and e.sal > m.sal;

집계 함수 
select ename ,round(sal) from emp;
select avg(sal) from emp;
select count(sal),count(comm),count(*),count(mgr) from emp;

select count(distinct job) from emp;
select sum(sal),count(*), round(sum(sal)/ count(*),2) 평균 , round(avg(sal),2) from emp;
select sum(sal),count(*), round(sum(sal)/ count(*),2) 평균 , round(avg(sal),2) from emp
where deptno = 10;

select deptno , sum(sal),count(*), round(avg(sal),2)as 평균 from emp
group by deptno;

select deptno , min(sal),max(sal), round(avg(sal),2)as 평균 from emp
group by deptno;

평균급여가 2000이상인 부서별 평균급여
select emp.deptno,dname,count(*),round(avg(sal)) 평균
from EMP,dept
where emp.deptno = dept.deptno and sal>2000
group by emp.deptno,dname
order by 평균;


평균급여가 2000이상인 부서정보 출력
select emp.deptno,dname,count(*),round(avg(sal)) 평균
from EMP,dept
where emp.deptno = dept.deptno and avg(sal) <- 이거 안되 그룹절은 where절 안에 못들어감
group by emp.deptno,dname
order by 평균;

평균급여가 2000이상인 부서정보 출력
select emp.deptno,dname,count(*),round(avg(sal)) 평균
from EMP,dept
where emp.deptno = dept.deptno
having avg(sal) > 2000
group by emp.deptno,dname
order by 평균;

각 그룹에 최고 연봉자를 제외한 평균을 구하시오 -- 아직 안돰
select emp.deptno,dname,count(*),round(avg(sal)) 평균
from EMP,dept
where emp.deptno = dept.deptno
having !max(sal)
group by emp.deptno,dname
order by 평균;

select ename,dname,sal,grade
from emp,dept,SALGRADE
where emp.deptno = DEPT.deptno and emp.sal between salgrade.losal and SALGRADE.hisal

ㅔ265페이지 참조 세개 이상의 테이블 결합
select ename,dname,sal,grade
from emp,dept,SALGRADE
where emp.deptno = DEPT.deptno and emp.sal between salgrade.losal and SALGRADE.hisal


select ename,dname,sal,grade
from emp 
join dept on emp.deptno = DEPT.deptno 
join SALGRADE on emp.sal between salgrade.losal and SALGRADE.hisal


select deptno , avg(sal)
from EMP
group by deptno
having avg(sal) > 2000;

서브쿼리
select ename , sal
from EMP
where (select sal from emp where ename = 'FORD') <= sal;

select ename , sal
from EMP
where (select round(avg(sal)) from emp) > sal;

select *
from EMP
where (select min(sal) from emp) = sal;

select min(sal) from emp group by deptno;


select *
from EMP
where sal = (select min(sal) from emp group by deptno);  <- 안됨

select *
from EMP
where sal in (select min(sal) from emp group by deptno);

자신이 속한 부서의 평균보다 급여가 적은 사람 리스트
select *
from emp e
where sal < (select avg(sal) from emp where deptno =e.deptno )



select rownum ,ename,job,sal
from emp;

select rownum ,ename,job,sal
from emp
order by sal;

순위
select rownum ,ename,job,sal
from emp
order by sal desc

select rownum ,ename,job,sal
from (select * from emp order by sal desc)
where rownum <4;

select rownum ,ename,job,sal
from (select * from emp order by sal desc)
where rownum >4;    -- <- 에러 

select rownum ,ename,job,sal
from (select * from emp order by sal desc)
where rownum between 1 and 4;

select ename,job,sal
from
(
	select rownum row#,ename,job,sal
	from (select * from emp order by sal desc)
)
where row# between 4 and 7

81년도에 입사한 사람중 월급 상위 3명
select * from emp
where to_char(hiredate ,'yy') = '81'
order by sal desc;

select rownum, ename , job, sal,hiredate
from (select * from emp
where to_char(hiredate ,'yy') = '81'
order by sal desc)
where rownum <4;





각 부서별 최고 급여
select max(sal)
from EMP
group by deptno;

select *
from EMP
where  sal in (select max(sal) from emp group by deptno);

select *
from EMP e
where (deptno,sal) 
in (select deptno,max(sal) from emp group by deptno);

-------------------------------과제----------------------

select * 
from EMPLOYEES;

select *
from DEPARTMENTS;

--문제 1. 각 사원(employee)에 대해서 사번(employee_id), 이름(first_name), 
--       부서명(department_name), 매니저(manager)의 이름(first_name)을 조회하시오. 


select e.employee_id , e.first_name , d.department_name , m.first_name
from EMPLOYEES e 
join DEPARTMENTS d 
on e.department_id = d.department_id
join EMPLOYEES m
on e.manager_id = m.employee_id;



--문제2. 자신의 매니저보다 연봉(salary)을 많이 받는 직원들의 성(last_name)과 연봉(salary)을 출력하시오. 

select e.last_name , e.salary 
from EMPLOYEES e, EMPLOYEES m
where e.manager_id = m.employee_id 
and e.salary > m.salary;

--문제3. 업무명(job_title)이 ‘Sales Representative’인 직원 중에서 연봉(salary)이 9,000 이상, 
-- 10,000 이하인 직원들의 이름(first_name), 성(last_name)과 연봉(salary)을 출력하시오.

select first_name , last_name,salary
from EMPLOYEES e, JOBS j
where e.job_id = j.job_id
and lower(job_title) = lower('Sales Representative')
and salary between 9000 and 10000;

--문제 4. 자신의 매니저보다 채용일(hire_date)이 빠른 사원의 사번(employee_id), 
--      성(last_name)과 채용일(hire_date)을 조회하라.

select e.last_name ,e.employee_id ,e.hire_date 
from EMPLOYEES e, EMPLOYEES m
where e.manager_id = m.employee_id 
and e.hire_date < m.hire_date;


--문제5.
--각 업무(job_title)가 어느 부서(department_name)에서 수행되는지 조회하는 SQL 쿼리문을 작성하세요. 
--(단, 수행하지 않는 업무는 표시하지 않고 중복되는 정보는 하나만 표시합니다.)
--출력: JOB_TITLE | DEPARTMENT_NAME

select distinct(j.JOB_TITLE) , d.DEPARTMENT_NAME
from JOBS j , EMPLOYEES e , DEPARTMENTS d
where j.job_id = e.job_id and e.department_id = d.department_id

--문제 6.
--월 별 입사자 수를 조회하는 SQL 쿼리문을 작성하세요. 월 순으로 정렬하세요. 
--출력: 월 | 입사자수

select hire_month as 월, count(*) as 입사자수
from (select to_char(hire_date, 'mm') as hire_month from EMPLOYEES)
group by hire_month
order by hire_month;

select to_char(hire_date, 'mm') as 월, count(*) as 입사자수
from EMPLOYEES
group by to_char(hire_date,'mm')
order by to_char(hire_date,'mm')


--문제 7. 
--08년도에 입사한 직원의 이름(first_name), 입사일(hire_date), 관리자사번(employee_id), 
--관리자 이름(first_name)을 조회합니다. 단, 관리자가 없는 사원정보도 출력결과에 포함되어야 합니다..  

select e.first_name, e.hire_date, e.manager_id, m.first_name
from EMPLOYEES e, EMPLOYEES m
where e.manager_id = m.employee_id(+)
and to_char(e.hire_date, 'yy') = '08';

--문제 8.
--‘Sales’부서에 속한 직원의 이름(first_name), 급여(salary), 부서이름(department_name)을 조회하시오. 

select e.first_name, e.salary, d.department_name
from EMPLOYEES e, DEPARTMENTS d
where e.department_id = d.department_id
and d.department_name = 'Sales';
--문제 9.
--2004년 입사한(hire_date) 직원들의 사번(employee_id), 이름(first_name), 
--성(last_name), 부서명(department_name)을 조회합니다. 
--이때, 부서에 배치되지 않은 직원의 경우, ‘<NOT ASSIGNED>’로 보여줍니다.
select e.hire_date, e.employee_id, e.first_name, e.last_name, nvl(d.department_name, '<NOT ASSIGNED>')
from EMPLOYEES e, DEPARTMENTS d
where e.department_id = d.department_id(+)
and to_char(e.hire_date, 'yy') = '04';

--문제 10. 
--80년대에 입사한 직원의 이름(first_name), 입사일(hire_date), 관리자사번(employee_id),
-- 관리자 이름(first_name)을 조회합니다.
-- 단, 관리자가 없는 사원정보도 출력결과에 포함되어야 합니다.
select e.first_name, e.hire_date, e.manager_id, m.first_name
from EMPLOYEES e, EMPLOYEES m
where e.manager_id = m.employee_id(+)
and e.hire_date between to_date('00/01/01', 'yy/mm/dd') and to_date('09/12/31', 'yy/mm/dd');

--------------
--
--
--
------------------

select * from tab;

select *
from EMP_DETAILS_VIEW;
















