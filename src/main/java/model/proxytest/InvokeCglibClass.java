package model.proxytest;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLIB动态代理
 */
public class InvokeCglibClass implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class targetClass){
        enhancer.setSuperclass(targetClass);
        enhancer.setCallback(this);
        return  enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before...");
        methodProxy.invokeSuper(o,objects);
        System.out.println("end....");
        return null;
    }
}
