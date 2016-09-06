--用户账号表
CREATE TABLE uu(
    sid int primary key auto_increment,
    mobile VARCHAR(20) unique not null,
    passwd VARCHAR(20) not null,
    code VARCHAR(20) 
);
drop table uu;
SELECT * FROM uu;
--用户角色中间表
CREATE TABLE uurole(
      srid int primary key auto_increment,
      sid int,
      rid int
)
insert into uurole(sid,rid) values(1,3),(1,2),(5,4),(1,3),(6,5),(4,4);

--角色表
CREATE TABLE role(
      rid int primary key auto_increment,
      rname varchar(20)
)

insert into role(rname) values('管理员'),('班主任'),('项目经理'),('学员');
--角色菜单中间表
CREATE TABLE rolemenu(
      rmid int primary key auto_increment,
      rid int,
      mid int
)
select *from rolemenu
insert into rolemenu(rid,mid) values(2,2),(1,3),(4,1),(3,3),(4,2),(1,1);
--菜单表
CREATE TABLE menu(
      mid int primary key auto_increment,
      name varchar(20),
      url varchar(200),
      isshow int  default 1,
      level int,
      parentid int
 
)
drop table menu;
insert into menu(name,url,isshow,level,parentid) values
('系统','#',0,1,-2);
insert into menu(name,url,isshow,level,parentid) values
('用户管理','#',1,2,1);
insert into menu(name,url,isshow,level,parentid) values
('用户列表','Show.do?methodName=showUser',1,3,2);
insert into menu(name,url,isshow,level,parentid) values
('权限管理','#',1,2,1);
insert into menu(name,url,isshow,level,parentid) values
('角色列表','aclass.do?methodName=aclass',1,3,4);
insert into menu(name,url,isshow,level,parentid) values
('菜单管理','#',1,2,1);
insert into menu(name,url,isshow,level,parentid) values
('菜单列表','aclass.do?methodName=aclass',1,3,6);
select m.* from uurole ur,rolemenu rm,menu m where
				ur.rid=rm.rid and rm.mid=m.mid and isshow=1 and ur.sid=9;





select * from menu where parentid =mid;













