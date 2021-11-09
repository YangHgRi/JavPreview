package com.yanghgri;

import com.yanghgri.checker.CloseChecker;
import com.yanghgri.checker.FormatChecker;
import com.yanghgri.processor.BasicProcess;
import com.yanghgri.processor.MainProcess;

public class Application {
  // https://cc3001.dmm.co.jp/litevideo/freepv/a/abc/abcd00123/abcd00123_dmb_w.mp4
  public static void main(String[] args) {
    do {
      String avId;
      String[] ids;
      do {
        avId = GetCommand.getCommand();
        CloseChecker.check(avId);
        ids = BasicProcess.process(avId);
        FormatChecker.check(ids);
      } while (FormatChecker.checker);
      String[] urls = MainProcess.process(ids);
      for (String url : urls) {
        OpenInBrowser.open(url);
      }
    } while (CloseChecker.checker);
  }
}
