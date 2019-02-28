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
    final List<Map<String, String>> result = new ArrayList<>();
    File[] files = root.listFiles();
    if (files != null) {
      Stream.of(files).filter(file -> file.getName().contains(".pdf")).forEach(pdf -> {
        ReadPDFWithPDFBox readPDFWithPDFBox = new ReadPDFWithPDFBox(pdf);
        result.add(readPDFWithPDFBox.extractText());
      });
    }
    StringBuffer csvContent = new StringBuffer();
    csvContent.append("姓名").append(",").append("发票代码").append(",")
        .append("发票号码").append(",").append("金额").append("\r\n");

    result.forEach(pdfContent -> csvContent.
        append(pdfContent.get("Name")).append(",").
        append(pdfContent.get("InvoiceCode")).append(",").
        append(pdfContent.get("InvoiceNum")).append(",").
        append(pdfContent.get("Money")).append("\r\n"));
    File csv = new File(rootPath + File.separator + "result.csv");
    FileUtil.writeFile(csvContent.toString(), csv);

  }

}
