package com.my.service.understanding.jvm;


import org.junit.Test;

public class FieldResolution {

  interface Interface0 {

    int A = 0;
  }

  interface Interface1 extends Interface0 {

    int A = 1;
  }

  interface Interface2 {

    int A = 2;
  }

  static class Parent implements Interface1 {

    public static int A = 3;
  }

  static class Sub extends Parent implements Interface2 {

    public static int A = 4;
  }

  @Test
  public void foo() {
    //Compile error if comment L25
    // Reference to 'A' is ambiguous, both 'Parent.A' and 'Interface2.A' match
    System.out.println(Sub.A);
  }

}
