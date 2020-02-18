package com.my.service.understanding.jvm;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;

public class ClassLoaderTest {

  @Test
  public void foo() throws Exception {
    ClassLoader classLoader = new ClassLoader() {
      @Override
      public Class<?> loadClass(String name) throws ClassNotFoundException {
        try {
          String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
          InputStream inputStream = getClass().getResourceAsStream(fileName);
          if (inputStream == null) {
            return super.loadClass(name);
          }
          byte b[] = new byte[inputStream.available()];
          inputStream.read(b);
          return defineClass(name, b, 0, b.length);
        } catch (IOException e) {
          throw new ClassNotFoundException(name);
        }
      }
    };

    Object o = classLoader.loadClass("com.my.service.understanding.jvm.ClassLoaderTest")
        .newInstance();
    System.out.println(o.getClass());
    Assert.assertFalse(o instanceof com.my.service.understanding.jvm.ClassLoaderTest);
  }

}
