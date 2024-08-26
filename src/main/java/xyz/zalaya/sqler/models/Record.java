package xyz.zalaya.sqler.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Record {

    private final Column column;
    private final Row row;
    private final String value;

    public Record(Column column, Row row, String value) {
        this.column = column;
        this.row = row;
        this.value = value;
    }

    public Record(Column column, String value) {
        this(column, null, value);
    }

    public Record(Row row, String value) {
        this(null, row, value);
    }

    public Record(String value) {
        this(null, null, value);
    }

}
