
package com.my.service.understanding.jvm;

import org.junit.Test;

/**
 * VM args: -Xss2M 设置每个线程的堆栈大小
 */
public class JavaVMStackOOM {

  public void fun() {
    while (true) {

    }
  }

  @Test
  public void stackLeakByThread() {
    while (true) {
      new Thread(() -> {
        fun();
      }).start();
    }
  }

}
