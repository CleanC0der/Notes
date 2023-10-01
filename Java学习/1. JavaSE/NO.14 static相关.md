---
title: NO.14 static相关
updated: 2021-01-24T10:03:14.0000000+08:00
created: 2021-01-22T17:08:22.0000000+08:00
---

![image1](Java学习/1.%20JavaSE/resources/image1-8.png)
NO.14 static相关
栈
2021年1月22日
17:08
![image2](Java学习/1.%20JavaSE/resources/image2-2.png)![image3](Java学习/1.%20JavaSE/resources/image3-1.png)
局部变量

实例变量
成员变量

静态变量
![image4](Java学习/1.%20JavaSE/resources/image4.png)![image1](Java学习/1.%20JavaSE/resources/image1-8.png)
| 成员 |
|------|
![image5](Java学习/1.%20JavaSE/resources/image5.png)![image6](Java学习/1.%20JavaSE/resources/image6.png)
|         | 实例                              | 是对象相关的                      | 静态        | 是类相关的 |
|----------|-----------------------------------|-----------------------------------|-------------|------------|
| 名称     | 实例函数                          | 实例变量                          | 静态函数    | 静态变量   |
| 如何访问 | new一个对象出来，通过对象变量访问 | new一个对象出来，通过对象变量访问 | 类.函数名() | 类.变量名  |
![image7](Java学习/1.%20JavaSE/resources/image7.png)![image8](Java学习/1.%20JavaSE/resources/image8.png)
堆
![image9](Java学习/1.%20JavaSE/resources/image9.png)![image5](Java学习/1.%20JavaSE/resources/image5.png)![image10](Java学习/1.%20JavaSE/resources/image10.png)![image11](Java学习/1.%20JavaSE/resources/image11.png)
方法区
![image12](Java学习/1.%20JavaSE/resources/image12.png)
静态变量在类加载时就初始化了，不用new对象，并且储存在方法区。

![image13](Java学习/1.%20JavaSE/resources/image13.png)
都是成员函数，成员变量

PS：System.out.println();方法中，System是类名，引用里面的一个static变量out，而out又是一个对象变量（引用），所以可以引用out指向对象中的println()方法。
