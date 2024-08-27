package xyz.zalaya.sqler.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@ToString
public class Row {

    private final Map<Column, Record> records;

    public Row(Map<Column, Record> records) {
        this.records = records;
    }

}
