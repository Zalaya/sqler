package xyz.zalaya.sqler.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Record {

    private final Column column;
    private final Comparable<?> value;

    public Record(Column column, Comparable<?> value) {
        this.column = column;
        this.value = value;
    }

}
