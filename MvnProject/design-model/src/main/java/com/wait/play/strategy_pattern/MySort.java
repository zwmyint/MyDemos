package com.wait.play.strategy_pattern;

public class MySort {

  private AStrategy strategy;

  public MySort(){}

  public MySort(AStrategy strategy){
    this.strategy = strategy;
  }

  public void sortString(String string) {
    strategy.sort(string);
  }

}
