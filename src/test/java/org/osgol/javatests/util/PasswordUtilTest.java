package org.osgol.javatests.util;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.osgol.javatests.util.PasswordUtil.*;

public class PasswordUtilTest {

    @Test
    public void weak_when_has_less_than_8_letters() {
        assertEquals(SecurityLevel.WEAK, assessPassword("1234567"));
    }

    @Test
    public void weak_when_has_only_letters() {
        assertEquals(SecurityLevel.WEAK, assessPassword("123aa!"));
    }

    @Test
    public void medium_when_has_letters_and_numbers() {
        assertEquals(SecurityLevel.MEDIUM, assessPassword("abcd1234"));
    }

    @Test
    public void strong_when_has_letters_numbers_and_symbols() {
        assertEquals(SecurityLevel.STRONG, assessPassword("abcd123!"));
    }
}