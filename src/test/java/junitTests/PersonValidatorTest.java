package junitTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import validators.PersonValidator;

class PersonValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "Maxim 18 years", // стандартный валидный
            "Maxim   19   years", // множественные пробелы
            "         Maxim 18 years", // пробелы в начале
            "Maxim 30 years         " // пробелы в конце
    })
    @DisplayName("Verification of valid adult users")
    void validAdultPersonTests(String input) {

        assertTrue(
                PersonValidator.isValidAdultPerson(input),
                "The string must pass validation successfully: " + input
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Ann 18 years", // имя <= 3 букв
            "Maxim 17 years", // возраст < 18
            "Maxim", // < 3 частей
            "Maxim years", // < 3 частей
            "Maxim abc years", // возраст не число
            "Maxim 18", // < 3 частей
            "   ", // // < 3 частей
            "18 years", // < 3 частей
            "Maxim18years", // < 3 частей
            "Anna -1 years" // отрицательный возраст
    })
    @DisplayName("Checking for incorrect user data")
    void invalidAdultPersonTests(String input) {

        assertFalse(
                PersonValidator.isValidAdultPerson(input),
                "The string should not be validated: " + input
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Checking for null and empty string")
    void nullAndEmptyInputTests(String input) {

        assertFalse(
                PersonValidator.isValidAdultPerson(input),
                "Empty input should not be validated"
        );
    }
}
