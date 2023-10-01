---
title: NO.11 反射
updated: 2021-05-02T12:35:38.0000000+08:00
created: 2021-02-05T19:02:04.0000000+08:00
---

反射机制
2、反射机制（比较简单，因为只要会查帮助文档，就可以了。）

2.1、反射机制有什么用？

通过java语言中的反射机制可以操作字节码文件。

优点类似于黑客。（可以读和修改字节码文件。）

通过反射机制可以操作代码片段。（class文件。）

2.2、反射机制的相关类在哪个包下？

java.lang.reflect.\*;

2.3、反射机制相关的重要的类有哪些？

java.lang.Class：代表整个字节码，代表一个类型，代表整个类。

java.lang.reflect.Method：代表字节码中的方法字节码。代表类中的方法

java.lang.reflect.Constructor：代表字节码中的构造方法字节码。代表类中的构造方法

java.lang.reflect.Field：代表字节码中的属性字节码。代表类中的成员变量（静态变量+实例变量）。

java.lang.Class：

public class User{

// Field

int no;

// Constructor

public User(){

}

public User(int no){

this.no = no;

}

// Method

public void setNo(int no){

this.no = no;

}

public int getNo(){

return no;

}

}

# 3、关于JDK中自带的类加载器：（聊一聊，不需要掌握，知道当然最好！）（可以直接跳过这看回顾部分，最后看这个）
3.1、什么是类加载器？

专门负责加载类的命令/工具。

ClassLoader

3.2、JDK中自带了3个类加载器

启动类加载器:rt.jar

扩展类加载器:ext/\*.jar

应用类加载器:classpath

3.3、假设有这样一段代码：

String s = "abc";

代码在开始执行之前，会将所需要类全部加载到JVM当中。

通过类加载器加载，看到以上代码类加载器会找String.class

文件，找到就加载，那么是怎么进行加载的呢？

首先通过“启动类加载器”加载。

注意：启动类加载器专门加载：C:\Program Files\Java\jdk1.8.0_101\jre\lib\rt.jar

rt.jar中都是JDK最核心的类库。

如果通过“启动类加载器”加载不到的时候，

会通过"扩展类加载器"加载。

注意：扩展类加载器专门加载：C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\\\*.jar

如果“扩展类加载器”没有加载到，那么

会通过“应用类加载器”加载。

**注意：应用类加载器专门加载：classpath中的类。**

3.4、java中为了保证类加载的安全，使用了双亲委派机制。

优先从启动类加载器中加载，这个称为“父”

“父”无法加载到，再从扩展类加载器中加载，

这个称为“母”。双亲委派。如果都加载不到，

才会考虑从应用类加载器中加载。直到加载

到为止。

# 1、回顾反射机制

1.1、什么是反射机制？反射机制有什么用？

反射机制：可以操作字节码文件

作用：可以让程序更加灵活。

1.2、反射机制相关的类在哪个包下？

java.lang.reflect.\*;

1.3、反射机制相关的主要的类？

java.lang.Class

java.lang.reflect.Method;

java.lang.reflect.Constructor;

java.lang.reflect.Field;

1.4、在java中<u>获取Class（不是类，而是字节码文件）</u>的三种方式？

指向字节码文件，代表这个类。

第一种：

Class c = Class.forName("完整类名");//会让类加载

第二种：

Class c = 对象.getClass();

第三种：（Java中任何数据类型，包括基本数据类型都有class属性）

Class c = int.class;

Class c = String.class;

1.5、获取了Class之后，可以调用无参数构造方法来实例化对象

//c代表的就是日期Date类型

Class c = Class.forName("java.util.Date");

//实例化一个Date日期类型的对象，newInstance会调用c的无参构造方法

Object obj = **c.newInstance();**

一定要注意：

newInstance()底层调用的是该类型的无参数构造方法。

如果没有这个无参数构造方法会出现"实例化"异常。

1.6、如果你只想让一个类的“静态代码块”执行的话，你可以怎么做？

Class.forName("该类的类名");

**这样类就加载，类加载的时候，静态代码块执行！！！！**

**在这里，对该方法的返回值不感兴趣，主要是为了使用“类加载”这个动作。**

1.7、关于路径问题？

![image1](Java学习/2.%20JavaSE进阶/resources/image1-9.png)

String path = Thread.currentThread().getContextClassLoader()

.getResource("写相对路径，但是这个相对路径从src出发开始找").getPath();

String path = Thread.currentThread().getContextClassLoader()

.getResource("abc").getPath();//必须保证src下有abc文件。

String path = Thread.currentThread().getContextClassLoader()

.getResource("a/db").getPath();//必须保证src下有a目录，a目录下有db文件。

String path = Thread.currentThread().getContextClassLoader()

.getResource("com/bjpowernode/test.properties").getPath();

**//必须保证src下有com目录，com目录下有bjpowernode目录。**

**//bjpowernode目录下有test.properties文件。**

这种方式是为了获取一个文件的绝对路径。（**通用方式，不会受到环境移植的影响，在macOS和linux上都行**）

但是该文件要求放在**<u>类路径下，换句话说：也就是放到src下面。</u>**

src下是类的根路径，不过获取不到以.java文件，因为加载的是.class文件，因为class存在out里

直接以流的形式返回：

**InputStream in = Thread.currentThread().getContextClassLoader()**

**.getResourceAsStream("com/bjpowernode/test.properties");**

1.8、IO + Properties，怎么快速绑定属性资源文件？

![image2](image2-8.png)

**//要求：第一这个文件必须在类路径下**

**//第二这个文件必须是以.properties结尾。**

**ResourceBundle bundle = ResourceBundle.getBundle("com/bjpowernode/test");**

**String value = bundle.getString(key);**

2、获取Field属性相关
![image3](image3-6.png)

![image4](image4-5.png)
这是演示反射机制有多牛逼，直接反编译class文件。
1.  访问属性的内容：（可能等到学框架才用得上）
    1.  ![image5](image5-5.png)

1.  ![image6](image6-5.png)
2.  访问Method
    1.  可变长度参数
        1.  类似int... args
        2.  **只能放在参数列表的最后一个，且只能有一个**
        3.  一定是三个'.'
        4.  这样就可以往方法里传多个参数
        5.  可以将其当做一个数组看
    2.  通过反射访问Method
        1.  ![image7](image7-5.png)
    3.  通过反射机制调用方法。
        1.  ![image8](image8-4.png)
3.  Constructor
    1.  ![image9](image9-3.png)

4.获取父类型，父类型的接口（反正自己的接口也能看到。）。
![image10](image10-2.png)

2、今日反射机制的重点内容
2.1、通过反射机制访问对象的某个属性。

2.2、通过反射机制调用对象的某个方法。

2.3、通过反射机制调用某个构造方法实例化对象。

2.4、通过反射机制获取父类以及父类型接口。
![image11](image11-2.png)![image12](image12-2.png)
