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

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface CustomName {

  String value() default "";
}

public class MyAnnotationTestCase {

  @Test
  public void customTeacher() throws Exception {
    Teacher teacher = new Teacher();
    teacher.setName("Li Ming");
    new PrintTeacher().serialize(teacher);

  }

}

class Teacher {

  @CustomName("Good")
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

class PrintTeacher {

  private static String getSerializedKey(Field field) {
    String annotationValue = field.getAnnotation(CustomName.class).value();
    if (annotationValue.isEmpty()) {
      return field.getName();
    } else {
      return annotationValue;
    }
  }

  public String serialize(Object object) throws Exception {
    try {
      Class<?> objectClass = requireNonNull(object).getClass();
      Map<String, String> jsonElements = new HashMap<>();
      for (Field field : objectClass.getDeclaredFields()) {
        field.setAccessible(true);
        if (field.isAnnotationPresent(CustomName.class)) {
          jsonElements.put(getSerializedKey(field), (String) field.get(object));
        }
      }
      System.out.println(result(jsonElements));
      return result(jsonElements);
    } catch (IllegalAccessException e) {
      throw e;
    }
  }

  private String result(Map<String, String> jsonMap) {
    String elementsString = jsonMap.entrySet()
        .stream()
        .map(entry -> "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"")
        .collect(Collectors.joining(","));
    return "{" + elementsString + "}";
  }
}
