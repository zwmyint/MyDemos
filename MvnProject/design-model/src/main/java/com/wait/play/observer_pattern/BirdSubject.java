package com.wait.play.observer_pattern;

import java.util.ArrayList;
import java.util.List;

public class BirdSubject implements Subject {

  private List<Observer> observerList = new ArrayList();

  public void registerObserver(Observer observer) {
    this.observerList.add(observer);
  }

  public void removeObserver(Observer observer) {
    this.observerList.remove(observer);
  }

  public void notifyObserver(String msg) {
    observerList.stream().forEach(o-> o.update(msg));
  }
}
