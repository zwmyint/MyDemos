package com.test.service.utils;

import java.io.File;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.test.service.ReadPDFWithPDFBox;
import com.test.service.WritePDFToExcelApp;

public class WritePDFToExcelTestCase {

  private static final Logger logger = LoggerFactory.getLogger(WritePDFToExcelTestCase.class);


  private URL resource;
  private ReadPDFWithPDFBox readPDFWithPDFBox;


  @Before
  public void init() {
    resource = ReadPDFWithPDFBoxTestCase.class.getResource("/");
  }

  @Test
  public void write() {
    try {
      File root = new File(resource.toURI());
      WritePDFToExcelApp.write(root);
    } catch (Exception e) {
      logger.error("Error!!!!");
    }

  }

}
