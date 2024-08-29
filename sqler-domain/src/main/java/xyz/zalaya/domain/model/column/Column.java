package xyz.zalaya.domain.model.column;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import xyz.zalaya.domain.model.entry.Entry;

import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode
@ToString
public class Column {

    private final ColumnName name;
    private final ColumnType type;
    private final List<Entry> entries;

    public Column(ColumnName name, ColumnType type, List<Entry> entries) {
        this.name = name;
        this.type = type;
        this.entries = entries;
    }

    public Column(ColumnName name, ColumnType type) {
        this.name = name;
        this.type = type;
        this.entries = new ArrayList<>();
    }

    public Column(ColumnName name) {
        this.name = name;
        this.type = null;
        this.entries = new ArrayList<>();
    }

    public void addEntry(Entry entry) {
        entries.add(entry);
    }

}
