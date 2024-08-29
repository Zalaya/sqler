package xyz.zalaya.domain.model.column;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import xyz.zalaya.domain.model.common.Type;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ColumnType extends Type {

    public ColumnType(String type) {
        super(type);
    }

}
