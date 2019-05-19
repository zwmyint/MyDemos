package com.my.utils;

import com.my.service.ReadPDFWithPDFBox;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtil {

  private static final Logger logger = LoggerFactory.getLogger(ReadPDFWithPDFBox.class);

  public static boolean writeFile(String content, File file) {
    return writeFile(content, file, false);
  }

  public static boolean writeFile(String content, File file, boolean append) {
    Writer out = null;
    try {
      out = new OutputStreamWriter(new FileOutputStream(file, append), "UTF-8");
      out.write(content);
      out.flush();
      logger.info("write file " + file.getPath());
    } catch (Exception e) {
      logger.error("write file failed" + file.getPath(), e);
      return false;
    } finally {
      try {
        out.close();
      } catch (IOException e) {
        logger.error("write file failed" + file.getPath(), e);
      }
    }
    return true;
  }
}
