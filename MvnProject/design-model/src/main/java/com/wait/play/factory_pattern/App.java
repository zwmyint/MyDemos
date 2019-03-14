package com.wait.play.factory_pattern;

import com.wait.play.abstract_factory_pattern.ACar;


/*
  工厂方法模式：
  一个抽象产品类，可以派生出多个具体产品类。
  一个抽象工厂类，可以派生出多个具体工厂类。
  每个具体工厂类只能创建一个具体产品类的实例。
 */
public class App {

  public static void main(String[] args) {
    ACar audio = new AudioFactory().produceCar();
    audio.start();

    ACar bwm = new BWMFactory().produceCar();
    bwm.start();
  }

}
