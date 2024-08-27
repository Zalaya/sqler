package xyz.zalaya.sqler.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Row {

    private final Column column;
    private final List<Record> records;

    public Row(Column column, List<Record> records) {
        this.column = column;
        this.records = records;
    }

}
