package xyz.zalaya.sqler.backend.domain.models;

import java.util.List;

public class Row {

    private final List<Registry> registries;

    public Row(List<Registry> registries) {
        this.registries = registries;
    }

    public List<Registry> getRegistries() {
        return registries;
    }

}
