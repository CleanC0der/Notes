---
title: NO.11 java的方法重载机制
updated: 2021-06-09T17:41:46.0000000+08:00
created: 2021-01-20T18:38:41.0000000+08:00
---

java的方法重载机制
<table>
<colgroup>
<col style="width: 100%" />
</colgroup>
<thead>
<tr class="header">
<th><p>publicclassOverLoadDemo01{</p>
<p>publicstaticvoidmain(String[]<em>args</em>){</p>
<p>sum(2,4);</p>
<p>sum(2L,4L);</p>
<p>sum(2.0,4.0);</p>
<p>}</p>
<p>publicstaticintsum(int<em>x</em>,int<em>y</em>){</p>
<p>System.out.println("intsum="+(x+y));</p>
<p>returnx+y;</p>
<p>}</p>
<p>publicstaticlongsum(long<em>x</em>,long<em>y</em>){</p>
<p>System.out.println("longsum="+(x+y));</p>
<p>returnx+y;</p>
<p>}</p>
<p>publicstaticdoublesum(double<em>x</em>,double<em>y</em>){</p>
<p>System.out.println("doublesum="+(x+y));</p>
<p>returnx+y;</p>
<p>}</p>
<p>}</p></th>
</tr>
</thead>
<tbody>
</tbody>
</table>

![image1](Java学习/1.%20JavaSE/resources/image1-6.png)
如图所示，不同参数类型、个数甚至参数名换个位置的方法可以使用同一个方法名，只需在调用的时候放入不同类型的变量
注：方法重载与返回类型、修饰符列表无关，只和方法名和参数列表有关。
返回类型是基本数据类型时必须相同。

是引用数据类型是可以是Animals变成Cat如
<table>
<colgroup>
<col style="width: 100%" />
</colgroup>
<thead>
<tr class="header">
<th><p>publicAnimalstest(){</p>
<p>returnnull;</p>
<p>}</p>
<p>publicCatstest(){</p>
<p>returnnull;</p>
<p>}</p></th>
</tr>
</thead>
<tbody>
</tbody>
</table>
是可以的

例：println方法就利用了方法重载（输入不同类型变量都能使用。）
![image2](Java学习/1.%20JavaSE/resources/image2.png)

在java中是如何区分不同方法的呢？
先是看方法名，再是看参数类型
优点：
1、功能相似的方法可以使用同一方法名。
2、整洁美观
