package com.test.service;


import static org.fusesource.jansi.Ansi.Color.GREEN;
import static org.fusesource.jansi.Ansi.Color.RED;
import static org.fusesource.jansi.Ansi.Color.YELLOW;
import static org.fusesource.jansi.Ansi.ansi;

public class JansiUtil {

  public static void main(String[] args) {
    int i = 1 % 7;
    System.out.print(ansi().eraseScreen().fg(RED).a(i).fg(YELLOW).a(" World").reset());
    System.out.print(ansi().eraseScreen().fg(RED).a(i).bg(GREEN).a(" World"));
    System.out.println("\033[30;4m" + "我滴个颜什" + "\033[0m");
    System.out.println("\033[31;4m" + "我滴个颜什" + "\033[0m");
  }

}
