package testNGTests;

import org.testng.annotations.*;
import static org.testng.Assert.assertTrue;
public class TestsExampleTestNG {

    @BeforeClass
    public void beforeAllTests() {
        System.out.println("Now the automated tests will run in the correct order");
    }

    @AfterClass
    public void afterAllTests() {
        System.out.println("Thank you for your attention!");
    }

    @Test(priority = 3)
    public void is1shouldBeThird() {
        //Метод должен быть вызван третьим
        System.out.println("Hi I am third test");
        System.out.println("Here is my assertion");
        assertTrue(145 > 0, "145 must be greater than 0");
        System.out.println("Now I will perish");
        System.out.println("Bye");
    }

    @Test(priority = 1)
    public void is2shouldBeFirst() {
        //Метод должен быть вызван первым
        System.out.println("Hi I am first test");
        System.out.println("Here is my assertion");
        assertTrue(6 > 5, "6 must be greater than 5");
        System.out.println("Now I will perish");
        System.out.println("Bye");
    }

    @Test(priority = 2)
    public void is3shouldBeSecond() {
        //Метод должен быть вызван вторым
        System.out.println("Hi I am second test");
        System.out.println("Here is my assertion");
        assertTrue(true, "This statement is always true.");
        System.out.println("Now I will perish");
        System.out.println("Bye");
    }
}
