package org.osgol.javatests.retos;

import java.util.TreeMap;

public class RomanNumerals {

    private RomanNumerals() throws IllegalStateException {
        throw new IllegalStateException("Clase de utilieria");
    }

    /**
     * Convierte un número entero a número romano
     */
    public static String arabicToRoman(int number) {

        // Almacena los valores romanos y sus equivalentes enteros
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        StringBuilder roman = new StringBuilder();
        while (number > 0) {
            int highest = map.floorKey(number);
            roman.append(map.get(highest));
            number -= highest;
        }
        return roman.toString();
    }
}
