package core.main.java.domain.model;

import core.main.java.domain.model.vo.TableName;
import shared.main.java.domain.annotation.AggregateRoot;
import shared.main.java.domain.annotation.Entity;

@Entity
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
