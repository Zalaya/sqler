package xyz.zalaya.domain.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Table {

    private final String name;
    private final List<Column> columns;

    public Table(String name, List<Column> columns) {
        this.name = name;
        this.columns = columns;
    }

    public Table(String name) {
        this.name = name;
        this.columns = new ArrayList<>();
    }

    public Table(List<Column> columns) {
        this.name = null;
        this.columns = columns;
    }

}
