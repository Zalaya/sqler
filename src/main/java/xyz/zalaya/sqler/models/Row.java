package xyz.zalaya.sqler.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Row {

    private final String name;
    private final List<Record> records;

    public Row(String name, List<Record> records) {
        this.name = name;
        this.records = records;
    }

    public Row(String name) {
        this(name, new ArrayList<>());
    }

}
