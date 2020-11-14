package model.singleton;

/**
 * @author luoxuan
 * @date 2020-11-14 17:53
 * @description 枚举方式实现单例 （Effective Java 作者推荐方法）
 */
public class SingletonEnum {

    enum Singleton{
        INSTANCE;
        private void demo(){
            System.out.println("demo..");
        }
    }

    public static void main(String[] args) {
        Singleton singleton=Singleton.INSTANCE;
        singleton.demo();
    }
}
