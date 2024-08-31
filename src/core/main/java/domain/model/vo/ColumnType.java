package core.main.java.domain.model.vo;

import shared.main.java.domain.annotation.ValueObject;
import shared.main.java.domain.model.StringValueObject;

@ValueObject
public class ColumnType extends StringValueObject {

    public ColumnType(String value) {
        super(value);
    }

}
