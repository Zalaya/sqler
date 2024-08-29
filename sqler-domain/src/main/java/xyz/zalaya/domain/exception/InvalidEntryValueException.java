package xyz.zalaya.domain.exception;

public class InvalidEntryValueException extends RuntimeException {

    public InvalidEntryValueException(String message) {
        super(message);
    }

    public InvalidEntryValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidEntryValueException(Throwable cause) {
        super(cause);
    }

}
