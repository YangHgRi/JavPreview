package com.yanghgri.checker;

import org.apache.commons.lang3.StringUtils;

public class CloseChecker {
  private CloseChecker() {}

  public static boolean checker = false;

  public static void check(String id) {
    id = StringUtils.lowerCase(id);
    if (StringUtils.contains(id, "exit")) {
      System.out.println("退出程序");
      System.exit(0);
    } else {
      checker = true;
    }
  }
}
