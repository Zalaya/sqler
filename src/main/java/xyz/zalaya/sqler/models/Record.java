package xyz.zalaya.sqler.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Record {

    private final Column column;
    private final String value;

    public Record(Column column, String value) {
        this.column = column;
        this.value = value;
    }

    public Record(String value) {
        this(null, value);
    }

}
