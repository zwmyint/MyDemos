package com.test.service;

import com.test.utils.MyProgressbar;
import java.io.PrintWriter;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyProgressBarUtilTestCase {

  private static final Logger logger = LoggerFactory.getLogger(MyProgressBarUtilTestCase.class);

  @Test
  public void buildProgressBar() {
    logger.info(MyProgressbar.buildProgressBar(80, 100));
  }

  @Test
  public void buildDone() {
    logger.info(MyProgressbar.buildDone());
  }

  @Test
  public void character() {
    char aa = '\u28FF';

    PrintWriter printWriter = new PrintWriter(System.out, true);
    printWriter.println(aa);
  }

}
