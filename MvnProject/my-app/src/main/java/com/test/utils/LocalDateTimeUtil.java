package com.test.utils;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.test.service.ReadPDFWithPDFBox;

public class LocalDateTimeUtil {

  public static final String DATE_FORMAT1 = "MM/dd/yyyy";
  public static final String DATE_FORMAT2 = "yyyy-MM-dd";
  public static final String DATE_FORMAT3 = "yyyy-MM-dd HH:mm:ss";
  public static final String DATE_FORMAT4 = "yyyy-MM-dd HH:mm:ss.SSS";
  public static final String DATE_FORMAT5 = "yyMMddHHmmss";
  public static final String DATE_FORMAT6 = "yyyy/MM/dd HH:mm:ss.SSS zzz";
  public static final String DATE_FORMAT7 = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
  public static final String DATE_FORMAT8 = "MM-dd HH:mm:ss";
  public static final String ISO601_FORMAT1 = "yyyy-MM-dd'T'HH:mm:ss'Z'";
  public static final String ISO601_FORMAT2 = "yyyy-MM-dd'T'HH:mm:ss";
  public static final String ISO601_FORMAT3 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
  public static final String ISO601_FORMAT4 = "yyyy-MM-dd'T'HH:mm:ss.SSS";
  private static final Logger logger = LoggerFactory.getLogger(LocalDateTimeUtil.class);

  public static LocalDateTime parse(final String dateTimeStr) {
    String[] formats = new String[]{DATE_FORMAT8, DATE_FORMAT7, DATE_FORMAT6, DATE_FORMAT5,
        DATE_FORMAT4, DATE_FORMAT1, DATE_FORMAT2, DATE_FORMAT3,
        ISO601_FORMAT1, ISO601_FORMAT2, ISO601_FORMAT3, ISO601_FORMAT4};
    LocalDateTime localDateTime = null;

    for (int i = 0; i < formats.length; i++) {
      try {
        localDateTime = LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern(formats[i]));
        if (null != localDateTime) {
          break;
        }
      } catch (Exception e) {
        logger.debug("Unparseable date: " + dateTimeStr + " with format " + formats[i]);
      }

    }
    return localDateTime;
  }

  public static String format(final LocalDateTime localDateTime, String dateTimeFormat) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormat);
    return localDateTime.format(formatter);
  }

  public static long getDateSpanYears(final Date startDate, final Date endDate) {
    return ChronoUnit.YEARS
        .between(convertToLocalDateTime(startDate), convertToLocalDateTime(endDate));
  }

  public static long getDateSpanMonths(final Date startDate, final Date endDate) {
    return ChronoUnit.MONTHS
        .between(convertToLocalDateTime(startDate), convertToLocalDateTime(endDate));
  }

  public static long getDateSpanDays(final Date startDate, final Date endDate) {
    return ChronoUnit.DAYS
        .between(convertToLocalDateTime(startDate), convertToLocalDateTime(endDate));
  }

  public static long getDateSpanHours(final Date startDate, final Date endDate) {
    return ChronoUnit.HOURS
        .between(convertToLocalDateTime(startDate), convertToLocalDateTime(endDate));
  }

  public static long getDateSpanMinutes(final Date startDate, final Date endDate) {
    return ChronoUnit.MINUTES
        .between(convertToLocalDateTime(startDate), convertToLocalDateTime(endDate));
  }

  public static long getDateSpanSecond(final Date startDate, final Date endDate) {
    return ChronoUnit.SECONDS
        .between(convertToLocalDateTime(startDate), convertToLocalDateTime(endDate));
  }

  public static LocalDate getToday() {
    return LocalDate.now();
  }

  public static LocalTime getNowAddMinutes(int minutes) {
    return LocalTime.now().plus(Duration.ofMinutes(minutes));
  }

  public static LocalDate getTomorrow() {
    return getToday().plus(Period.ofDays(1));
  }

  public static LocalDate getYesterday() {
    return getToday().plus(Period.ofDays(-1));
  }

  public static LocalDate getNowAddDays(int days) {
    return getToday().plus(Period.ofDays(days));
  }

  public static LocalDate nowAddMonths(int months) {
    return getToday().plus(Period.ofMonths(months));
  }

  public static LocalDate nowAddYears(int years) {
    return getToday().plus(Period.ofYears(years));
  }

  public static LocalDateTime convertToLocalDateTime(Date dateToConvert) {
    return LocalDateTime.ofInstant(dateToConvert.toInstant(), ZoneId.systemDefault());
  }

  public Date convertToDateViaInstant(LocalDateTime dateToConvert) {
    return Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
  }

}
