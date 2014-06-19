package com.github.i_takehiro.fizzbuzz;

public class FizzBuzz {

    public String say(final int input) {
        if (input <= 0) {
            throw new IllegalArgumentException(
                    "input must be greater than 0.(input=" + input + ")");
        }

        final boolean divisibleBy3 = (input % 3 == 0);
        final boolean divisibleBy5 = (input % 5 == 0);

        if (divisibleBy3 && divisibleBy5) {
            return "FizzBuzz";
        }
        if (divisibleBy3) {
            return "Fizz";
        }
        if (divisibleBy5) {
            return "Buzz";
        }
        return Integer.toString(input);
    }
}
