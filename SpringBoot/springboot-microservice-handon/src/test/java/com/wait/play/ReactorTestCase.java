package com.wait.play;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

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

  @Test
  public void flapMap() {
    StepVerifier.create(
        Flux.just("flux", "mono").flatMap(s -> Flux.fromArray(s.split("\\s*")).delayElements(
            Duration.ofMillis(100)))
            .doOnNext(System.out::print)).expectNextCount(8).verifyComplete();

  }

  @Test
  public void filter() {
    StepVerifier.create(Flux.range(1, 6).filter(i -> i % 2 == 1).map(i -> i * i))
        .expectNext(1, 9, 25).verifyComplete();
  }

}
