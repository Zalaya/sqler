package xyz.zalaya.domain.model.column;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import xyz.zalaya.domain.model.common.type.SqlType;
import xyz.zalaya.domain.model.entry.Entry;

import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode
@ToString
public class Column {

    private final ColumnName name;
    private final SqlType type;
    private final List<Entry> entries;

    public Column(ColumnName name, SqlType type, List<Entry> entries) {
        this.name = name;
        this.type = type;
        this.entries = entries;
    }

    public Column(ColumnName name, SqlType type) {
        this.name = name;
        this.type = type;
        this.entries = new ArrayList<>();
    }

    public Column(ColumnName name, List<Entry> entries) {
        this.name = name;
        this.type = SqlType.fromEntries(entries);
        this.entries = new ArrayList<>();
    }

    public void addEntry(Entry entry) {
        entries.add(entry);
    }

}
