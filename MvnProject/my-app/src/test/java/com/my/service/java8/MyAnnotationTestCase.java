package com.my.service.java8;

import static java.util.Objects.requireNonNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

//[ref-doc]: https://dzone.com/articles/creating-custom-annotations-in-java

// 1. Processing Annotations at RunTime
// 2. Modifying Class at Load Time used for dependence injection, persistence and so on.
// 3. Wish ASM library to do Bytecode engineering


/**
 * 1. Define the custom annotation
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface ToString {
  boolean includeName() default true;
}


/**
 * 2. Implement the custom annotation
 */


class ToStringFactory {

  public static String customToString(Object object) throws Exception {
    Map<String, String> result = new HashMap();
    Class<?> clazz = requireNonNull(object).getClass();
    ToString classAnnotation = clazz.getAnnotation(ToString.class);
    for (Field field : clazz.getDeclaredFields()) {
      field.setAccessible(true);
      ToString fieldAnnotation = field.getAnnotation(ToString.class);
      if (fieldAnnotation.includeName()) {
        result.put(field.getName(), (String) field.get(object));
      }
    }
    return result(result);
  }

  private static String result(Map<String, String> map) {
    String elementsString = map.entrySet()
        .stream()
        .map(entry -> "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"")
        .collect(Collectors.joining(","));
    return "{" + elementsString + "}";
  }
}

public class MyAnnotationTestCase {

  @Test
  public void customToString() throws Exception {
    Point pointWithName = new Point("12.3", "11.3", "Point1");
    System.out.println(ToStringFactory.customToString(pointWithName));
  }

}

class Point {

  @ToString
  private String x;
  @ToString
  private String y;
  @ToString(includeName = true)
  private String name;

  public Point(String x, String y, String name) {
    this.x = x;
    this.y = y;
    this.name = name;
  }

  public String getX() {
    return x;
  }

  public void setX(String x) {
    this.x = x;
  }

  public String getY() {
    return y;
  }

  public void setY(String y) {
    this.y = y;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

