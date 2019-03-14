package com.wait.play.strategy_pattern;

public class QuickSort extends AStrategy {

  @Override
  public String sort(String string) {
    System.out.println("Quick Sort!!!");
    return string;
  }
}
