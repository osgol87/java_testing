package org.osgol.javatests.util;

public class StringUtil {

    private StringUtil() throws IllegalStateException {
        throw new IllegalStateException("Clase de utilieria");
    }

    public static String repeat (String str, int times) {

        if (times < 0) {
            throw new IllegalArgumentException("negative times not allowed");
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < times; i++) {
            result.append(str);
        }

        return result.toString();
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}
