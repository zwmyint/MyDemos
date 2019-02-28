package com.test.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApachePOIUtil {

  private static final Logger logger = LoggerFactory.getLogger(ApachePOIUtil.class);

  public static void write(String headers[], List<Map<String, String>> contents, File file) {
    if (contents != null && contents.size() > 0) {
      Workbook workbook = new XSSFWorkbook();
      Sheet sheet = workbook.createSheet("sheet1");
      int rowNum = 0;
      Row headerRow = sheet.createRow(rowNum++);
      //Write Header
      for (int i = 0; i < headers.length; i++) {
        Cell headerRowCell = headerRow.createCell(i);
        headerRowCell.setCellValue(headers[i]);
        headerRowCell.setCellType(CellType.STRING);
      }
      //Write Content from row 1
      for (int j = 0; j < contents.size(); j++) {
        Row row = sheet.createRow(rowNum++);
        Map<String, String> content = contents.get(j);
        for (int k = 0; k < content.size(); k++) {
          Cell contentRowCell = row.createCell(k);
          contentRowCell.setCellValue(content.get(headers[k]));
          contentRowCell.setCellType(CellType.STRING);
        }
      }
      for (int m = 0; m < headers.length; m++) {
        sheet.autoSizeColumn(m);
      }
      try {
        FileOutputStream fileOut = new FileOutputStream(file);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
      } catch (Exception e) {
        logger.error("Error to write file {}", file.getName());
        e.printStackTrace();
      }
    }


  }


}
