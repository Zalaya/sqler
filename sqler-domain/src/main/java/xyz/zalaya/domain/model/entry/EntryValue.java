package xyz.zalaya.domain.model.entry;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import xyz.zalaya.domain.model.common.Value;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class EntryValue extends Value {

    public EntryValue(String value) {
        super(value);
    }

}
