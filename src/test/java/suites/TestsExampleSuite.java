package suites;

import junitTests.TestsExampleJunit;
import org.junit.jupiter.api.DisplayName;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@DisplayName("Checking the order of test execution and handling of user exceptions")
@SelectClasses({
        TestsExampleJunit.class
})
public class TestsExampleSuite {
}
