package com.yanghgri;

import com.yanghgri.checker.Checker;
import com.yanghgri.processor.BasicProcess;
import com.yanghgri.processor.MainProcess;

public class Application {
  // https://cc3001.dmm.co.jp/litevideo/freepv/a/abc/abcd00123/abcd00123_dmb_w.mp4
  public static void main(String[] args) {
    Checker checker = new Checker();
    do {
      String avId;
      String[] ids;
      do {
        avId = GetCommand.getCommand();
        checker.closeChecker(avId);
        ids = BasicProcess.process(avId);
        checker.formatChecker(ids);
      } while (checker.isFormatCheck());
      String[] urls = MainProcess.process(ids);
      for (String url : urls) {
        OpenInBrowser.open(url);
      }
    } while (checker.isCloseCheck());
  }
}
