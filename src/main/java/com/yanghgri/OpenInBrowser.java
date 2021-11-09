package com.yanghgri;

import java.awt.*;
import java.net.URI;

/** @author 19877 */
public class OpenInBrowser {
  private OpenInBrowser() {}

  public static void open(String urlInput) {
    URI url;
    Desktop desktop = Desktop.getDesktop();
    try {
      url = new URI(urlInput);
      desktop.browse(url);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
