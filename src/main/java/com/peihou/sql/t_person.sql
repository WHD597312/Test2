create table t_person(
	id int primary key auto_increment,
	name char(40) character set utf8 default null,
	age int
)engine=innodb default charset=utf8;

insert into t_person(name,age) values('王海东',26);
SELECT * FROM t_person;