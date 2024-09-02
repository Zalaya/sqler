package domain.vo;

import domain.annotation.ValueObject;

import java.util.Objects;

@ValueObject
public abstract class StringValueObject {

    private final String value;

    public StringValueObject(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public boolean isEmpty() {
        return value.isEmpty();
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

}
