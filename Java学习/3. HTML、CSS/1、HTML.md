---
title: 1、HTML
updated: 2021-10-28T17:48:42.0000000+08:00
created: 2021-04-23T12:18:36.0000000+08:00
---

HyperText Makeup Language：超文本**标记**语言

**一些基础的标签。**
<table>
<colgroup>
<col style="width: 100%" />
</colgroup>
<thead>
<tr class="header">
<th><p>&lt;!DOCTYPEhtml&gt;</p>
<p>&lt;htmllang="en"&gt;</p>
<p>&lt;head&gt;</p>
<p>&lt;title&gt;页面标签&lt;/title&gt;</p>
<p>&lt;/head&gt;</p>
<p>&lt;body&gt;<em>&lt;!--body主体--&gt;</em></p>
<p>&lt;aname="顶部（设定锚所在位置）"&gt;top&lt;br&gt;&lt;/a&gt;</p>
<p>&lt;h1&gt;一级标签&lt;/h1&gt;</p>
<p>&lt;h2&gt;二级标签&lt;/h2&gt;</p>
<p>&lt;h3&gt;三级标签&lt;/h3&gt;</p>
<p>&lt;h4&gt;四级标签&lt;/h4&gt;</p>
<p>&lt;h5&gt;五级标签&lt;/h5&gt;</p>
<p>&lt;h6&gt;六级标签&lt;/h6&gt;</p>
<p>&lt;p&gt;&lt;strong&gt;粗体&lt;/strong&gt;&lt;/p&gt;</p>
<p>&lt;p&gt;&lt;em&gt;斜体&lt;/em&gt;&lt;/p&gt;</p>
<p>&lt;p&gt;空格&amp;nbsp;&lt;/p&gt;</p>
<p>&lt;p&gt;大于号&amp;gt;&lt;/p&gt;</p>
<p>&lt;p&gt;小于号&amp;lt;&lt;/p&gt;</p>
<p>&lt;p&gt;回车&lt;br&gt;&lt;br&gt;&lt;/p&gt;</p>
<p>&lt;p&gt;版权所有&amp;copy;&lt;/p&gt;</p>
<p>&lt;ahref="https://www.google.com"target="_self"&gt;点击我跳转到谷歌（不在新表页签打开，target也可以省略，默认为_self）&lt;br&gt;&lt;/a&gt;</p>
<p>&lt;ahref="https://www.google.com"target="_blank"&gt;点击跳转到谷歌（在新表页签打开）&lt;br&gt;&lt;br&gt;&lt;/a&gt;</p>
<p>&lt;ahref="2.html#定位点1"target="_blank"&gt;跳转到2.html的定位点1&lt;br&gt;&lt;br&gt;&lt;/a&gt;</p>
<p>&lt;ahref="mailto:fuzhichao.me@gmail.com"&gt;发送邮件到fuzhichao.me@gmail.com&lt;br&gt;&lt;br&gt;&lt;/a&gt;</p>
<p>&lt;atarget="_blank"href="http://wpa.qq.com/msgrd?v=3&amp;uin=&amp;site=qq&amp;menu=yes"&gt;</p>
<p>&lt;imgborder="0"src="http://wpa.qq.com/pa?p=2::51"alt="QQ超链接测试"title="QQ超链接测试"/&gt;</p>
<p>&lt;/a&gt;</p>
<p>&lt;br&gt;&lt;br&gt;</p>
<p>&lt;p&gt;&lt;videosrc=""controlsautoplay&gt;&lt;/video&gt;&lt;/p&gt;</p>
<p>&lt;p&gt;&lt;audiosrc=""controlsautoplay&gt;&lt;/audio&gt;&lt;/p&gt;</p>
<p>&lt;br&gt;&lt;br&gt;&lt;br&gt;&lt;br&gt;&lt;br&gt;&lt;br&gt;&lt;br&gt;&lt;br&gt;&lt;br&gt;&lt;br&gt;&lt;br&gt;&lt;br&gt;&lt;br&gt;&lt;br&gt;&lt;br&gt;&lt;br&gt;&lt;br&gt;&lt;br&gt;</p>
<p></p>
<p>&lt;imgsrc="1.jpg"alt="图片不能加载时代替图片的文字"title="暂停的文字"width="100"&gt;</p>
<p>&lt;br&gt;</p>
<p>&lt;ahref="#顶部（设定锚所在位置）"&gt;回到顶部（锚链接）&lt;/a&gt;</p>
<p>&lt;br&gt;</p>
<p>&lt;/body&gt;</p>
<p>&lt;/html&gt;</p></th>
</tr>
</thead>
<tbody>
</tbody>
</table>

table相关
<table>
<colgroup>
<col style="width: 100%" />
</colgroup>
<thead>
<tr class="header">
<th><p>&lt;!DOCTYPEhtml&gt;</p>
<p>&lt;htmllang="en"&gt;</p>
<p>&lt;head&gt;</p>
<p>&lt;title&gt;Test4-1&lt;/title&gt;</p>
<p>&lt;/head&gt;</p>
<p>&lt;body&gt;</p>
<p>&lt;tableborder="1"cellspacing="0"color="red"&gt;</p>
<p>&lt;tr&gt;</p>
<p>&lt;tdalign="center"&gt;&lt;strong&gt;姓名&lt;/strong&gt;&lt;/td&gt;</p>
<p>&lt;tdalign="center"&gt;张三&lt;/td&gt;</p>
<p>&lt;tdalign="center"&gt;&lt;strong&gt;性别&lt;/strong&gt;&lt;/td&gt;</p>
<p>&lt;tdalign="center"&gt;男&lt;/td&gt;</p>
<p>&lt;tdrowspan="2"align="center"&gt;&lt;imgsrc="1.jpg"width="100px"&gt;&lt;/td&gt;</p>
<p>&lt;/tr&gt;</p>
<p>&lt;tr&gt;</p>
<p>&lt;tdalign="center"&gt;&lt;strong&gt;电话&lt;/strong&gt;&lt;/td&gt;</p>
<p>&lt;tdcolspan="3"align="center"&gt;(0798)11111111&lt;/td&gt;</p>
<p>&lt;/tr&gt;</p>
<p>&lt;tr&gt;</p>
<p>&lt;tdalign="center"&gt;&lt;strong&gt;工作单位&lt;/strong&gt;&lt;/td&gt;</p>
<p>&lt;tdcolspan="4"align="center"&gt;&lt;ahref="http://www.jxau.edu.cn"target="_blank"&gt;江西农业大学&lt;/a&gt;&lt;/td&gt;</p>
<p>&lt;/tr&gt;</p>
<p>&lt;/table&gt;</p>
<p>&lt;/body&gt;</p>
<p>&lt;/html&gt;</p></th>
</tr>
</thead>
<tbody>
</tbody>
</table>

页面结构分析
![image1](Java学习/3.%20HTML、CSS/resources/image1.png)

内联框架
![image2](Java学习/3.%20HTML、CSS/resources/image2.png)

表单
<table>
<colgroup>
<col style="width: 100%" />
</colgroup>
<thead>
<tr class="header">
<th><p>&lt;!DOCTYPEhtml&gt;</p>
<p>&lt;htmllang="en"&gt;</p>
<p>&lt;head&gt;</p>
<p>&lt;title&gt;表单&lt;/title&gt;</p>
<p>&lt;/head&gt;</p>
<p>&lt;body&gt;</p>
<p><em>&lt;!--action指提交给谁，method指方法</em></p>
<p><em>get会在URL里看到东西</em></p>
<p><em>post则看不到，不过还是可以通过浏览器右键审查元素查看</em></p>
<p><em>不过这可以通过加密来隐藏--&gt;</em></p>
<p>&lt;formaction="基础标签.html"method="GET"&gt;</p>
<p><em>&lt;!--required表示不能为空--&gt;</em></p>
<p>&lt;p&gt;账号：&lt;inputtype="text"name="username"placeholder="请输入账号"required&gt;&lt;/p&gt;</p>
<p>&lt;p&gt;密码：&lt;inputtype="password"name="pwd"placeholder="请输入密码"required&gt;&lt;/p&gt;</p>
<p>&lt;p&gt;checkbox&lt;inputtype="checkbox"value="检查"&gt;&lt;/p&gt;</p>
<p>&lt;p&gt;</p>
<p>性别：</p>
<p>&lt;inputtype="radio"value="boy"name="sex"&gt;男</p>
<p>&lt;inputtype="radio"value="girl"name="sex"&gt;女</p>
<p>&lt;/p&gt;</p>
<p>&lt;p&gt;file&lt;inputtype="file"&gt;&lt;/p&gt;</p>
<p>&lt;p&gt;hidden&lt;inputtype="hidden"&gt;&lt;/p&gt;</p>
<p>&lt;p&gt;image，就是一个图片按钮，相当于submit&lt;inputtype="image"src="1.jpg"width="100"&gt;&lt;/p&gt;</p>
<p>&lt;p&gt;button&lt;inputtype="button"value="按钮文字"&gt;&lt;/p&gt;</p>
<p>&lt;p&gt;</p>
<p>下拉框</p>
<p>&lt;selectname="列表名称"id=""&gt;</p>
<p>&lt;optionvalue="一"&gt;一&lt;/option&gt;</p>
<p>&lt;optionvalue="二"&gt;二&lt;/option&gt;</p>
<p>&lt;optionvalue="三"&gt;三&lt;/option&gt;</p>
<p>&lt;/select&gt;</p>
<blockquote>
<p>&lt;/p&gt;</p>
<p><em>&lt;!--文本域--&gt;</em></p>
<p>&lt;p&gt;</p>
<p>&lt;textareaname="textarea"id=""cols="30"rows="10"placeholder="这里是文本域"&gt;&lt;/textarea&gt;</p>
<p>&lt;/p&gt;</p>
<p><em>&lt;!--邮件验证，会自动简单的验证--&gt;</em></p>
<p>&lt;p&gt;邮箱：</p>
<p>&lt;inputtype="email"&gt;</p>
<p>&lt;/p&gt;</p>
<p><em>&lt;!--数字框--&gt;</em></p>
<p>&lt;p&gt;选择数字：</p>
<p>&lt;inputtype="number"name="number"max="10"min="0"step="1"&gt;</p>
<p>&lt;/p&gt;</p>
<p><em>&lt;!--滑块--&gt;</em></p>
<p>&lt;p&gt;</p>
<p>&lt;inputtype="range"name="滑块"max="10"min="1"step="1"&gt;</p>
<p>&lt;/p&gt;</p>
<p>&lt;p&gt;</p>
<p>&lt;inputtype="search"name="search"placeholder="这是搜索框"&gt;</p>
<p>&lt;/p&gt;</p>
<p></p>
<p>&lt;p&gt;</p>
<p>&lt;labelfor="位置"&gt;你点我试试&lt;/label&gt;</p>
<p><em>&lt;!--直接跳转到下面这个input里去了--&gt;</em></p>
<p>&lt;inputtype="text"id="位置"&gt;</p>
<p>&lt;/p&gt;</p>
<p>&lt;p&gt;</p>
<p><em>&lt;!--自定义邮箱，pattern正则表达式，网上搜代码--&gt;</em></p>
<p>&lt;inputtype="text"name="divmail"placeholder="输入邮箱"pattern="^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$"&gt;</p>
<p>&lt;/p&gt;</p>
<p>&lt;p&gt;</p>
<p>&lt;inputtype="submit"&gt;</p>
<p>&lt;inputtype="reset"&gt;</p>
<p>&lt;/p&gt;</p>
<p>&lt;/form&gt;</p>
<p>&lt;/body&gt;</p>
<p>&lt;/html&gt;</p>
</blockquote></th>
</tr>
</thead>
<tbody>
</tbody>
</table>
表单还有两个属性：readonly只读、disabled禁用、hidden隐藏（用于给默认值）

![image3](Java学习/3.%20HTML、CSS/resources/image3.png)

![image4](Java学习/3.%20HTML、CSS/resources/image4.png)

**\<base\>标签：\<base href=""/\>表示当前页面所有链接的基准url**
