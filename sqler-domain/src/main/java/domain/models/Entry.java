package domain.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Entry {

    private final Column column;
    private final String value;

    public Entry(Column column, String value) {
        this.column = column;
        this.value = value;
    }

}
