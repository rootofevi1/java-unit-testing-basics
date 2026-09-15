package exceptions;

public class TestDataValidationException extends RuntimeException {

    public TestDataValidationException(String message) {
        super(message);
    }

    public TestDataValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
