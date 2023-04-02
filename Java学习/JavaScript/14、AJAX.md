---
title: 14、AJAX
updated: 2021-12-08T19:08:00.0000000+08:00
created: 2021-05-24T21:06:17.0000000+08:00
---

1、介绍：
一种做局部刷新的方法。

全局刷新：整个浏览器被新的数据覆盖。在网络中传输大量的数据。浏览器需要加载，渲染页面。

局部刷新：在浏览器的内部，发起请求，获取数据，改变页面中的部分内容。

其余的页面无需加载和渲染。网络中数据传输量少，给用户感受好。

ajax是用来做局部刷新的。局部刷新使用的和新对象是 异步对象【XMLHttpRequest】，这个异步对象是存在浏览器内存中的，使用**JS来创建和使用【XMLHTTPRequest】**对象。
2、AJAX（Asynchronous JavaScript and XML）
AJAX是一种做局部刷新的方法（2003年左右），不是一种语言。

AJAX主要包含的对象有：JavaScript，DOM， CSS， XML等等。

核心是JavaScript和XML。

JavaScript：负责创建异步对象，发送请求，更新页面的DOM对象。

XML：网络中的传输的数据格式。（现在使用JSON替换了XML）
1.  异步对象的属性：
    1.  readState：存有XMLHttpRequest的状态。0-4
0：请求未初始化，创建异步请求对象， var xmlHttp = new XMLHttpRequest()

1：初始化异步请求对象，xmlHttp.open(请求方式, 请求地址, true);

2：异步对象发送请 求，xmlHttp.send();

3：异步对象接收应答数据，从服务端返回数据。XMLHttpRequest内部处理。

4：异步请求对象已经将数据解析完毕。此时才可以读取数据

我们需要在这里更新页面内容。
2.  status：网络请求的状态。
200，404，500
2.  方法：
    1.  open("请求方式", "服务器端的访问地址", 同步(false)or异步(true))
        1.  例如：xmlHttp.open("get", "url", true);
    2.  send()

3、AJAX中使用XMLHttpRequest对象
1.  创建异步对象 var xmlHttp = new XMLHttpRequest();
2.  给异步对象绑定事件。
onreadystatechange：当异步对象发起请求，获取了数据都会触发这个事件。这个事件需要指定一个函数，在函数中处理状态的变化。

例如：

xmlHttp.onreadystatechange = function() {

//处理请求的状态变化

if(xmlHttp.readyState == 4 && xmlHttp.status == 200){

document.getElementById("name").value = data;

//为什么在这里处理数据呢？

//因为之后导致状态变化，异步对象会自动调用onreadystatechange事件对应的函数

//这叫做回调

//open会来一下，send也回来一下

//还有个方法responseText()获取Servlet返回的response的数据

//所以说，xmlHttp代替了浏览器发送和收，与Servlet交互

}

}
3.  初始异步请求对象：
    1.  异步的方法open().
        1.  open("请求方式", "服务器端的访问地址", 同步(false)or异步(true))
            1.  例如：xmlHttp.open("get", "url", true);
            2.  因为xml代替了浏览器的表单，所以表单的值不会传给url，所以我们自己得加上去
4.  使用异步对象发送请求
    1.  xmlHttp.send()
一例胜十言：
<table>
<colgroup>
<col style="width: 100%" />
</colgroup>
<thead>
<tr class="header">
<th><p>&lt;%--</p>
<p>CreatedbyIntelliJIDEA.</p>
<p>User:帅帅付</p>
<p>Date:2021/5/26</p>
<p>Time:20:53</p>
<p>TochangethistemplateuseFile|Settings|FileTemplates.</p>
<p>--%&gt;</p>
<p>&lt;%@pagecontentType="text/html;charset=UTF-8"language="java"%&gt;</p>
<p>&lt;html&gt;</p>
<p>&lt;head&gt;</p>
<p>&lt;title&gt;Title&lt;/title&gt;</p>
<p>&lt;/head&gt;</p>
<p>&lt;body&gt;</p>
<p>&lt;%--</p>
<p>CreatedbyIntelliJIDEA.</p>
<p>User:帅帅付</p>
<p>Date:2021/5/26</p>
<p>Time:20:54</p>
<p>TochangethistemplateuseFile|Settings|FileTemplates.</p>
<p>--%&gt;</p>
<p>&lt;%@pagecontentType="text/html;charset=UTF-8"language="java"%&gt;</p>
<p>&lt;html&gt;</p>
<p>&lt;head&gt;</p>
<p>&lt;title&gt;$Title$&lt;/title&gt;</p>
<p>&lt;scriptsrc="https://code.jquery.com/jquery-3.6.0.min.js"</p>
<p>integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="</p>
<p>crossorigin="anonymous"&gt;</p>
<p>&lt;/script&gt;</p>
<p>&lt;script&gt;</p>
<p>$(function(){</p>
<p>$("input[type='button']").click(functiondoAJAX(){</p>
<blockquote>
<p>letxml=newXMLHttpRequest();</p>
</blockquote>
<p>letname=document.getElementById("name").value;</p>
<p>letweight=document.getElementById("weight").value;</p>
<p>letheight=document.getElementById("height").value;</p>
<p><em>//使用xmlHttpRequest发起请求，接受数据</em></p>
<p>xml.onreadystatechange=function(){</p>
<p><em>//这里操作Servlet返回的结果</em></p>
<p><em>//记得添加条件，什么时候才输出，不让重复输出没用的东西</em></p>
<p>if(xml.readyState===4&amp;&amp;xml.status===200){</p>
<p>$("p").append(xml.responseText);</p>
<p>}</p>
<p>}</p>
<p>letparam="name="+$("input[name='name']").val()+"&amp;weight="+</p>
<p>$("input[name='weight']").val()+"&amp;height="+$("input[name='height']").val();</p>
<p><em>//alert(param);</em></p>
<p>xml.open("get","BMIServlet?"+param,true);</p>
<p>xml.send();</p>
<p>})</p>
<p>})</p>
<p>&lt;/script&gt;</p>
<p>&lt;/head&gt;</p>
<p>&lt;body&gt;</p>
<p>姓名：&lt;inputtype="text"name="name"id="name"&gt;&lt;br&gt;</p>
<p>体重：&lt;inputtype="text"name="weight"id="weight"&gt;&lt;br&gt;</p>
<p>身高：&lt;inputtype="text"name="height"id="height"&gt;&lt;br&gt;</p>
<p>&lt;pid="output"&gt;信息：&lt;/p&gt;</p>
<p>&lt;inputtype="button"value="button"&gt;</p>
<p>&lt;/body&gt;</p>
<p>&lt;/html&gt;</p>
<p>&lt;/body&gt;</p>
<p>&lt;/html&gt;</p>
<p></p></th>
</tr>
</thead>
<tbody>
</tbody>
</table>

异步就是在open执行之后既可以往下执行也可以回调函数，

同步就是在open执行之后必须等待

