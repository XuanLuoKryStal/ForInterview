package model.singleton;

/**
 * @author luoxuan
 * @date 2020-11-14 17:10
 * @decription 静态内部类
 * 说明：饿汉的扩展实现方式，利用静态内部类再包装一次，这样可以实现类的延迟加载（lazy loading）
 *      静态类会在使用的时候才会初始化
 * 优点：不存在线程安全的问题
 */
public class SingletonHungryAdd {
    public  static class SingletonInner{
        private static SingletonHungryAdd instance=new SingletonHungryAdd();

        private SingletonInner(){
            System.out.println("inner class...");
        }
    }

    private SingletonHungryAdd() {
        System.out.println("outer class++++");
    }

    public static SingletonHungryAdd getInstance(){
        return SingletonInner.instance;
    }

    public static void main(String[] args) {
        SingletonHungryAdd add=SingletonHungryAdd.getInstance();
    }
}
