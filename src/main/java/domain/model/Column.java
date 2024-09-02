package domain.model;

import domain.annotation.Entity;
import domain.vo.ColumnName;
import domain.vo.ColumnType;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Column {

    private final ColumnName name;
    private final ColumnType type;
    private final List<String> values;

    public Column(String name, String type, List<String> values) {
        this.name = ColumnName.of(name);
        this.type = ColumnType.of(type);
        this.values = values;
    }

    public Column(String name) {
        this.name = ColumnName.of(name);
        this.type = ColumnType.empty();
        this.values = new ArrayList<>();
    }

    public String getName() {
        return name.getValue();
    }

    public String getType() {
        return type.getValue();
    }

    public List<String> getValues() {
        return values;
    }

    public void addValue(String value) {
        values.add(value);
    }

}
