package xyz.zalaya.sqler.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Row {

    private final List<Record> records;

    public Row(List<Record> records) {
        this.records = records;
    }

}
