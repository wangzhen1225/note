# 关于ThreadLocal类的理解

### 1.作用

ThreadLocal类的作用就是你在多线程环境中使用它之后，各个线程都能够设置，使用自己当前线程的变量，起到隔离各个线程数据的作用。



### 2.原理

线程类Thread类有个成员变量 ThreadLocalMap,然后这个Map的key就是程序里面的那个声明定义的ThreadLocal变量，Map的value才是我们线程本身要使用的值。

也就是说如果有10个线程的话，那么这10个线程内部的ThreadLocalMap成员变量key都是同一个，就是程序里面定义的ThreadLocal变量。

如图所示:

![ThreadLocal原理](https://ws2.sinaimg.cn/large/0069RVTdgy1fu4kdo60ewj31cc0t4n5v.jpg)







