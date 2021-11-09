package com.yanghgri.checker;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
public class Checker {
  private boolean closeCheck;
  private boolean formatCheck;

  public void closeChecker(String command) {
    command = StringUtils.lowerCase(command);
    if (StringUtils.contains(command, "exit")) {
      System.out.println("退出程序");
      System.exit(0);
    } else {
      setCloseCheck(true);
    }
  }

  public void formatChecker(String[] avIds) {
    for (String id : avIds) {
      // 番号不包含"-"，肯定有问题
      if (!StringUtils.contains(id, "-")) {
        System.err.println("格式错误,重新输入");
        setFormatCheck(true);
      } else {
        setFormatCheck(false);
      }
    }
  }
}
