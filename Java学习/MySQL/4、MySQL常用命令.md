---
title: 4、MySQL常用命令
updated: 2021-05-02T12:45:23.0000000+08:00
created: 2021-04-22T22:24:48.0000000+08:00
---

查看mysql中有哪些数据库？

show databases;

注意：以分号结尾，分号是英文的分号。

![image1](resources/image1-1.png)

mysql默认自带了4个数据库。

怎么选择使用某个数据库呢？

![image2](resources/image2.png)

怎么创建数据库呢？

![image3](resources/image3.png)

PS：数据库管理系统的不同，中间会有些细微的差异，如SQL server中创建数据库：

![image4](resources/image4.png)

查看某个数据库下有哪些表？

![image5](resources/image5.png)

注意：以上的命令不区分大小写，都行。

查看mysql数据库的版本号：

![image6](resources/image6.png)

查看当前使用的是哪个数据库？

![image7](resources/image7.png)

注意：mysql是不见“;”不执行，“;”表示结束！

\c用来终止一条命令的输入。

退出mysql ：exit
