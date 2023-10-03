---
title: 2、CSS
updated: 2021-08-29T19:57:41.0000000+08:00
created: 2021-05-03T10:37:36.0000000+08:00
---

什么是CSS
层叠样式表(Cascading Style Sheets)
![image1](resources/image1-1.png)
![image2](resources/image2-1.png)

# 语法：
选择器{
声明1;

声明2;

..
}

推荐使用分号结尾
内部样式：用style标签
外部样式：
“链接式”（html标签）：用link标签
“导入式”（css的语法）：
| \<linkrel="stylesheet"href="css/style.css"\> |
|------------------------------------------------|
写在别的文件的好处：
1.  内容和表现分离
2.  网页结构表现统一，可以实现复用
3.  样式十分的丰富
4.  建议使用独立于html的css文件
5.  利用SEO，容易被搜索引擎搜到
行内样式：在标签元素中，编写一个style属性，编写样式

以上三种（其实是四种）遵循就近原则（或者说是覆盖原则），哪个样式离需要改样式的元素近，就是用哪个
<table>
<colgroup>
<col style="width: 100%" />
</colgroup>
<thead>
<tr class="header">
<th><p>&lt;!DOCTYPEhtml&gt;</p>
<p>&lt;htmllang="en"&gt;</p>
<p>&lt;head&gt;</p>
<p>&lt;metacharset="UTF-8"&gt;</p>
<p>&lt;metahttp-equiv="X-UA-Compatible"content="IE=edge"&gt;</p>
<p>&lt;metaname="viewport"content="width=device-width,initial-scale=1.0"&gt;</p>
<p>&lt;title&gt;第一个css&lt;/title&gt;</p>
<p><em>&lt;!--一般写在一块的话就放在head标签里--&gt;</em></p>
<p>&lt;linkrel="stylesheet"href="css/style.css"&gt;</p>
<p>&lt;style&gt;</p>
<p>@importurl("css/style.css");</p>
<p>&lt;/style&gt;</p>
<p>&lt;style&gt;</p>
<p>h1{</p>
<p>color:rgba(72,192,35,0.438);</p>
<p>}</p>
<p>&lt;/style&gt;</p>
<p>&lt;/head&gt;</p>
<p>&lt;body&gt;</p>
<p>&lt;h1style="color:rgba(72,192,35,0.438)"&gt;h1标题&lt;/h1&gt;</p>
<p>&lt;/body&gt;</p>
<p>&lt;/html&gt;</p></th>
</tr>
</thead>
<tbody>
</tbody>
</table>
