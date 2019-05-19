package com.my.service.java8;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



import org.junit.Test;



public class MyLambdasTestCase {

  public void format() {
    /**
     * 1. Simplest form:
     * (parameters) -> expression
     *
     * 2. use {} and return statement
     * (parameters) -> {
     *   return 0;
     * }
     *
     * 3. If there are no parameters, you still supply parentheses
     * () -> System.out.println("Hello");
     *
     * 4.If parameter type can be inferred, omit it.
     * Comparator<String> comp = (first, second) -> first.length() - second.length()
     *
     * 5. If there is exactly one parameter with inferred type, omit parentheses
     *
     * ActionListener listener = event -> System.out.println(event);
     */
  }

  /**
   * Functional Interface - A interface with single abstract method.
   */

  interface MyFunctionalInterface {
    Boolean isEqual(String first, String second);
  }


  @Test
  public void fun1() {
    new Thread(() -> {
      System.out.println("Do something!");
    }).start();
  }


}
