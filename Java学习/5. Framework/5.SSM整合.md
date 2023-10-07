---
title: 7、SSM整合
updated: 2021-10-29T17:32:55.0000000+08:00
created: 2021-10-28T18:55:25.0000000+08:00
---

SSM整合：
SpringMVC：视图层，管理Controller对象
Spring：业务层，管理Service，DAO工具类对象
Mybatis：持久层
步骤：
1、定义表，创建表
2、IDEA创建项目，添加Maven依赖
（1）spring相关：
1）spring-context（可以不写，webmvc依赖于这个，所以maven会导入，要写就版本一样，不然想找半天找不到？）
2）spring-tx
3）spring-jdbc
（2）mybatis相关：
4）mysql-connector-java
5）mybatis
6）druid（也可以不用这个连接池，只不过大概率会用）
（3）spring整合mybatis
7）mybatis-spring
（4）SpringMVC相关：
8）javax.servlet-api
9）spring-webmvc
10）jackson-core
11）jackson-databind
12）jackson-annotations
3、配置Web容器（我主要用Tomcat）
（1）注册DispatcherServlet，用于创建SpringMVC容器去管理Controller
（2）注册ContextLoaderListener，用于创建Spring容器去管理Service，DAO
（3）注册CharacterEncodingFilter，用于处理传递、接收参数时导致的乱码
4、创建Controller，Service，DAO实体类
5、配置SpringMVC，Spring，Mybatis的配置文件
6、写代码
