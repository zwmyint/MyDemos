package com.my.service.understanding.jvm;

import org.junit.Test;

public class FinalizeEscapeGC {

  public static FinalizeEscapeGC SAVE_HOOK = null;

  public void isAlive() {
    System.out.println("yes, iam still alive.");
  }

  @Override
  protected void finalize() throws Throwable {
    super.finalize();
    System.out.println("finalize method executed!");
    FinalizeEscapeGC.SAVE_HOOK = this; //对象被救活！！
  }

  @Test
  public void foo() throws Exception {
    //第一次成功自救，没有被回收
    SAVE_HOOK = new FinalizeEscapeGC();
    SAVE_HOOK = null;
    System.gc();

    SAVE_HOOK = null;
    System.gc();

    Thread.sleep(500);
    if (SAVE_HOOK != null) {
      SAVE_HOOK.isAlive();
    } else {
      System.out.println("Dead!");
    }

//    Thread.sleep(1000);
  }

}
