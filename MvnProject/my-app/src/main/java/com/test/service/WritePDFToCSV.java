package com.test.service;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WritePDFToCSV {

  private static final Logger logger = LoggerFactory.getLogger(WritePDFToCSV.class);

  public static void main(String[] args) {
    String rootPath = args[0];
    File root = new File(rootPath);
    if (!root.exists()) {
      logger.error("Invalid pdf dir error!!");
      return;
    }
    List<Map<String, String>> result = new ArrayList<Map<String, String>>();
    Stream.of(root.listFiles()).filter(file -> file.getName().contains(".pdf")).forEach(pdf -> {
      ReadPDFWithPDFBox readPDFWithPDFBox = new ReadPDFWithPDFBox(pdf);
      result.add(readPDFWithPDFBox.extractText());
    });

    StringBuffer csvContent = new StringBuffer();

    result.stream().forEach(pdfContent -> {
      csvContent.
          append(pdfContent.get("Name")).append(",").
          append(pdfContent.get("InvoiceCode")).append(",").
          append(pdfContent.get("InvoiceNum")).append(",").
          append(pdfContent.get("Money")).append("\r\n");
    });
    File csv = new File(rootPath + File.separator + "result.csv");
    FileUtil.writeFile(csvContent.toString(), csv);

  }

}
