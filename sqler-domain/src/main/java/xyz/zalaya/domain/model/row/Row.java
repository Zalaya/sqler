package xyz.zalaya.domain.model.row;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import xyz.zalaya.domain.model.entry.Entry;

import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode
@ToString
public class Row {

    private final List<Entry> entries;

    public Row(List<Entry> entries) {
        this.entries = entries;
    }

    public Row() {
        this.entries = new ArrayList<>();
    }

    public void addEntry(Entry entry) {
        entries.add(entry);
    }

}
