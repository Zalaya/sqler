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

    public Column(String name, List<String> values) {
        this.name = ColumnName.of(name);
        this.type = ColumnType.empty();
        this.values = values;
    }

    public Column(String name) {
        this.name = ColumnName.of(name);
        this.type = ColumnType.empty();
        this.values = new ArrayList<>();
    }

    public ColumnName getName() {
        return name;
    }

    public ColumnType getType() {
        return type;
    }

    public List<String> getValues() {
        return values;
    }

    public void addValue(String value) {
        values.add(value);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Column name: ").append(name).append("\n");
        values.forEach(value -> builder.append(value).append("\n"));

        return builder.toString();
    }

}
