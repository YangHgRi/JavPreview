package com.yanghgri.processor;

import org.apache.commons.lang3.StringUtils;

public class BasicProcess {
  private BasicProcess() {}

  public static String[] process(String avId) {
    // 去空格 + toLowerCase + 中文逗号转英文
    avId = StringUtils.deleteWhitespace(avId);
    avId = StringUtils.lowerCase(avId);
    avId = StringUtils.replace(avId, "，", ",");
    return avId.split(",");
  }
}
