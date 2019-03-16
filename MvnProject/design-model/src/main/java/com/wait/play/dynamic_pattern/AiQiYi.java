package com.wait.play.dynamic_pattern;

public class AiQiYi implements IVedio {

  public void start(String name) {
    System.out.println("[AiQiYi] Start " + name);
  }

  public String end(String name) {
    System.out.println("[AiQiYi] End " + name);
    return name;
  }
}
