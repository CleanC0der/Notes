---
title: NO.8 集合
updated: 2021-05-22T22:03:28.0000000+08:00
created: 2021-01-31T21:57:28.0000000+08:00
---

NO.8 集合
2021年1月31日
集合
# 主要集合概述
1.  什么是集合？
    1.  集合也是一个对象，有内存地址
    2.  集合就是一个容器，可以容纳其他类型数据
    3.  数组就是一个集合
    4.  集合中储存的都是内存地址，是引用，且不能直接储存基本数据类型
    5.  ![image1](Java学习/2.%20JavaSE进阶/resources/image1-6.png)
    6.  在Java中，每一个种集合，底层调用了一种数据结构
    7.  集合分为两大类
        1.  以单个值储存，超级父类为java.util.Collection
            1.  Collection又继承了Iterable（可迭代的）接口，表示这些集合都是可以迭代的（遍历）
        2.  以键值对储存，超级父类为java.util.Map
# Collection和Iterator
1.  Collection
    1.  继承Iterable（可迭代的，即可继承的），这个接口里面有Iterator()方法被继承，可以用Collection创建一个对象调用Iterator()方法返回一个迭代器Iterator对象(Iterator it = 实现Collection接口的对象的引用.Iterator())
    2.  迭代器里有next(),hasnext(),remove()三个方法来实现迭代
    3.  ![image2](image2-5.png)
    4.  Collection中的常用方法
        1.  ![image3](Java学习/2.%20JavaSE进阶/resources/image3-3.png)
        2.  boolean add(Object e)//
            1.  传入数字会自动装箱。
        3.  int size()
            1.  返回集合的大小
        4.  void clear()
            1.  清空集合
        5.  boolean contains(Object o)
            1.  判断集合是否包含这个元素
            2.  底层调用了equals，所以判断String属性元素是否存在要好好斟酌。
        6.  void remove(Object o)
            1.  移除集合内指定元素.
            2.  也会调用equals方法，删一个外面没放进集合里的重写了equals方法且内容相同的类会把集合里的这个类删掉。
        7.  boolean isEmpty()
            1.  判断集合是否为空
        8.  Object\[\] toArray()
            1.  转换成数组
        9.  Iterator iterator()
            1.  创建一个迭代器对象（通过Iterator接口的实现类创建）
            2.  迭代器的方法
                1.  boolean hasNext()
判断集合是否有下一个元素
2.  Object next()
让迭代器指向下一个元素并返回，不过顺序不一定会一样。
3.  只要集合发生改变，迭代器就需要更新
    1.  所以删除元素需要用迭代器里的remove方法，否则出异常。
2.  什么是List？
    1.  有序可重复
        1.  有下标，从0开始，并且怎么存进去的顺序就保持什么顺序

2.  ![image4](Java学习/2.%20JavaSE进阶/resources/image4-2.png)
3.  List特有且常用的方法（和数组一样，下标从0开始）
    1.  void add(int index, Object element)
        1.  向此集合里的index位置上添加element，其他的往后移，用得不多，效率低
    2.  Object get(int index)
        1.  得到下标对应的元素，List特有的方法
    3.  int indexOf(Object element)
        1.  获得指定元素第一次出现的下标，没有的返回-1
    4.  int lastIndexOf(Object element)
        1.  获得指定元素最后一次出现的下标，没有返回-1
    5.  void remove(int index)
        1.  删除指定位置的元素
4.  ArrayList类
    1.  实现了List接口，继承了AbstractList类，初始化容量是10，每次扩容是当前的1.5倍，底层是一个Object类型的数组，如果想自己设置容量，可以new对象的时候传进一个数字当做容量。
    2.  这种类可以扩容，不过建议初始化的时候预估计内存
    3.  **其中一种构造方法，传入一个 集合 转换成数组。**
    4.  非线程安全的
5.  LinkedList类
    1.  底层双向链表
    2.  适合反复增删中间的元素
6.  vector类
    1.  底层是数组
    2.  初始容量10，每次扩容为当前的2倍
    3.  是线程安全的，效率低，使用较少
3.  什么是Set？
    1.  无需不可重复
        1.  无下标，不能重复，存进去是什么顺序，取出来就不一定了
    2.  ![image5](Java学习/2.%20JavaSE进阶/resources/image5-2.png)
    3.  SortedSet
        1.  会自动排序，而自定义类不晓得怎么排序，所以需要实现**Comparable\<\>**接口，实现后去重写compareTo(类名 变量名)方法
        2.  或者在创建TreeSet对象时传入一个比较器。这个比较器需要自己去写一个类去实现**Comparator\<\>**接口，实现compareTo方法(比较规则经常改变选择这个，用哪个规则传哪个类)PS：**TreeSet会去重**
        3.  例程：
        4.  ![image6](Java学习/2.%20JavaSE进阶/resources/image6-2.png)
# Map
![image7](Java学习/2.%20JavaSE进阶/resources/image7-2.png)
#  扩容：之前的两倍
# 
![image8](Java学习/2.%20JavaSE进阶/resources/image8-1.png)

![image9](Java学习/2.%20JavaSE进阶/resources/image9-1.png)

![image10](Java学习/2.%20JavaSE进阶/resources/image10.png)
1.  Map类常用方法
    1.  V put(K key, V value)
        1.  向Map中添加键值对.
        2.  ![image11](Java学习/2.%20JavaSE进阶/resources/image11.png)
        3.  key和value在HashMap中可以为空，但在Hashtable里都不能为空
    2.  **V get(Object key)**
        1.  **通过key获得对应的value**
        2.  ![image12](Java学习/2.%20JavaSE进阶/resources/image12.png)

3.  ![image13](Java学习/2.%20JavaSE进阶/resources/image13.png)
3.  void clear()
    1.  清空Map
4.  boolean containsKey(Object key)
    1.  判断Map的Key部分是否包含传入值
5.  boolean containsValue(Object value)
    1.  判断Map的Value部分是否包含传入值
6.  boolean isEmpty()
    1.  判断Map集合中的元素个数是否为0
7.  **V remove(Object key)**
    1.  **通过key删除键值对**
8.  int size()
    1.  获取Map集合中键值对的个数
9.  Collection\<V\> values()
    1.  获取Map集合中所有的value，返回一个Collection
10. Set\<K\> keySet()
    1.  获取Map集合所有的key
11. Set\<Map.Entry\<K,V\>\> entrySet().
    1.  将Map集合转换成Set集合
    2.  10,11代码的对比
<table>
<colgroup>
<col style="width: 100%" />
</colgroup>
<thead>
<tr class="header">
<th><p>importjava.util.HashMap;</p>
<p>importjava.util.Map;</p>
<p>importjava.util.Set;</p>
<p>publicclassEnhancedForTest01{</p>
<p>publicstaticvoidmain(String[]<em>args</em>){</p>
<p>Map&lt;String,String&gt;maps=newHashMap&lt;&gt;();</p>
<p>maps.put("1","一");</p>
<p>maps.put("2","二");</p>
<p>maps.put("3","三");</p>
<p>maps.put("4","四");</p>
<p><em>//此部分适合小数据量，需要获得map1，再通过map1得到value的值</em></p>
<p>Set&lt;String&gt;setter=maps.keySet();</p>
<p>for(Stringkey:setter){</p>
<p>System.out.println(key+"---&gt;"+maps.get(key));</p>
<p>}</p>
<p>System.out.println("==========================");;</p>
<p><em>//此部分适合大数据量，值都是Map.Entry&lt;String,String&gt;内的属性，直接调用</em></p>
<p>Set&lt;Map.Entry&lt;String,String&gt;&gt;set=maps.entrySet();</p>
<p>for(Map.Entry&lt;String,String&gt;setter2:set){</p>
<p>System.out.println(setter2.getKey()+"---&gt;"+setter2.getValue());</p>
<p>}</p>
<p>}</p>
<p>}</p></th>
</tr>
</thead>
<tbody>
</tbody>
</table>

3.  ![image14](Java学习/2.%20JavaSE进阶/resources/image14.png)

1.  ![image15](Java学习/2.%20JavaSE进阶/resources/image15.png)
2.  properties
# Collections工具类
1.  注意这个末尾的s，这个是工具类，没s的是接口
2.  常用的方法
    1.  publicstatic\<T\>List\<T\>synchronizedList(List\<T\>*list*)
        1.  可以将非线性安全的List类转成线性安全的
    2.  Collections.sort(List\<\> list)/(List\<\> list, Comparator comparator)（PS：Comparator是比较器）
        1.  使集合排序，前者需要被排序的对象实现了Comparable接口，并重写compareTo方法
# 泛型机制
1.  JDK1.5之后有的，然后JDK1.8之后有了自动类型推断机制（又称钻石表达式）
2.  ![image16](Java学习/2.%20JavaSE进阶/resources/image16.png)
3.  不过只是在迭代的时候，只调用父类的方法挺方便的，毕竟迭代器只返回Object类型的数据，但是需要调用子类特有的方法还是需要向下转型
4.  如何使用看下面代码
<table>
<colgroup>
<col style="width: 100%" />
</colgroup>
<thead>
<tr class="header">
<th><p>importjava.util.ArrayList;</p>
<p>importjava.util.Iterator;</p>
<p>publicclassGenericTest01{</p>
<p>publicstaticvoidmain(String[]<em>args</em>){</p>
<p>System.out.println(142);</p>
<p><em>//ArrayList&lt;Animals&gt;里面的Animals在JDK8之后可以删去，JVM可以自动推断</em></p>
<p>ArrayList&lt;Animals&gt;MyList=newArrayList&lt;Animals&gt;();</p>
<p>Catcat1=newCat();</p>
<p>Fishfish1=newFish();</p>
<p>MyList.add(cat1);</p>
<p>MyList.add(fish1);</p>
<p>Iterator&lt;Animals&gt;it=MyList.iterator();</p>
<p>while(it.hasNext()){</p>
<p>it.next().move();</p>
<p>}</p>
<p>}</p>
<p>}</p>
<p>classAnimals{</p>
<p>publicvoidmove(){</p>
<p>System.out.println("动物在移动");</p>
<p>}</p>
<p>}</p>
<p>classCatextendsAnimals{</p>
<p>publicvoideat(){</p>
<p>System.out.println("小猫在吃老鼠");</p>
<p>}</p>
<p>}</p>
<p>classFishextendsAnimals{</p>
<p>publicvoidswim(){</p>
<p>System.out.println("鱼儿在游泳");</p>
<p>}</p>
<p>}</p></th>
</tr>
</thead>
<tbody>
</tbody>
</table>
5.  以上代码都是用了SUN写的类，那么想让自己写的类的某些方法需要接收一些特定类型的参数时该怎么做呢？
    1.  例：class Animals\<随便怎么写\>{ public void doSome(随便怎么写 test){ sout(test);} }
    2.  就是需要new对象作用才有些……
    3.  ![image17](Java学习/2.%20JavaSE进阶/resources/image17.png)
![image18](Java学习/2.%20JavaSE进阶/resources/image18.png)![image19](Java学习/2.%20JavaSE进阶/resources/image19.png)

![image20](Java学习/2.%20JavaSE进阶/resources/image20.png)![image21](image21.png)

![image22](image22.png)![image23](image23.png)![image24](image24.png)

![image25](image25.png)

为什么要重写equals和hashCode方法？
因为默认的equals比较的是内存地址，
默认的hashCode是根据内存地址换算的值，
![image26](image26.png)

因为HashMap里面是无序不可重复，尽管是两个对象，但如果内容一样那就是一样的，就不能同时出现在集合里面，但是，put的底层是先调用hashCode方法，由于没重写，极大概率不能定位在已存在对象所在链表，equals比较的都不是那个已存在的相同对象，所以就会把这个要存的对象的引用存进去，造成重复了

以上是重写hashCode方法的一个原因

hashCode主要用于提升查询效率，来确定在散列结构中对象的存储地址；

![image27](image27.png)![image28](image28.png)
