package core.main.java.domain.model;

import core.main.java.domain.model.vo.ColumnName;
import core.main.java.domain.model.vo.ColumnType;
import shared.main.java.domain.annotation.Entity;

@Entity
public class Column {

    private final ColumnName name;
    private final ColumnType type;

    public Column(String name, String type) {
        this.name = new ColumnName(name);
        this.type = new ColumnType(type);
    }

    public Column(String name) {
        this.name = new ColumnName(name);
        this.type = new ColumnType("None");
    }

    public String getName() {
        return name.getValue();
    }

    public String getType() {
        return type.getValue();
    }

}
