package org.osgol.javatests.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DateUtilLeapYearShould {

    /**
     * All years divisible by 400 ARE leap years (1600, 2000, 2400)
     */
    @Test
    public void return_true_when_year_is_divisible_by_400() {

        assertTrue(DateUtil.isLeapYear(1600));
        assertTrue(DateUtil.isLeapYear(2000));
        assertTrue(DateUtil.isLeapYear(2400));
    }

    /**
     * All years divisible by 100 but not by 400 are NOT leap years (1700, 1800, 1900)
     */
    @Test
    public void return_false_when_year_is_divisible_by_100_but_not_by_400() {

        assertFalse(DateUtil.isLeapYear(1700));
        assertFalse(DateUtil.isLeapYear(1800));
        assertFalse(DateUtil.isLeapYear(1900));
    }

    /**
     * All years divisible by 4 but not by 100 ARE leap years (1996, 2004, 2008)
     */
    @Test
    public void return_true_when_year_is_divisible_by_4_but_not_by_100() {
        assertTrue(DateUtil.isLeapYear(1996));
        assertTrue(DateUtil.isLeapYear(2004));
        assertTrue(DateUtil.isLeapYear(2008));
    }

    /**
     * All years not divisible by 4 are NOT leap years (2017, 2018, 2019)
     */
    @Test
    public void return_false_when_year_is_not_divisible_by_4() {

        assertFalse(DateUtil.isLeapYear(2017));
        assertFalse(DateUtil.isLeapYear(2018));
        assertFalse(DateUtil.isLeapYear(2019));
    }
}