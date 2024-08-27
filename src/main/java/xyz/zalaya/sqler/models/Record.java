package xyz.zalaya.sqler.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Record {

    private final Comparable<?> value;

    public Record(Comparable<?> value) {
        this.value = value;
    }

}
