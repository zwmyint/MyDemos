package com.my.service.java8;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;


public class MyInputAndOutput {

  @Test
  public void files() {
    URL url = MyInputAndOutput.class.getResource("/test.text");
    try {
      Path path = Paths.get(url.toURI());
      byte[] bytes = Files.readAllBytes(path);
      System.out.println(bytes.length);

      List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
      lines.forEach(System.out::println);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void scanner() {
    URL url = MyInputAndOutput.class.getResource("/test.text");
    try {
      Path path = Paths.get(url.toURI());
      Scanner scanner = new Scanner(path, "UTF-8");
      scanner.useDelimiter("\\PL+");
      while(scanner.hasNext()) {
        System.out.println(scanner.next());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void printerWriter() {
    URL url = MyInputAndOutput.class.getResource("/test.text");
    try {
      Path folder = Paths.get(url.toURI()).getParent();

    } catch (Exception e) {
      e.printStackTrace();
    }

    /**
     * 1. PrintWriter out
     * 2. try (PrintWriter out = ...)
     * 3. Files.write(path, contentString.getBytes(charset));
     * 4. Files.write(path, lines, charset)
     * 5. Files.write(path, lines, charset, StandardOpenOption.APPEND);
     */
  }

}
