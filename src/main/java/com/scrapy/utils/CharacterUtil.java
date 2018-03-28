package com.scrapy.utils;

/**
 * Created by marico on 2018/2/23.
 */
public class CharacterUtil {

    public static boolean isUpper(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }

        char[] strs = str.toCharArray();
        for (char s : strs) {
            if (s < 'A' || s > 'Z') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUpper("ABCDF"));
    }
}
