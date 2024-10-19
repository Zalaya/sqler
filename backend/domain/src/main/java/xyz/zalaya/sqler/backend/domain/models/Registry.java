package xyz.zalaya.sqler.backend.domain.models;

import xyz.zalaya.sqler.backend.domain.annotations.Entity;
import xyz.zalaya.sqler.backend.domain.enumerators.SqlType;

@Entity
public class Registry {

    private final String value;
    private final SqlType type;

    public Registry(String value, SqlType type) {
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public SqlType getType() {
        return type;
    }

}
