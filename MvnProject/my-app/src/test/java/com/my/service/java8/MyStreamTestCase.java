package com.my.service.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.my.bean.Person;

import org.junit.Test;


/**
 * 1. Stream is immutable - all operations yield new streams (or return result)
 */
public class MyStreamTestCase {

  List<String> people = Arrays.asList("Tom", "Jack");
  List<String> phones = Arrays.asList("SumSang", "Sony");
  List<Integer> numbers = Arrays.asList(1, 12, 30, 30, 3, 2, 4, 5, 4, 5);
  List<Person> personList = new ArrayList<>();
  Stream<Locale> localeStream = Stream.of(Locale.getAvailableLocales());

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

  // Use flatMap to transform stream
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

  @Test
  public void toMap() {
    personList.stream().collect(Collectors.toMap(Person::getId, Person::getName));
  }


  /**
   * Simplest form repeats applying a binary function. (x, y) -> x operate y
   */
  @Test
  public void reduce() {
    Integer sum = numbers.stream().reduce(0, (x, y) -> x + y);
    System.out.println(sum);

    Integer product = numbers.stream().reduce(1, (x, y) -> x * y);
    System.out.println(product);

    Integer totalWordsLength = phones.stream()
        .reduce(0, (total, word) -> total + word.length(), (total1, total2) -> total1 + total2);
    System.out.println(totalWordsLength);

    Integer totalWordsLengthSimple = phones.stream().map(String::length).reduce(0, (x, y) -> x + y);
    System.out.println(totalWordsLengthSimple);

  }


  @Test
  public void groupby() {
    Map<String, List<Locale>> locales = localeStream
        .collect(Collectors.groupingBy(Locale::getCountry));
    locales.forEach((key, value) -> {
      value.stream().forEach(v -> System.out.println(v.getLanguage()));
    });
  }

  @Test
  public void partitioningby() {
    Map<Boolean, List<Locale>> locales = localeStream
        .collect(Collectors.partitioningBy(locale -> locale.getLanguage().equals("en")));
    locales.forEach((key, value) -> {
      System.out.println(key);
      value.stream().forEach(v -> System.out.println(v.getLanguage()));
      System.out.println("----");
    });
  }


  @Test
  public void usePrimitiveTypeStream() {
    /**
     * IntStream, LongStream, DoubleStream
     */
  }

  @Test
  public void parallelStream() {
    /**
     * 1. Parallel streams compute stream results concurrently
     * 2. Faster with large in-memory stream
     */
    Stream<String> parallel = phones.parallelStream();
    Optional<String> any = parallel.findAny();
    System.out.println(any.get());

    Stream<String> stream = phones.stream();
    Optional<String> other = stream.findAny();
    System.out.println(other.get());
  }




}
