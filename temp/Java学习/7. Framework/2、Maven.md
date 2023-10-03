---
title: 2、Maven
updated: 2021-07-13T08:50:31.0000000+08:00
created: 2021-06-06T18:42:44.0000000+08:00
---

Maven（一个项目的构建工具）

1.  完成一个Java项目，需要做哪些工作？
    1.  分析项目要做什么，知道项目有哪些组成部分。
    2.  设计项目，通过哪些步骤，使用哪些技术。需要多少人，多长的时间。
    3.  组建团队，招人，购置设备，服务器，软件，笔记本。
    4.  开发人员写代码。开发人员需要测试自己的写的代码。重复多次的工作。
    5.  测试人员，测试项目功能是否符合要求。
测试开发人员提交代码=＞有问题的话需要开发人员修改=＞再提交代码给测试=＞测试人员再测试代码=＞有问题的话需要开发人员修改=＞。。。直到测试代码通过。
2.  传统开发项目的问题：
    1.  很多模块，模块之间有关系，手工管理关系，比较繁琐。
    2.  需要很多第三方功能，需要很多jar文件，需要手工从网络中获取各个jar
    3.  需要管理jar的版本，你需要的是mysql 5.1.5.jar 那你不能给一个mysql 4.0.jar
    4.  管理jar文件的依赖，项目要用到a.jar，但a.jar又需要b.jar，a与b之间的关系叫做依赖，a依赖b类
3.  Maven的作用：
    1.  可以管理jar文件
    2.  自动下载jar和他的文档，源代码
    3.  管理jar直接的依赖，a.jar需要b.jar，Maven会自动下载b.jar
    4.  管理你需要的jar版本。
    5.  帮你编译程序，把java文件编译成class
    6.  帮你测试你的代码是否正确。
    7.  帮你打包文件，形成jar文件或者war文件
    8.  帮你部署项目
4.  构建：
项目的构建

构建是面向过程的，就是一些步骤，完成项目代码的编译，测试，运行，打包，部署等等。Maven支持的构建包有：
1.  清理：把之前项目编译的东西删除掉，为新的编译代码做准备。
2.  编译：把程序源代码编译成执行代码，java-class文件，这是批量的，Maven可以同时把成千上百个文件编译成class，javac不一样，一次只编译一个文件。
3.  测试：Maven可执行测试程序代码，验证你的功能是否正确，这也是批量的，Maven可以同时执行多个测试代码，同时测试很多功能。
4.  报告：生产测试结果的文件，测试有没有通过。
5.  打包：把你的项目中所有的class文件，配置文件等所有资源放在一个压缩文件中，Java程序是jar包，web应用是war包
6.  安装：把（5）中生成的jar，war安装到本地仓库
7.  部署：吧程序安装好可以执行
5.  Maven核心概念：用好Maven，了解这些概念
    1.  POM（Project Object Model）：一个文件——pom.xml，Maven把一个项目当做模型使用，控制Maven构建项目的过程，管理jar依赖。
    2.  约定的目录结构：Maven项目的目录和文件的位置是规定的。
    3.  坐标：是一个唯一的字符串，用来表示资源的。
    4.  依赖管理：管理你的项目可以使用jar文件
    5.  仓库管理：你的资源存放的位置
    6.  生命周期：Maven工具构建项目的过程，这就是生命周期。
    7.  插件和目标：执行maven构建的时候用的工具的插件。
    8.  继承：
    9.  聚合：
6.  POM：
基本信息
1.  **groupId**：组织ID，一般式公司域名的倒写，格式可以为：
    1.  域名倒写：com.fzc
    2.  域名倒写+项目名：com.fzc.projectName
2.  **artifactId**：项目名称，也是模块名称，对应groupId中项目中的子项目
3.  **version**：项目版本号。如果项目还在开发中，是不稳定版本，通常在版本后带-SNAPSHOT（快照）
4.  packaging：打包后压缩文件的扩展名，默认是jar，web程序要设置为war
如果是Java程序，可以不写
5.  **dependencies**：依赖集合，里面每一个**dependence**都是一个依赖信息
6.  properties：设置属性（可以配置build里的东西）
7.  build：Maven在进行项目的构建时的配置信息：指定编译java程序的jdk版本
    1.  plugins：插件集
    2.  plugin：插件配置
    3.  资源插件
        1.  ![image1](Java学习/7.%20Framework/resources/image1.png)
        2.  默认没有使用resources的时候，maven执行编译代码，会把src/main/resources里的文件拷贝到target/classes里，对于src/main/java目录下的非java文件不拷贝到target/classes目录中
        3.  但又是需要复制包含的文件，所以可以将（1）的内容添加进去。
8.  自定义标签：
    1.  要写在properties里，然后在别的地方可以通过\${标签名}来调用标签里的值
    2.  ![image2](Java学习/7.%20Framework/resources/image2.png)
7.  Maven约定的目录结构，约定是大家都遵循的一个规则
    1.  ![image3](Java学习/7.%20Framework/resources/image3.png)
    2.  在pom.xml文件所在目录的位置执行cmd命令：mvn compile来编译文件，执行之后，在src同级目录下生成一个target目录（结果目录）
    3.  疑问：mvn compile编译src/main目录下所有的java文件。
        1.  （第一次使用）为什么下载？
            1.  maven工具执行的操作需要很多插件（jar文件）完成的。
        2.  下载什么东西了？：
            1.  jar文件——插件——完成某些功能
        3.  下载的东西存放在哪？
            1.  存放在本地仓库（默认仓库）
            2.  C:\Users\帅帅付\\.m2\repository（这是帅帅付的登陆Window时所在的目录）
            3.  中央仓库地址：https://repo.maven.apache.org
8.  坐标（Gav）
    1.  POM中groupId、artifactID、version三者联合起来就是一个坐标，全网唯一
9.  Maven的仓库
    1.  修改Maven默认存放资源的目录（本地仓库）：maven安装目录/conf/settings.xml中找到setting标签，写一个localRepository标签，内容就是自定义本地仓库的地址
    2.  仓库是什么：仓库是存放各种东西的，存放Maven使用的jar和我们项目使用的jar
        1.  Maven使用的插件（各种jar）
        2.  项目使用的jar（第三方工具，如mysql-jdbc）
    3.  仓库的分类：
        1.  本地仓库：在个人计算机的文件夹，存放各种jar
        2.  远程仓库：
            1.  中央仓库：最权威的，所有开发人员都共享使用的一个集中的仓库
            2.  中央仓库的镜像：中央仓库的备份，或者说为了解决连接速度慢，多设立了几个服务器，
            3.  私服：在公司内部，在局域网中使用，不对外使用。
10. Maven的生命周期和常用命令
    1.  Maven的生命周期
        1.  Maven提供一个项目构建的模型，把**清理、编译、测试、打包、安装、部署**等都对应成一个个的生命周期阶段，并对每一个阶段提供相应的命令，程序员只需要掌握一小队命令就可以完成项目的构建过程，maven命令执行时，真正完成功能的是插件，插件就是一些jar文件，就是一个个类
    2.  单元测试
        1.  用的是Junit，是一个专门测试的框架（工具）
        2.  Junit测试的内容：测试的是类中的**方法**，每一个方法都是独立测试的。方法是测试的**基本单位（单元）**
        3.  Maven借助单元测试批量的测试你类中的大量方法是否符合预期
        4.  使用步骤：
            1.  加入依赖：
\<dependency\>

\<groupId\>junit\</groupId\>

\<artifactId\>junit\</artifactId\>

\<version\>x.xx\</version\>

\<scope\>test\</scope\>

\</dependency\>
2.  在Maven项目中的src/test/java目录下，创建测试程序。
推荐的创建类和方法的提示：

1、测试类的名称是：Test + 你要测试的类名

2、测试的方法名称是：test + 方法名称

例如：

要测试的类是：HelloWorld

那么测试类应该是：TestHelloWorld

里面有个方法：

@Test

public void test方法名() {}

定义规则：
1.  方法是public的
2.  方法没有返回值
3.  方法名称是自定义的，推荐是test+方法名称
4.  在方法的上面添加注解：@Test
3.  Maven的常用命令
    1.  mvn clean：清除target文件夹
    2.  mvn compile：编译主程序，也就是main文件夹里的java文件
    3.  mvn test-compile：编译测试文件
    4.  mvn test：测试（在target里生成一个surefire-report文件夹保存测试结果）
    5.  mvn package：打包主程序，变成jar或者war文件放在target目录下
    6.  mvn install：安装主程序（把jar文件按照坐标放在本地仓库）
    7.  mvn deploy：部署主程序（会把本工程打包，按照本工程的坐标保存到本地库中，并且还会保存到私服仓库中，还会自动把项目部署到web容器中）。
PS：执行哪个命令会把前面的都执行一遍。
11. 依赖范围
    1.  用scope表示
    2.  有：
        1.  compile（默认）（所有过程中）
        2.  test（只在测试中起作用）
        3.  provided（在变异测试的时候使用，打包后由服务器提供（不参与打包））
        4.  ![image4](Java学习/7.%20Framework/resources/image4.png)

