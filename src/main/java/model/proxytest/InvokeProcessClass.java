package model.proxytest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理实现
 * 1.处理和执行方法--处理器--实现InvocationHandler
 * 2.产生代理类--利用Proxy方法
 */
public class InvokeProcessClass implements InvocationHandler {

    private Object target;

    public InvokeProcessClass(Object invokeClass) {
        this.target = invokeClass;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Do something before");
        Object result = method.invoke(target, args);
        System.out.println("Do something after");
        return result;
    }

    /**
     * 产生代理类
     * 此处第二个参数就能看出jdk动态代理需要实现相同接口
     */
     public Object getProxy(){
         return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
     }
}
