package domain.vo;

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
