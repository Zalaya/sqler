package domain.model;

import domain.annotation.AggregateRoot;
import domain.annotation.Entity;
import domain.vo.TableName;

import java.util.ArrayList;
import java.util.List;

@Entity
@AggregateRoot
public class Table {

    private final TableName name;
    private final List<Column> columns;
    private final List<Row> rows;

    public Table(String name, List<Column> columns, List<Row> rows) {
        this.name = TableName.of(name);
        this.columns = columns;
        this.rows = rows;
    }

    public Table(String name) {
        this.name = TableName.of(name);
        this.columns = new ArrayList<>();
        this.rows = new ArrayList<>();
    }

    public String getName() {
        return name.getValue();
    }

    public List<Column> getColumns() {
        return columns;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void addColumn(Column column) {
        columns.add(column);
    }

    public void addRow(Row row) {
        rows.add(row);
    }

}
