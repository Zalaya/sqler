package xyz.zalaya.sqler.backend.domain.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a column in a table.
 * It is contained in a {@link Table}.
 */
public class Column {

    private final String name;
    private final List<Registry> registries;

    public Column(String name) {
        this.name = name;
        this.registries = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Registry> getRegistries() {
        return registries;
    }

    public void addRegistry(Registry registry) {
        registries.add(registry);
    }

}
