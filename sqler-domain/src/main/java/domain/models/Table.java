package domain.models;

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
    private final List<Row> rows;

    public Table(String name, List<Column> columns, List<Row> rows) {
        this.name = name;
        this.columns = columns;
        this.rows = rows;
    }

    public Table(String name) {
        this(name, new ArrayList<>(), new ArrayList<>());
    }

    public void addColumn(Column column) {
        columns.add(column);
    }

    public void addRow(Row row) {
        rows.add(row);
    }

}
