package domain.vo;

import domain.annotation.ValueObject;

@ValueObject
public class ColumnType extends StringValueObject {

    public ColumnType(String value) {
        super(value);
    }

    public static ColumnType of(String value) {
        return new ColumnType(value);
    }

    public static ColumnType empty() {
        return new ColumnType("");
    }

}
