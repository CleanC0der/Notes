---
title: 8、表DDL、DML
updated: 2021-09-08T18:39:24.0000000+08:00
created: 2021-04-25T22:51:10.0000000+08:00
---

# 建表（DDL）
# 法一：
create table 表名(
字段1 数据类型
字段2 数据类型
…
);
补充数据类型：
varchar(最长255)

可变长度的字符串

比较智能，节省空间。

会根据实际的数据长度动态分配空间。

优点：节省空间

缺点：需要动态分配空间，速度慢。

char(最长255)

定长字符串

不管实际的数据长度是多少。

分配固定长度的空间去存储数据。

使用不恰当的时候，可能会导致空间的浪费。

优点：不需要动态分配空间，速度快。

缺点：使用不当可能会导致空间的浪费。

varchar和char我们应该怎么选择？

性别字段你选什么？因为性别是固定长度的字符串，所以选择char。

姓名字段你选什么？每一个人的名字长度不同，所以选择varchar。

int(最长11)

数字中的整数型。等同于java的int。

bigint

数字中的长整型。等同于java中的long。

float

单精度浮点型数据

double

双精度浮点型数据

date

短日期类型

datetime

长日期类型

clob

字符大对象

最多可以存储4G的字符串。

比如：存储一篇文章，存储一个说明。

超过255个字符的都要采用CLOB字符大对象来存储。

Character Large OBject:CLOB

blob

二进制大对象

Binary Large OBject

专门用来存储图片、声音、视频等流媒体数据。

往BLOB类型的字段上插入数据的时候，例如插入一个图片、视频等，

你需要使用IO流才行。

# 法二：
create table 表名 as select ……

# 删表（DDL）
drop table 表名
# 改表（DDL）
alter table 表名
增加列，删除列balabala的
**修改表名**
MySQL：alter table table_name rename to new_name
| Sqlserve：exec sp_rename 'table_name', 'new_name | '   |
|--------------------------------------------------|-----|

插入数据（DML）
insert into 表名(字段1，字段2…) values(值1，值2…)
或者
insert into 表名 values(值1,值2,…) 所有字段都给值
注意字段和值一一对应
**插入多条数据**
语法：insert into t_user(字段名1,字段名2) values(),(),(),();
拓展：
快速创建表（SQLserver的语法略有不同）：

create table \[table_name\] as

(select …)

删除数据（DML）
delete from 表名 where 删哪
delete语句删除数据的原理？（delete属于DML语句！！！）
表中的数据被删除了，但是这个数据在硬盘上的真实存储空间不会被释放！！！

这种删除缺点是：删除效率比较低。

这种删除优点是：支持回滚，后悔了可以再恢复数据！！！

truncate语句删除数据的原理？
这种删除效率比较高，表被一次截断，物理删除。

这种删除缺点：不支持回滚。

这种删除优点：快速。
或者：truncate table \[table_name\]; (DDL)

修改数据(DML)
update 表名 set 字段1=值1, 字段2=值2…. where 哪里改
