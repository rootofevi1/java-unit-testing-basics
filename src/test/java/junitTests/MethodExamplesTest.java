package junitTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.MethodExamples;

import static org.junit.jupiter.api.Assertions.*;

public class MethodExamplesTest {

    @Test
    @DisplayName("Checking the factorial calculation")
    void factorialTests() {

        assertAll("Verification of the method factorial",

                () -> Assertions.assertEquals(
                        1.0,
                        MethodExamples.factorial(0),
                        "0! = 1 (minimum value)"),

                () -> Assertions.assertEquals(
                        1.0,
                        MethodExamples.factorial(1),
                        "1! = 1 (first value with cycle)"),

                () -> Assertions.assertEquals(
                        120.0,
                        MethodExamples.factorial(5),
                        "5! = 120 (typical value)"),

                () -> assertThrows(
                        IllegalArgumentException.class,
                        () -> MethodExamples.factorial(-5),
                        "The factorial of a negative number must be IllegalArgumentException")
        );
    }

    @Test
    @DisplayName("Checking the definition of a prime number")
    void isPrimeTests() {

        assertAll("Checking prime and composite numbers",

                () -> Assertions.assertTrue(
                        MethodExamples.isPrime(2),
                        "2 - prime number (boundary value)"),

                () -> Assertions.assertFalse(
                        MethodExamples.isPrime(4),
                        "4 - composite number"),

                () -> Assertions.assertFalse(
                        MethodExamples.isPrime(1),
                        "1 - neither prime nor composite"),

                () -> Assertions.assertFalse(
                        MethodExamples.isPrime(-5),
                        "Negative numbers are not prime")
        );
    }

    @Test
    @DisplayName("Checking the definition of a perfect number")
    void isPerfectTests() {

        assertAll("Checking perfect numbers",

                () -> Assertions.assertTrue(
                        MethodExamples.isPerfect(6),
                        "6 - perfect number (1+2+3=6)"),

                () -> Assertions.assertFalse(
                        MethodExamples.isPerfect(12),
                        "12 - imperfect number"),

                () -> Assertions.assertFalse(
                        MethodExamples.isPerfect(1),
                        "1 - imperfect number (borderline value)"),

                () -> Assertions.assertFalse(
                        MethodExamples.isPerfect(0),
                        "0 - imperfect number (borderline value)"),

                () -> Assertions.assertFalse(
                        MethodExamples.isPerfect(-1),
                        "Negative numbers are not perfect.")

        );
    }

    @Test
    @DisplayName("Counting the number of occurrences of a digit in a number")
    void digitCountInNumberTests() {

        assertAll("Verification of the method digitCountInNumber",

                () -> Assertions.assertEquals(
                        2,
                        MethodExamples.digitCountInNumber(12321, 2),
                        "The number 12321 must contain two digits 2"),

                () -> Assertions.assertEquals(
                        0,
                        MethodExamples.digitCountInNumber(12345, 9),
                        "The number 12345 should not contain the number 9."),

                () -> Assertions.assertEquals(
                        1,
                        MethodExamples.digitCountInNumber(7, 7),
                        "The number 7 must contain one digit 7"),

                () -> Assertions.assertEquals(
                        1,
                        MethodExamples.digitCountInNumber(101, 0),
                        "The number 101 must contain one digit 0."),

                () -> Assertions.assertEquals(
                        3,
                        MethodExamples.digitCountInNumber(-555, 5),
                        "The number -555 must contain three digits 5"),

                () -> Assertions.assertEquals(
                        1,
                        MethodExamples.digitCountInNumber(0, 0),
                        "The number 0 must contain one digit 0"),

                () -> Assertions.assertEquals(
                        0,
                        MethodExamples.digitCountInNumber(0, 5),
                        "The number 0 should not contain the digit 5."),

                () -> assertThrows(
                        IllegalArgumentException.class,
                        () -> MethodExamples.digitCountInNumber(12345, 10),
                        "The value m must be a number from 0 to 9"),

                () -> assertThrows(
                        IllegalArgumentException.class,
                        () -> MethodExamples.digitCountInNumber(12345, -1),
                        "A negative value of m should cause IllegalArgumentException")
        );
    }
}
