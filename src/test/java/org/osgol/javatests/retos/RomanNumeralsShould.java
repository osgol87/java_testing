package org.osgol.javatests.retos;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanNumeralsShould {

    /**
     * Convierte un número entero a número romano
     */
    @Test
    public void convert_arabic_number_to_roman() {
        assertEquals("II", RomanNumerals.arabicToRoman(2));
    }
}