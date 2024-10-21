package xyz.zalaya.sqler.backend.domain.models;

import xyz.zalaya.sqler.backend.domain.annotations.Entity;
import xyz.zalaya.sqler.backend.domain.enumerators.SQLType;

@Entity
public class Registry {

    private final SQLType type;
    private final String value;

    public Registry(SQLType type, String value) {
        this.type = type;
        this.value = value;
    }

    public SQLType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

}
