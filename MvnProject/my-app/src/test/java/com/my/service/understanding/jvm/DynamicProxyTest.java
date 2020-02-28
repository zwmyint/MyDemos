package com.my.service.understanding.jvm;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {

  interface IHello {

    void sayHello();
  }

  static class Hello implements IHello {

    @Override
    public void sayHello() {
      System.out.println("hello, world!");
    }
  }

  static class DynamicProxy implements InvocationHandler {

    Object object;

    Object bind(Object object) {
      this.object = object;
      return Proxy
          .newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(),
              DynamicProxy.this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      return method.invoke(object, args);
    }
  }

  public static void main(String[] args) {
    IHello iHello = (IHello) new DynamicProxy().bind(new Hello());
    iHello.sayHello();
  }
}
