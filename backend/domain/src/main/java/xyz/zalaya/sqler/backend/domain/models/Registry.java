package xyz.zalaya.sqler.backend.domain.models;

import xyz.zalaya.sqler.backend.domain.annotations.Entity;
import xyz.zalaya.sqler.backend.domain.enumerators.SqlType;

@Entity
public class Registry {

    private final SqlType type;
    private final String value;

    public Registry(SqlType type, String value) {
        this.type = type;
        this.value = value;
    }

    public SqlType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

}
