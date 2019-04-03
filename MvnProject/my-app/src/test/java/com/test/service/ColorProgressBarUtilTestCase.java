package com.test.service;

import com.test.utils.ColorProgressBarUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ColorProgressBarUtilTestCase {

  private static final Logger logger = LoggerFactory.getLogger(ColorProgressBarUtilTestCase.class);

  @Test
  public void buildProgressBar() {
    logger.info(ColorProgressBarUtil.buildProgressBar(80, 100));
  }

  @Test
  public void buildDone() {
    logger.info(ColorProgressBarUtil.buildDone());
  }

}
