package com.test.utils;


import static org.fusesource.jansi.Ansi.Color.BLUE;
import static org.fusesource.jansi.Ansi.Color.DEFAULT;
import static org.fusesource.jansi.Ansi.Color.GREEN;
import static org.fusesource.jansi.Ansi.ansi;

public class ColorProgressBarUtil {

  public final static int EMPTYS = 48;

  public static String buildProgressBar(int completedJobs, int sumJobs) {
    if (completedJobs == sumJobs) {
      return ColorProgressBarUtil.buildDone();
    }
    int cellNum = (completedJobs * EMPTYS / sumJobs);
    String cell = "█";
    String empty = "▁";
    String progressBar = "";
    String colorCells = "";
    String colorEmptys = "";
    StringBuffer sb = new StringBuffer();
    String colorTitle = ansi().eraseScreen().fg(BLUE).a("Progress").toString();
    String progress =
        ansi().eraseScreen().fg(DEFAULT).a("<").toString() + colorTitle + ansi().eraseScreen()
            .fg(DEFAULT).a(":").toString() + String.format("%02d", completedJobs * 100 / sumJobs)
            + "%> ";
    for (int i = 0; i < cellNum; i++) {
      sb.append(cell);
    }
    colorCells = ansi().eraseScreen().fg(GREEN).a(sb.toString()).toString();
    sb.setLength(0);
    for (int j = 0; j < EMPTYS - cellNum; j++) {
      sb.append(empty);
    }
    colorEmptys = ansi().eraseScreen().fg(DEFAULT).a(sb.toString()).toString();
    progressBar = progress + colorCells + colorEmptys;
    return progressBar;
  }

  public static String buildDone() {
    String cell = "█";
    String colorCells = "";
    StringBuffer sb = new StringBuffer();
    String colorTitle = ansi().eraseScreen().fg(BLUE).a("Completed").toString();
    String progress =
        ansi().eraseScreen().fg(DEFAULT).a("<").toString() + colorTitle + ansi().eraseScreen()
            .fg(DEFAULT).a(":").toString() + "100%> ";
    for (int i = 0; i < EMPTYS; i++) {
      sb.append(cell);
    }
    colorCells = ansi().eraseScreen().fg(GREEN).a(sb.toString()).toString();
    return progress + colorCells;
  }
}


