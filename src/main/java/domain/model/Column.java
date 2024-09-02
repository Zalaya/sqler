package domain.model;

import domain.annotation.Entity;
import domain.vo.ColumnName;

import java.util.List;

@Entity
public class Column {

    private final ColumnName name;
    private final List<String> values;

    public Column(String name, List<String> values) {
        this.name = ColumnName.of(name);
        this.values = values;
    }

    public String getName() {
        return name.getValue();
    }

    public List<String> getValues() {
        return values;
    }

}
