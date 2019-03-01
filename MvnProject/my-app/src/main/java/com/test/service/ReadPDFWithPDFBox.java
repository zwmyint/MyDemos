package com.test.service;

import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ReadPDFWithPDFBox {

  private static final Logger logger = LoggerFactory.getLogger(ReadPDFWithPDFBox.class);

  private File file;

  public ReadPDFWithPDFBox() {
  }

  public ReadPDFWithPDFBox(File file) {
    this.file = file;
  }


  public Map<String, Rectangle2D> buildRect(String type) {
    Map<String, Rectangle2D> rects = new HashMap<String, Rectangle2D>();
    if ("中国移动".equalsIgnoreCase(type)) {
      rects.put("Name", new Rectangle2D.Float(100, 80, 80, 15));
      rects.put("InvoiceCode", new Rectangle2D.Float(0, 0, 620, 20));
      rects.put("InvoiceNum", new Rectangle2D.Float(470, 30, 100, 10));
      rects.put("Money", new Rectangle2D.Float(160, 260, 340, 20));
    } else if ("中国联通".equalsIgnoreCase(type) || "中国电信".equalsIgnoreCase(type)) {
      rects.put("Name", new Rectangle2D.Float(110, 100, 80, 15));
      rects.put("InvoiceCode", new Rectangle2D.Float(480, 40, 100, 10));
      rects.put("InvoiceNum", new Rectangle2D.Float(480, 50, 100, 10));
      rects.put("Money", new Rectangle2D.Float(160, 260, 340, 20));
    }
    return rects;
  }

  private String getPDFType(PDDocument document) {
    String type = "";
    try {
      PDFTextStripperByArea textStripper = new PDFTextStripperByArea();
      PDFTextStripper stripper = new PDFTextStripper();
      stripper.setSortByPosition(true);
      stripper.setStartPage(1);
      stripper.setEndPage(1);
      String text = stripper.getText(document);
      text = text.replace("\r\n", "").trim();
      if (text.contains("中国移动通信")) {
        type = "中国移动";
      } else if (text.contains("中国联合网络通信")) {
        type = "中国联通";
      } else {
        type = "中国电信";
      }
    } catch (Exception e) {

    }
    return type;
  }


  public Map<String, String> extractText() {
    Map<String, String> result = new HashMap<String, String>();
    PDDocument document = null;
    try {
      document = PDDocument.load(this.file);
      String type = this.getPDFType(document);
      Map<String, Rectangle2D> rect = this.buildRect(type);
      PDFTextStripperByArea textStripper = new PDFTextStripperByArea();
      PDPage docPage = document.getPage(0);
      for (String key : rect.keySet()) {
        textStripper.addRegion(key, rect.get(key));
      }
      textStripper.extractRegions(docPage);
      for (String key : rect.keySet()) {
        String text = textStripper.getTextForRegion(key).trim();
        if ("InvoiceCode".equals(key)) {
          text = text.replace(":", "").replace("：", "").trim();
          text = text + " ";
        } else if ("InvoiceNum".equals(key)) {
          text = text.replace(":", "").replace("：", "").trim();
          text = text + " ";
        } else if ("Name".equals(key)) {
          text = text.replace(":", "").replace("：", "").trim();
        } else if ("Money".equals(key)) {
          text = text.replace(":", "").replace("：", "")
              .replace("￥", "").replace("¥", "").trim();
          text = text + " ";
        }
        if (text.length() == 0) {
          logger.error("Parse File Error :{}", this.file.getName());
          break;
        }
        logger.info("{}:{}", key, text);
        result.put(key, text);
      }

    } catch (Exception e) {
      logger.error("Parse File Error :{}", this.file.getName());
    } finally {
      if (null != document) {
        try {
          document.close();
        } catch (Exception e) {
          logger.error("Close File Error :{}", this.file.getName());
        }
      }
    }
    return result;
  }

  private String getSectionOfPage(Rectangle2D rect, int pageIndex) {
    String textForRegion = "";
    try {
      PDDocument document = PDDocument.load(this.file);
      PDFTextStripperByArea textStripper = new PDFTextStripperByArea();
      textStripper.addRegion("region", rect);
      PDPage docPage = document.getPage(pageIndex);
      textStripper.extractRegions(docPage);
      textForRegion = textStripper.getTextForRegion("region").trim();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return textForRegion;
  }

  //机器编码
  public String getMachineCode() {
    Rectangle2D rect = new Rectangle2D.Float(60, 0, 100, 80);
    String machineCode = this.getSectionOfPage(rect, 0);
    machineCode = machineCode.replace(":", "").trim();
    return machineCode;
  }

  //发票代码
  public String getInvoiceCode_ChinaMobile() {
    Rectangle2D rect = new Rectangle2D.Float(0, 0, 620, 20);
    return this.getSectionOfPage(rect, 0);
  }

  public String getInvoiceCodeOfUnion() {
    Rectangle2D rect = new Rectangle2D.Float(480, 40, 100, 10);
    String invoiceNum = this.getSectionOfPage(rect, 0);
    invoiceNum = invoiceNum.replace("：", "").trim();
    return invoiceNum;
  }

  public String getInvoiceCodeOfTelcom() {
    return this.getInvoiceCodeOfUnion();
  }

  //发票号码
  public String getInvoiceNumOfMobile() {
    Rectangle2D rect = new Rectangle2D.Float(470, 30, 100, 10);
    String invoiceNum = this.getSectionOfPage(rect, 0);
    invoiceNum = invoiceNum.replace(":", "").trim();
    return invoiceNum;
  }

  public String getInvoiceNumOfUnion() {
    Rectangle2D rect = new Rectangle2D.Float(480, 50, 100, 10);
    String invoiceNum = this.getSectionOfPage(rect, 0);
    invoiceNum = invoiceNum.replace("：", "").trim();
    return invoiceNum;
  }

  public String getInvoiceNumOfTelcom() {
    return this.getInvoiceCodeOfUnion();
  }

  //检验码
  public String getValidCode() {
    Rectangle2D rect = new Rectangle2D.Float(470, 70, 200, 15);
    String validCode = this.getSectionOfPage(rect, 0);
    validCode = validCode.replace(":", "").trim();
    return validCode;
  }

  //名称-姓名
  public String getNameOfMobile() {
    Rectangle2D rect = new Rectangle2D.Float(100, 80, 80, 15);
    String name = this.getSectionOfPage(rect, 0);
    name = name.replace(":", "").trim();
    return name;
  }

  public String getNameOfUnion() {
    Rectangle2D rect = new Rectangle2D.Float(110, 100, 80, 15);
    String name = this.getSectionOfPage(rect, 0);
    name = name.replace("：", "").trim();
    return name;
  }

  public String getNameOfTelecom() {
    return this.getNameOfUnion();
  }

  public String getCompName() {
    Rectangle2D rect = new Rectangle2D.Float(30, 300, 200, 10);
    String name = this.getSectionOfPage(rect, 0);
    name = name.replace(":", "").trim();
    return name;
  }

  //电话
  public String getTel() {
    Rectangle2D rect = new Rectangle2D.Float(100, 110, 100, 15);
    String tel = this.getSectionOfPage(rect, 0);
    tel = tel.replace(":", "").trim();
    return tel;
  }

  //纳税人识别号
  public String getTaxpayerNum() {
    Rectangle2D rect = new Rectangle2D.Float(0, 310, 260, 10);
    return this.getSectionOfPage(rect, 0);
  }

  //金额
  public String getMoney() {
    Rectangle2D rect = new Rectangle2D.Float(160, 260, 340, 20);
    return this.getSectionOfPage(rect, 0);
  }


  public void getFullPage(File file) {
    PDDocument document = null;
    try {
      document = PDDocument.load(file);
      PDFTextStripperByArea textStripper = new PDFTextStripperByArea();
      PDFTextStripper stripper = new PDFTextStripper();
      stripper.setSortByPosition(true);
      stripper.setStartPage(1);
      stripper.setEndPage(1);
      String text = stripper.getText(document);
      String pageStr = String.format("page %d:", 1);
      System.out.println(pageStr);
      for (int i = 0; i < pageStr.length(); ++i) {
        System.out.print("-");
      }
      System.out.println();
      text = text.replace("\r\n", "").trim();
      System.out.println(text.trim());
      System.out.println();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (null != document) {
        try {
          document.close();
        } catch (Exception e) {
          logger.error("Close File Error :{}", this.file.getName());
        }
      }
    }
  }

  public File getFile() {
    return file;
  }

  public void setFile(File file) {
    this.file = file;
  }
}
