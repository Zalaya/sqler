package core.main.java.domain.model;

import core.main.java.domain.model.vo.TableName;
import shared.main.java.domain.annotation.AggregateRoot;
import shared.main.java.domain.annotation.Entity;

import java.util.ArrayList;
import java.util.List;

@Entity
@AggregateRoot
public class Table {

    private final TableName name;
    private final List<Column> columnList;
    private final List<Row> rowList;

    public Table(String name, List<Column> columnList, List<Row> rowList) {
        this.name = new TableName(name);
        this.columnList = columnList;
        this.rowList = rowList;
    }

    public Table(String name) {
        this.name = new TableName(name);
        this.columnList = new ArrayList<>();
        this.rowList = new ArrayList<>();
    }

    public String getName() {
        return name.getValue();
    }

    public List<Column> getColumnList() {
        return columnList;
    }

    public List<Row> getRowList() {
        return rowList;
    }

}
