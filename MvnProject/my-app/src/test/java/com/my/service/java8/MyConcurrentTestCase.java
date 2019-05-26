package com.my.service.java8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class MyConcurrentTestCase {

  @Test
  public void future() {
    ExecutorService executor = Executors.newCachedThreadPool();
    Callable<String> task = () -> {
      return "Done";
    };
    Future<String> result = executor.submit(task);
  }


  @Test
  public void executorCompletionService() throws Exception {
    ExecutorService executor = Executors.newCachedThreadPool();
    Callable<String> task1 = () -> {
      return "Done1";
    };
    Callable<String> task2 = () -> {
      return "Done2";
    };

    List<Callable<String>> tasks = Arrays.asList(task1, task2);
    ExecutorCompletionService<String> service = new ExecutorCompletionService<>(executor);
    tasks.forEach(task -> service.submit(task));
    //Return futures in the order of completion
    for (int i = 0; i < tasks.size(); i++) {
      service.take().get();
    }
  }

  @Test
  public void invokeAny() throws Exception {
    ExecutorService executor = Executors.newCachedThreadPool();
    Callable<String> task1 = () -> {
      return "Done1";
    };
    Callable<String> task2 = () -> {
      return "Done2";
    };
    List<Callable<String>> tasks = Arrays.asList(task1, task2);
    //The invokeAny method will run all of the tasks in parallel, and as soon as one of them finds the answer, then that answer is returned.
    executor.invokeAny(tasks);
  }

  public void safeConcurrency() {
    /**
     * 1. Confinement - Don't share data among tasks
     * 2. Immutability - It's safe to share immutable data
     * 3. Locking
     *
     * 4. Don't leak mutable state.
     * - Don't have any method return a reference to any mutable innards such as arrays.
     * -  Don't pass any such reference to other methods
     *
     * 5. Don't let "this" escape in a constructor
     * - Someone could observe a partially constructed object.
     * - Don't pass this to another method during construction.
     * - Don't let "this" be captures in an inner class during construction.
     *
     */
  }

  public void reentrantLock() {
    // shard among multiple thread
    Lock lock = new ReentrantLock();
    // shard among multiple thread
    int count = 0;
    lock.lock();
    try {
      count++;
    } finally {
      lock.unlock();
    }
  }

  public void intrinsicLock() {
    Object obj = new Object();
    //obj.intrinsicLock.lock();
    synchronized (obj) {
      //Critical section
    }
  }

}
