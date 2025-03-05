package org.osgol.javatests.retos;

public class FizzBuzz {

    private FizzBuzz() throws IllegalAccessException {
        throw new IllegalAccessException("Clase de utilieria");
    }

    public static String fizzBuzz(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "FizzBuzz";
        }

        if (number % 3 == 0) {
            return "Fizz";
        }

        if (number % 5 == 0) {
            return "Buzz";
        }

        return String.valueOf(number);
    }
}
