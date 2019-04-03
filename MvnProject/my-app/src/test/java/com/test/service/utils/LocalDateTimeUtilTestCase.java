package com.test.service.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

import org.junit.Test;

import com.test.utils.LocalDateTimeUtil;

import static junit.framework.TestCase.assertEquals;

public class LocalDateTimeUtilTestCase {

  @Test
  public void parse() {
    String dateStr = "2013-12-18T03:40:42Z";
    LocalDateTime date = LocalDateTimeUtil.parse(dateStr);
    String formatString = LocalDateTimeUtil.format(date, "yyyy-MM-dd hh:mm:ss");
    assertEquals("2013-12-18 03:40:42", formatString);
  }

  @Test
  public void getSpanHours() {
    try{
      String dateStr = "2013-12-18 03:40:42";
      Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr);
      String dateStr1 = "2013-12-18 04:40:42";
      Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr1);
      long span = LocalDateTimeUtil.getDateSpanHours(date, date1);
      assertEquals(1, span);
    }catch(Exception e) {

    }

  }

  @Test
  public void getSpanMinutes() {
    try{
      String dateStr = "2013-12-18 04:40:42";
      Date start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr);
      String dateStr1 = "2013-12-18 04:41:42";
      Date end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr1);
      long span = LocalDateTimeUtil.getDateSpanMinutes(start, end);
      assertEquals(1, span);
    }catch(Exception e) {

    }
  }

  @Test
  public void getSpanSeconds() {
    try{
      String dateStr = "2013-12-18 04:40:42";
      Date start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr);
      String dateStr1 = "2013-12-18 04:40:43";
      Date end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr1);
      long span = LocalDateTimeUtil.getDateSpanSecond(start, end);
      assertEquals(1, span);
    }catch(Exception e) {

    }
  }

  @Test
  public void zoneDateTime() {


    LocalDateTime localDateTime = LocalDateTime.now();

    ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("America/New_York"));




    System.out.println(zonedDateTime);


    System.out.println(ZoneId.systemDefault());

    System.out.println("===========");
    ZoneId.getAvailableZoneIds().stream().filter(z->z.toString().contains("America")).forEach(z-> System.out.println(z));

  }

}
