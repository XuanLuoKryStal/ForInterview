package model.singleton;

/**
 * @author luoxuan
 * @date 2020-11-14 17:46
 * @description 双重校验锁法
 * 原理：本质是懒汉模式，改进的是在静态变量中增加volatile关键字，其次在获取实例用synchronized关键字，同时校验一次变量
 */
public class SingletonLazySynchronize {
    private static volatile SingletonLazySynchronize instance;

    private SingletonLazySynchronize() {
    }

    private static synchronized SingletonLazySynchronize getInstance(){
        if(instance==null) {
            synchronized (SingletonLazySynchronize.class){
                if(instance==null){
                    instance=new SingletonLazySynchronize();
                }
            }
        }
        return instance;
    }
}
