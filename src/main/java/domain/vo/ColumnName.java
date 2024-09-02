package domain.vo;

import domain.annotation.ValueObject;

@ValueObject
public class ColumnName extends StringValueObject {

    public ColumnName(String value) {
        super(value);
    }

    public static ColumnName of(String value) {
        return new ColumnName(value);
    }

    public static ColumnName empty() {
        return new ColumnName("");
    }

}
