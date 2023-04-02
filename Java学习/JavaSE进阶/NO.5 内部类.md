---
title: NO.5 内部类
updated: 2021-05-02T12:37:35.0000000+08:00
created: 2021-01-29T17:01:54.0000000+08:00
---

内部类
分别是什么？
![image1](resources/image1-3.png)

静态内部类

实例内部类

局部内部类：

匿名内部类**（属于局部内部类，因没有名字而得名）**

**使用：**
<table>
<colgroup>
<col style="width: 100%" />
</colgroup>
<thead>
<tr class="header">
<th><p>publicinterfaceAnonymousInner{</p>
<p>publicstaticvoidmain(String[]<em>args</em>){</p>
<p>Bb=newB();</p>
<p><em>/*Aa=newA();//因为接口不能new对象，所以需要设置一个类去继承接口A，然后通过那个类new对象生成A型的数据，但是我们可以通过匿名内部类来装逼（在IDEA里可以Alt + Enter自动纠错生成）</em></p>
<p><em>b.sum(a,100,200);*/</em></p>
<p>b.sum(newA(){</p>
<p>@Override</p>
<p>publicintsum(int<em>x</em>,int<em>y</em>){</p>
<p>return<em>x</em>+<em>y</em>;</p>
<p>}</p>
<p>},100,200);//new A(){}花括号里的就是匿名内部类</p>
<p>}</p>
<p>}</p>
<p>interfaceA{</p>
<p>intsum(int<em>x</em>,int<em>y</em>);</p>
<p>}</p>
<p>classB{</p>
<p>publicvoidsum(A<em>a</em>,int<em>x</em>,int<em>y</em>){</p>
<p><em>a</em>.sum(<em>x</em>,<em>y</em>);</p>
<p>}</p>
<p>}</p></th>
</tr>
</thead>
<tbody>
</tbody>
</table>

为什么少用？
可读性差，能不用就不用。

用的时候最好写前面，写在下面识别不了。
