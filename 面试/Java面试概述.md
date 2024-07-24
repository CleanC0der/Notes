# Java基础
## 包装类型的缓存机制

Java的基本数据类型使用了缓存来提升性能
Byte,Short,Integer,Long将\[-128,127]范围内的值缓存，Character创建了[0,127]的缓存，Boolean则是直接返回Ture或False
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
