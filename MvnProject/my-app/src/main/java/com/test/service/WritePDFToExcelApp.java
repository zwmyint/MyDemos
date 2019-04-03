package com.test.service;

import com.test.utils.ApachePOIUtil;
import com.test.utils.MyProgressbar;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WritePDFToExcelApp {

  private static final Logger logger = LoggerFactory.getLogger(WritePDFToExcelApp.class);

  public static void main(String[] args) {
    String rootPath = args[0];
    WritePDFToExcelApp.write(new File(rootPath));
  }

  public static void write(File root) {
    if (!root.exists()) {
      logger.error("Invalid pdf dir error!!");
      return;
    }
    final List<Map<String, String>> result = new ArrayList<>();
    File[] files = root.listFiles();
    List<File> pdfs = Stream.of(files).filter(file -> file.getName().contains(".pdf")).collect(
        Collectors.toList());
    int completedJobs = 0;
    int sumJobs = pdfs.size();
    for (File pdf : pdfs) {
      ReadPDFWithPDFBox readPDFWithPDFBox = new ReadPDFWithPDFBox(pdf);
      result.add(readPDFWithPDFBox.extractText());
      String progress = MyProgressbar.buildProgressBar(completedJobs++, sumJobs);
      System.out.print(progress);
      try {
        Thread.sleep(200);
      } catch (Exception e) {
        e.printStackTrace();
      }
      for (int j = 1; j <= 1000; j++) {
        System.out.print("\b");
      }

    }

    String[] headers = {"Name", "InvoiceCode", "InvoiceNum", "Money"};
    ApachePOIUtil
        .write(headers, result, new File(root.getAbsolutePath() + File.separator + "result.xlsx"));
    System.out.print(MyProgressbar.buildDone());
  }

}
