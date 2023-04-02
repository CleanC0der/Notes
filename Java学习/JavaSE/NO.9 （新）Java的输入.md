---
title: NO.9 （新）Java的输入
updated: 2021-05-02T12:39:58.0000000+08:00
created: 2020-12-30T21:39:36.0000000+08:00
---

<table>
<colgroup>
<col style="width: 100%" />
</colgroup>
<thead>
<tr class="header">
<th><p><em>//importjava.util.Scanner;//这行加了那下面的java.util.就可以去掉了。</em></p>
<p>publicclassTest{</p>
<p>publicstaticvoidmain(String[]<em>args</em>){</p>
<p>java.util.Scannera=newjava.util.Scanner(System.in);<em>//创建了一个java.util.Scanner对象</em></p>
<p>Strings=a.next();<em>//next是用来输入字符串的，而nextInt就是整数,nextDouble就是双精度浮点型，不过没有nextString</em></p>
<p>System.out.println("Whatyourinputis:"+s);</p>
<p>}</p>
<p>}</p>
<p><em>/*</em></p>
<p><em>next()碰到空格、回车、Tab当做结束符</em></p>
<p><em>而nextLine()只以回车当做结束符</em></p>
<p></p>
<p></p>
<p><em>这些‘.’是不是很熟悉？？像java.util就是一个类，Scanner就是其中的对象，可以和C语言中的结构体对比。</em></p>
<p><em>（大话数据结构里也讲到，面对struct声明和针对结构的参数传递的代码时，可以理解为是类的定义和由类生成对象的传递。）</em></p>
<p><em>（至于创建对象后可以用a.next，怀疑是Java创建对象相当C语言自动用了typedef）</em></p>
<p><em>（也可能是我猜错了。先这样想着，未来学到对象，类再回头看看）</em></p>
<p><em>*/</em></p></th>
</tr>
</thead>
<tbody>
</tbody>
</table>
引入一个对象
