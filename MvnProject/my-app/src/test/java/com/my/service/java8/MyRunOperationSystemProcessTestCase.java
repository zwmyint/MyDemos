package com.my.service.java8;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import org.junit.Test;

public class MyRunOperationSystemProcessTestCase {

  String resources =
      "." + File.separator + "src" + File.separator + "test" + File.separator + "resources"
          + File.separator;


  @Test
  public void test() throws Exception {
    Path path = Paths.get(resources);
    ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c",
        "dir " + path.toAbsolutePath());
    Process process = processBuilder.start();
    InputStream inputStream = process.getInputStream();
    Scanner in = new Scanner(inputStream);
    while (in.hasNext()) {
      System.out.println(in.nextLine());
    }
    //Java 9 API
    process.onExit().thenAccept(h -> System.out.println(h + " Done"));

  }

}
