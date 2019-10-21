package designPattern;

public class SingleObject {
    //3.饿汉式,线程安全
    //创建 SingleObject 的一个对象
    private static SingleObject instance = new SingleObject();
    //让构造函数为 private，这样该类就不会被实例化
    private SingleObject(){}
    //获取唯一可用的对象
    public static SingleObject getInstance(){
        return instance;
    }
    public void showMessage(){
        System.out.println("Hello World!");
    }
}
//1.懒汉式，线程不安全
//public class Singleton {
//    private static Singleton instance;
//    private Singleton (){}
//
//    public static Singleton getInstance() {
//    if (instance == null) {
//        instance = new Singleton();
//    }
//    return instance;
//    }
//}

//2.懒汉式，线程安全
//public class Singleton {
//    private static Singleton instance;
//    private Singleton (){}
//    public static synchronized Singleton getInstance() {
//    if (instance == null) {
//        instance = new Singleton();
//    }
//    return instance;
//    }
//}
//4.双检锁/双重校验锁（DCL，即 double-checked locking）,线程安全
//public class Singleton {
//    private volatile static Singleton singleton;
//    private Singleton (){}
//    public static Singleton getSingleton() {
//    if (singleton == null) {
//        synchronized (Singleton.class) {
//        if (singleton == null) {
//            singleton = new Singleton();
//        }
//        }
//    }
//    return singleton;
//    }
//}
//5、登记式/静态内部类，线程安全
//public class Singleton {
//    private static class SingletonHolder {
//    private static final Singleton INSTANCE = new Singleton();
//    }
//    private Singleton (){}
//    public static final Singleton getInstance() {
//    return SingletonHolder.INSTANCE;
//    }
//}
