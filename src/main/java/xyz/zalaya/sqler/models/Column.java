package xyz.zalaya.sqler.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Column {

    private final String name;

    public Column(String name) {
        this.name = name;
    }

}
