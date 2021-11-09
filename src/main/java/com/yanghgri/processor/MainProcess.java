package com.yanghgri.processor;

import org.apache.commons.lang3.StringUtils;

public class MainProcess {
  // https://cc3001.dmm.co.jp/litevideo/freepv/a/abc/abc00123/abc00123_dmb_w.mp4
  private MainProcess() {}

  public static String[] process(String[] avIds) {
    String[] urls = new String[avIds.length];
    for (int i = 0; i < avIds.length; i++) {
      String[] lettersAndNumbers = StringUtils.split(avIds[i], "-", 0);
      String letters = lettersAndNumbers[0];
      String numbers = lettersAndNumbers[1];
      urls[i] = getUrl(letters, numbers);
    }
    return urls;
  }

  private static String getUrl(String letters, String numbers) {
    return "https://cc3001.dmm.co.jp/litevideo/freepv/"
        + letters.charAt(0)
        + "/"
        + letters.substring(0, 3)
        + "/"
        + letters
        + "00"
        + numbers
        + "/"
        + letters
        + "00"
        + numbers
        + "_dmb_w.mp4";
  }
}
