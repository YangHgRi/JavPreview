package com.yanghgri.processor;

import org.apache.commons.lang3.StringUtils;

import java.text.NumberFormat;

/**
 * @author YangHgRi
 */
public class MainProcess {
    private static final int LIMITED_LENGTH = 3;
    private static final NumberFormat NUMBER_FORMATTER = NumberFormat.getInstance();
    private static final String URL_PREFIX = "https://cc3001.dmm.co.jp/litevideo/freepv/";

    static {
        NUMBER_FORMATTER.setGroupingUsed(false);
        NUMBER_FORMATTER.setMinimumIntegerDigits(5);
        NUMBER_FORMATTER.setMaximumIntegerDigits(5);
    }

    private MainProcess() {
    }

    public static String[] process(String[] avIds) {
        // https://cc3001.dmm.co.jp/litevideo/freepv/a/abc/abc00123/abc00123_mhb_w.mp4
        String[] urls = new String[avIds.length];
        for (int i = 0; i < avIds.length; i++) {
            String[] lettersAndNumbers = StringUtils.split(avIds[i], "-", 0);
            String letters = lettersAndNumbers[0];
            String numbersWithZeroFill = NUMBER_FORMATTER.format(Long.valueOf(lettersAndNumbers[1]));

            urls[i] = getUrl(letters, numbersWithZeroFill);
        }
        return urls;
    }

    private static String getUrl(String letters, String numbers) {
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(URL_PREFIX).append(letters.charAt(0)).append("/");

        if (letters.length() < LIMITED_LENGTH) {
            urlBuilder.append(letters);
        } else {
            urlBuilder.append(letters, 0, 3);
        }

        urlBuilder.append("/").append(letters).append(numbers).append("/").append(letters).append(numbers).append("_mhb_w.mp4");
        return urlBuilder.toString();
    }
}