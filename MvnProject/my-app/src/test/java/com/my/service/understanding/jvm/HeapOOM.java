package com.my.service.understanding.jvm;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * VM args -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {

  static class OOMObject {

  }


  @Test
  public void fun() {
    List<OOMObject> list = new ArrayList<>();
    while (true) {
      list.add(new OOMObject());
    }
  }

}
