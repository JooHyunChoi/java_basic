-- DDL �슂�빟
create table
alter table
drop table book
rename
---

�뀒�씠釉� �깮�꽦
create table book(
	bookno number(5),
	title varchar2(12),
	author varchar2(12),
	pubdate date
);

select * from tab;

drop table book;

select * from book;

insert into book values(1, 'java','kim',sysdate);

rollback

commit

insert into book values(2,null,null,sysdate);
insert into book values(3, 'java','kim',sysdate);
insert into book values(4, 'java','kim',sysdate);

insert into book (bookno,title,author,pubdate)
				values (3,'sql','lee',null);
insert into book (bookno,author,title)
				values (4,'java01','db');
				

delete from book
where title is null;
delete from book
where author = 'kim';

commit

alter table book add(price number(7));

�듃�옖�젥�뀡 �뾽臾댁쓽 �떒�쐞 �옟�쓽 �떒�쐞
�쟻�젅�븳 怨녹뿉�꽌 �쟻�젅�븳 怨녹뿉�꽌 而ㅻ컠�궇由ш퀬 �쟻�젅�븳 怨녹뿉�꽌 濡ㅻ갚�쓣 �궇�젮�빞 �빀�땲�떎.


insert into book values (5,default,default,default,default);


		
delete from book
where bookno =5;

update book set price = null;
update book set price =10 , title = 'jsp' where bookno =1;

alter table book modify(price number(7,2));

alter table book drop column price;        

rename book to book2;
rename book2 to book1;

truncate table book1;    -- <- �뀒�씠釉붿쓣 理쒖큹 �깮�꽦�맂 珥덇린�긽�깭濡� 留뚮벉.  Rollback 遺덇��뒫. 

drop table book1;

select * from emp;
select * from dept;

create table emp2
as select * from emp;

create table emp3
as select * from emp where deptno = 10;

create table dept2
as select * from dept;


insert into dept2 values (50 , 'MARKETING' , 'SEOUL');
insert into dept2 values (10 , 'MARKETING' , 'SEOUL');

create table book(
	bookno number(5) constraint scott_book_pk primary key,
	title varchar2(12) constraint book_title_unique unique,
	author varchar2(12) constraint book_author_notnull not null,
	price number(5) constraint book_price_check check (price>0),
	pubdate date default sysdate
);

insert into book(bookno , title , author,price,pubdate)
			values(1,'java 1','kim' , 9000,sysdate);

insert into book(bookno , title , author,price,pubdate)
			values(2,'java 2','kim' , 9000,sysdate);
insert into book(bookno , title , author,price,pubdate)
			values(3,'java 3','lee' ,7500 ,sysdate);
insert into book(bookno , title , author,price,pubdate)
			values(3,'java 3','lee' ,7500 ,default);
insert into book(bookno , title ,price,author)
			values(5,'java 5',7000,'qwe');

select constraint_name from user_cons_columns; 
--user_cons_column �떆�뒪�뀥�뿉 �엳�뒗�븷�엫
--�뒪罹뉕퀎�젙�뿉 �엳�뒗 �젣�빟議곌굔�쓣 �븣�젮以�
select constraint_name from user_cons_columns
where table_name = 'BOOK';			
		
drop table book;
--�쑕吏��넻 鍮꾩슦湲�
purge recyclebin;
			
drop table book cascade constraint;
			
create table book(
	bookno number(5) primary key,
	title varchar2(12) unique,
	author varchar2(12),
	price number(5) check (price>0),
	pubdate date default sysdate
);


insert into book(bookno , title , author,price,pubdate)
			values(1,'java 1','kim' , 9000,sysdate);
select constraint_name from user_cons_columns
where table_name = 'BOOK';  -- �젣�빟議곌굔 �씠由� 蹂닿린
drop table book

create table book(
	bookno number(5) ,
	title varchar2(12) unique,
	author varchar2(12),
	price number(5) check (price>0),
	pubdate date default sysdate
);
--�뀒�씠釉� �젣�빟議곌굔 諛붽씀湲�
alter table book add constraint scott_book_pk primary key(bookno);




insert into book(bookno , title , author,price,pubdate)
			values(1,'java 1','kim' , 9000,sysdate);

insert into book(bookno , title , author,price,pubdate)
			values(1,'java 2','kim' , 9000,sysdate);
			
			
drop table dept2;

create table dept2
as select * from dept;

drop table emp2;
create table emp2
as select * from emp;

-- dept2 �뀒�씠釉붿뿉 pk�꽕�젙  deptno而щ읆�뿉
alter table dept2 add constraint dept2_deptno primary key(deptno);

-- emp2 �뀒�씠釉붿뿉 empno 而щ읆�뿉 pk�꽕�젙
alter table emp2 add constraint emp2_empno_pk primary key(empno);

-- emp2 �뀒�씠釉붿뿉 mgr 而щ읆�뿉 fk �꽕�젙
alter table emp2 add constraint emp2_mgr_fk foreign key(mgr) references dept2;
alter table emp2 add foreign key(deptno) references dept2;



select constraint_name from user_cons_columns
where table_name = 'emp2';  -- �젣�빟議곌굔 �씠由� 蹂닿린

--�젣�빟議곌굔 �젣嫄�
alter table book drop constraint book_bookno_pk;



select *
from emp,dept,SALGRADE
where emp.deptno = DEPT.deptno and emp.sal between salgrade.losal and SALGRADE.hisal

create or replace view emp_detail
as
select ename,dname,sal,grade
from emp,dept,SALGRADE
where emp.deptno = DEPT.deptno and emp.sal between salgrade.losal and SALGRADE.hisal

select * from emp_detail

-- pk�궘�젣 �븷�뻹 �쇅遺� fk濡� �릺�뼱 �엳�쑝硫� cascade�궗�슜�빐�빞�븿


---
drop table emp3
create table emp3
as select *
from emp
where deptno=10;
select * from emp3
-- 
insert into emp3
select * from emp where deptno =20

update emp set sal = sal*1.1 where deptno = 10;

select * from book;

create sequence bookno;

insert into book(bookno,title,price)
values (bookno.nextval , 'SQL11',7000);

---
create table book(
	bookno number(5) primary key,
	title varchar2(12),
	author varchar2(12),
	price number(5) check (price>0),
	pubdate date default sysdate
);

insert into book(bookno,title,price)
values((select nvl(max(bookno),0)+1 from book) , 'SQL',7000);


select nvl(max(bookno),0)+1 from book;


-----
select * from book  where bookno=3;
select * from book where lower(title)= lower('sql');


set autotrace on;
select * from book where lower(title)= lower('sql');

create index book_title on book(title);
drop index book_title;

commit






select * from book;	
commit
rollback


--------------------------------------------------------------------------------
drop table users;
drop table board;
create table users(
	id number(7),
	password varchar2(12),
	name varchar2(12),
	role varchar2(12)
);

create table board (
	seq number(3),       
     title varchar2(12),
     content varchar2(12),   
     regdate date,
     cnt number(3), 
     userid number(7)
)
      
alter table board add constraint board_pk primary key(seq);
alter table users add constraint users_pk primary key(id);
alter table board add constraint board_fk foreign key(userid) references users;


--�쉶�썝�벑濡�

insert into users(id,password,name,role)
values((select nvl(max(id),0)+1 from users) ,'1234','kim','�궗�썝');
insert into users(id,password,name,role)
values((select nvl(max(id),0)+1 from users) ,'1234','lee','��由�');
insert into users(id,password,name,role)
values((select nvl(max(id),0)+1 from users) ,'1234','park','怨쇱옣');
insert into users(id,password,name,role)
values((select nvl(max(id),0)+1 from users) ,'1234','choi','李⑥옣');

select * from users;

-- �쉶�썝�젙蹂댁닔�젙
update users
set password = '4321'
where id= 1;

--濡쒓렇�씤

select rownum
from users
where id = '1' and password = '4321';

--寃뚯떆�뙋 湲� �벑濡�
insert into board(seq,title,content,regdate,cnt,userid)
values((select nvl(max(seq),0)+1 from board) ,'�젣紐�','�궡�슜',sysdate,null,1);
insert into board(seq,title,content,regdate,cnt,userid)
values((select nvl(max(seq),0)+1 from board) ,'�젣紐�2','�궡�슜2',sysdate,null,2);

--湲��닔�젙
update board
set title='諛붾�먯젣紐�',
	content='諛붾�먮궡�슜'
where userid= 2;

--寃뚯떆�뙋 湲� �궘�젣
delete 
from board
where title = '�젣紐�';

--�뜲�씠�꽣寃��깋(Query)

select seq,title,content
from board
where content like '%�궡%';

--�쟾泥� �벑濡앷� �닔
select count(*) as �쟾泥�_�벑濡앷�_�닔 
from board

--�궗�슜�옄蹂� �벑濡앷��닔 
select userid,count(*) as �쟾泥�_�벑濡앷�_�닔
from board
group by userid;
--�썡蹂꾧컻�떆湲��닔
select to_char(regdate , 'mm') �썡,count(*) as �썡蹂�_�벑濡앷�_�닔
from board
group by to_char(regdate , 'mm');

--�궗�슜�옄蹂� 寃뚯떆湲� 寃��깋
select name,title,content
from board,users
where board.userid = users.id
and users.name = 'kim';

--�젣紐⑹쑝濡� 寃뚯떆湲� 寃��깋
select seq , title , content
from board
where title = '�젣紐�';


-----------------------------------------------------------
select * from board
create table users(
	id varchar2(20) primary key,
	password varchar2(20) not null,
	name varchar2(20) not null,
	role varchar2(20) default 'user'
);

create table board (
	 seq     number(5)  primary key,       
     title   varchar2(20) not null,
     content varchar2(800) not null,   
     regdate date default sysdate,
     cnt     number(3) default 0, 
     id      varchar2(20) references users
);
�쉶�썝�벑濡�

insert into users(id,password,name)
values('java01','1234','�솉湲몃룞');
insert into users(id,password,name)
values('java02','1234','蹂��궗�삉');
insert into users(id,password,name,role)
values('admin','7321','愿�由ъ옄','admin');

select * from users
select * from board
commit
寃뚯떆�뙋 �벑濡�

insert into board (seq,title,content,regdate,cnt,id)
values();

insert into board (seq,title,content,id)
values((select nvl(max(seq),0)+1 from board),'怨듭�','�돺�땲�떎','admin');

insert into board (seq,title,content,id)
values((select nvl(max(seq),0)+1 from board),'�젣紐�','�궡�슜','java01');

--�궡媛� �벖湲� 蹂닿린

select * from board 
where id = 'java01';

select * from board
where seq = 1;

--�썡蹂� �벖湲� 蹂닿린

select to_char(regdate , 'mm') as �썡 , count(*) �닔
from board
group by to_char(regdate , 'mm');

---濡쒓렇�씤
select *
from users
where id = '' and password = '';

select rownum
from users
where id = 'java01' and password = '1233';

update book set price =10 , title = 'jsp' where bookno =2;













