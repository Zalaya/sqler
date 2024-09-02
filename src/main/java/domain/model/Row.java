package domain.model;

import domain.annotation.Entity;

import java.util.List;

@Entity
public class Row {

    private final List<String> values;

    public Row(List<String> values) {
        this.values = values;
    }

    public List<String> getValues() {
        return values;
    }

    public void addValue(String value) {
        values.add(value);
    }

}
