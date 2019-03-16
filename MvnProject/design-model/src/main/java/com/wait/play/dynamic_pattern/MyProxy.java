package com.wait.play.dynamic_pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy implements InvocationHandler {

  private Object obj;

  public MyProxy() {
  }

  public MyProxy(Object obj) {
    this.obj = obj;
  }

  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    if (method.getName().startsWith("start")) {
      System.out.println("保护环境，人人有责！");
    }

    if (method.getName().startsWith("end")) {
      System.out.println("共建社会主义美好家园！");
    }
    return method.invoke(this.obj, args);
  }

  public Object getProxyInstance() {
    return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
  }
}
