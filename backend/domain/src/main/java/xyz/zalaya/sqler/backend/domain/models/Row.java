package xyz.zalaya.sqler.backend.domain.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a row in a table.
 * It is contained in a {@link Table}.
 */
public class Row {

    private final List<Registry> registries;

    public Row() {
        this.registries = new ArrayList<>();
    }

    public List<Registry> getRegistries() {
        return registries;
    }

    public void addRegistry(Registry registry) {
        registries.add(registry);
    }

}
