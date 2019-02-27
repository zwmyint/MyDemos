package com.test.service;

import java.io.File;
import java.util.stream.Stream;

import org.junit.Test;

public class ReadPDFWithPDFBoxTestCase {

  private File pdf = new File("C:/AAA/simple_telecom.pdf");

  private ReadPDFWithPDFBox readPDFWithPDFBox = new ReadPDFWithPDFBox(pdf);

  @Test
  public void getFullPage() {
    readPDFWithPDFBox.getFullPage();
  }

  @Test
  public void getMachineCode() {
    String machineCode = readPDFWithPDFBox.getMachineCode();
    System.out.println(machineCode);
  }

  @Test
  public void getInvoiceCode_ChinaMobile() {
    String invoiceCode = readPDFWithPDFBox.getInvoiceCode_ChinaMobile();
    System.out.println(invoiceCode);
  }

  @Test
  public void getInvoiceCodeOfUnion() {
    String invoiceNum = readPDFWithPDFBox.getInvoiceCodeOfUnion();
    System.out.println(invoiceNum);
  }

  @Test
  public void getInvoiceCodeOfTelcom() {
    String invoiceNum = readPDFWithPDFBox.getInvoiceCodeOfUnion();
    System.out.println(invoiceNum);
  }

  @Test
  public void getInvoiceNumOfMobile() {
    String invoiceNum = readPDFWithPDFBox.getInvoiceNumOfMobile();
    System.out.println(invoiceNum);
  }

  @Test
  public void getInvoiceNumOfUnion() {
    String invoiceNum = readPDFWithPDFBox.getInvoiceNumOfUnion();
    System.out.println(invoiceNum);
  }

  @Test
  public void getInvoiceNumOfTelcom() {
    String invoiceNum = readPDFWithPDFBox.getInvoiceNumOfTelcom();
    System.out.println(invoiceNum);
  }

  @Test
  public void getValidCode() {
    String validCode = readPDFWithPDFBox.getValidCode();
    System.out.println(validCode);
  }

  @Test
  public void getNameOfMobile() {
    String name = readPDFWithPDFBox.getNameOfMobile();
    System.out.println(name);
  }

  @Test
  public void getNameOfUnion() {
    String name = readPDFWithPDFBox.getNameOfUnion();
    System.out.println(name);
  }

  @Test
  public void getNameOfTelecom() {
    String name = readPDFWithPDFBox.getNameOfTelecom();
    System.out.println(name);
  }

  @Test
  public void getCompName() {
    String name = readPDFWithPDFBox.getCompName();
    System.out.println(name);
  }

  @Test
  public void getTel() {
    String tel = readPDFWithPDFBox.getTel();
    System.out.println(tel);
  }

  @Test
  public void getTaxpayerNum() {
    String taxpayerNum = readPDFWithPDFBox.getTaxpayerNum();
    System.out.println(taxpayerNum);
  }

  @Test
  public void getMoney() {
    String money = readPDFWithPDFBox.getMoney();
    System.out.println(money);
  }

  @Test
  public void extractText() {
    readPDFWithPDFBox.extractText();
  }

  @Test
  public void extractFolder() {
    File dir = new File("C:/AAA/pdfs");
    Stream.of(dir.listFiles()).forEach(pdf->{
      ReadPDFWithPDFBox readPDFWithPDFBox = new ReadPDFWithPDFBox(pdf);
      readPDFWithPDFBox.extractText();

    });
  }

}
