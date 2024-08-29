package xyz.zalaya.domain.model.entry;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import xyz.zalaya.domain.model.common.Type;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class EntryType extends Type {

    public EntryType(String type) {
        super(type);
    }

}
