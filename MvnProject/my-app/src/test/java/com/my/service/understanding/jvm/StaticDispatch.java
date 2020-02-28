package com.my.service.understanding.jvm;

import org.junit.Test;

public class StaticDispatch {

  static abstract class Human {

  }

  static class Man extends Human {

  }

  static class Woman extends Human {

  }

  public void sayHello(Human guy) {
    System.out.println("hello, guy!");
  }

  public void sayHello(Man guy) {
    System.out.println("hello, gentleman!");
  }

  public void sayHello(Woman guy) {
    System.out.println("hello, lady!");
  }

  @Test
  public void foo() {

    Human man = new Man();
    Human woman = new Woman();
    StaticDispatch staticDispatch = new StaticDispatch();
    staticDispatch.sayHello(man);
    staticDispatch.sayHello((Woman) woman);


  }

}
