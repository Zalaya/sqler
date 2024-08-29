package xyz.zalaya.domain.model.entry;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import xyz.zalaya.domain.exception.InvalidEntryValueException;

@Getter
@EqualsAndHashCode
@ToString
public class EntryValue {

    private final String value;

    public EntryValue(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new InvalidEntryValueException("Entry value cannot be null or empty");
        }

        this.value = value;
    }

}
