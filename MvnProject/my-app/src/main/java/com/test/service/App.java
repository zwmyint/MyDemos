package com.test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.fusesource.jansi.Ansi.Color.BLUE;
import static org.fusesource.jansi.Ansi.Color.DEFAULT;
import static org.fusesource.jansi.Ansi.Color.GREEN;
import static org.fusesource.jansi.Ansi.ansi;

/**
 * Hello world!
 */
public class App {

  private static final Logger logger = LoggerFactory.getLogger(App.class);


  public static void main(String[] args) throws Exception {
    for (int i = 1; i <= 100; i++) {
      String progress = buildProgressBar(i, 100);
      System.out.print(progress);
      Thread.sleep(100);
      for (int j = 1; j <= progress.length(); j++) {
        System.out.print("\b");
      }
      if (i == 100) {
        for (int j = 1; j <= progress.length(); j++) {
          System.out.print("\b");
        }
        System.out.print(buildDone(i, 100));
      }
    }
  }

  private static String buildDone(int cellNum, int sum) {
    String cell = "█";
    String colorCells = "";
    StringBuffer sb = new StringBuffer();
    String colorTitle = ansi().eraseScreen().fg(BLUE).a("Completed").toString();
    String progress =
        ansi().eraseScreen().fg(DEFAULT).a("<").toString() + colorTitle + ansi().eraseScreen()
            .fg(DEFAULT).a(":").toString() + cellNum + "%> ";
    for (int i = 0; i < cellNum; i++) {
      sb.append(cell);
    }
    colorCells = ansi().eraseScreen().fg(GREEN).a(sb.toString()).toString();
    return progress + colorCells;
  }

  private static String buildProgressBar(int cellNum, int sum) {
    String cell = "█";
    String empty = "░";
    String progressBar = "";
    String colorCells = "";
    String colorEmptys = "";
    StringBuffer sb = new StringBuffer();

    String colorTitle = ansi().eraseScreen().fg(BLUE).a("Progress").toString();
    String progress =
        ansi().eraseScreen().fg(DEFAULT).a("<").toString() + colorTitle + ansi().eraseScreen()
            .fg(DEFAULT).a(":").toString() + String.format("%02d", cellNum) + "%> ";
    for (int i = 0; i < cellNum; i++) {
      sb.append(cell);
    }
    colorCells = ansi().eraseScreen().fg(GREEN).a(sb.toString()).toString();
    sb.setLength(0);
    for (int j = 0; j < sum - cellNum; j++) {
      sb.append(empty);
    }
    colorEmptys = ansi().eraseScreen().fg(DEFAULT).a(sb.toString()).toString();
    progressBar = progress + colorCells + colorEmptys;
    return progressBar;
  }

}
