---
title: NO.9 IO流
updated: 2021-05-02T12:36:08.0000000+08:00
created: 2021-02-04T10:37:35.0000000+08:00
---

IO流
1、集合这块最主要掌握什么内容？
1.1、每个集合对象的创建（new）

1.2、向集合中添加元素

1.3、从集合中取出某个元素

1.4、遍历集合

1.5、主要的集合类：

ArrayList

LinkedList

HashSet (HashMap的key，存储在HashMap集合key的元素需要同时重写hashCode + equals)

TreeSet

HashMap

Properties

TreeMap

2、IO流，什么是IO？
I : Input

O : Output

通过IO可以完成硬盘文件的读和写。

3、IO流的分类？

有多种分类方式：

一种方式是按照流的方向进行分类：

以内存作为参照物，

往内存中去，叫做输入(Input)。或者叫做读(Read)。

从内存中出来，叫做输出(Output)。或者叫做写(Write)。

另一种方式是按照读取数据方式不同进行分类：

有的流是按照字节的方式读取数据，一次读取1个字节byte，等同于一次读取8个二进制位。

这种流是万能的，什么类型的文件都可以读取。包括：文本文件，图片，声音文件，视频文件等....

假设文件file1.txt，采用字节流的话是这样读的：

a中国bc张三fe

第一次读：一个字节，正好读到'a'

第二次读：一个字节，正好读到'中'字符的一半。

第三次读：一个字节，正好读到'中'字符的另外一半。

有的流是按照字符的方式读取数据的，一次读取一个字符，这种流是为了方便读取

普通文本文件而存在的，这种流不能读取：图片、声音、视频等文件。只能读取纯

文本文件，连word文件都无法读取。

假设文件file1.txt，采用字符流的话是这样读的：

a中国bc张三fe

第一次读：'a'字符（'a'字符在windows系统中占用1个字节。）

第二次读：'中'字符（'中'字符在windows系统中占用2个字节。）

综上所述：流的分类

输入流、输出流

字节流、字符流

4、Java中的IO流都已经写好了，我们程序员不需要关心,我们最主要还是掌握，
在java中已经提供了哪些流，每个流的特点是什么，每个流对象上的常用方法有
哪些？？？？
java中所有的流都是在：java.io.\*;下。

java中主要还是研究：

怎么new流对象。

调用流对象的哪个方法是读，哪个方法是写。

5、java IO流这块有四大家族：
四大家族的首领：

java.io.InputStream 字节输入流

java.io.OutputStream 字节输出流

java.io.Reader字符输入流

java.io.Writer字符输出流

**四大家族的首领都是抽象类。(abstract class)**

所有的流都实现了：

java.io.Closeable接口，都是可关闭的，都有close()方法。

流毕竟是一个管道，这个是内存和硬盘之间的通道，用完之后一定要关闭，

不然会耗费(占用)很多资源。养成好习惯，用完流一定要关闭。

所有的输出流都实现了：

java.io.Flushable接口，都是可刷新的，都有flush()方法。

养成一个好习惯，输出流在最终输出之后，一定要记得flush()

刷新一下。这个刷新表示将通道/管道当中剩余未输出的数据

强行输出完（清空管道！）刷新的作用就是清空管道。

注意：如果没有flush()可能会导致丢失数据。

注意：在java中只要“类名”以Stream结尾的都是字节流。以“Reader/Writer”结尾的都是字符流。

6、java.io包下需要掌握的流有16个：

文件专属：

java.io.FileInputStream（掌握）
1.  int read();
    1.  执行一次，指针就指向下一个字节。
    2.  指的地方是空时返回-1
2.  int read(byte\[\] bytes)
    1.  返回读取到字节的数量，并将字节储存在数组里。
    2.  没有存到就返回-1
    3.  长度设小了，再读一遍会覆盖值，没覆盖到那就保留原本的值
    4.  以ASCII码储存在数组里，想让咱们能看懂，还是需要变成字符串。（创建字符串对象的时候传入这个数组）
3.  int available()
    1.  返回当前流还有多少字节没读
    2.  **使用技巧：上来就看这个流有多长，直接设置数组的长度，读一次就行了。注：不适合大文件，因为大文件的长度过大， 而数组长度不能很大。**
4.  long skip(long n)
    1.  跳过当前流的n个字节不读
java.io.FileOutputStream（掌握）
1.  构造方法，(String file)/(String file, boolean append)
    1.  append为true则不重写文件，为添加内容
2.  void write()
    1.  将指定的字节写入文件。
3.  void write(byte\[\] b)
    1.  写入整个文件
4.  void write(byte\[\] b, int off, int length)
    1.  从off开始写入length个元素到文件里
5.  **虽然无法直接写入汉字，但是可以通过一个字符串转换成一个byte数组**
    1.  **byte\[\] getBytes();**
java.io.FileReader
1.  只能读字符！！下面的那个也是！
java.io.FileWriter
1.  **write方法可以直接写入字符串！！**

转换流：（将字节流转换成字符流）**（通过构造方法传进去）**

java.io.InputStreamReader

java.io.OutputStreamWriter

缓冲流专属：

java.io.BufferedReader

![image1](Java学习/2.%20JavaSE进阶/resources/image1-7.png)

![image2](image2-6.png)
1.  有个readLine()方法很方便，直接读一行，不过 不会读取换行
java.io.BufferedWriter
1.  一样可以写入字符串。
java.io.BufferedInputStream

java.io.BufferedOutputStream

数据流专属：**(使用这里的写入，也需要用这里的读取，还需要写入时的顺序，不让读不正确，鬼加密)**

java.io.DataInputStream

![image3](image3-4.png)

java.io.DataOutputStream

![image4](Java学习/2.%20JavaSE进阶/resources/image4-3.png)

标准输出流：

java.io.PrintWriter

java.io.PrintStream（掌握）（其实这个天天在用）（写日志用得上）

![image5](image5-3.png)
<table>
<colgroup>
<col style="width: 100%" />
</colgroup>
<thead>
<tr class="header">
<th><p>packagePrintStream;</p>
<p>importjava.io.FileNotFoundException;</p>
<p>importjava.io.FileOutputStream;</p>
<p>importjava.io.PrintStream;</p>
<p>importjava.text.SimpleDateFormat;</p>
<p>importjava.util.Date;</p>
<p><em>/**</em></p>
<p><em>*@author帅帅付</em></p>
<p><em>*project2.04</em></p>
<p><em>*date2021/2/416:56</em></p>
<p><em>**/</em></p>
<p>publicclassMain{</p>
<p>publicstaticvoidmain(String[]<em>args</em>){</p>
<p>Logger.log("付智超好英俊啊！！！！我的心扑通扑通的。");</p>
<p>}</p>
<p>}</p>
<p>classLogger{</p>
<p>publicstaticvoidlog(String<em>str</em>){</p>
<p>Datedate=newDate();</p>
<p>SimpleDateFormatsdf=newSimpleDateFormat("yyyy-MM-ddH:m:ss");</p>
<p>try{</p>
<p>PrintStreamps=newPrintStream(newFileOutputStream("log",true));</p>
<p>System.setOut(ps);</p>
<p>System.out.println(sdf.format(date)+"："+str);</p>
<p>}catch(FileNotFoundException<em>e</em>){</p>
<p>e.printStackTrace();</p>
<p>}</p>
<p>}</p>
<p>}</p></th>
</tr>
</thead>
<tbody>
</tbody>
</table>

对象专属流：

java.io.ObjectInputStream（掌握）

java.io.ObjectOutputStream（掌握）

7、java.io.File类。
File类的常用方法。
1.  boolean createNewFile()
    1.  当且仅当具有此名称的文件尚不存在时，以原方式创建由传入构造函数的路径名命名的新空文件。
2.  boolean mkdir()
    1.  创建由传入构造函数的路径名指定的目录
3.  boolean mkdirs()
    1.  创建传入构造函数的路径名指定的目录，包括子目录
4.  boolean exists()
    1.  测试此抽象路径名表示的文件或目录是否存在。
5.  File getAbsoluteFile()
    1.  返回一个绝对路径
6.  String getAbsolutePath()
    1.  返回此抽象路径名的绝对路径名的字符串。
7.  String getParent()
    1.  以字符串形式返回此抽象路径名父路径，如果此路径名未指定父目录，则返回 null 。
8.  File getParentFile()
    1.  返回此抽象路径名父项的抽象路径名，如果此路径名未指定父目录，则返回 null 。
9.  long lastModified()
    1.  返回上次修改此抽象路径名表示的文件的时间。 从1970-00-00 0:0:0 000开始的毫秒数
10. long length()
    1.  返回此抽象路径名表示的文件的长度。
11. File\[\] listFiles()
    1.  返回一个抽象路径名数组，表示此抽象路径名表示的目录中的文件。
![image6](image6-3.png)

8、java io这块还剩下什么内容：
第一：ObjectInputStream ObjectOutputStream的使用。

第二：IO流+Properties集合的联合使用。

1、拷贝目录。

2、关于对象流（将对象写入硬盘的过程叫做序列化（Serialize），反之就是反序列化（DeSerialize））
ObjectInputStream
1.  里面的readObject()方法不能对同一对象进行多次操作，会出现EOFException，貌似作用格式提醒你没有可以read 的了。经检测，没东西读就会出现这种异常，不像FileInputStream的read，没东西读就返回-1
ObjectOutputStream

![image7](image7-3.png)

关于序列化：
1.  想要对象实现序列化，还需要实现Serializable接口
2.  ![image8](Java学习/2.%20JavaSE进阶/resources/image8-2.png)
3.  同时序列化多个可以使用集合，如List集合。
4.  transient关键字能让对象元素不参与序列化。
5.  ![image9](Java学习/2.%20JavaSE进阶/resources/image9-2.png)

6.  ![image10](Java学习/2.%20JavaSE进阶/resources/image10-1.png)
7.  自动生成序列化版本号的缺陷
    1.  十年前是一个类，十年后修改这个类编译后会产生新的序列化版本号，反序列化就会报错。
    2.  所以建议给该类提供一个固定的序列化版本号，也就是自己想个数写出来。.
    3.  重点：
**参与序列化的类型必须实现java.io.Serializable接口。**

**并且建议将序列化版本号手动的写出来。**

**private static final long serialVersionUID = 1L;**

3、IO + Properties联合使用。
IO流：文件的读和写。

Properties:是一个Map集合，key和value都是String类型。

以下非常重要

![image11](Java学习/2.%20JavaSE进阶/resources/image11-1.png)

![image12](Java学习/2.%20JavaSE进阶/resources/image12-1.png)

![image13](image13-1.png)

