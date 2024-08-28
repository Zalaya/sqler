package domain.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Row {

    private final List<Entry> entries;

    public Row(List<Entry> entries) {
        this.entries = entries;
    }

    public Row() {
        this(new ArrayList<>());
    }

    public void addEntry(Entry entry) {
        entries.add(entry);
    }

}
