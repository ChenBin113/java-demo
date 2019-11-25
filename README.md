# [java - demo](https://github.com/ChenBin113/java-demo)

<!-- MarkdownTOC levels="1,2" autolink="true" -->

- [项目起源](#%E9%A1%B9%E7%9B%AE%E8%B5%B7%E6%BA%90)
- [javase](#javase)
    - [概述](#%E6%A6%82%E8%BF%B0)
    - [语言基础](#%E8%AF%AD%E8%A8%80%E5%9F%BA%E7%A1%80)
    - [面向对象](#%E9%9D%A2%E5%90%91%E5%AF%B9%E8%B1%A1)
    - [异常](#%E5%BC%82%E5%B8%B8)
    - [数组](#%E6%95%B0%E7%BB%84)
    - [String 类](#string-%E7%B1%BB)
    - [Calendar](#calendar)
    - [Collection](#collection)
    - [Map](#map)
    - [IO 流](#io-%E6%B5%81)
    - [多线程](#%E5%A4%9A%E7%BA%BF%E7%A8%8B)
    - [反射](#%E5%8F%8D%E5%B0%84)
- [juc](#juc)
    - [进程和线程](#%E8%BF%9B%E7%A8%8B%E5%92%8C%E7%BA%BF%E7%A8%8B)
    - [并发和并行](#%E5%B9%B6%E5%8F%91%E5%92%8C%E5%B9%B6%E8%A1%8C)
    - [三个包](#%E4%B8%89%E4%B8%AA%E5%8C%85)
    - [WWH](#wwh)
- [jvm](#jvm)
    - [问题](#%E9%97%AE%E9%A2%98)
    - [类加载器](#%E7%B1%BB%E5%8A%A0%E8%BD%BD%E5%99%A8)
    - [执行引擎 Execution Engine](#%E6%89%A7%E8%A1%8C%E5%BC%95%E6%93%8E-execution-engine)
    - [本地方法接口和本地方法栈](#%E6%9C%AC%E5%9C%B0%E6%96%B9%E6%B3%95%E6%8E%A5%E5%8F%A3%E5%92%8C%E6%9C%AC%E5%9C%B0%E6%96%B9%E6%B3%95%E6%A0%88)
    - [寄存器](#%E5%AF%84%E5%AD%98%E5%99%A8)
    - [方法区](#%E6%96%B9%E6%B3%95%E5%8C%BA)
    - [栈](#%E6%A0%88)
    - [gc](#gc)

<!-- /MarkdownTOC -->


# 项目起源

- 这不是一个介绍 Java 知识点的项目，而是对 Java 特性进行实验的 demo。

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

进入一个空的文件夹后使用 `dir` 命令可以看到两个 `dir` 文件 `.` 和 `..` ，分别代表本级文件夹和上一级文件夹。

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

/ ，除法，得到结果都是 0.

```java
System.out.println(-1 / 2);
System.out.println(1 / 2);

output:
0;
0;
```



%，如果对负数取模，可以把模数负号忽略不计。

```java
System.out.println(5 % -2); //1
System.out.println(-5 % 2); //-1
System.out.println(-5 % -2); //-1
System.out.println(5 % 2); //1
```



### 位运算符

位运算符优先级和算术运算符优先级

```java
//如果位运算符优先级比算术运算符优先级高，输出应该为 15
//如果位运算符优先级比算术运算符优先级低，输出应该为 8
int i = 1 << 4 - 1;
System.out.println(i);

output:8;
//结论：位运算符优先级比算术运算符优先级低
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

[可以](./src/javase/LoopTest01.java)，这也是局部代码块的优点。

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

父类 SuperClass 和 子类 SubClass，当子类的没有写构造方法的时候，编译会默认追加注释行代码，[参看代码](./src/javase/SuperKeywordTest01.java)

```java
class SuperClass {
    public SuperClass() {
        System.out.println("Super");
    }
}
```

```java
class SubClass extends SuperClass {
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

Object 类是 sun 公司提供的根类，所有类都默认是继承 Object 类，其中就有抽象类，所以答案是[可以](./src/javase/AbstractTest01.java)。举个例子：

![1572680822717](https://github.com/ChenBin113/java-demo/blob/master/static/1572680822717.png)

![1572681294824](https://github.com/ChenBin113/java-demo/blob/master/static/1572681294824.png)

无论是 java 自带的类库还是自己新建的抽象类，无一例外继承了 Object 类。

### 接口

#### 接口的根类是 Object 类？

不是，[这篇文章](https://blog.csdn.net/xidiancoder/article/details/78011148)很详细说明了。举个直观例子说明：

![1572680857088](https://github.com/ChenBin113/java-demo/blob/master/static/1572680857088.png)

### 权限修饰符

#### 四种修饰符：private，(default)，protected，public。

|  修饰词   | 本类 | 同一个包的类 | 子类 | 任何地方 |
| :-------: | :--: | :----------: | :--: | :------: |
|  private  |  √   |      ×       |  ×   |    ×     |
| (default) |  √   |      √       |  ×   |    ×     |
| protected |  √   |      √       |  √   |    ×     |
|  public   |  √   |      √       |  √   |    √     |

如果 ModifierTest01 和 ModifierTest02 不在同一个包，且 ModifierTest02 是 ModifierTest01 子类，所以只能访问到 height 和 id 属性。

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

public class ModifierTest02 extends ModifierTest01 {
    public static void main(String[] args) {
        ModifierTest02 test02 = new ModifierTest02();
        System.out.println(test02.height);
        System.out.println(test02.id);
    }
}
```

子类继承父类的所有成员变量和方法，但是由于权限控制有些成员变量和方法不能直接使用。

### 构造方法和静态代码块加载顺序

```java
/**
 * 1.实验结果表明，static 修饰的静态代码块在类加载的时候就运行，且只运行一次
 * 2.构造方法随 new 对象的时候执行，每新建一个对象执行一次
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("-------------- 实验 1 --------------");
        new Main();
        new Main();
    }

    static {
        System.out.println("before main");
    }

    public Main() {
        Syscar.Mainntln("Main.Main");
    }
}

output:
before main
-------------- 实验 1 --------------
Main.Main
Main.Main
```

### 多态

```java
package javase;

/**
 * 1.父类引用指向子类对象，只能使用父类本身的成员变量
 * 2.强制类型转换后，就可以使用子类的成员变量
 * 3.instanceof 测试结果表明，一个类的对象 instanceof 类 / 父类，返回 true；一个类的对象 instanceof 子类 / 其他类，false
 */
public class PlymorphismTest01 {
    class FatherClass {
        private String name = "Father";
    }

    class SonClass extends FatherClass {
        String name = "Son";
    }

    public void fun1() {
        FatherClass f = new SonClass();
        System.out.println(f.name); //Father
        System.out.println("-------------- 父类转为子类 --------------");
        System.out.println(((SonClass) f).name); //Son
    }

    public void fun2() {
        FatherClass f = new FatherClass();
        System.out.println(f instanceof FatherClass); //true
        System.out.println(f instanceof SonClass); //false
    }

    public void fun3() {
        SonClass f = new SonClass();
        System.out.println(f instanceof FatherClass); //true
        System.out.println(f instanceof SonClass); //true
    }

    public static void main(String[] args) {
        new PlymorphismTest01().fun1();
    }
}
```



## 异常

![1572662724903.png](https://github.com/ChenBin113/java-demo/blob/master/static/1572662724903.png)

### throw 和 throws 的区别

`throw new RuntimeException();` 语句之后的代码无法再运行，此时 Eclipse 会显示 `Unreachable code` 错误。

在 FileInputStream 的构造方法中可以看到，该方法抛出了一个异常，可以有两种处理方式：一是在调用该方法的另一个方法继续 throws FileNotFoundException，二是使用 try-catch 语句处理异常。

```java
/*FileInputStream.java*/
public FileInputStream(String name) throws FileNotFoundException {
    this(name != null ? new File(name) : null);
}

javase.reflect.carcar.Test.java*/
public static void main(String[] args) throws FileNotFoundException {
    new FileInputStream("d:/test");
}

public static void main(String[] args) {
    try {
    	new FileInputStream("d:/test");    
	} catch(FileNotFoundException e){
        e.printStackTrace();
    }
}
```

```java
public class javase.reflect.car.Test {
	public static void main(String[] args) throws RuntimeException,Exception {	
		throw new RuntimeException();	
	}
}
```

综合：可以看到 throw 之后跟的是**一个异常对象**，而 throws 之后跟的是**一个或多个异常类名**。

## 数组

### 声明和初始化

```java
//声明
int[] arr;

//初始化
//静态初始化，初始化并赋值
int[] arr = new int[]{0, 1, 2};

//动态初始化，初始化，之后再赋值
int[] arr = new int[3];
```

错误的方式：

```java
int[] arr = new int[]; //没有指定数组大小
int[3] arr = new int[3]; //arr 前的 int[] 是声明为 int 类型数组，不能在 [] 中定义数组大小
int[] arr = new int[3]{0, 1, 2}; //不能同时使用动态初始化和静态初始化
```



### 数组的属性 length

数组一经初始化，其长度就保持不变，通过这个属性可以轻易求出数组的长度。

```java
int[] arr = new int[]{0, 1, 2};
System.out.println(arr.length);

output:3
```



## String 类

### 正则表达式

```java
Pattern 类
s.matches();
s.replaceFirst();
s.replaceAll();
s.split();
```



### StringBuffer

#### 文档说明

![1572494593118](https://github.com/ChenBin113/java-demo/blob/master/static/1572494593118.png)

根据 StringBuffer 的文档说明可知：

StringBuffer 是**线程安全**的，主要体现在它的方法上有 synchronized 同步锁，也因此导致其执行效率较低。

StringBuffer 虽然是线程安全的，但是其安全指的是操作上的安全，需要处理的数据在处理过程中不能改变，或者处理的数据不被其他线程共享。也就是处理的数据中途自身发生改变，则得到的结果可能和想要的结果不一致，这种不一致并不是因为线程不安全，而是数据自身的不稳定。

StringBuffer 主要有两个常用方法，append() 和 insert()。

容量问题，如果不超过则不会扩容，超过容量自动扩容。

传入的参数不能是 null，否则会报出 NullPointException。

JDK 5 加入了 StringBuilder，它适用于单线程，且操作相同，由于没有加入 synchronized 同步机制，使得它能更快完成任务，**官方优先推荐**使用。

#### StringBuffer 初始化容量

```java
public StringBuffer() {
    super(16);
}

public StringBuffer(int capacity) {
    super(capacity);
}

public StringBuffer(String str) {
    super(str.length() + 16);
    append(str);
}

public StringBuffer(CharSequence seq) {
    this(seq.length() + 16);
    append(seq);
}
```

由构造方法的源码可知，有三种初始化容量：

1. 无参，容量为 16.
2. 传入容量值.
3. 传入 String 或 实现 CharSequence 接口的类型的数据长度 + 16.

#### StringBuffer 扩容

StringBuffer 在使用 append() 方法时会扩容，策略有两种：

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

## Calendar 

Calendar 类使用了简单工厂模式(静态工厂模式)，使用此方法获得唯一的实例对象。

通过追寻源码可知，getInstance 方法中调用的是 createCalendar 方法，createCalendar 方法的参数分别是获取时区 TimeZone.getDefault() 和地区 Locale.getDefault(Locale.Category.FORMAT)，Locale 获取的默认方法中使用了**双重检查**的方法来确保线程安全。

```java
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

```java
private volatile static Locale defaultDisplayLocale = null;
```

通过追寻源码可以看到，这个变量 defaultDisplayLocale 使用了 volatile 关键字，再使用了双重检查的方式确保多线程调用的环境下有效的获取变量，提高效率。

## Collection

![1574249182927](https://github.com/ChenBin113/java-demo/blob/master/static/1574249182927.png)

### List



#### ArrayList 源码分析

数组和集合的区别主要有三点：

1. 数组一旦定义，在内存的空间也就确定；集合可以动态的增加长度。
2. 数组可以存储基本类型的数据和引用类型数据；集合只能存储引用类型数据，基本数据类型需要转换成相应的包装类。
3. 数组是某一类型的集合；但是集合需要使用泛型才能统一类型，没有使用泛型的情况下，集合中可以存储多种类型的数据。

通过探究 ArrayList add() 和 remove() 源码，了解集合扩容机制。

##### add() 方法：

需要确保链表够大，这时候需要计算内部容量，已经明确需要多少容量，如果需要容量 > 已有容量，则需要扩容。

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

##### remove() 方法：

检查是否越界，挪动，尾部元素置空等待 GC 回收。

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

##### contains() 方法：

该方法是用来判断集合中是否存在元素，返回 boolean 类型数据。

```java
/*
java.util.Collection，接口中为空方法
*/
boolean contains(Object o);

/*
java.util.ArrayList，实现了方法，
contains() 调用了 indexOf()，
indexOf() 调用了 equals()
*/
public boolean contains(Object o) {
    return indexOf(o) >= 0;
}

public int indexOf(Object o) {
    if (o == null) {
        for (int i = 0; i < size; i++)
            if (elementData[i]==null)
                return i;
    } else {
        for (int i = 0; i < size; i++)
            if (o.equals(elementData[i]))
                return i;
    }
    return -1;
}
```

**重点**：在使用 ArrayList 做容器装载其他类型的对象时，要调用 contains() 方法，需要重写其他类中的 equals() 方法。

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

先创建一个比较器 IdComparator 和即将比较的类 Person。

```java
class IdComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o2.getId() - o1.getId();
    }
}

class Person {
    private int id;
    private String name;

    public Person() {
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
```

测试一下

```java
public class ComparatorTest02 {
    public static void main(String[] args) {
        Person p1 = new Person(1, "张三");
        Person p2 = new Person(2, "李四");
        Person p3 = new Person(3, "王五");

        TreeSet<Person> set = new TreeSet<>(new IdComparator());
        set.add(p1);
        set.add(p2);
        set.add(p3);

        for (Person p : set) {
            System.out.println(p);
        }
    }
}
```

测试类先创建了三个 Person 类对象，然后创建一个 TreeSet 对象，构造方法传入一个事先定义的 IdComparator 类的对象，调用 add() 方法，探究一下 add() 方法源码：

```java
public boolean add(E e) {
    return m.put(e, PRESENT)==null;
}
```

此时可以看到方法使用的是 put() 方法，先看看 m 是什么：

```java
//The backing map.
private transient NavigableMap<E,Object> m;
```

应该是继承自 Map，通过查它的“族谱”发现这是一个接口，继承 Map 接口：

![1574250349672](https://github.com/ChenBin113/java-demo/blob/master/static/1574250349672.png)

key 在这个案例中就是 Person 类了，value 是一个 Object 类型。再看看 put 方法第二个参数 `PRESENT` ，注释说是起到占位作用的，也就是 TreeSet 只需要 Map 的 key 存放元素，value 则使用一个 Object 类的对象填充。 

```java
// Dummy value to associate with an Object in the backing Map
private static final Object PRESENT = new Object();
```

此时可以查看 put() 方法是如何调用的了，通过 debug 可以看到调用的是 TreeMap 的 put() 方法：

```java
public V put(K key, V value) {
    /*
    static final class Entry<K,V> implements Map.Entry<K,V> {
        K key;
        V value;
        Entry<K,V> left;
        Entry<K,V> right;
        Entry<K,V> parent;
        boolean color = BLACK;
    }
    */
    //这个 Entry 是 TreeMap 的一个静态内部类
    Entry<K,V> t = root;
	···
    int cmp;
    Entry<K,V> parent;
    // split comparator and comparable paths
    //这里就是我们定义的 IdComparator 
    Comparator<? super K> cpr = comparator;
	···
}
```

感兴趣的同学可以深入研究一下 put() 方法的逻辑，现在就不展开了。最后输出结果为：

```java
output:
Person{id=3, name='王五'}
Person{id=2, name='李四'}
Person{id=1, name='张三'}
```

查看以上的输出结果，自定义比较器做到了以 Id 降序比较，TreeSet 构建方法传入了比较器。

### Queue

#### PriorityQueue

最大堆，最小堆的应用。



## Map

![1574249447217](https://github.com/ChenBin113/java-demo/blob/master/static/1574249447217.png)

### Hashtable

> If a thread-safe implementation is not needed, it is recommended to use `HashMap` in place of  `Hashtable`. If a thread-safe highly-concurrent implementation is  desired, then it is recommended to use `ConcurrentHashMap`  in place of `Hashtable`.

JDK 1.0 就有了 Hashtable，但是**官方文档**推荐我们在线程安全的环境下使用 HashMap，在高并发环境下，则改用 ConcurrentHashMap。总的来说就是，成为历史文物了。

### HashMap

#### 哈希表

核心是基于哈希值的桶和链表，哈希值由哈希函数计算得到。

JDK 1.7 组成为 `数组 + 链表`，JDK 1.8 组成为 `数组 + 链表 + 红黑树`。

### TreeMap

#### 

## IO 流

### FileInputStream

官方文档是这样描述的：

> A `FileInputStream` obtains input bytes from a file in a file system. What files are available depends on the host environment. 
> `FileInputStream` is meant for reading streams of raw bytes such  as image data. For reading streams of characters, consider using  `FileReader`.

FileInputStream 是从操作系统中的文件以字节的方式读取的，文件是否存在需要看主机中。照片可以用这种方式读，文本建议还是用 FileReader。

序列化和反序列化

## 多线程

#### 多线程创建的三种方式：

1. 继承 Thread 类，重写 run 方法。
2. 实现 Runnable 接口。
3. 实现 Callable 接口。这个方法比较编写代码比较复杂，是 JDK 1.5 出来的。

#### Thread 类源码分析

从官方文档得到：

- JVM 是支持多线程的。
- 线程是有优先级的。当在线程中创建一个线程对象时，新对象的优先级和当前线程相同，当且仅当线程是守护线程，新的线程对象才能是守护线程。
- 创建线程的方式：继承 Thread 类；实现 Runnable 接口。

```java
//继承 Thread 类
class PrimeThread extends Thread {
    long minPrime;
    PrimeThread(long minPrime) {
        this.minPrime = minPrime;
    }

    public void run() {
        // compute primes larger than minPrime
        . . .
    }
}

//给出调用方法
PrimeThread p = new PrimeThread(143);
p.start();
```

```java
//实现 Runnable 接口
class PrimeRun implements Runnable {
    long minPrime;
    PrimeRun(long minPrime) {
        this.minPrime = minPrime;
    }

    public void run() {
        // compute primes larger than minPrime
        . . .
    }
}

//给出调用方法
PrimeRun p = new PrimeRun(143);
new Thread(p).start();
```

从源码级别可以看到这两种创建线程方法的区别，一个是直接创建继承 Thread 类的子类对象，子类对象可以直接调用 start 方法；另一个是使用了 Thread 类不同的构造器，传入的对象是一个实现了 Runnable 接口的类对象。

#### Thread.State - Thread 的内部枚举类

Thread 类从源码可以看到，线程一共有六种状态，分别是：

```java
public enum State {
    //A thread that has not yet started is in this state. 
    //新建，刚刚 new 出来，还没有调用 start 方法
    NEW,
    
    //A thread executing in the Java virtual machine is in this state. 
    //线程在虚拟机中正在运行
    RUNNABLE,
    
    //A thread that is blocked waiting for a monitor lock is in this state.
    //被锁住了
    BLOCKED,
    
    //A thread that is waiting indefinitely for another thread to perform a particular action is in this state. 
    //处于等待状态
    WAITING,
    
    //A thread that is waiting for another thread to perform an action for up to a specified waiting time is in this state.
    //确定时间的等待状态
    TIMED_WAITING,
    
    //A thread that has exited is in this state. 
	//线程已经退出，即终结了
    TERMINATED;
}
```

感兴趣的同学可以再去看看源码。

## 反射

```java
package javase.reflect.car;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * 反射：使用两种方式读取配置文件的信息
 */
public class Test {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        fun1();
        fun2();
    }

    public static void fun1() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ResourceBundle bundle = ResourceBundle.getBundle("javase/reflect/config/config");
        String car = bundle.getString("car");
        Class<?> aClass = Class.forName(car);
        Car c = (Car) aClass.newInstance();
        c.run();
    }

    public static void fun2() {
        Properties p = new Properties();
        try (FileReader fileReader = new FileReader("src/javase/reflect/config/config.properties")) {
            p.load(fileReader);
            Class<?> aClass = Class.forName(p.getProperty("car"));
            Car c = (Car) aClass.newInstance();
            c.run();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
```

通过读取配置文件，使用反射动态的创建类，虽然运行的效率受到影响，但是可以比较灵活的修改配置而不改动代码，避免不必要产生的 bug。框架常使用反射原理修改配置。

# juc

## 进程和线程

进程是资源（内存，CPU）分配的基本单位，线程是轻量化的进程，受 CPU 调度和分派的基本单位。一个程序运行就是一个进程，而一个进程往往有多个线程。多线程的程序可以提供丰富的功能。

## 并发和并行

并发指多个人同时做一件事，如秒杀活动。

并行指多个操作同时处理，如一个人同时做多件事

## 三个包

java.util.concurrent

java.util.concurrent.atomic

java.util.concurrent.locks

## WWH

what 什么是 juc？

why 为什么要用 juc？

how 怎么用 juc？



# jvm

## 问题

请谈谈你对 JVM 的理解？java8 的虚拟机有什么更新？

什么是 00M ？什么是 StackOverflowError？有哪些方法分析？

JVM 的常用参数调优你知道哪些？

谈谈 JVM 中，对类加载器你的认识？

![](https://github.com/ChenBin113/java-demo/blob/master/static/1573980500697.png)

## 类加载器

### 类加载器是什么？

- java 文件编译成字节码文件，需要由类加载器子系统加载到虚拟机中。

- 字节码文件有特殊的标识：`cafe`。

- 加载时将文件内容转换成方法区运行时的数据结构。

### 有几种类加载器？

jvm 一共有三种加载器，可通过继承 ClassLoader 类自定义类加载器

- Bootstrap ClassLoader，rt 包 jre1.8.0_221/lib/rt.jar
- Extension ClassLoader，扩展包
- Application ClassLoader，定义类
- 还可以继承 ClassLoader 类，自定义加载器，级别为 AppClassLoader 之下

通过查看源码 `rt.jar\sun\misc` 可以看到加载器的存储位置在 rt(run time) 包下，即运行时就会加载的包。

![1573981732945](https://github.com/ChenBin113/java-demo/blob/master/static/1573981732945.png)

### 双亲委派机制 Parents Delegate

类加载的时候不同的加载器来加载类，都会先往上传递，交给 Bootstrap 类加载器，它不能加载的类再交给 Extension 类加载器， Extension 类加载器不能加载再交给 AppClassLoader 类加载器，如果还不能加载类，则会报 ClassNotFoundException。因此，由不同的类加载器加载 Object 类，最终加载的都是同一个。

```java
package jvm;

public class ClassLoaderTest01 {
    public static void main(String[] args) {
        ClassLoaderTest01 c = new ClassLoaderTest01();
        System.out.println(c.getClass().getClassLoader());
        System.out.println(c.getClass().getClassLoader().getParent());
        System.out.println(c.getClass().getClassLoader().getParent().getParent());

        Object o = new Object();
        System.out.println(o.getClass().getClassLoader());
        System.out.println(o.getClass().getClassLoader().getParent());

        /*
        output:
        sun.misc.Launcher$AppClassLoader@18b4aac2
        sun.misc.Launcher$ExtClassLoader@1b6d3586
        null
        null
        Exception in thread "main" java.lang.NullPointerException
            at jvm.ClassLoaderTest01.main(ClassLoaderTest01.java:12)

        Process finished with exit code 1
         */
    }
}
```

从输出结果可以看到，自定义的类由 AppClassLoader 加载，AppClassLoader 父类为 ExtClassLoader，ExtClassLoader 父类为 Bootstrap ClassLoader，打印结果为 null，再**往上找**就出现了 NullPointerException。

### 沙箱安全

由于类加载有双亲委派机制，以下代码虽然在语法上没有问题，编译可以通过，但是运行的时候由于加载的是 java.lang 包下的 String 类，AppClassLoader 会往上查找，最终由 Bootstrap ClassLoader 加载。

因此双亲委派机制能够保证 java 运行环境是安全无污染的。

```java
package java.lang;

publicclassString{
    publicstaticvoidmain(String[]args){
        fun1();
    }

    publicstaticvoidfun1(){
        System.out.println("String.fun1");
    }
}
      
错误: 在类 java.lang.String 中找不到 main 方法, 请将 main 方法定义为:
	public static void main(String[] args)
否则 JavaFX 应用程序类必须扩展javafx.application.Application
```

## 执行引擎 Execution Engine

执行引擎的作用是：解释命令，和操作系统交互

## 本地方法接口和本地方法栈

和底层交互的栈区，一些以 native 关键字修饰的方法使用的栈区，程序计数器对这里的指令为 null，以 C 语言写的方法放置的区域。

![](https://github.com/ChenBin113/java-demo/blob/master/static/1573980418802.png)

## 寄存器

线程**私有**，指针，作用是指向方法区的方法字节码，所占内存小，可忽略不计，几乎不存在 gc。

![](https://github.com/ChenBin113/java-demo/blob/master/static/1573982452965.png)

## 方法区

存储的是类结构信息，例如字节码文件 Car.class 通过类加载器加载到 JVM 内存中，成为一个模板文件 Car Class，以后实例化一个个对象都是从这个模板文件开始的。

方法区有运行时常量池，类的属性、方法数据，构造方法和普通方法信息。

不同 JDK 版本的方法区有所区别，这个跟实现有关，JDK 7 为永久代 (PermGen Space) ，JDK 8 为元空间 (Metaspace)。

实例变量不是存放在方法区中，而是存放在堆内存中。

## 栈

栈管运行，堆管存储。



## gc

四大垃圾收集算法

七个垃圾收集器

