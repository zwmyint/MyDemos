package com.my.service.java8;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

public class CountDownLatchTestCase {

  @Test
  public void test() throws Exception {
    int threadCount = 200;
    ExecutorService exec = Executors.newCachedThreadPool();
    final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
    for (int i = 0; i < threadCount; i++) {
      final int threadNum = i;
      exec.execute(() -> {
        try {
          Thread.sleep(1000);
          System.out.println("Thread Num:" + threadNum);
        } catch (Exception e) {
          System.out.println(e);
        } finally {
          countDownLatch.countDown();
        }
      });
    }
    countDownLatch.await();
    System.out.println("finish");
    exec.shutdown();
  }

}
