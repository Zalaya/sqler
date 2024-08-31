package core.main.java.domain.model;

import shared.main.java.domain.annotation.ValueObject;
import shared.main.java.domain.model.StringValueObject;

@ValueObject
public class TableName extends StringValueObject {

    public TableName(String value) {
        super(value);
    }

}
