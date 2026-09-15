package testNGTests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;
import utils.MethodExamples;

public class MethodExamplesTestNG {

    @Test(description = "Checking the factorial calculation")
    public void factorialTests() {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(
                MethodExamples.factorial(0),
                1.0,
                "0! = 1 (minimum value)"
        );

        softAssert.assertEquals(
                MethodExamples.factorial(1),
                1.0,
                "1! = 1 (first value with cycle)"
        );

        softAssert.assertEquals(
                MethodExamples.factorial(5),
                120.0,
                "5! = 120 (typical value)"
        );

        IllegalArgumentException exception =
                Assert.expectThrows(
                        IllegalArgumentException.class,
                        () -> MethodExamples.factorial(-5)
                );

        Assert.assertEquals(
                exception.getMessage(),
                "Factorial is undefined for negative numbers",
                "For negative numbers, a proper error message should be thrown."
        );

        softAssert.assertAll();
    }

    @Test(description = "Checking the definition of a prime number")
    public void isPrimeTests() {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(
                MethodExamples.isPrime(2),
                "2 - prime number (boundary value)"
        );

        softAssert.assertFalse(
                MethodExamples.isPrime(4),
                "4 - composite number"
        );

        softAssert.assertFalse(
                MethodExamples.isPrime(1),
                "1 - not a prime and composite number"
        );

        softAssert.assertFalse(
                MethodExamples.isPrime(-5),
                "Negative numbers are not prime"
        );

        softAssert.assertAll();
    }

    @Test(description = "Checking the definition of a perfect number")
    public void isPerfectTests() {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(
                MethodExamples.isPerfect(6),
                "6 - perfect number (1+2+3=6)"
        );

        softAssert.assertFalse(
                MethodExamples.isPerfect(12),
                "12 - imperfect number"
        );

        softAssert.assertFalse(
                MethodExamples.isPerfect(1),
                "1 - imperfect number (boundary value)"
        );

        softAssert.assertFalse(
                MethodExamples.isPerfect(0),
                "0 - imperfect number (boundary value)"
        );

        softAssert.assertFalse(
                MethodExamples.isPerfect(-1),
                "Negative numbers are not perfect."
        );

        softAssert.assertAll();
    }

    @Test(description = "Counting the number of occurrences of a digit in a number")
    public void digitCountInNumberTests() {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(
                MethodExamples.digitCountInNumber(12321, 2),
                2,
                "The number 12321 must contain two digits 2"
        );

        softAssert.assertEquals(
                MethodExamples.digitCountInNumber(12345, 9),
                0,
                "The number 12345 should not contain the number 9."
        );

        softAssert.assertEquals(
                MethodExamples.digitCountInNumber(7, 7),
                1,
                "The number 7 must contain one digit 7"
        );

        softAssert.assertEquals(
                MethodExamples.digitCountInNumber(101, 0),
                1,
                "The number 101 must contain one digit 0."
        );

        softAssert.assertEquals(
                MethodExamples.digitCountInNumber(-555, 5),
                3,
                "The number -555 must contain three digits 5"
        );

        softAssert.assertEquals(
                MethodExamples.digitCountInNumber(0, 0),
                1,
                "The number 0 must contain one digit 0"
        );

        softAssert.assertEquals(
                MethodExamples.digitCountInNumber(0, 5),
                0,
                "The number 0 should not contain the digit 5."
        );

        IllegalArgumentException exceptionForTen =
                Assert.expectThrows(
                        IllegalArgumentException.class,
                        () -> MethodExamples.digitCountInNumber(12345, 10)
                );

        softAssert.assertEquals(
                exceptionForTen.getMessage(),
                "Parameter m must be a digit from 0 to 9",
                "Passing the value 10 should return the expected error message"
        );

        IllegalArgumentException exceptionForNegative =
                Assert.expectThrows(
                        IllegalArgumentException.class,
                        () -> MethodExamples.digitCountInNumber(12345, -1) );

        softAssert.assertEquals(
                exceptionForNegative.getMessage(),
                "Parameter m must be a digit from 0 to 9",
                "Passing a negative value should return the expected error message"
        );

        softAssert.assertAll();
    }
}
