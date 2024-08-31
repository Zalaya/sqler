package core.main.java.domain.model;

import shared.main.java.domain.annotation.ValueObject;
import shared.main.java.domain.model.StringValueObject;

@ValueObject
public class ColumnName extends StringValueObject {

    public ColumnName(String value) {
        super(value);
    }

}
