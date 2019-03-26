package com.wait.play.observer_pattern;

public class PeopleObserver implements Observer {

  private String name;

  public PeopleObserver() {
  }

  public PeopleObserver(String name) {
    this.name = name;
  }

  @Override
  public void update(String msg) {
    System.out.println(name + " : " + msg);
  }
}
