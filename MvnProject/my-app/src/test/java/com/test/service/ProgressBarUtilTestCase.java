package com.test.service;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProgressBarUtilTestCase {

  private static final Logger logger = LoggerFactory.getLogger(ProgressBarUtilTestCase.class);

  @Test
  public void buildProgressBar() {
    logger.info(ProgressBarUtil.buildProgressBar(80, 100));
  }

  @Test
  public void buildDone() {
    logger.info(ProgressBarUtil.buildDone());
  }

}
