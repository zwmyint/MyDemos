package com.test.service.java8;


import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;


/**
 * CyclicBarrier也叫同步屏障，在JDK1.5被引入，可以让一组线程达到一个屏障时被阻塞，直到最后一个线程达到屏障时，所以被阻塞的线程才能继续执行。
 * CyclicBarrier好比一扇门，默认情况下关闭状态，堵住了线程执行的道路，直到所有线程都就位，门才打开，让所有线程一起通过。
 */

class LongTimeTask implements Runnable {

  private CyclicBarrier cyclicBarrier;
  private String name;
  private List<String> names;

  public LongTimeTask(CyclicBarrier cyclicBarrier, String name, List<String> names) {
    this.cyclicBarrier = cyclicBarrier;
    this.name = name;
    this.names = names;
  }

  @Override
  public void run() {
    try {
      System.out.println(name + " begin to run");
      Thread.sleep(4000);
      names.add(name);
      this.cyclicBarrier.await();
      System.out.println(name + " after wait");
      System.out.println(names.size() + " size()....");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

public class CyclicBarrierTestCase {


  public static void main(String[] args) {
    int tasks = 5;
    CopyOnWriteArrayList<String> names = new CopyOnWriteArrayList<String>();
    CyclicBarrier cyclicBarrier = new CyclicBarrier(tasks);
    for (int i = 0; i < tasks; i++) {
      new Thread(new LongTimeTask(cyclicBarrier, "Thread " + i, names)).start();
    }

  }

}
