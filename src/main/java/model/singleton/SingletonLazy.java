package model.singleton;

/**
 * @author luoxuan
 * @description 懒汉模式
 * 名称解释：当程序需要这个实例的时候才去创建对象，就如同一个人懒的饿到不行了才去吃东西。
 * 原理：静态变量只加载一次，但是只在使用的时候才会去创建实例
 * 缺点：没有保证线程安全
 * 线程安全版本：1.getInstance()前加上synchronized
 *            2.双重校验锁法 {@link SingletonLazySynchronize}
 */
public class SingletonLazy {
    private static SingletonLazy instance;
    private static SingletonLazy getInstance(){
        if(instance==null){
            instance=new SingletonLazy();
        }
        return instance;
    }

    //必须写成private，这样外部类不能调用new SingletonLazy()，只能用getInstance()方法获取实例
    private SingletonLazy(){

    }

    //线程安全的改进版本
    private static synchronized SingletonLazy getInstance1(){
        if(instance==null){
            instance=new SingletonLazy();
        }
        return instance;
    }
}
