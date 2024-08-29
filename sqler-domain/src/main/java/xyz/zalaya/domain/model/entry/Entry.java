package xyz.zalaya.domain.model.entry;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Entry {

    private final EntryType type;
    private final EntryValue value;

    public Entry(EntryType type, EntryValue value) {
        this.type = type;
        this.value = value;
    }

    public Entry(EntryValue value) {
        this.type = null;
        this.value = value;
    }

}
