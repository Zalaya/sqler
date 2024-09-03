package domain.model;

import domain.annotation.Entity;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Row {

    private final List<String> values;

    public Row(List<String> values) {
        this.values = values;
    }

    public Row() {
        this.values = new ArrayList<>();
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

        values.forEach(value -> builder.append(value).append("\n"));

        return builder.toString();
    }

}
