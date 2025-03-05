package org.osgol.javatests.retos;

import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzShould {

    /**
     * Si el número es divisible por 3, devuelve Fizz
     */
    @Test
    public void return_fizz_when_number_is_divisible_by_3() {

        assertEquals("Fizz", FizzBuzz.fizzBuzz(3));
        assertEquals("Fizz", FizzBuzz.fizzBuzz(6));
    }

    /**
     * Si el número es divisible por 5, devuelve Buzz
     */
    @Test
    public void return_buzz_when_number_is_divisible_by_5() {

        assertEquals("Buzz", FizzBuzz.fizzBuzz(5));
        assertEquals("Buzz", FizzBuzz.fizzBuzz(10));
    }

    /**
     * Si el número es divisible por 3 y 5, devuelve el FizzBuzz
     */
    @Test
    public void return_fizzbuzz_when_number_is_divisible_by_3_and_5() {

        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15));
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(30));
    }

    /**
     * Si el número no es divisible por 3 o 5, devuelve el número
     */
    @Test
    public void return_number_when_number_is_not_divisible_by_3_or_5() {

        assertEquals("2", FizzBuzz.fizzBuzz(2));
        assertEquals("16", FizzBuzz.fizzBuzz(16));

    }
}