package xyz.zalaya.domain.model.entry;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import xyz.zalaya.domain.model.common.type.SqlType;

@Getter
@EqualsAndHashCode
@ToString
public class Entry {

    private final EntryValue value;
    private final SqlType type;

    public Entry(EntryValue value) {
        this.value = value;
        this.type = SqlType.fromEntryValue(value);
    }

}
