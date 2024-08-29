package xyz.zalaya.domain.exception;

public class InvalidColumnNameException extends RuntimeException {

    public InvalidColumnNameException(String message) {
        super(message);
    }

    public InvalidColumnNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidColumnNameException(Throwable cause) {
        super(cause);
    }

}
