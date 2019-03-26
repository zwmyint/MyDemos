package com.wait.play.observer_pattern;

public class App {

  //1. 定义一个主题
  //2. 定义主题的观察者
  //3. 主题可以添加，删除观察者，当主题的状态发生变化的时候，通知观察者

  public static void main(String[] args) {
    BirdSubject birdSubject = new BirdSubject();

    PeopleObserver p1 = new PeopleObserver("p1");
    PeopleObserver p2 = new PeopleObserver("p2");

    birdSubject.registerObserver(p1);
    birdSubject.registerObserver(p2);

    birdSubject.notifyObserver("Testing Connection...");

    System.out.println("------------------------");

    birdSubject.notifyObserver("Connected...");
  }

}
