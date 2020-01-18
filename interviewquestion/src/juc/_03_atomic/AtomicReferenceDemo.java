package juc._03_atomic;

import java.util.concurrent.atomic.AtomicReference;

class User {
    String userName;
    int age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }

    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }
}

/**
 * 对于自定义类，也能够使用 CAS
 * 学习 AtomicReference 类
 */
public class AtomicReferenceDemo {

    public static void main(String[] args) {
        User z3 = new User("z3", 20);
        User li4 = new User("li4", 30);

        AtomicReference<User> atomicReference = new AtomicReference<User>(z3);

        System.out.println(atomicReference.compareAndSet(z3, li4) + "\t" + atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(z3, li4) + "\t" + atomicReference.get().toString());
    }
}
