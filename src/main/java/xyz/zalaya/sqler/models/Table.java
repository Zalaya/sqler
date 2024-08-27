package xyz.zalaya.sqler.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Table {

    private final String name;
    private final List<Column> columns;
    private final List<Row> records;

    public Table(String name, List<Column> columns, List<Row> records) {
        this.name = name;
        this.columns = columns;
        this.records = records;
    }

    public Table(String name) {
        this(name, new ArrayList<>(), new ArrayList<>());
    }

}
