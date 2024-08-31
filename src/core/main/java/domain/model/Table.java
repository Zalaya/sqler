package core.main.java.domain.model;

import shared.main.java.domain.annotation.AggregateRoot;

@AggregateRoot
public class Table {

    private final TableName name;

    public Table(String name) {
        this.name = new TableName(name);
    }

    public String getName() {
        return name.getValue();
    }

}
