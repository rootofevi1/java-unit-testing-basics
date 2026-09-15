package testNGTests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.PalindromeChecker;

import static org.testng.Assert.assertEquals;

public class PalindromeCheckerTestNG {

    @DataProvider(name = "palindromeData")
    public Object[][] palindromeData() {
        return new Object[][]{
                // палиндромы
                {"madam", true},
                {"Anna", true},
                {"a", true},
                {"123321", true},
                {"abc cba", true},
                {"A man a plan a canal Panama", true},
                {"", true},
                {"  ", true},
                {"  madam", true},
                {"madam  ", true},
                {"  madam  ", true},
                {"  Anna", true},
                {"  abc cba  ", true},
                // спец. символы
                {"!!!", true},
                {"@", true},
                // не палиндромы
                {"hello", false},
                // null
                {null, false},
        };
    }

    @Test(
            dataProvider = "palindromeData",
            description = "Checking the definition of palindromes"
    )
    public void palindromeTests(String text, boolean expectedResult) {

        assertEquals(
                PalindromeChecker.isPalindrome(text),
                expectedResult,
                "Incorrect result for string: " + text
        );
    }
}
