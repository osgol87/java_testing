package org.osgol.javatests.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringUtilTest {

    @Test
    public void repeat_string_once() {
        Assert.assertEquals("hola", StringUtil.repeat("hola", 1));
    }

    @Test
    public void repeat_string_multiple_times() {
        Assert.assertEquals("holaholahola", StringUtil.repeat("hola", 3));
    }

    @Test
    public void repeat_string_zero_times() {
        Assert.assertEquals("", StringUtil.repeat("hola", 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void repeat_string_negative_times() {
        StringUtil.repeat("hola", -1);
    }

    @Test
    public void isEmpty_string_not_empty() {
        boolean empty = StringUtil.isEmpty("Hola");

        assertFalse(empty);
    }

    @Test
    public void isEmpty_string_empty() {
        boolean empty = StringUtil.isEmpty("");

        assertTrue(empty);
    }

    @Test
    public void isEmpty_string_null() {
        boolean empty = StringUtil.isEmpty(null);

        assertTrue(empty);
    }

    @Test
    public void isEmpty_string_white_spaces() {
        boolean empty = StringUtil.isEmpty("    ");

        assertTrue(empty);
    }
}