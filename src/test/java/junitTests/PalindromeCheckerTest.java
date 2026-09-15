package junitTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import utils.PalindromeChecker;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PalindromeCheckerTest {

    @ParameterizedTest
    @MethodSource("palindromeData")
    @DisplayName("Checking the definition of palindromes")
    void palindromeTests(String text, boolean expectedResult) {

        assertEquals(
                expectedResult,
                PalindromeChecker.isPalindrome(text),
                "Incorrect result for line: " + text
        );
    }

    static Stream<Arguments> palindromeData() {

        return Stream.of(

                // === ПОЛОЖИТЕЛЬНЫЕ ТЕСТЫ (палиндромы)===
                Arguments.of("madam", true), // Обычный палиндром
                Arguments.of("Anna", true), // Палиндром с разным регистром
                Arguments.of("abc cba", true), // Палиндром с пробелами
                Arguments.of("A man a plan a canal Panama", true), // Палиндром с пробелами и разным регистром
                Arguments.of("a", true), // Одиночный символ
                Arguments.of("@", true), // Одиночный спецсимвол
                Arguments.of("!!!", true), // Спецсимволы
                Arguments.of("123321", true), // Числовой палиндром
                Arguments.of("  madam", true), // Пробелы в начале
                Arguments.of("madam  ", true), // Пробелы в конце
                Arguments.of("  madam  ", true), // Пробелы в начале и конце
                Arguments.of("  Anna", true), // Пробелы в начале с регистром
                Arguments.of("  abc cba  ", true), // Пробелы в начале и конце с пробелами внутри

                // === ГРАНИЧНЫЕ ЗНАЧЕНИЯ (палиндромы) ===
                Arguments.of("", true),
                Arguments.of("  ", true),

                // === ОТРИЦАТЕЛЬНЫЕ ТЕСТЫ (непалиндром) ===
                Arguments.of("hello", false),

                // ГРАНИЧНЫЕ ЗНАЧЕНИЯ (непалиндром)
                Arguments.of(null, false)
        );
    }
}
