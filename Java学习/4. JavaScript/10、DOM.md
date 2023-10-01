---
title: 10、DOM
updated: 2021-05-07T19:00:42.0000000+08:00
created: 2021-05-07T17:35:18.0000000+08:00
---

Document Object Model

浏览器网页就是一个Dom树形结构
![image1](Java学习/4.%20JavaScript/resources/image1-3.png)
一个标签就是一个节点
更新：更新Dom节点
删除：删除一个Dom节点
添加：添加一个Dom节点
遍历DOM节点：得到Dom节点

对Dom节点操作就需要先获取Dom节点
用document的方法，
document.getElementByTagsName()
document.getElementById()
document.getElementByClass()
创建：
document.createElement('tagName')

传入一个标签字符串，就可以创建一个这样的节点了

然后怎么向节点添加属性？

直接

.属性 = 'xxx'

或者

.setAttribute('属性','值')
更新：
然后可以对节点操作

innerText

就是文本

innerHTML

可以解析HTML标签

都是插入
删除：
要先获取要删除节点的父节点，在通过removeChild方法删除

获取父节点：

var parent = \[idName\].parentElement;

删除子节点：

parent.removeChild(\[idName\])

不过如果要删除多个节点，这样好麻烦

可以通过parent.children获取一个子节点数组，然后通过下标来删，就是这个是实时更新的，删除上面一个，下面的就填上去了
插入：
节点.appendChild(节点)

如果插入的节点是已有的，那么相当于移动这个节点

节点.insertBefore(节点)

在节点前插入

