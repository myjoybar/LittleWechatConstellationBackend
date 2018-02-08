package com.joy.utils;

/**
 * Created by joybar on 2018/2/7.
 */
public class StringUtils {

    public static boolean isEmpty(CharSequence str) {
        if (str == null || str.length() == 0)
            return true;
        else
            return false;
    }
}
