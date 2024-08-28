package domain.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Column {

    private final String name;
    private final List<Entry> entries;

    public Column(String name, List<Entry> entries) {
        this.name = name;
        this.entries = entries;
    }

    public Column(String name) {
        this(name, new ArrayList<>());
    }

    public void addEntry(Entry entry) {
        entries.add(entry);
    }

}
