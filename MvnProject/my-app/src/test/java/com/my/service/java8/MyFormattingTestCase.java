package com.my.service.java8;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

import org.junit.Test;

public class MyFormattingTestCase {

  @Test
  public void format() {
    Locale locale = Locale.GERMANY;
    NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
    double amount = 123456.78;
    String result = numberFormat.format(amount);
    System.out.println(result);

    numberFormat.setCurrency(Currency.getInstance("USD"));
    result = numberFormat.format(amount);
    System.out.println(result);


  }

  @Test
  public void read() throws Exception {
    Locale locale = Locale.US;
    NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
    String amount = "$123456.78";
    Number parsed = numberFormat.parse(amount);
    double value = parsed.doubleValue();
    System.out.println(value);

  }

}
