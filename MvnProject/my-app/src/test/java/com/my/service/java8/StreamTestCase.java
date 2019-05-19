package com.my.service.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;


/**
 * 1. Stream is immutable - all operations yield new streams (or return result)
 */
public class StreamTestCase {

  List<String> people = Arrays.asList("Tom", "Jack");
  List<String> phones = Arrays.asList("SumSang", "Sony");
  List<Integer> numbers = Arrays.asList(1, 12, 34, 35, 23, 29, 45, 50, 45, 50, 50);


  @Before
  public void init() {
  }

  @Test
  public void fun() {
    people.stream().filter(e -> e.equals("Tom"));
  }

  // Use map to transform all stream elements
  @Test
  public void map() {
    people.stream().map(e -> e.length());
    people.stream().map(e -> e.toLowerCase());
    people.stream().map(e -> e.substring(0, 3));
  }

  //  Use flatMap to transform stream
  @Test
  public void flatMap() {
    List<List<String>> lists = new ArrayList<>();
    lists.add(people);
    lists.add(phones);
    lists.stream().forEach(System.out::println);
    lists.stream().flatMap(collection -> collection.stream()).forEach(System.out::println);
  }

  @Test
  public void limit() {
    Stream.generate(Math::random).limit(10).forEach(System.out::println);
  }

  @Test
  public void getAnswer() {
    Long num1 = numbers.stream().filter(e -> e - 20 > 0).count();
    System.out.println(num1);

    Integer max = numbers.stream().max(Integer::compareTo).get();
    System.out.println(max);

    Integer min = numbers.stream().min(Integer::compareTo).get();
    System.out.println(min);

    Double average = numbers.stream().mapToInt(e -> Integer.valueOf(e)).average().getAsDouble();
    System.out.println(average);

    OptionalInt first = numbers.stream().mapToInt(e -> Integer.valueOf(e)).filter(e -> e - 120 > 0)
        .findFirst();
    System.out.println(first);
  }

  @Test
  public void toList() {
    numbers.stream().filter(e -> e - 20 > 0).collect(Collectors.toList())
        .forEach(System.out::println);
  }

  @Test
  public void toSet() {
    numbers.stream().filter(e -> e - 20 > 0).collect(Collectors.toSet())
        .forEach(System.out::println);
  }

  @Test
  public void toSummary() {
    IntSummaryStatistics intSummaryStatistics = numbers.stream()
        .collect(Collectors.summarizingInt(Integer::intValue));
    intSummaryStatistics.getAverage();
    intSummaryStatistics.getCount();
    intSummaryStatistics.getMax();
    intSummaryStatistics.getMin();
    intSummaryStatistics.getSum();
  }


}
