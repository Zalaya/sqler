package xyz.zalaya.sqler.backend.domain.models;

import java.util.List;

/**
 * Represents a row in a table.
 * It is contained in a {@link Table}.
 */
public class Row {

    private final List<Registry> registries;

    public Row(List<Registry> registries) {
        this.registries = registries;
    }

    public List<Registry> getRegistries() {
        return registries;
    }

}
