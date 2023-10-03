---
title: 9、BOM
updated: 2021-05-07T16:22:54.0000000+08:00
created: 2021-05-07T15:54:51.0000000+08:00
---

Browser Object Model（浏览器对象模型）

内核：
- IE 6 - 11
- Chrome
- Safari
- FireFox、
- Opera

属性：
1.  Window
2.  Navigator（封装了浏览器的信息）
3.  screen（屏幕）
    - width：宽度
    - height：高度
4.  location（代表当前页面的URL信息）
    - assign('url')：将网页跳转到新的url
5.  document（代表当前页面，HTML DOM文档树）
    - title：\<title\>\</title\>修改其中的内容
    - getElementById()：可以获取指定id的值，就可以通过innerHTML来修改值
    - cookie：获取cookie信息
      1.  劫持cookie：通过植入js代码，来获取cookie，就会丢失用户信息
      2.  好在服务器端可以设置cookie：HttpOnly，使cookie不能被JavaScript访问
6.  history（代表浏览器的历史记录）
    - back()：后退
    - forward()：前进
