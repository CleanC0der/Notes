---
title: 5、Spring
updated: 2021-10-21T23:11:56.0000000+08:00
created: 2021-09-09T08:10:59.0000000+08:00
---

5、Spring
2021年9月9日
8:10
Spring
Spring全家桶：

Spring， SpringMVC， Spring Boot， Spring Cloud

Spring的作用：解决企业级开发的难度，减轻对项目模块与模块、类和类之间的管理，降低开发难度，帮助开发人员创建对象，管理对象之间的关系，说白了就是 **解耦合** ，核心技术有AOP（面向切面编程），IOC（控制反转），他就是一个容器

Spring的功能：管理依赖，和Maven不同，它管理的是项目内部自己写的类的依赖，而Maven是管理外部依赖。

![image1](Java学习/7.%20Framework/resources/image1-2.png)
1.  什么样的对象放到spring容器中
    1.  dao，controller，service，工具类这种不是代码运行中得到的对象最好放在容器中，
2.  IOC控制反转
    1.  是什么？
        1.  将对象的【创建】，【赋值】，【管理】工作交给代码之外的【容器】实现
        2.  有反转那就有正转，在使用spring之前都是正转，对象都是我们自己【创建管理赋值】
    2.  为什么使用？
        1.  目的就是减少对代码的改动也可以实现不同的功能，**解耦合**
    3.  现在知道有哪些创建对象的方法？
        1.  构造方法：new 对象
        2.  反射
        3.  序列化
        4.  克隆
        5.  ioc：容器创建对象
            1.  想一想，tomcat里Servlet，Listener，Filter是不是这样实现的呢？
没错就是这样，咱们在xml里注册个Servlet，tomcat服务器就会自动给我创建对象，所以tomcat服务器也叫作tomcat容器
4.  IOC的实现：
    1.  DI（Dependence Injection依赖注入）是IOC的技术实现
        1.  只需要在程序中提供对象名称，**创建、赋值、管理都由容器实现**
        2.  底层使用了反射机制
        3.  spring用的就是这个
        4.  实现方式
            1.  **使用spring的配置文件，称为基于xml的DI实现**
                1.  语法
                    1.  *使用对象的set方法*。
                        1.  配置文件：
                            1.  ![image2](Java学习/7.%20Framework/resources/image2-2.png)
                            2.  ![image3](Java学习/7.%20Framework/resources/image3-2.png)
                            3.  (一)是基本类型，(二)是引用
                            4.  然后bean标签里有个autowrite，有两个值【byName，byClass】，前者表示在配置文件里找个id是对象变量名的，后者则是一个类就赋值（子类，实现类都行）。**PS：仅限引用**
                    2.  *使用对象的有参构造*
                        1.  \<constructor-arg/\>
                        2.  可以使用name属性来对特定的变量赋值，也可以使用index指定下标，从0开始，还可以都不写，那就是按顺序赋值了。
                        3.  value表示要赋的值（基本类型），ref是对象
                    3.  来看个例子吧：
                        1.  创建配置文件：可以使用idea创建xml里的Spring模板
<table>
<colgroup>
<col style="width: 100%" />
</colgroup>
<thead>
<tr class="header">
<th><p>&lt;?xmlversion="1.0"encoding="UTF-8"?&gt;</p>
<p>&lt;beansxmlns="http://www.springframework.org/schema/beans"</p>
<p>xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"</p>
<p>xsi:schemaLocation="http://www.springframework.org/schema/beans<a href="http://www.springframework.org/schema/beans/spring-beans.xsd">http://www.springframework.org/schema/beans/spring-beans.xsd</a>"&gt;</p>
<p><em>&lt;!--xsd文件和在mybatis中dtd文件作用一样，都是约束用的，这个格式更强大--&gt;</em></p>
<p><em>&lt;!--spring中将Java对象成为bean，你来创建个bean=你来创建个对象--&gt;</em></p>
<p><em>&lt;!--beans是根标签--&gt;</em></p>
<p><em>&lt;!--一个bean标签就声明一个对象--&gt;</em></p>
<p><em>&lt;!--</em></p>
<p><em>需要声明类时就像下面这样，id就是自定义的名字，class需要写实现类，且是全限定名称，毕竟是用反射实现的嘛</em></p>
<p><em>spring是将创建好的对象放入map中</em></p>
<p><em>--&gt;</em></p>
<p>&lt;beanid="oneService"class="com.fzc.service.impl.OneServiceImpl"/&gt;</p>
<p>&lt;/beans&gt;</p></th>
</tr>
</thead>
<tbody>
</tbody>
</table>
2.  使用：
<table>
<colgroup>
<col style="width: 100%" />
</colgroup>
<thead>
<tr class="header">
<th><p>packagecom.fzc;</p>
<p>importcom.fzc.service.OneService;</p>
<p>importorg.junit.Test;</p>
<p>importorg.springframework.context.ApplicationContext;</p>
<p>importorg.springframework.context.support.ClassPathXmlApplicationContext;</p>
<p><em>/**</em></p>
<p><em>*UnittestforsimpleApp.</em></p>
<p><em>*/</em></p>
<p>publicclassMain</p>
<p>{</p>
<p><em>/**</em></p>
<p><em>*RigorousTest:-)</em></p>
<p><em>*/</em></p>
<p>@Test</p>
<p>publicvoidtestDoSome(){</p>
<p>Stringconfig="beans.xml";<em>//配置文件名称</em></p>
<p><em>/**</em></p>
<p><em>*ApplicationContext是容器</em></p>
<p><em>*ClassPathXmlApplication表示从类路径加载配置文件</em></p>
<p><em>*/</em></p>
<p>ApplicationContextcontext=newClassPathXmlApplicationContext(config);</p>
<p><em>/**</em></p>
<p><em>*要通过getBean来获取对象，这里通过id获取（也就是在配置文件里的id）</em></p>
<p><em>*/</em></p>
<p>OneServiceoneService=(OneService)context.getBean("oneService");</p>
<p>oneService.doSome();</p>
<p></p>
<p></p>
<p>}</p>
<p>}</p></th>
</tr>
</thead>
<tbody>
</tbody>
</table>
3.  并且经过测试，可以发现spring创建对象的是在：new ClassPathApplicationContext(config)时创建了
而且一个bean标签一个对象，是同一个类也没事
2.  如何实现多个配置文件？
    1.  使用一个主配置文件包含其他文件
        1.  \<import resource="路径"/\>
            1.  PS：是classpath:路径，以target的classes作为根目录
            2.  路径可以使用通配符【\*】，这样包含的文件不能包含自己

2.  多文件的分配方式：
    1.  按功能模块，一个模块一个配置文件
    2.  按类的功能，数据库相关的一个文件配置文件，做事务功能一个配置文件，做service功能一个配置文件
2.  **使用spring的注解，称为基于注解的DI实现**
    1.  步骤
        1.  还是要配置文件，在配置文件里写个标签\<context:component-scan base-package=""/\>，在指定路径下扫描所有有注解的类（可以像win7设置环境变量那样用分号隔开每个扫描的地方）
        2.  创建对象的方法
            1.  @Component（写在类上方）
                1.  @Component(value = "")//表示这个对象放在容器中的名字是什么
                2.  @Component("")//作用与（一）一致
                3.  @Component //Spring自动取个名字，为【首字母小写的类名】
            2.  @Repository（放在持久层类的上面，使用方法与（一）一致）
            3.  @Service（放在业务处理类的上面，使用方法与（一）一致）
            4.  @Controller（用于控制器上面，使用方法与（一）一致）
            5.  PS：（一）\~（四）功能一样，只是表示不同含义，对项目分层的。
        3.  赋值
            1.  @Value（写在变量上方或者set方法上，前者不会用set方法，后者会用）
                1.  @Value(value = "")//直接将值赋给对象
                2.  @Value("")//
            2.  @Autowrited（写在变量上面或者set方法上面）
                1.  @Autowrited//默认写法，默认是byType，这样是给引用赋值的一个方法
                2.  @Autowrited(required = false)//表示引用找不到时不报错，通过
            3.  @Qualifier(value = "")//与@Autowrited一起使用，表示byName，value的值就是name，可以直接""不写value
            4.  @Resource//JDK自带的注解，新版本没有。
                1.  @Resource//默认byName，失败后byType
                2.  @Resource(name = "")//只使用byName
3.  AOP（Aspect Oriented Programing）
    1.  是什么？
        1.  基于动态代理，可以使用jdk或者cglib两种动态代理方式，AOP就是动态代理的规范化，把动态代理的步骤、方式都定义好了，让开发人员使用一种统一的规范来使用动态代理。
    2.  怎么理解？
        1.  需要在分析项目功能时，找出切面。
        2.  合理的安排切面的执行时间（在目标方法前，还是目标方法后）
        3.  合理的安排切面执行的位置（在哪个类，哪个方法增加增强功能）
        4.  术语：
            1.  Aspect（切面）：表示增强的功能，就是一堆代码，完成某一个功能（非业务功能），常见的切面功能有日志，事务，统计信息，参数检查，权限验证。
            2.  JoinPoint（连接点）：连接业务方法和切面的位置。即invoke中执行某个方法的位置。
            3.  Pointcut（切入点）：指多个连接点方法的集合，是多个方法，即invoke中一些功能的位置（看一个说法是，加了if判断某个方法的地方就是JoinPoint，没加的地方就是Pointcut
            4.  目标对象：给哪个类的方法增加功能，这个类就是目标对象
            5.  Advice：通知，通知表示切面功能执行的时机
        5.  切面的三个关键要素：
            1.  切面的功能代码，切面干什么。
            2.  切面的执行位置，使用Pointcut表示切面执行的位置
            3.  切面的执行时间，使用Advice表示时间，在目标方法之前，还是目标方法之后。
    3.  怎么实现？
        1.  安排是一个规范，是动态代理的一个规范化，一个标准。
        2.  aop的技术实现框架：
            1.  spring：spring在内部实现了安排规范，能做aop的工作。spring主要在食物处理时使用aop。我们项目开发中很少使用spring的aop实现。因为spring的aop比较笨重。
            2.  aspectJ：一个开源的专门做aop的框架。spring框架中集成了aspectJ框架，通过spring就能使用aspectJ的功能。
                1.  哪个代理：
                    1.  有接口默认是JDK动态代理，没有就是cglib
                    2.  想有接口也用cglib要在配置文件里将\<aop:aspectj-autoproxy/\>改成\<aop:aspectj-autoproxy proxy-target-class="true"/\>
                2.  其实现aop有两种方式：
                    1.  使用xml的配置文件：配置全局事务
                    2.  使用注解：一般使用这个注解，有5个**（属于Advice）**
                        1.  @Before（执行方法前运行这个方法）
                            1.  方法要求如下：
1.  public
2.  没有返回值
3.  名称可以自定义，但要是有参数，参数不是，有规定的
    1.  @AfterReturning（方法执行后返回时执行：目标方法() -》 切面方法 -》 变量 = 目标方法()，**期间可对返回值做修改**）
        1.  参数：
1.  value：写execution，切入点
2.  returning：返回值，要与方法形参名一样（可选）
    1.  方法要求如下：
1.  除了与@Before一样还有方法有参数，推荐是Object，参数名自定义（自定义变量名必须和通知方法的形参名一样）。
    1.  特点：
1.  可以根据返回值做不同的处理功能
2.  可以修改这个返回值。
    1.  @Around
        1.  方法要求如下：
1.  public
2.  **必须有返回值**，推荐使用Object
3.  名称自定义
4.  方法有参数，固定参数：ProceedingJoinPoint
    1.  特点
1.  它是功能最强的通知
2.  在目标方法的前后都能增强功能
3.  控制目标方法是否被调用执行（通过ProceedingJoinPoint里的proceed方法来调用，会有返回值）
4.  修改原来的目标方法的执行结果。影响最后的调用结果
5.  **等同于JDK动态代理的InvocationHandler接口里的invoke方法，咱们自己定义咋搞**
    1.  @AfterThrowing
        1.  参数：
1.  value
2.  throwing：异常名，要与方法的Exception参数名一致（可选）
    1.  方法要求如下：
1.  public
2.  无返回值
3.  名称自定义
4.  参数为Exception，可选JoinPoint
    1.  特点：
1.  在方法抛出异常前执行。
    1.  @After
        1.  方法要求如下：
1.  public
2.  无返回值
3.  名称自定义
4.  参数可选JoinPoint
    1.  特点
1.  类似finally，不管抛不抛异常都会执行
    1.  @Pointcut
        1.  方法要求：
1.  无要求，名字自定义
    1.  特点
1.  重复利用切入点表达式
2.  方法名就是别名。
3.  当需要用到@Pointcut中value的切入点时，可以使用别名来代替（要带括号）。

7.  参数：
    1.  JointPoint：表示此时执行的方法的信息，**所有通知都可以用（PS：必须放在参数列表的第一位）**
    2.  Object result：自定义的，储存着方法返回值，@AfterReturning(value = "", returning = "result") 表示返回值赋给result
3.  定义了专门的表达式用于指定切入点**（属于Pointcut）**：
    1.  方法上面加个注解，里面写切入点表达式
    2.  execution(\[访问控制权限\] 返回值类型 \[包名类名\] 方法名 \[抛出异常类型\]) //红色表示必选
    3.  ![image4](Java学习/7.%20Framework/resources/image4-2.png)
    4.  示例：
        1.  execution(\* \*(..)) //指定切入点为任一 方法
        2.  execution(\* com.fzc..\*.\*(..)) //fzc及其子包的任一方法，注意，..表示当前包及其子包
4.  代码：
    1.  创建切面类（就是普普通通的类），就是要在类的上面加入@Aspect
    2.  在类中定义方法，方法就是切面要执行的功能代码，在方法的上面加入aspectJ中的通知注解，例如【@Before】，有需要指定切入点表达式execution()

3.  示例：
    1.  配置文件：
<table>
<colgroup>
<col style="width: 100%" />
</colgroup>
<thead>
<tr class="header">
<th><p></p>
<p>&lt;?xmlversion="1.0"encoding="UTF-8"?&gt;</p>
<p>&lt;beansxmlns="http://www.springframework.org/schema/beans"</p>
<p>xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"</p>
<p>xmlns:context="http://www.springframework.org/schema/context"</p>
<p>xmlns:aop="http://www.springframework.org/schema/aop"</p>
<p>xsi:schemaLocation="http://www.springframework.org/schema/beans<a href="http://www.springframework.org/schema/beans/spring-beans.xsd">http://www.springframework.org/schema/beans/spring-beans.xsd</a><a href="http://www.springframework.org/schema/context">http://www.springframework.org/schema/context</a><a href="https://www.springframework.org/schema/context/spring-context.xsd">https://www.springframework.org/schema/context/spring-context.xsd</a><a href="http://www.springframework.org/schema/aop">http://www.springframework.org/schema/aop</a><a href="https://www.springframework.org/schema/aop/spring-aop.xsd">https://www.springframework.org/schema/aop/spring-aop.xsd</a>"&gt;</p>
<p>&lt;context:component-scanbase-package="com.fzc"/&gt;</p>
<p><em>&lt;!--表示将容器中所有类能当代理的对象自动变成代理（根据execution中的东西，所以即使切面类不是目标类也要让容器管理），</em></p>
<p><em>这是在内存中修改结构的操作，</em></p>
<p><em>所以目标类就是代理类了</em></p>
<p><em>--&gt;</em></p>
<p>&lt;aop:aspectj-autoproxy/&gt;</p>
<p>&lt;/beans&gt;</p></th>
</tr>
</thead>
<tbody>
</tbody>
</table>
2.  实现类（目标类）（接口就不写出来了）：
<table>
<colgroup>
<col style="width: 100%" />
</colgroup>
<thead>
<tr class="header">
<th><p>package com.fzc.service;</p>
<p><em>/*</em></p>
<p><em>* 2021/10/7</em></p>
<p><em>*/</em></p>
<p>import org.springframework.stereotype.Service;</p>
<p>@Service</p>
<p>public class OneServiceImpl implements OneService {</p>
<p>  @Override</p>
<p>  public void beforeTest() {</p>
<p>    System.out.println("这里是OneService.beforeTest()方法");</p>
<p>  }</p>
<p>  @Override</p>
<p>  public StringBuilder afterReturningTest() {</p>
<p>    System.out.println("这里是OneService.afterReturningTest()方法");</p>
<p>    return new StringBuilder("付智超最帅（afterReturningTest）");</p>
<p>  }</p>
<p>  @Override</p>
<p>  public StringBuilder aroundTest() {</p>
<p>    System.out.println("这里是OneService.aroundTest()方法");</p>
<p>    return new StringBuilder("付智超好帅（aroundTest）");</p>
<p>  }</p>
<p>  @Override</p>
<p>  public void afterThrowingTest() {</p>
<p>    System.out.println("这里是OneService.afterThrowingTest()方法");</p>
<p>    int a = 1 / 0;</p>
<p>  }</p>
<p>  @Override</p>
<p>  public void afterTest() {</p>
<p>    System.out.println("这里是OneService.afterTest()方法");</p>
<p>  }</p>
<p>}</p></th>
</tr>
</thead>
<tbody>
</tbody>
</table>
3.  切面类：
<table>
<colgroup>
<col style="width: 100%" />
</colgroup>
<thead>
<tr class="header">
<th><p></p>
<p>package com.fzc.service;</p>
<p><em>/*</em></p>
<p><em>* 2021/10/7</em></p>
<p><em>* MyAspect</em></p>
<p><em>*/</em></p>
<p>import org.aspectj.lang.JoinPoint;</p>
<p>import org.aspectj.lang.ProceedingJoinPoint;</p>
<p>import org.aspectj.lang.annotation.*;</p>
<p>import org.springframework.stereotype.Component;</p>
<p><em>/**</em></p>
<p><em>* @Aspect 代表是一个切面类</em></p>
<p><em>*   切面类：用来增加功能的，在这个类中有切面的功能代码</em></p>
<p><em>*   位置：在类定义的上面</em></p>
<p><em>*/</em></p>
<p>@Aspect</p>
<p>@Component</p>
<p>public class MyAspect {</p>
<p>  <em>/*</em></p>
<p><em>   现在定义方法，方法是实现切面功能的</em></p>
<p><em>   要求如下：</em></p>
<p><em>   1、public</em></p>
<p><em>   2、没有返回值</em></p>
<p><em>   3、名称可以自定义，但要是有参数，参数不是，有规定的</em></p>
<p><em>  */</em></p>
<p><em>  /**</em></p>
<p><em>  * @Before 表示在指定方法前执行</em></p>
<p><em>  * 不会改变目标方法</em></p>
<p><em>  */</em></p>
<p>  @Before("execution(* *..before*(..))")</p>
<p>  public void doBefore() {</p>
<p>    System.out.println("这里是@Before");</p>
<p>  }</p>
<p>  @AfterReturning(value = "execution(* *..afterReturning*(..))", returning =</p>
<p>      "res")</p>
<p>  public void doAfterReturning(JoinPoint <em>method</em>, Object <em>res</em>) {</p>
<p>    System.out.println("这里是@AfterReturning，方法：" + method.getSignature() + "返回了：" + res);</p>
<p>    <em>//下面一句对返回结果做修改。</em></p>
<p>    ((StringBuilder) res).append("AfterReturning");</p>
<p>  }</p>
<p>  @Around("execution(* *..around*(..))")</p>
<p>  public Object doAround(ProceedingJoinPoint <em>method</em>) throws Throwable {</p>
<p>    Object result = null;</p>
<p>    System.out.println("@Around，在方法执行前");</p>
<p>    result = method.proceed(); <em>//相当于InvocationHandler里的invoke方法</em></p>
<p>    System.out.println("@Around，在方法执行之后");</p>
<p>    ((StringBuilder) result).append("Around");</p>
<p>    return result;</p>
<p>  }</p>
<p>  @AfterThrowing(value = "execution(* *..afterThrowing*(..))", throwing =</p>
<p>      "exception")</p>
<p>  public void doAfterThrowing(Exception <em>exception</em>) {</p>
<p>    System.out.println("这里是@AfterThrowing，抛出了异常：" + exception.getMessage());</p>
<p>  }</p>
<p>  @After("pointcutTest()")</p>
<p>  public void doAfter() {</p>
<p>    System.out.println("这里是@After");</p>
<p>  }</p>
<p>  @Pointcut("execution(* *..afterTest(..))")</p>
<p>  private void pointcutTest(){}</p>
<p>}</p></th>
</tr>
</thead>
<tbody>
</tbody>
</table>
4.  结果：
![image5](Java学习/7.%20Framework/resources/image5-1.png)
4.  Spring整合Mybatis
    1.  步骤：
        1.  新建Maven项目
        2.  加入Maven依赖
            1.  junit
            2.  spring-context
            3.  spring-tx //spring事务
            4.  spring-jdbc //spring事务
            5.  mybatis
            6.  mysql-connector-java
            7.  mybatis-spring //mybatis和spring集成的依赖：mybatis官方体用的，用来spring项目中创建mybatis的SqlSessionFactory，DAO对象的
            8.  druid
        3.  创建实体类
        4.  创建DAO接口和mapper文件
        5.  创建mybatis主配置文件
        6.  创建Service接口和实现类，属性是DAO
        7.  创建spring的配置文件，声明mybatis的对象交给spring创建
            1.  SqlSessionFactory
            2.  DAO对象
            3.  声明自定义的Service
    2.  代码演示：
        1.  mybatis的主配置文件：
<table>
<colgroup>
<col style="width: 100%" />
</colgroup>
<thead>
<tr class="header">
<th><p></p>
<p>&lt;?xml version="1.0" encoding="UTF-8" ?&gt;</p>
<p><em>&lt;!--配置文件--&gt;</em></p>
<p>&lt;!DOCTYPE configuration</p>
<p>    PUBLIC "-//mybatis.org//DTD Config 3.0//EN"</p>
<p>    "<a href="http://mybatis.org/dtd/mybatis-3-config.dtd">http://mybatis.org/dtd/mybatis-3-config.dtd</a>"&gt;</p>
<p><em>&lt;!--根标签（配置用）--&gt;</em></p>
<p>&lt;configuration&gt;</p>
<p>  <em>&lt;!-- settings控制mybatis全局行为 --&gt;</em></p>
<p>  &lt;settings&gt;</p>
<p>    <em>&lt;!--打印日志--&gt;</em></p>
<p>    &lt;setting name="logImpl" value="STDOUT_LOGGING"/&gt;</p>
<p>  &lt;/settings&gt;</p>
<p>  <em>&lt;!--这个标签是设置别名的--&gt;</em></p>
<p>  &lt;typeAliases&gt;</p>
<p>    <em>&lt;!--这里表示entity下的类的别名就是类名，不区分大小写--&gt;</em></p>
<p>    &lt;package name="com.fzc.entity"/&gt;</p>
<p>  &lt;/typeAliases&gt;</p>
<p>  <em>&lt;!-- SQL映射文件的位置，有一个文件就写一个【mapper】 --&gt;</em></p>
<p>  &lt;mappers&gt;</p>
<p>    &lt;package name="com/fzc/dao"/&gt;</p>
<p>  &lt;/mappers&gt;</p>
<p>&lt;/configuration&gt;</p>
<p><em>&lt;!-- mybatis的主配置文件--&gt;</em></p></th>
</tr>
</thead>
<tbody>
</tbody>
</table>
2.  一个接口的mapper文件：
<table>
<colgroup>
<col style="width: 100%" />
</colgroup>
<thead>
<tr class="header">
<th><p></p>
<p>&lt;?xml version="1.0" encoding="UTF-8" ?&gt;</p>
<p>&lt;!DOCTYPE mapper</p>
<p>    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"</p>
<p>    "<a href="http://mybatis.org/dtd/mybatis-3-mapper.dtd">http://mybatis.org/dtd/mybatis-3-mapper.dtd</a>"&gt;</p>
<p>&lt;mapper namespace="com.fzc.dao.StudentDAO"&gt;</p>
<p>  &lt;select id="selectStudents" resultType="Student"&gt;</p>
<p>    select id,name,email,age from student</p>
<p>  &lt;/select&gt;</p>
<p>  &lt;insert id="insertStudent"&gt;</p>
<p>    insert into student values(#{id}, #{name}, #{email}, #{age})</p>
<p>  &lt;/insert&gt;</p>
<p>&lt;/mapper&gt;</p></th>
</tr>
</thead>
<tbody>
</tbody>
</table>
3.  spring的配置文件：
<table>
<colgroup>
<col style="width: 100%" />
</colgroup>
<thead>
<tr class="header">
<th><p></p>
<p>&lt;?xml version="1.0" encoding="UTF-8"?&gt;</p>
<p>&lt;beans xmlns="http://www.springframework.org/schema/beans"</p>
<p>   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"</p>
<p>   xmlns:context="http://www.springframework.org/schema/context"</p>
<p>   xsi:schemaLocation="http://www.springframework.org/schema/beans <a href="http://www.springframework.org/schema/beans/spring-beans.xsd">http://www.springframework.org/schema/beans/spring-beans.xsd</a> <a href="http://www.springframework.org/schema/util">http://www.springframework.org/schema/util</a> <a href="https://www.springframework.org/schema/util/spring-util.xsd">https://www.springframework.org/schema/util/spring-util.xsd</a> <a href="http://www.springframework.org/schema/context">http://www.springframework.org/schema/context</a> <a href="https://www.springframework.org/schema/context/spring-context.xsd">https://www.springframework.org/schema/context/spring-context.xsd</a>"&gt;</p>
<p>  <em>&lt;!--引入属性配置文件--&gt;</em></p>
<p>  &lt;context:property-placeholder location="classpath:jdbc.properties"/&gt;</p>
<p>  <em>&lt;!--创建一个Druid对象--&gt;</em></p>
<p>  &lt;bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource" init-method="init"</p>
<p>     destroy-method="close"&gt;</p>
<p>    &lt;property name="url" value="${jdbc.url}"/&gt;</p>
<p>    &lt;property name="username" value="${jdbc.username}"/&gt;</p>
<p>    &lt;property name="password" value="${jdbc.password}"/&gt;</p>
<p>    &lt;property name="maxActive" value="${jdbc.maxActive}"/&gt;</p>
<p>  &lt;/bean&gt;</p>
<p>  <em>&lt;!--创建一个SqlSessionFactoryBean就是创建一个SqlSessionFactory--&gt;</em></p>
<p>  &lt;bean id="sqlSessionFactory"</p>
<p>     class="org.mybatis.spring.SqlSessionFactoryBean"&gt;</p>
<p>    &lt;property name="configLocation"</p>
<p>         value="classpath:mybatis.xml"/&gt;</p>
<p>    &lt;property name="dataSource" ref="dataSource"/&gt;</p>
<p>  &lt;/bean&gt;</p>
<p>  <em>&lt;!--在内部将SqlSessionFactory调用openSession方法，然后将所有接口来getMapper，之后那些DAO的默认id是类名首字母小写--&gt;</em></p>
<p>  &lt;bean class="org.mybatis.spring.mapper.MapperScannerConfigurer"&gt;</p>
<p>    &lt;property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/&gt;</p>
<p>    &lt;property name="basePackage" value="com.fzc.dao"/&gt;</p>
<p>  &lt;/bean&gt;</p>
<p>&lt;/beans&gt;</p></th>
</tr>
</thead>
<tbody>
</tbody>
</table>
4.  之后使用就正常使用就行了
5.  Spring的事务处理
    1.  ![image6](Java学习/7.%20Framework/resources/image6-1.png)
    2.  Spring具体怎么实现事务管理呢？
        1.  使用事务管理器，代替你完成commit，rollback
        2.  事务管理器是一个接口和其众多实现类。
            1.  接口PlatformTransactionManager，定义了事务的重要方法commit，rollback
            2.  spring把每一种【数据库访问技术】对应的事务处理类的创建好了（例如mybatis，jdbc）
        3.  使用：在配置文件里声明访问技术对应的类即可
        4.  PlatformTransactionManager里的事务相关
            1.  隔离级别
                1.  DEFAULT：默认，采用DB默认的事务隔离级别。MySQL默认是REPEATABLE_READ，Oracle默认为READ_COMMITTED
                2.  READ_UNCOMMITED：读未提交
                3.  READ_COMMITTED：读已提交
                4.  REPEATABLE_READ：可重复读。
                5.  SERIALIZABLE：序列化。
            2.  事务超时时间
                1.  表示一个方法最长的执行时间，方法执行超过了时间就回滚，单位为**秒**，默认为-1（无限）
            3.  **传播行为**
                1.  PROPAGATION_REQUIRED（Spring默认）
                    1.  ![image7](Java学习/7.%20Framework/resources/image7-1.png)
                2.  PROPAGATION_REQUIRES_NEW
                    1.  ![image8](Java学习/7.%20Framework/resources/image8-1.png)
例如select就可以这样
3.  PROPAGATION_SUPPORTS
    1.  ![image9](Java学习/7.%20Framework/resources/image9-1.png)

2.  ![image10](Java学习/7.%20Framework/resources/image10-1.png)
4.  PROPAGATION_MANDATORY
5.  PROPAGATION_NESTED
6.  PROPAGATION_NEVER
7.  PROPAGATION_SUPPORTED
5.  事务提交时机，回滚事务的时机
    1.  提交事务：
        1.  执行成功，没有异常抛出，当方法执行完毕，spring在方法执行后提交事务
        2.  业务方法抛出【编译时异常】，提交事务
    2.  回滚事务：
        1.  业务方法抛出【运行时异常】或【error】
6.  总结：
    1.  管理事务的是【事务管理模型】和【其实现类】
    2.  spring的事务是一个统一模型
        1.  执行要使用的事务管理器实现类，使用\<bean\>
        2.  指定哪些类，哪些方法需要加入事务的功能
        3.  指定方法需要的隔离级别，传播行为，超时
3.  使用：
    1.  Spring的事务注解管理事务（适合小项目）
        1.  在【业务方法】上使用@Transactional
            1.  像是try {业务方法;commit();} catch { rollback();} finally {close();}
            2.  一般用默认的就行，不需要设置参数
            3.  可选属性：
                1.  propagation：用于设置事务传播行为，属性为Propagation，默认值为Propagation.REQUIRED
                2.  isolation：用于设置事务的隔离级别，属性类型为Isolation，默认为Isolation.DEFAULT
                3.  readOnly：用于设置该方法对数据库的操作是否是只读的。该属性为boolean，默认值为false
                4.  timeout：用于设置本操作与数据库连接的超时时限，单位为秒，类型为int，默认为-1，没有时限
                5.  rollbackFor：指定需要回滚的异常类，类型为Class\[\]，默认为空数组，只有一个异常可以不使用数组） //spring看这个数组里有没有，没有就看是不是RuntimeException，是的话就回滚
                6.  rollbackForClassName：指定需要回滚的异常类类名，类型为String\[\]，默认为空数组，只有一个异常类时可以不使用数组
                7.  noRollbackFor：指定不需要回滚的异常类，与【5】一致。
                8.  noRollbackForClassName：指定不需要回滚的异常类类名，与【6】一致
            4.  示例：
                1.  spring配置文件：多了个（注意是springframework.org/schema/tx下的
                    1.  ![image11](Java学习/7.%20Framework/resources/image11-1.png)
                2.  然后在需要事务的类或者方法加上@Transactional即可
    2.  AspectJ的事务管理
        1.  配置文件需要变换一下：添加maven依赖
<table>
<colgroup>
<col style="width: 100%" />
</colgroup>
<thead>
<tr class="header">
<th><p></p>
<p>&lt;dependency&gt;</p>
<p> &lt;groupId&gt;org.springframework&lt;/groupId&gt;</p>
<p> &lt;artifactId&gt;spring-aspects&lt;/artifactId&gt;</p>
<p> &lt;version&gt;5.3.10&lt;/version&gt;</p>
<p>&lt;/dependency&gt;</p></th>
</tr>
</thead>
<tbody>
</tbody>
</table>
2.  spring配置
<table>
<colgroup>
<col style="width: 100%" />
</colgroup>
<thead>
<tr class="header">
<th><p></p>
<p>  <em>&lt;!--配置aspectJ的事务--&gt;</em></p>
<p>  &lt;tx:advice id="myAdvice" transaction-manager="transactionManager"&gt;</p>
<p>    <em>&lt;!--attributes配置事务属性--&gt;</em></p>
<p>    &lt;tx:attributes&gt;</p>
<p>      <em>&lt;!--</em></p>
<p><em>      name：需要配置事务方法的名字（可以使用通配符）</em></p>
<p><em>      propagation：传播行为</em></p>
<p><em>      rollback-for：需要回滚的异常，是全限定名称</em></p>
<p><em>      --&gt;</em></p>
<p>      &lt;tx:method name="buy" propagation="REQUIRED"</p>
<p>           rollback-for="com.fzc.exception.AmountNotEnoughException"/&gt;</p>
<p>    &lt;/tx:attributes&gt;</p>
<p>  &lt;/tx:advice&gt;</p>
<p>  <em>&lt;!--配置事务切入点--&gt;</em></p>
<p>  &lt;aop:config&gt;</p>
<p>    <em>&lt;!--配置切入点--&gt;</em></p>
<p>    <em>&lt;!--</em></p>
<p><em>    id：唯一标识符</em></p>
<p><em>    expression：切入点表达式</em></p>
<p><em>    --&gt;</em></p>
<p>    &lt;aop:pointcut id="servicePointcut" expression="execution(* *..service.*.*(..))"/&gt;</p>
<p>    <em>&lt;!--关联advice和pointcut，使用advice-ref和pointcut-ref--&gt;</em></p>
<p>    &lt;aop:advisor advice-ref="myAdvice" pointcut-ref="servicePointcut"/&gt;</p>
<p>  &lt;/aop:config&gt;</p></th>
</tr>
</thead>
<tbody>
</tbody>
</table>
6.  Spring写Web
    1.  因为在servlet里创建容器会导致每次使用都会创建一个容器，容器又创建对象，导致资源消耗
    2.  解决方法：在监听器里监听全局作用域对象的生成，好在框架有，不需要我们自己搞
    3.  使用：
        1.  先在maven里加入依赖：spring-web
\<!-- <https://mvnrepository.com/artifact/org.springframework/spring-web> --\>

\<dependency\>

\<groupId\>org.springframework\</groupId\>

\<artifactId\>spring-web\</artifactId\>

\<version\>5.3.11\</version\>

\</dependency\>
2.  在web.xml里写，框架会帮我们创建容器存进全局作用域对象
![image12](Java学习/7.%20Framework/resources/image12-1.png)
3.  获取容器：WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext);

