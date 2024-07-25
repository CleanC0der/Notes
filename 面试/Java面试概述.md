# Java基础
## 包装类型的缓存机制

Java的基本数据类型使用了缓存来提升性能
Byte,Short,Integer,Long将\[-128,127]范围内的值缓存，Character创建了\[0,127]的缓存，Boolean则是直接返回Ture或False

```java
// Integer 缓存代码
public static Integer valueOf(int i) {
    if (i >= IntegerCache.low && i <= IntegerCache.high)
        return IntegerCache.cache[i + (-IntegerCache.low)];
    return new Integer(i);
}
private static class IntegerCache {
    static final int low = -128;
    static final int high;
    static {
        // high value may be configured by property
        int h = 127;
    }
}
```
## 接口和抽象类的区别

> 共同点
> 1. 都不能实例化
> 2. 都可以包含抽象方法

> 不同点
> 1. 接口主要是对行为约束，而抽象类的主要目的是代码复用
> 2. java里接口可以实现多个，而类（抽象类）只能继承一个
> 3. 接口中的变量只能是`public static final`类型的，而抽象类里就是正常的
> 4. 接口方法可以是`public abstract`，`default`，`static`的（后两个是Java8之后才有的），抽象类可以有抽象方法和非抽象方法

