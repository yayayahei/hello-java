package com.yayayahei.regex;

import java.util.Arrays;
import java.util.List;

public class TestRegex {
    private static final String SPLIT_MARK = "|||";

    public static void main(String[] args) {
        String key = "更换" + SPLIT_MARK + "灰尘过滤器";
        List<String> keyWords = Arrays.asList(key.split("\\|\\|\\|"));
        System.out.println(keyWords);
    }
}
