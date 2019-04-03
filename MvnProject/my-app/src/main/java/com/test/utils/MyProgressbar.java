package com.test.utils;


public class MyProgressbar {


  public final static int EMPTYS = 48;

  public static String buildProgressBar(int completedJobs, int sumJobs) {
    if (completedJobs == sumJobs) {
      return MyProgressbar.buildDone();
    }
    int cellNum = (completedJobs * EMPTYS / sumJobs);
    String cell = "█";
    String empty = "▁";
    String progressBar = "";
    StringBuffer sb = new StringBuffer();
    String progress = "<Progress:" + String.format("%02d", completedJobs * 100 / sumJobs) + "%> ";

    for (int i = 0; i < cellNum; i++) {
      sb.append(cell);
    }
    for (int j = 0; j < EMPTYS - cellNum; j++) {
      sb.append(empty);
    }
    progressBar = progress + sb.toString();
    return progressBar;
  }

  public static String buildDone() {
    String cell = "█";
    StringBuffer sb = new StringBuffer();
    String progress = "<Completed:100%>";
    for (int i = 0; i < EMPTYS; i++) {
      sb.append(cell);
    }
    return progress + sb.toString();
  }
}
