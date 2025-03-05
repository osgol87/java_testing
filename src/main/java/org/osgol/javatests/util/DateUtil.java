package org.osgol.javatests.util;

public class DateUtil {

    private DateUtil() throws IllegalStateException {
        throw new IllegalStateException("Clase de utilieria");
    }

    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }
}
