package com.test.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WritePDFToExcel {

  private static final Logger logger = LoggerFactory.getLogger(WritePDFToExcel.class);

  public static void main(String[] args) {
    String rootPath = args[0];
    WritePDFToExcel.write(new File(rootPath));
  }

  public static void write(File root) {
    if (!root.exists()) {
      logger.error("Invalid pdf dir error!!");
      return;
    }
    final List<Map<String, String>> result = new ArrayList<>();
    File[] files = root.listFiles();
    if (files != null) {
      Stream.of(files).filter(file -> file.getName().contains(".pdf")).forEach(pdf -> {
        ReadPDFWithPDFBox readPDFWithPDFBox = new ReadPDFWithPDFBox(pdf);
        result.add(readPDFWithPDFBox.extractText());
      });
    }
    String[] headers = {"Name", "InvoiceCode", "InvoiceNum", "Money"};
    ApachePOIUtil
        .write(headers, result, new File(root.getAbsolutePath() + File.separator + "result.xlsx"));
  }

}
