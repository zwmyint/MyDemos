package com.wait.play.dynamic_pattern;

public class YouKu implements IVedio {

  public void start(String name) {
    System.out.println("[YouKu] Start " + name);
  }

  public String end(String name) {
    System.out.println("[YouKu] End " + name);
    return name;
  }
}
