---
title: NO.4 Object类
updated: 2021-05-02T12:37:43.0000000+08:00
created: 2021-01-29T11:50:30.0000000+08:00
---

Object类
目前为止我们需要知道的：
**1、protected Object clone()** //负责对象克隆的。（以下浅克隆，深克隆基于类中有个String name属性）
1.  **浅克隆：直接将源对象中的name的引用值拷贝给新对象的name字段；**
2.  **深克隆：根据原Person对象中的name指向的字符串对象创建一个新的相同的字符串对象，将这个新字符串对象的引用赋给新拷贝的Person对象的name字段。**
3.  ![image1](Java学习/2.%20JavaSE进阶/resources/image1-2.png)
4.  **所以，clone方法执行的是浅拷贝， 在编写程序时要注意这个细节。**
**如果想要实现深拷贝，可以通过覆盖Object中的clone方法的方式。**

现在为了要在clone对象时进行深拷贝， 那么就要Clonable接口，覆盖并实现clone方法，除了调用父类中的clone方法得到新的对象， 还要将该类中的引用变量也clone出来。

2、int hashCode() //获取对象哈希值的一个方法。
1.  **目前学不来！！**
3、boolean equals (Object obj) //判断两个对象是否相等
1.  “==”比较的是俩对象变量的值，也就是对象的地址，普通变量才是比较值
2.  默认状态下和“==”效果一样，只不过只能比引用数据类型，所以一般会重写（IDEA中自动重写的equals有几个选项，一般第一页两个都选，第四页（只有出现了引用数据类型才会出现）看情况选，不选的话会用Object类下的
<table>
<colgroup>
<col style="width: 100%" />
</colgroup>
<thead>
<tr class="header">
<th><p>publicstaticbooleanequals(Object<em>a</em>,Object<em>b</em>){</p>
<p>return(<em>a</em>==<em>b</em>)||(<em>a</em>!=null&amp;&amp;<em>a</em>.equals(<em>b</em>));</p>
<p>}</p></th>
</tr>
</thead>
<tbody>
</tbody>
</table>
去判断这个变量是否为空

选的话包含非空值的字段。这个可选的框帮助生成的代码避免了对 null的检查，从而提高性能。）
3.  String类中被复写的equals()方法其实是**比较两个字符串的内容**。
4.  面试题：请解释字符串比较之中“==”和equals()的区别？
==：比较的是两个字符串内存地址（堆内存）的数值是否相等，属于数值比较；

equals()：比较的是两个字符串的内容，属于内容比较。
5.  调用确定不空的对象的equals可以避免空指针异常，例如"admin".equals(username)而不是
username.equals("admin")

4、String toString() //将对象转换成字符串形式
1.  建议重写，简洁但信息丰富的表示，便于人们阅读。
5、protected void finalize() //垃圾回收器负责调用的方法**（注：JDK9之后需要造很多垃圾才能启动这个机制，大于一千万，小于一亿，不过可以使用System.gc()加大概率）**
1.  是对象回收的一个时机，可以重写让其有遗言
2.  ![image2](Java学习/2.%20JavaSE进阶/resources/image2-2.png)
3.  顺便复习下：
    1.  类加载时机：静态代码块
    2.  对象创建时机：普通代码块
    3.  对象回收时机：finalize方法

