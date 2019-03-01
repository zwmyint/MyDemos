package com.test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 */
public class App {

  private static final Logger logger = LoggerFactory.getLogger(App.class);

  public static void main(String[] args) throws Exception {
    System.out.print("Progress:");
    for (int i = 1; i <= 100; i++) {
      System.out.print(i + "%");
      Thread.sleep(200);

      for (int j = 0; j <= String.valueOf(i).length(); j++) {
        System.out.print("\b");
      }

      if (i == 100) {
        for (int j = 0; j <= String.valueOf("Progress:").length(); j++) {
          System.out.print("\b");
        }
        System.out.print("Completed!!");
      }
    }
    System.out.println();
  }
}
