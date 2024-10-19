package xyz.zalaya.sqler.backend.domain.models;

import xyz.zalaya.sqler.backend.domain.enumerators.SqlType;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a column in a table.
 * It is contained in a {@link Table}.
 */
public class Column {

    private final String name;
    private final SqlType type;
    private final List<Registry> registries;

    public Column(String name, SqlType type) {
        this.name = name;
        this.type = type;
        this.registries = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public SqlType getType() {
        return type;
    }

    public List<Registry> getRegistries() {
        return registries;
    }

    public void addRegistry(Registry registry) {
        registries.add(registry);
    }

}
