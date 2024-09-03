package domain.vo;

import domain.annotation.ValueObject;

import java.util.Objects;

@ValueObject
public abstract class StringValueObject {

    private final String value;

    public StringValueObject(String value) {
        this.value = value;
    }

    public boolean isEmpty() {
        return value.isEmpty();
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof StringValueObject)) return false;

        return Objects.equals(value, ((StringValueObject) other).value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(value).append("\n");

        return builder.toString();
    }

}
