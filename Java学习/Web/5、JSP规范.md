---
title: 5、JSP规范
updated: 2021-10-26T11:33:25.0000000+08:00
created: 2021-05-18T21:30:07.0000000+08:00
---

JSP规范

介绍：
来自JavaEE规范中的一种，JSP规范制定了如何开发JSP文件代替响应对象将数据写入响应体的开发流程

JSP规范制定了Http服务器如何调用管理JSP文件
作用：
jsp文件执行时会自动将文件所有内容写进响应体中，省得写一堆response.getWriter().write();

相当于一个servlet
如何写Java命令呢？
使用执行标签（所有执行标签被看成一个整体，所以可以在里面用

%\>html代码\<%来插入HTML代码）：

\<%

这里面写内容。

%\>

导包

\<% @page import="" %\>

还有输出标记

可以将java里的变量写进响应体

\<%=java里的变量名%\>
内置对象：
1.  request
    1.  类型：HttpServletRequest
    2.  作用：在JSP文件运行时读取请求包信息
2.  response
3.  session
    1.  类型：HttpSession
4.  application
    1.  类型：ServletContext
PS：Servlet和JSP分工：
Servlet：负责处理业务逻辑并得到结果

JSP：多用于传结果到网页中（响应体）

可以在Servlet工作完毕后，通过请求转发调用JSP

又因为 请求转发，共用同一个request，所以数据共享可以通过请求作用域对象

理一理：
JSP是怎样被调用的？
1.Http服务器负责将JSP文件【编辑】成一个Servlet的接口实现类【.java】

2.Http服务器负责将这个Servlet的接口实现类【.java】文件【编译】成【.class】文件

3.Http服务器负责创建这个class文件的【实现类】，这个实例对象就是【Servlet实例对象】

4.Http服务器通过Servlet实例对象调用service()方法将JSP文件写入响应体

一、EL表达式：
1.命令格式：\${作用域对象别名.AttributeName}

2.命令作用：

1）EL表达式是EL工具包（在Tomcat里有）提供一中特殊命令格式【表达式命令格式】

2）EL表达式在JSP文件上使用

3）负责在JSP文件上从作用域对象读取指定的共享数据并输出到响应体
二、EL表达式——作用域对象别名
| Servlet类名           | JSP对象名   | EL表达式对象别名 | 别名                                  |
|-----------------------|-------------|------------------|---------------------------------------|
| 1）ServletContext     | application | applicationScope | 全局作用域对象                        |
| 2）HttpSession        | session     | sessionScope     | 会话作用域对象                        |
| 3）HttpServletRequest | request     | requestScope     | 请求作用域对象                        |
| 4）PageContext        | pageContext | pageScope        | 当前页作用域对象，JSP独有的作用于对象 |
PageContext：当前页作用域对象，这是JSP文件独有的作用域对象。Servlet中不存在当前页作用域对象，存放的共享数据仅能在当前JSP文件中使用，不能共享给其他Servlet或者其他JSP文件

真实开发过程，主要用于JSTL标签与JSP文件之间数据共享
三、EL表达式——将引用对象属性写入到响应体
1.命令格式：\${作用域对象别名.AttributeName}

2.命令作用：从作用于对象读取指定共享数据关联的引用对象的属性值。

3.属性名：一定要去引用类型属性名完全一致（大小写）

4.EL表达式没有提供遍历集合的方法。所以不能把集合一个个遍历出来，只能自己一个个的get出来
四、EL表达式——简化版
1.命令格式：\${共享数据名}

2.命令作用：EL表达式允许开发人员开发时省略作用域对象别名

3.共享数据名重名了怎么办？

实测优先级：pageScope \> requestScope \> sessionScope \> applicationScope

4.存在隐患：

可能降低程序执行速度。

5.应用场景：

设计目的：就是简化从PageContext读取共享数据
五、EL表达式——支持运算表达式
1.前提：在JSP文件有时需要将读取共享数据进行一番运算之后，将运算结果写入响应体

2.运算表达式：

1）数学运算：**可以将字符串数字相加（将字符串调方法转换成数字）**

2）关系运输

\> \>= == \< \<= !=

gt ge eq lt le !=

3）逻辑运算

! && \|\|
六、EL表达式——其他内置对象
1.命令格式：\${param.请求参数名}

2.作用：得到请求参数并在web输出

3.如果是像这样呢？http://localhost:8080/04_JSPTest_war_exploded/index.jsp?t=1&t=2

这样的话就只会读取第一个，像要到后面的，需要用paramValues

\${paramValues.请求参数名\[index\]}
