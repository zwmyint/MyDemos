package com.wait.play.strategy_pattern;

public class App {

  public static void main(String[] args) {
    String str = "2019/03/13";

    MySort quickSort = new MySort(new QuickSort());
    quickSort.sortString(str);

    quickSort = new MySort(new MergeSort());
    quickSort.sortString(str);
  }

}
