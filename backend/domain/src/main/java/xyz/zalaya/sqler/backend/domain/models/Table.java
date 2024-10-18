package xyz.zalaya.sqler.backend.domain.models;

import java.util.ArrayList;
import java.util.List;

public class Table {

    private final String name;
    private final List<Column> columns;
    private final List<Row> rows;

    public Table(String name, List<Column> columns, List<Row> rows) {
        this.name = name;
        this.columns = columns;
        this.rows = rows;
    }

    public Table(String name) {
        this.name = name;
        this.columns = new ArrayList<>();
        this.rows = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public List<Row> getRows() {
        return rows;
    }

}
