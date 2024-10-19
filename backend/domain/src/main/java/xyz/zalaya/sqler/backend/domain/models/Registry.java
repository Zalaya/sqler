package xyz.zalaya.sqler.backend.domain.models;

import xyz.zalaya.sqler.backend.domain.enumerators.SqlType;

/**
 * Represents a registry in a table.
 * It is contained in a {@link Row} or a {@link Column}.
 */
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
