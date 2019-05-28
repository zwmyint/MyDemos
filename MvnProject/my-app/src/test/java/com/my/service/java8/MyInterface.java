package com.my.service.java8;

public interface MyInterface {

  //  Static method in interface
  static String getName() {
    return "Bob";
  }

  //  Default method in interface
  default Boolean isEmpty() {
    return this.size() == 0;
  }

  int size();

  private String getResult() {
    return "result";
  }

  default String getLastResult() {
    return this.getResult();
  }
}

interface MySecondInterface {

  static String getName() {
    return "Tom";
  }

  default Boolean isEmpty() {
    return this.size() < 1000;
  }

  int size();
}

class Person implements MyInterface, MySecondInterface {

  public int size() {
    return 1;
  }

  public Boolean isReallyEmpty() {
    return MyInterface.super.isEmpty();
  }

  public Boolean isEmpty() {
    return MySecondInterface.super.isEmpty();
  }
}



