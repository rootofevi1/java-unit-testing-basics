package suites;

import junitTests.MethodExamplesTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@DisplayName("Test Suite: Testing Example Methods (factorial, prime numbers, perfect numbers, digit counting)")
@SelectClasses({
        MethodExamplesTest.class
})
public class MethodExamplesSuite {
}
