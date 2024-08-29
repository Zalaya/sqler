package xyz.zalaya.domain.model.table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import xyz.zalaya.domain.model.common.Name;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TableName extends Name {

    public TableName(String name) {
        super(name);
    }

}
