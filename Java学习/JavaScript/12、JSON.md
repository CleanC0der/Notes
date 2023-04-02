---
title: 12、JSON
updated: 2021-05-24T21:06:08.0000000+08:00
created: 2021-05-23T20:32:58.0000000+08:00
---

JSON

1.前提：JavaScript中得到的object类型对象方式

方式1：由构造函数生成的对象都是object对象。

new Object()//内置构造函数

方式2：由JSON数据描述格式生成对象都是object类型

2.JSON数据描述格式：

JavaScript中获得object类型对象简化版

3.标准命令格式：

var obj = {"属性名1":value,"属性名2":value…} //这不就是声明对象的方法嘛

4.JSON对象数组：

var jsonArr = \[

{"属性名1":value,"属性名2":value…},

{"属性名1":value,"属性名2":value…},

…

\]

5.将Java对象变成JSON对象：

需要用反射机制将类的属性一个个捞到（也可以直接重写toString方法）

6.JSON工具包：

简化了【5】

1、JSONObject.fromObject(objectName);//返回一个JSONObject对象

2、JSONArray.fromObject(objectName);//返回一个JSONArray对象（JSON数组）
