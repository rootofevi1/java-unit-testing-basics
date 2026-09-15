package testNGTests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import validators.PersonValidator;

import static org.testng.Assert.*;

public class PersonValidatorTestNG {

    @DataProvider(name = "validAdultPersonData")
    public Object[][] validAdultPersonData() {
        return new Object[][]{
                {"Maxim 18 years"}, // стандартный валидный
                {"Maxim   19   years"}, // множественные пробелы
                {"         Maxim 18 years"}, // пробелы в начале
                {"Alexander 30 years         "} // пробелы в конце
        };
    }

    @DataProvider(name = "invalidAdultPersonData")
    public Object[][] invalidAdultPersonData() {
        return new Object[][]{
                {"Ann 18 years"},        // Имя <= 3 символов
                {"Maxim 17 years"},      // Возраст меньше 18
                {"Maxim"},               // Недостаточно частей
                {"Maxim years"},         // Недостаточно частей
                {"Maxim abc years"},     // Возраст не число
                {"Maxim 18"},            // Недостаточно частей
                {"   "},                 // Только пробелы
                {"18 years"},            // Нет имени
                {"Maxim18years"},        // Нет пробелов
                {"Anna -1 years"}        // Отрицательный возраст
        };
    }

    @DataProvider(name = "nullAndEmptyData")
    public Object[][] nullAndEmptyData() {
        return new Object[][]{
                {null},
                {""}
        };
    }

    @Test(
            dataProvider = "validAdultPersonData",
            description = "Verification of valid adult users"
    )
    public void validAdultPersonTests(String input) {
        assertTrue(
                PersonValidator.isValidAdultPerson(input),
                "The string must pass validation successfully: " + input
        );
    }

    @Test(
            dataProvider = "invalidAdultPersonData",
            description = "Checking for incorrect user data"
    )
    public void invalidAdultPersonTests(String input) {
        assertFalse(
                PersonValidator.isValidAdultPerson(input),
                "The string should not be validated: " + input
        );
    }

    @Test(
            dataProvider = "nullAndEmptyData",
            description = "Checking for null and empty string"
    )
    public void nullAndEmptyInputTests(String input) {
        assertFalse(
                PersonValidator.isValidAdultPerson(input),
                "Empty input should not be validated."
        );
    }
}
