package xyz.zalaya.domain.model.column;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import xyz.zalaya.domain.model.common.Name;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ColumnName extends Name {

    public ColumnName(String name) {
        super(name);
    }

}
