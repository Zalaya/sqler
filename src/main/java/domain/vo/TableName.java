package domain.vo;

import domain.annotation.ValueObject;

@ValueObject
public class TableName extends StringValueObject {

    public TableName(String value) {
        super(value);
    }

    public static TableName of(String value) {
        return new TableName(value);
    }

    public static TableName empty() {
        return new TableName("");
    }

}
