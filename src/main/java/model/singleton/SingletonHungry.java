package model.singleton;

/**
 * @author luoxuan
 * @date 2020-11-14 16:28
 * @description 饿汉模式
 * 名称理解：像不管一个人想不想吃东西都把吃的先买好，如同饿怕了一样
 * 原理：静态变量只初始化一次；类加载的时候创建实例
 * 优点：不存在线程安全的问题
 * 缺点：类加载慢（初始化需要创建实例）
 */
public class SingletonHungry {
    private static SingletonHungry instance=new SingletonHungry();

    private SingletonHungry(){

    }

    private static SingletonHungry getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        SingletonHungry singletonHungry1=SingletonHungry.getInstance();
        SingletonHungry singletonHungry2=SingletonHungry.getInstance();
        if(singletonHungry1.equals(singletonHungry2)){
            System.out.println("true");
        }
    }
}
