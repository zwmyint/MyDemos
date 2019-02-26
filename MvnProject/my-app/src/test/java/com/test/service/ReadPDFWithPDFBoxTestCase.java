package com.test.service;

import java.io.File;

import org.junit.Test;

public class ReadPDFWithPDFBoxTestCase {

  private File pdf = new File("C:/AAA/simple.pdf");

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
  public void getInvoiceCode() {
    String invoiceCode = readPDFWithPDFBox.getInvoiceCode();
    System.out.println(invoiceCode);
  }

  @Test
  public void getInvoiceNum() {
    String invoiceNum = readPDFWithPDFBox.getInvoiceNum();
    System.out.println(invoiceNum);
  }

  @Test
  public void getValidCode() {
    String validCode = readPDFWithPDFBox.getValidCode();
    System.out.println(validCode);
  }

  @Test
  public void getName() {
    String name = readPDFWithPDFBox.getName();
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

}
