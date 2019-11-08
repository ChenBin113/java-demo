# java - demo

[TOC]



## 项目起源

- Java 知识点总结。
- 钻研 JDK 源码，分析内在逻辑和**设计模式**。

# javase

## 概述

### 常用 DOS 命令

| 功能                                     | 如何实现             |
| ---------------------------------------- | -------------------- |
| 进入不同的磁盘                           | D:                   |
| 查看当前目录所有文件和文件夹             | dir                  |
| 创建文件夹                               | md test              |
| 进入文件夹                               | cd test              |
| 退回到上一级目录                         | cd..                 |
| 删除文件                                 | del test.txt         |
| 删除多个同类型文件                       | del *.txt            |
| 删除空文件夹                             | rd test              |
| 删除非空文件夹，使用下列命令后提示选择 Y | del test             |
| 读取文件内容                             | more [file]          |
| 编译 java 文件                           | javac *.java         |
| 运行字节码文件                           | java *(不需要扩展名) |

进入一个空的文件夹后使用 `dir` 命令可以看到两个 <dir> 文件 `.` 和 `..` ，分别代表本级文件夹和上一级文件夹。

```java
public class MainTest {
    public static void main(String[] args) {
        System.out.println(args[0]);
        System.out.println(args[1]);
    }
}

cmd:
javac MainTest.java
java MainTest "hello" "world"

output:
"hello"
"world"
```



## 语言基础

### 算术运算符

注意：算法(第四版)中指出

> +、-、*、/ 都是被重载过的
>
> Java 语言规范规定，在逻辑运算符中，! 拥有最高的优先级，之后是 &&，接下来是 ||

%，如果对负数取模，可以把模数负号忽略不计。

```java
System.out.println(5 % -2); //1
System.out.println(-5 % 2); //-1
System.out.println(-5 % -2); //-1
System.out.println(5 % 2); //1
```

### 基本数据类型

```java
double d1 = 1.0;
double d2 = 0.00;
double d3 = d1 / d2;
System.out.println(d3); //output: Infinity
//System.out.println(d3 instanceof Double); //Error，instanceof 不能比较基本数据类型
System.out.println(d1 / d2); //output: Infinity

Double d1 = 1.0;
Double d2 = 0.00;
Double d3 = d1 / d2;
System.out.println(d3); //output: Infinity
System.out.println(d3 instanceof Double); //true
System.out.println(d1 / d2); //output: Infinity
```



### 分支语句

#### while & for 循环：开发使用 for 循环比较多，变量可以从内存中较早的消失？

[可以](src/javase/branch/LoopTest01.java)，这也是局部代码块的优点。

```java
public class LoopTest01 {
    /*
    实验：for 和 while 循环
    验证：for 循环，变量可以从内存中较早的消失
    结果：循环结束时，i 变量仍存在，j 变量已消失，验证结论
    */
    public static void main(String[] args) {
        int i = 3;
        while (i > 0) {
            System.out.println(i--);
        }

        for (int j = 0; j < 3; j++) {
            System.out.println(j);
        }
    }
}
```

## 面向对象

### 构造方法

#### 默认构造方法的 super() 调用

父类 SuperClass 和 子类 SubClass，当子类的没有写构造方法的时候，编译会默认追加注释行代码

```java
public class SuperClass {
    public SuperClass() {
        System.out.println("Super");
    }
}
```

```java
public class SubClass extends SuperClass {
    //public SubClass() {
    //    super();
    //}
}
```

注释行代码写与否都会输出下列的结果 output: Super

```java
public class Test01 {
    public static void main(String[] args) {
        //测试证明，子类如果不重写，编译器也会默认写上 super() 这一行代码
        SubClass subClass = new SubClass();
    }
}
```

### 抽象类

#### 抽象类能够继承非抽象类？

Object 类是 sun 公司提供的根类，所有类都默认是继承 Object 类，其中就有抽象类，所以答案是[可以](src/javase/abstracttest/AbstractTest01.java)。举个例子：

![1572680822717](https://github.com/ChenBin113/java-demo/blob/master/static/1572680822717.png)

![1572681294824](https://github.com/ChenBin113/java-demo/blob/master/static/1572681294824.png)

无论是 java 自带的类库还是自己新建的抽象类，无一例外继承了 Object 类。

### 接口

#### 接口的根类是 Object 类？

不是，[这篇文章](https://blog.csdn.net/xidiancoder/article/details/78011148)很详细说明了。举个例子：

![1572680857088](https://github.com/ChenBin113/java-demo/blob/master/static/1572680857088.png)

### 权限修饰符

#### 四种修饰符：private，(default)，protected，public。

|  修饰词   | 本类 | 同一个包的类 | 子类 | 任何地方 |
| :-------: | :--: | :----------: | :--: | :------: |
|  private  |  √   |      ×       |  ×   |    ×     |
| (default) |  √   |      √       |  ×   |    ×     |
| protected |  √   |      √       |  √   |    ×     |
|  public   |  √   |      √       |  √   |    √     |

ModifierTest01 和 ModifierTest02 不在同一个包，因此只能访问到 height 和 id 属性。

```java
package javase.modifier;

public class ModifierTest01 {
    private int age = 1;
    int count = 2;
    protected int height = 3;
    public int id = 4;
}
```

```java
package javase;

import javase.modifier.ModifierTest01;

public class ModifierTest02 extends ModifierTest01 {
    public static void main(String[] args) {
        ModifierTest02 test02 = new ModifierTest02();
        System.out.println(test02.height);
        System.out.println(test02.id);
    }
}
```

## 异常

![1572662724903.png](https://github.com/ChenBin113/java-demo/blob/master/static/1572662724903.png)

## String 类

### 正则表达式

```java
Pattern 类
s.matches();
s.replaceFirst();
s.replaceAll();
s.split();
```

一些能够适用正则表达式的地方

### StringBuffer

![1572494593118](https://github.com/ChenBin113/java-demo/blob/master/static/1572494593118.png)

根据 StringBuffer 的文档说明可知，StringBuffer 是线程安全的，主要体现在它的方法上有 synchronized 同步锁。

StringBuffer 主要有两个常用方法，append() 和 insert()。

StringBuffer 虽然是线程安全的，但是其安全指的是操作上的安全，需要处理的数据在处理过程中不能改变，或者处理的数据不被其他线程共享。

容量问题，如果不超过则不会扩容，超过容量自动扩容。

传入的参数不能是 null，否则会报出 NullPointException。

JDK 5 加入了 StringBuilder，它适用于单线程，且操作相同，由于没有加入 synchronized 同步机制，使得它能更快完成任务，优先推荐使用。

StringBuffer 初始容量默认是 16，此后如果超出长度，在使用 append() 方法时会扩容，策略有两种：

1. 先将当前容量 * 2，再加 2.

2. 如果此时容量还比追加后的 StringBuffer 长度 minCapacity 小，则使用minCapacity.

3. 此时的容量仍需要判断是否超出 StringBuffer 规定的最大容量，如果超过则**可能**报出 OutOfMemoryError 异常.

   注：**可能** 是因为 StringBuffer 规定的最大容量和 Integer.*MAX_VALUE* 仍有 8 个空位.

```java
/*
AbstractStringBuilder.java
StringBuffer 调用的 append() 方法中调用了父类的这个方法
*/
private int newCapacity(int minCapacity) {
    // overflow-conscious code
    int newCapacity = (value.length << 1) + 2;
    if (newCapacity - minCapacity < 0) {
        newCapacity = minCapacity;
    }
    return (newCapacity <= 0 || MAX_ARRAY_SIZE - newCapacity < 0)
        ? hugeCapacity(minCapacity)
        : newCapacity;
}

private int hugeCapacity(int minCapacity) {
    if (Integer.MAX_VALUE - minCapacity < 0) { // overflow
        throw new OutOfMemoryError();
    }
    return (minCapacity > MAX_ARRAY_SIZE)
        ? minCapacity : MAX_ARRAY_SIZE;
}

private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
```

```java
/*
Integer.java
*/
@Native public static final int MAX_VALUE = 0x7fffffff;
```

为了避免频繁扩容影响运行效率，可以提前设定好 StringBuffer 的容量。

## Collection

### List

#### ArrayList 源码分析

数组和集合的区别主要有三点：

1. 数组一旦定义，在内存的空间也就确定；集合可以动态的增加长度。
2. 数组可以存储基本类型的数据和引用类型数据；集合只能存储引用类型数据，基本数据类型需要转换成相应的包装类。
3. 数组是某一类型的集合；但是集合需要使用泛型才能统一类型，没有使用泛型的情况下，集合中可以存储多种类型的数据。

主要探究 ArrayList add() 和 remove() 源码，借此看集合如何扩容。

add() 方法：

- 需要确保链表够大，这时候需要计算内部容量，已经明确需要多少容量，如果需要容量 > 已有容量，则需要扩容。

```java
public boolean add(E e) {
    //主要工作的函数：
    ensureCapacityInternal(size + 1);  // Increments modCount!!
    //末尾增加数据，size + 1
    elementData[size++] = e;
    return true;
}

//确保内部容量够
private void ensureCapacityInternal(int minCapacity) {
    ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
}

//计算容量
private static int calculateCapacity(Object[] elementData, int minCapacity) {
    //如果一开始链表的内容为空，将返回的是 DEFAULT_CAPACITY = 10
    if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
        //DEFAULT_CAPACITY 默认容量是 10
        return Math.max(DEFAULT_CAPACITY, minCapacity);
    }
    return minCapacity;
}

//明确的容量
private void ensureExplicitCapacity(int minCapacity) {
    modCount++;

    // overflow-conscious code
    if (minCapacity - elementData.length > 0)
        //扩容
        grow(minCapacity);
}

//扩容方法，如果扩容为原来的 1.5 倍够用则可，否则扩容到够用为止(除非达到上限)，和 StringBuffer 扩容原理相似
private void grow(int minCapacity) {
    // overflow-conscious code
    int oldCapacity = elementData.length;
    int newCapacity = oldCapacity + (oldCapacity >> 1);
    if (newCapacity - minCapacity < 0)
        newCapacity = minCapacity;
    if (newCapacity - MAX_ARRAY_SIZE > 0)
        newCapacity = hugeCapacity(minCapacity);
    // minCapacity is usually close to size, so this is a win:
    elementData = Arrays.copyOf(elementData, newCapacity);
}
```

remove() 方法：

- 检查是否越界，挪动，尾部元素置空等待 GC 回收。

```java
public E remove(int index) {
    //检查一下是否越界
    rangeCheck(index);

    modCount++;
    //获取值
    E oldValue = elementData(index);

    //将移除元素后面的数值整体往前挪一位
    int numMoved = size - index - 1;
    if (numMoved > 0)
        System.arraycopy(elementData, index+1, elementData, index, numMoved);
    //size - 1，同时也就是链表结尾的元素置空，等待 GC 回收，非常优雅的写法
    elementData[--size] = null; // clear to let GC do its work

    return oldValue;
}
```

#### Vector 源码分析

主要是 grow() 方法的对比：一般扩容后的容量为原来容量的 2 倍。

```java
private void grow(int minCapacity) {
    // overflow-conscious code
    int oldCapacity = elementData.length;
    int newCapacity = oldCapacity + ((capacityIncrement > 0) ? capacityIncrement : oldCapacity);
    if (newCapacity - minCapacity < 0)
        newCapacity = minCapacity;
    if (newCapacity - MAX_ARRAY_SIZE > 0)
        newCapacity = hugeCapacity(minCapacity);
    elementData = Arrays.copyOf(elementData, newCapacity);
}
```

#### ArrayList & LinkedList 源码分析

```java
/*
ArrayList.java，数据结构是一个数组
*/
private static final Object[] EMPTY_ELEMENTDATA = {};

private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

transient Object[] elementData;
```

LinkedList 的 add() 和 remove() 方法主要是双向链表的插入和删除。

```java
/*
LinkedList.java，数据结构是一个双向链表，除头结点和尾结点外其他结点都有前驱和后继
*/
private static class Node<E> {
    E item;
    Node<E> next;
    Node<E> prev;

    Node(Node<E> prev, E element, Node<E> next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }
}
```

### Set

#### HashSet 源码分析

底层是 HashMap

#### LinkedHashSet 源码分析

底层是链表。

#### TreeSet 源码分析

数据结构是二叉树。

### Queue

#### PriorityQueue

最大堆，最小堆的应用。

## Map

### Hashtable

> If a thread-safe implementation is not needed, it is recommended to use `HashMap` in place of  `Hashtable`. If a thread-safe highly-concurrent implementation is  desired, then it is recommended to use `ConcurrentHashMap`  in place of `Hashtable`.

JDK 1.0 就有了 Hashtable，但是**官方文档**推荐我们在线程安全的环境下使用 HashMap，在高并发环境下，则改用 ConcurrentHashMap。总的来说就是，成为历史文物了。

### HashMap

JDK 1.7 组成为 `数组 + 链表`，JDK 1.8 组成为 `数组 + 链表 + 红黑树`。

### TreeMap

## IO 流

### FileInputStream

官方文档是这样描述的：

> A `FileInputStream` obtains input bytes from a file in a file system. What files are available depends on the host environment. 
> `FileInputStream` is meant for reading streams of raw bytes such  as image data. For reading streams of characters, consider using  `FileReader`.

FileInputStream 是从操作系统中的文件以字节的方式读取的，文件是否存在需要看主机中。照片可以用这种方式读，文本建议还是用 FileReader。

序列化和反序列化

## 多线程

三种方法：

1. 继承 Thread 类，重写 run 方法。
2. 实现 Runnable 接口。
3. 实现 Callable 接口。

#### Thread 类源码分析

# mysql

```mysql
create schema `mysql-1`;
drop schema `mysql-1`;
```







# 下面是需要整合的内容

# JDK 源码 - 看虚拟机规范和基础学习

## JVM 8 虚拟机规范 2.12 Class Libraries

Java SE platform 运行一些类库需要虚拟机的支持，如

- java.lang.reflect 包和类 Class：reflect 包提供了 .class 文件反射成 .java 文件的一些类，如 Method，Field，Modifier 等。
- Loading 加载或者 creation 产生一个接口或类，最经典的例子就是 ClassLoader 类。
- Linking 连接和 initialization 初始化一个类或接口。上面的一些类也是属于这个范畴。
- Security，java.security 包和其他类如 SecurityManager。
- 多线程，Thread 类。
- Weak references，java.lang.ref 包，API 中只显示 5 个类，比包内少了  3 个。

## Java 类的生命周期

- Loading
- Linking
- Initalization
- Using
- Unloading

## 待办

- [ ] JVM 类加载
- [ ] 引用 references
- [ ] 少的几个类

# Calendar 的使用
- Calendar 类使用了简单工厂模式(静态工厂模式)，使用此方法获得唯一的实例对象
- 通过追寻源码可知，getInstance 方法中调用的是 createCalendar 方法，createCalendar 方法的参数分别是获取时区 TimeZone.getDefault() 和地区 Locale.getDefault(Locale.Category.FORMAT)，Locale 获取的默认方法中使用了双重检查的方法来确保线程安全
```
case DISPLAY:
            if (defaultDisplayLocale == null) {
                synchronized(Locale.class) {
                    if (defaultDisplayLocale == null) {
                        defaultDisplayLocale = initDefault(category);
                    }
                }
            }
            return defaultDisplayLocale;
```
```
private volatile static Locale defaultDisplayLocale = null;
```

- 通过追寻源码可以看到，这个变量 defaultDisplayLocale 使用了 volatile 关键字，再使用了双重检查的方式确保多线程调用的环境下有效的获取变量，提高效率。