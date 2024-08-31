package core.main.java.domain.model;

import shared.main.java.domain.annotation.Entity;

@Entity
public class Column {

    private final ColumnName name;

    public Column(String name) {
        this.name = new ColumnName(name);
    }

    public String getName() {
        return name.getValue();
    }

}
