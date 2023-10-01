---
title: NO.13 GUI编程
updated: 2021-05-02T12:35:14.0000000+08:00
created: 2021-02-06T16:28:40.0000000+08:00
---

GUI编程
**一、AWT(Abstract Window Toolkit)**
1.  **关于AWT？**
    1.  包含了很多类和接口！
    2.  元素：窗口，按钮，文本框
    3.  在java.awt包下
    4.  需要知道的：Component(组件),button(按钮),TextArea(文本域),Label(标签),Container(容器),Window(窗口),frame(窗口),Dialog(弹窗),panel(面板),Applet(支程序)
2.  **关于Frame**
<table>
<colgroup>
<col style="width: 100%" />
</colgroup>
<thead>
<tr class="header">
<th><p>Framef1=newFrame();//可直接传入title</p>
<p>f1.setVisible(true);<em>//窗口是否可见</em></p>
<p>f1.setTitle("付智超最帅");</p>
<p>f1.setSize(640,360);<em>//设置窗口的大小</em></p>
<p>f1.setBackground(newColor(30,166,208));<em>//设置背景颜色</em></p>
<p>f1.setResizable(false);<em>//设置是否可手动改变窗口大小。</em></p>
<p>f1.setBounds(id*100,id*100,400,400);<em>//也可以这样同时设置长宽高</em></p></th>
</tr>
</thead>
<tbody>
</tbody>
</table>
3.  **关于Frame中的paint方法。**
    1.  画东西用的

4.  **关于panel**
    1.  需要内嵌在Frame上，且需要设置颜色，不然颜色和Frame的一样，就分辨不出了，不过不需要setVisivle方法
<table>
<colgroup>
<col style="width: 100%" />
</colgroup>
<thead>
<tr class="header">
<th><p>FrameCreatefc1=newFrameCreate();</p>
<p>Paneltools=newPanel();</p>
<p>fc1.add(tools);</p>
<p>fc1.setLayout(null);</p>
<p>tools.setBounds(0,0,400,50);</p>
<p>tools.setBackground(newColor(255,255,255));</p></th>
</tr>
</thead>
<tbody>
</tbody>
</table>
2.  和frame不一样的是，panel创建时就可以传入布局，而frame不行，需要用对象去调用方法
5.  **关于Button**
    1.  创建对象时可以选择是否传入一个字符串作为label
    2.  setActionCommand(String command)//设置触发的动作事件的**命令名称，指这个命令叫什么**
    3.  点击的时候触发动作事件
6.  **关于文本框TextField**
    1.  按回车的时候触发动作事件
    2.  可以通过getSource方法获取资源，即输入的文本，不过不像getActionCommand，返回的是String，而是返回Object，可以向下转型

7.  **布局管理器**
    1.  在setLayout方法里需要**传一个LayoutManager类型的变量**，这个就是布局管理器
    2.  布局管理器分为：
        1.  绝对布局
            1.  设置为null
            2.  设置为这个那么加进去的东西都需要自行设置Bounds
        2.  流式布局（FlowLayout）
            1.  一个个的排列，不够就换行
            2.  目前来说出了点问题，不晓得为什么会导致颜色全变成设置这个的（貌似frame对panel最好别是流式布局）
        3.  东南西北中（BorderLayout）
            1.  中间一块，上下左右各有一块。
            2.  frame不设置BorderLayout布局也可以直接用
            3.  这个不是单独使用，而是在添加东西的时候使用。
<table>
<colgroup>
<col style="width: 100%" />
</colgroup>
<thead>
<tr class="header">
<th><p>FrameCreatefc=newFrameCreate();</p>
<p>PanelCreatepc=newPanelCreate(0,30,400,50);</p>
<p>ButtonCreatebc1=newButtonCreate("East");</p>
<p>ButtonCreatebc2=newButtonCreate("West");</p>
<p>ButtonCreatebc3=newButtonCreate("South");</p>
<p>ButtonCreatebc4=newButtonCreate("North");</p>
<p>ButtonCreatebc5=newButtonCreate("Center");</p>
<p>fc.setLayout(newBorderLayout());</p>
<p><em>//让panel在frame上是以东南西北中的北布置</em></p>
<p>fc.add(pc,BorderLayout.NORTH);</p>
<p><em>//让panel以流式布局排放按钮</em></p>
<p>pc.setLayout(newFlowLayout(FlowLayout.LEFT));</p>
<p>pc.add(bc1);</p>
<p>pc.add(bc2);</p>
<p>pc.add(bc3);</p>
<p>pc.add(bc4);</p>
<p>pc.add(bc5);</p></th>
</tr>
</thead>
<tbody>
</tbody>
</table>
4.  表格（GridLayout）
    1.  按几行几列，间隔多少距离布局
<table>
<colgroup>
<col style="width: 100%" />
</colgroup>
<thead>
<tr class="header">
<th><p>FrameCreatefc=newFrameCreate();</p>
<p>PanelCreatepc=newPanelCreate(0,30,400,50);</p>
<p>ButtonCreatebc1=newButtonCreate("bc1");</p>
<p>ButtonCreatebc2=newButtonCreate("bc2");</p>
<p>ButtonCreatebc3=newButtonCreate("bc3");</p>
<p>ButtonCreatebc4=newButtonCreate("bc4");</p>
<p>ButtonCreatebc5=newButtonCreate("bc5");</p>
<p>ButtonCreatebc6=newButtonCreate("bc6");</p>
<p><em>//让面板按表格布局。二行三列，不过这样会让面板的大小设置无效</em></p>
<p>pc.setLayout(newGridLayout(2,3));</p>
<p>pc.add(bc1);</p>
<p>pc.add(bc2);</p>
<p>pc.add(bc3);</p>
<p>pc.add(bc4);</p>
<p>pc.add(bc5);</p>
<p>pc.add(bc6);</p>
<p>fc.add(pc);</p></th>
</tr>
</thead>
<tbody>
</tbody>
</table>
8.  **事件监听器EventListener**
    1.  WindowListener(窗口监听器)
        1.  
    2.  ActionListener(动作监听器)
        1.  都有个addActionListener方法，传入一个动作监听器。
    3.  MouseListener(鼠标监听器)
        1.  鼠标每次点击的事件都是一个Point类型的东西，监听器的代码就会执行一遍。
    4.  keyListener(键盘监听器)
        1.  分为preesed，released，typed，看名字就晓得有什么用了。
**二、Swing**
1.  JFrame(继承了Frame)
    1.  关闭窗口可以不必去创建监听器，直接调用setDefaultCloseOperation(int i)
直接传入WindowContents里的静态变量。如：EXIT_ON_CLOSE
2.  设置颜色时不能直接set，需要获取容器，然后对容器进行操作。
3.  貌似除了是否可视，大小与初始位置不要用，其他设置最好都要用。
4.  **且在JFrame下需要用J系的东西，否则Title会乱码，按钮经过测试。**
5.  在JFrame关闭JFrame可以用dispose()方法，在其中一个Panel中可以SwingUtilities.getWindowAncestor(*this*).dispose();
像这样使用
2.  Dialog(弹窗)
    1.  不需要设置关闭，自带默认
    2.  一般都是需要用一个东西来触发弹窗效果。如按钮
    3.  需要手动设置是否看得见
3.  JButton
    1.  好看点
    2.  也可以添加图片
    3.  JRadioButton（单选框）
        1.  其实和点的都算按钮，只不过这个点了会填充满那个框。
        2.  不能同时都选择。（前提是在同一个ButtonGroup，但默认不是同一个组，所以可以都选。）
    4.  JCheckBox（多选框）
        1.  不需要搞什么ButtonGroup
    5.  ComboBox（下拉框）
        1.  通过addItem(String str)来添加选项
        2.  getText来获取。（提示：通过getSource得到对象）
    6.  JList（列表框）
        1.  可以再创建对象的时候传入一个**集合**对象。
        2.  一般就是用来展示用的

4.  JLabel
    1.  可以设置靠哪对齐，用setHorizontalAlignment()方法，经测试，只有Jlabel里有这个
传入0-4，分别为中，上，左，下，右，他们都是SwingContents里的常量。
2.  可以通过setIcon方法直接传入一个ImageIcon对象，这个对象创建时传一个URL就彳亍
3.  一般可以通过*this*.getClass().getResource("bqb.jpg") 返回一个URL类型的变量来访问图片，默认在java文件所在的目录下搜索
5.  JPanel
6.  JTextField

7.  ICON
    1.  需要实现类，可以放在label或者按钮上
    2.  一般可以通过*this*.getClass().getResource("bqb.jpg") 返回一个URL类型的变量来访问图片，默认在java文件所在的目录下搜索
8.  JScrollPanel
    1.  可以滚动
    2.  add没用，只能创建时传进去一个组件。

