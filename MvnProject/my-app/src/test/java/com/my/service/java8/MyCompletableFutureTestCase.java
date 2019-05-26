package com.my.service.java8;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.junit.Test;

/**
 * CompletableFuture<T> implements Future<T>, CompletionStage<T>
 */

public class MyCompletableFutureTestCase {


  public CompletableFuture<String> readPage(URL url) {
    Executor executor = Executors.newSingleThreadExecutor();
    return CompletableFuture.supplyAsync(() -> {
      String content = "";
      return content;
    }, executor);
  }

  public List<URL> getImageURLs(String webpage) {
    return new ArrayList<>();
  }

  public CompletableFuture<List<BufferedImage>> getImages(List<URL> url) {
    return new CompletableFuture<List<BufferedImage>>();
  }

  public void saveImages(List<BufferedImage> images) {
  }


  @Test
  public void pipeline() {
//    Executor executor = Executors.newSingleThreadExecutor();
//    List<URL> url = new ArrayList<>();
//    CompletableFuture.completedFuture(url).thenComposeAsync(this::readPage, executor).thenApply(this::getImages)
  }

}
