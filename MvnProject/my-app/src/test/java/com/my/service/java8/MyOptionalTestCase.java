package com.my.service.java8;

import java.util.Optional;

import org.junit.Test;

/**
 * Best practices:
 * 1. A variable of type Optional should never be null
 * 2. Don't have fields of Optional type
 * 3. Avoid parameters of Optional type
 * 4. Don't create an optional to make a null check
 *    Optional.ofNullable(result).ifPresentOrElse(...); Way too complex
 * 5. A list of Optional value or a map with Optional key is dubious
 *    Instead of List<Optional<String>>, just have List<String>
 */
public class MyOptionalTestCase {

  @Test
  public void fun() {
    String name = "Bob";
    Optional<String> optionalName = Optional.of(name);
    if(optionalName.isPresent()) {
      System.out.println(optionalName.get());
    }
    Optional<String> emptyStr = Optional.empty();
    System.out.println(emptyStr);
  }

}
