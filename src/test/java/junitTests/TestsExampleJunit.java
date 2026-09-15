package junitTests;

import exceptions.TestDataValidationException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestsExampleJunit {

    @BeforeAll
    static void beforeAllTests() {
        System.out.println("Now the automated tests will be run in the correct order");
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("Thank you for your attention!");
    }

    @Test
    @Order(3)
    @DisplayName("The third test should be performed last, we check that the number is > 0")
    void is1shouldBeThird() {

        System.out.println("Hi I am third test");
        System.out.println("Here is my assertion");

        assertTrue(
                145 > 0,
                "145 должно быть больше 0"
        );

        System.out.println("Now I will perish");
        System.out.println("Bye");
    }

    @Test
    @Order(1)
    @DisplayName("The first test should be run first, checking that the number is > 5")
    void is2shouldBeFirst() {

        System.out.println("Hi I am first test");
        System.out.println("Here is my assertion");

        assertTrue(
                6 > 5,
                "6 должно быть больше 5"
        );

        System.out.println("Now I will perish");
        System.out.println("Bye");
    }

    @Test
    @Order(2)
    @DisplayName("The second test should be executed second, we check false")
    void is3shouldBeSecond() {

        System.out.println("Hi I am second test");
        System.out.println("Here is my assertion");

        assertFalse(
                false,
                "false"
        );

        System.out.println("Now I will perish");
        System.out.println("Bye");
    }

    @ParameterizedTest
    @ValueSource(ints = {4})
    @DisplayName("Converting a Validation Error to a Custom Exception")
    void shouldThrowCustomExceptionWhenValueIsInvalid(int value) {

        TestDataValidationException exception =
                assertThrows(TestDataValidationException.class, () -> {

                    try {

                        assertTrue(
                                value > 5,
                                "The number must be greater than 5"
                        );

                    } catch (AssertionError error) {

                        System.out.println("AssertionError intercepted");
                        System.out.println("Error message:");
                        System.out.println(error.getMessage());
                        System.out.println("Tracing the original error");
                        error.printStackTrace();

                        throw new TestDataValidationException(
                                "Value passed " + value +
                                        ". A number greater than 5 was expected.",
                                error
                        );
                    }
                });

        assertNotNull(exception.getCause());
    }

    @ParameterizedTest
    @ValueSource(ints = {6, 10})
    @DisplayName("Correct values are checked")
    void shouldPassValidationForValidValues(int value) {

        assertDoesNotThrow(() ->
                assertTrue(value > 5)
        );
    }
}
