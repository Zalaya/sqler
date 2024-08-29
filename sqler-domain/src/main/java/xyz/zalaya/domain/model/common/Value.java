package xyz.zalaya.domain.model.common;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import xyz.zalaya.domain.exception.InvalidEntryValueException;

@Getter
@EqualsAndHashCode
@ToString
public class Value {

    private final String value;

    public Value(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new InvalidEntryValueException("Entry value cannot be null or empty");
        }

        this.value = value;
    }

}
