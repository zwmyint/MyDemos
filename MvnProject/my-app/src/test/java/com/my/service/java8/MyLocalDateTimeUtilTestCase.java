package com.my.service.java8;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import org.junit.Test;

import com.my.utils.LocalDateTimeUtil;

import static java.time.temporal.ChronoUnit.MINUTES;
import static junit.framework.TestCase.assertEquals;

public class MyLocalDateTimeUtilTestCase {

  @Test
  public void parse() {
    String dateStr = "2013-12-18T03:40:42Z";
    LocalDateTime date = LocalDateTimeUtil.parse(dateStr);
    String formatString = LocalDateTimeUtil.format(date, "yyyy-MM-dd hh:mm:ss");
    assertEquals("2013-12-18 03:40:42", formatString);
  }

  @Test
  public void getSpanHours() {
    try {
      String dateStr = "2013-12-18 03:40:42";
      Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr);
      String dateStr1 = "2013-12-18 04:40:42";
      Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr1);
      long span = LocalDateTimeUtil.getDateSpanHours(date, date1);
      assertEquals(1, span);
    } catch (Exception e) {

    }

  }

  @Test
  public void getSpanMinutes() {
    try {
      String dateStr = "2013-12-18 04:40:42";
      Date start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr);
      String dateStr1 = "2013-12-18 04:41:42";
      Date end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr1);
      long span = LocalDateTimeUtil.getDateSpanMinutes(start, end);
      assertEquals(1, span);
    } catch (Exception e) {

    }
  }

  @Test
  public void getSpanSeconds() {
    try {
      String dateStr = "2013-12-18 04:40:42";
      Date start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr);
      String dateStr1 = "2013-12-18 04:40:43";
      Date end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr1);
      long span = LocalDateTimeUtil.getDateSpanSecond(start, end);
      assertEquals(1, span);
    } catch (Exception e) {

    }
  }

  @Test
  public void zoneDateTime() {
    LocalDateTime localDateTime = LocalDateTime.now();
    ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("America/New_York"));
    System.out.println(zonedDateTime);
    System.out.println(ZoneId.systemDefault());
    System.out.println("===========");
    ZoneId.getAvailableZoneIds().stream().filter(z -> z.toString().contains("America"))
        .forEach(z -> System.out.println(z));

  }


  /**
   * UTC offset
   */
  @Test
  public void zoneId_1() {
    ZoneId newYork = ZoneId.of("America/New_York");
    LocalDate localDate = LocalDate.of(2014, Month.MARCH, 8);
    LocalTime localTime = LocalTime.of(16, 00);
    LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);

    System.out.println("localDateTime: " + localDateTime);

    ZonedDateTime courseStart = ZonedDateTime.of(localDateTime, newYork);
    System.out.println("courseStart: " + courseStart);

    ZonedDateTime newCourseStart = courseStart.plusDays(1);
    System.out.println("newCourseStart: " + newCourseStart);

    ZonedDateTime hereNow = ZonedDateTime.now(newYork).truncatedTo(MINUTES);
    System.out.println("HereNow: " + hereNow);
  }

  /**
   * OffsetDateTime
   */
  @Test
  public void zoneId_2() {
    LocalDateTime meeting = LocalDateTime.of(2014, Month.JUNE, 13, 12, 30);
    ZoneId angeles = ZoneId.of("America/Los_Angeles");
    ZonedDateTime staffCall = ZonedDateTime.of(meeting, angeles);
    OffsetDateTime offsetDateTime = staffCall.toOffsetDateTime();

    System.out.println("meeting: " + meeting);
    System.out.println("staffCall: " + staffCall);
    System.out.println("offsetDateTime: " + offsetDateTime);

    ZoneId london = ZoneId.of("Europe/London");
    OffsetDateTime offsetDateTime1 = staffCall.toOffsetDateTime();
    ZonedDateTime staffCallUK = offsetDateTime1.atZoneSameInstant(london);
    System.out.println("staffCallUK: " + staffCallUK);
  }

  /**
   * 计算跨TimeZone 飞机的起飞与降落时间
   */
  @Test
  public void zoneId_3() {
    LocalDateTime takeoff_BJ_Local = LocalDateTime.now();
    LocalDateTime land_BJ_Local = LocalDateTime.now().plusHours(2).plusMinutes(30);

    System.out.println("Takeoff at BJ, BJ Time: " + takeoff_BJ_Local.truncatedTo(MINUTES));
    System.out.println("Land at NY, BJ Time: " + land_BJ_Local.truncatedTo(MINUTES));

    ZoneId newYork = ZoneId.of("America/New_York");
    //将LocalDateTime转化为对应的ZonedDateTime
    ZonedDateTime takeoff_BJ_Zone = ZonedDateTime.of(takeoff_BJ_Local, ZoneId.systemDefault());
    //计算UTC offset
    OffsetDateTime takeoff_BJ_offset = takeoff_BJ_Zone.toOffsetDateTime();
    //计算NY的当地时间
    ZonedDateTime takeoff_NY_Zone = takeoff_BJ_offset.atZoneSameInstant(newYork);
    System.out.println("Takeoff at BJ,  NY Time: " + takeoff_NY_Zone.truncatedTo(MINUTES));

    ZonedDateTime land_BJ_Zone = ZonedDateTime.of(land_BJ_Local, ZoneId.systemDefault());
    //计算UTC offset
    OffsetDateTime land_NY_offset = land_BJ_Zone.toOffsetDateTime();
    //计算NY的当地时间
    ZonedDateTime land_NY_Zone = land_NY_offset.atZoneSameInstant(newYork);
    System.out.println("Land at NY,  NY Time: " + land_NY_Zone.truncatedTo(MINUTES));


  }


}
