package com.yanghgri.processor;

import org.apache.commons.lang3.StringUtils;

/**
 * @author YangHgRi
 */
public class MainProcess {
    public static final int LIMITED_LENGTH = 3;

    private MainProcess() {
    }

    public static String[] process(String[] avIds) {
        // https://cc3001.dmm.co.jp/litevideo/freepv/a/abc/abc00123/abc00123_dmb_w.mp4
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
        if (letters.length() < LIMITED_LENGTH) {
            return "https://cc3001.dmm.co.jp/litevideo/freepv/"
                    + letters.charAt(0)
                    + "/"
                    + letters
                    + "/"
                    + letters
                    + "00"
                    + numbers
                    + "/"
                    + letters
                    + "00"
                    + numbers
                    + "_dmb_w.mp4";
        } else {
            return "https://cc3001.dmm.co.jp/litevideo/freepv/"
                    + letters.charAt(0)
                    + "/"
                    + letters.substring(0, 3)
                    + "/"
                    + letters
                    /*版本更新，不需要这两个 00 了*/
                    /*+ "00"*/
                    + numbers
                    + "/"
                    + letters
                    /*+ "00"*/
                    + numbers
                    /*+ "_dmb_w.mp4";*/
                    /*mhb 画质高于 dmb*/
                    + "_mhb_w.mp4";
            // https://cc3001.dmm.co.jp/litevideo/freepv/g/gvh/gvh482/gvh482_mhb_w.mp4
        }
    }
}
