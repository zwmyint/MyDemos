package com.wait.play;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import reactor.core.publisher.Flux;

public class ReactorTestCase {
  private List<String> words = Arrays
      .asList("the", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");


  @Test
  public void singleSubscriber() {
    Flux<String> manyWords = Flux.fromIterable(words);
    List<String> result = new ArrayList<>();
    manyWords.subscribe(result::add);
    result.forEach(System.out::println);
  }


}
