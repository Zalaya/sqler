package shared.main.java.domain.exception;

public class InvalidStringValueException extends RuntimeException {

    public InvalidStringValueException(String value) {
        super(String.format("The value <%s> is not a valid string", value));
    }

}
