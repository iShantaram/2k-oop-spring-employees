package com.agapov.buhuchet;

import org.apache.commons.lang3.StringUtils;

public class StringUtilsTest {
    public static void main(String[] args) {
        String message1 = "ivanov";
        String message2 = "IVAN";

        String result1 = StringUtils.capitalize(StringUtils.toRootLowerCase(message1));
        String result2 = StringUtils.capitalize(StringUtils.toRootLowerCase(message2));

        System.out.println(result1);
        System.out.println(result2);
    }
}
