package com.wait.play.simple_factory_pattern;

public class App {

  public static void main(String[] args) {
    SimpleFactory factory = new SimpleFactory();
    factory.setType("BWM");
    factory.getCarByType().start();

    factory.setType("Audio");
    factory.getCarByType().start();
  }

}
