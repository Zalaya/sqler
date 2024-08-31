package shared.main.java.domain.model;

import java.util.Objects;

public abstract class StringValueObject {

    private final String value;

    protected StringValueObject(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty");
        }

        this.value = value;
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

}
