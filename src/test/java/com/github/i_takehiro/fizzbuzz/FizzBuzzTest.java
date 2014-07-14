package com.github.i_takehiro.fizzbuzz;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class FizzBuzzTest {

    @RunWith(Theories.class)
    public static class When_input_is_greater_than_0 {

        @DataPoints
        public static Fixture[] getFixtures() {
            final List<Fixture> fixtures = new ArrayList<>();
            fixtures.add(new Fixture(1, "1"));
            fixtures.add(new Fixture(3, "Fizz"));
            fixtures.add(new Fixture(4, "4"));
            fixtures.add(new Fixture(5, "Buzz"));
            fixtures.add(new Fixture(6, "Fizz"));
            fixtures.add(new Fixture(10, "Buzz"));
            fixtures.add(new Fixture(11, "11"));
            fixtures.add(new Fixture(15, "FizzBuzz"));
            return fixtures.toArray(new Fixture[fixtures.size()]);
        }

        private FizzBuzz sut;
        private String expected;
        private String actual;

        @Before
        public void setUp() {
            sut = new FizzBuzz();
        }

        @Theory
        public void say_fizzbuzz(final Fixture fixture) {
            expected = fixture.expected;
            actual = sut.say(fixture.input);
            assertThat(fixture.toString(), actual, is(expected));
        }

        static class Fixture {
            int input;
            String expected;

            Fixture(final int input, final String expected) {
                this.input = input;
                this.expected = expected;
            }

            @Override
            public String toString() {
                return "input=" + this.input + ",expected=" + this.expected;
            }
        }
    }

    public static class When_input_is_less_than_or_equal_to_0 {

        @Rule
        public ExpectedException thrown = ExpectedException.none();

        private FizzBuzz sut;

        @Before
        public void setUp() {
            sut = new FizzBuzz();
        }

        @Test
        public void thrown_exception_when_input_is_0() throws Exception {
            thrown.expect(IllegalArgumentException.class);
            thrown.expectMessage(is("input must be greater than 0.(input=0)"));
            sut.say(0);
        }
    }
}
