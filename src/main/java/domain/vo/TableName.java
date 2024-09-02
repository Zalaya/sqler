package domain.vo;

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
