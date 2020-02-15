package com.my.service.understanding.jvm;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


/**
 * Vm args: -XX:PermSize=10M -XX:MaxPermSize=10M Java HotSpot(TM) 64-Bit Server VM warning: Ignoring
 * option PermSize; support was removed in 8.0 Java HotSpot(TM) 64-Bit Server VM warning: Ignoring
 * option MaxPermSize; support was removed in 8.0
 */
public class RuntimeConstantPoolOOM {

  @Test
  public void fun() {

    List<String> list = new ArrayList<>();
    int i = 0;
//    while (true) {
//      list.add(String.valueOf(i).intern());
//    }

  }

  @Test
  public void foo() {
    String str1 = new StringBuilder("hello, ").append("world").toString();
    Assert.assertTrue(str1.intern() == str1);

    String str2 = new StringBuilder(",welcomme ").append("home").toString();
    Assert.assertTrue(str2.intern() == str2);
  }

}
