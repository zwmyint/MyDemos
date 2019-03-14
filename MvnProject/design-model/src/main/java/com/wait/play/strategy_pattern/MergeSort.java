package com.wait.play.strategy_pattern;

public class MergeSort extends AStrategy {

  @Override
  public String sort(String string) {
    System.out.println("Merge Sort!!!");
    return string;
  }
}
