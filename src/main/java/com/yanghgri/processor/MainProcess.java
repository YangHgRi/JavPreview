package com.yanghgri.processor;

import org.apache.commons.lang3.StringUtils;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author YangHgRi
 */
public class MainProcess {
    private static final int LIMITED_LENGTH = 3;
    private static final NumberFormat NUMBER_FORMATTER = NumberFormat.getInstance();
    private static final String FANZA_URL_PREFIX = "https://cc3001.dmm.co.jp/litevideo/freepv/";
    private static final String MGS_URL_PREFIX = "https://sample.mgstage.com/sample/prestige/";
    private static final Map<String, String> POST_PROCESS_MAP = new HashMap<>();
    private static final Set<String> MGS_LETTERS_SET = new HashSet<>();

    static {
        NUMBER_FORMATTER.setGroupingUsed(false);
        NUMBER_FORMATTER.setMinimumIntegerDigits(5);
        NUMBER_FORMATTER.setMaximumIntegerDigits(5);

        MGS_LETTERS_SET.add("abp");
        MGS_LETTERS_SET.add("abw");

        POST_PROCESS_MAP.put("stars", "1stars");
        POST_PROCESS_MAP.put("sdmua", "1sdmua");
        POST_PROCESS_MAP.put("sdmm", "1sdmm");
        POST_PROCESS_MAP.put("sdde", "1sdde");
        POST_PROCESS_MAP.put("sdmf", "1sdmf");
        POST_PROCESS_MAP.put("star", "1star");
        POST_PROCESS_MAP.put("sdab", "1sdab");
        POST_PROCESS_MAP.put("sdnm", "1sdnm");
        POST_PROCESS_MAP.put("sdjs", "1sdjs");

        POST_PROCESS_MAP.put("mvs", "mvsd");
    }

    private MainProcess() {
    }

    public static String[] process(String[] avIds) {
        // https://cc3001.dmm.co.jp/litevideo/freepv/a/abc/abc00123/abc00123_mhb_w.mp4
        String[] urls = new String[avIds.length];
        for (int i = 0; i < avIds.length; i++) {
            String[] lettersAndNumbers = StringUtils.split(avIds[i], "-", 0);
            String letters = lettersAndNumbers[0];

            for (Map.Entry<String, String> entry : POST_PROCESS_MAP.entrySet()) {
                if (letters.equals(entry.getKey())) {
                    letters = entry.getValue();
                    break;
                }
            }

            if (letters.startsWith("1")) {
                urls[i] = getUrlForFanza(letters, lettersAndNumbers[1]);
            } else if (MGS_LETTERS_SET.contains(letters)) {
                urls[i] = getUlrForMGS(letters, lettersAndNumbers[1]);
            } else {
                urls[i] = getUrlForFanza(letters, NUMBER_FORMATTER.format(Long.valueOf(lettersAndNumbers[1])));
            }
        }
        return urls;
    }

    private static String getUrlForFanza(String letters, String numbers) {
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(FANZA_URL_PREFIX).append(letters.charAt(0)).append("/");

        if (letters.length() < LIMITED_LENGTH) {
            urlBuilder.append(letters);
        } else {
            urlBuilder.append(letters, 0, 3);
        }

        urlBuilder.append("/").append(letters).append(numbers).append("/").append(letters).append(numbers).append("_mhb_w.mp4");
        return urlBuilder.toString();
    }

    private static String getUlrForMGS(String letters, String numbers) {
        return MGS_URL_PREFIX + letters + "/" + numbers + "/" + letters.toUpperCase() + "-" + numbers + ".mp4";
    }
}