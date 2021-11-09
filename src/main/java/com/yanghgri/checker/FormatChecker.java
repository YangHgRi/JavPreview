package com.yanghgri.checker;

import org.apache.commons.lang3.StringUtils;

public class FormatChecker {
  private FormatChecker() {}

  public static boolean checker = false;

  public static void check(String[] avIds) {
    for (String id : avIds) {
      // 番号不包含"-"，肯定有问题
      if (!StringUtils.contains(id, "-")) {
        System.err.println("格式错误,重新输入");
        checker = true;
      } else {
        checker = false;
      }
    }
  }
}
