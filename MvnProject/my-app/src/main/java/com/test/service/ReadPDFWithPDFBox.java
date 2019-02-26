package com.test.service;

import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;


public class ReadPDFWithPDFBox {

  private File file;

  public ReadPDFWithPDFBox() {
  }

  public ReadPDFWithPDFBox(File file) {
    this.file = file;
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
    Rectangle2D rect = new Rectangle2D.Float(0, 0, 130, 80);
    return this.getSectionOfPage(rect, 0);
  }

  //发票代码
  public String getInvoiceCode() {
    Rectangle2D rect = new Rectangle2D.Float(0, 0, 620, 20);
    return this.getSectionOfPage(rect, 0);
  }

  //发票号码
  public String getInvoiceNum() {
    Rectangle2D rect = new Rectangle2D.Float(0, 30, 600, 10);
    String invoiceNum = this.getSectionOfPage(rect, 0);
    invoiceNum = invoiceNum.replace("发票号码:监票发一", "").trim();
    return invoiceNum;
  }

  //检验码
  public String getValidCode() {
    Rectangle2D rect = new Rectangle2D.Float(160, 70, 680, 15);
    String validCode = this.getSectionOfPage(rect, 0);
    validCode = validCode.replace("海 市 税 务 局 ", "")
        .replace("校 验 码:", "");
    return validCode;
  }

  //名称
  public String getName() {
    Rectangle2D rect = new Rectangle2D.Float(0, 80, 140, 15);
    String name = this.getSectionOfPage(rect, 0);
    name = name.replace("名        称:", "");
    return name;
  }

  //电话
  public String getTel() {
    Rectangle2D rect = new Rectangle2D.Float(0, 110, 180, 15);
    String tel = this.getSectionOfPage(rect, 0);
    tel = tel.trim().replace("买", "")
        .replace(" ", "")
        .replace("\r\n", "").replace("地址、电话:", "");
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


  public void getFullPage() {
    try {
      PDDocument document = PDDocument.load(new File("C:/AAA/simple.pdf"));
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
      System.out.println(text.trim());
      System.out.println();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public File getFile() {
    return file;
  }

  public void setFile(File file) {
    this.file = file;
  }
}
