package xyz.zalaya.sqler.backend.domain.models;

import java.util.List;

public class Column {

    private final String name;
    private final List<Registry> registries;

    public Column(String name, List<Registry> registries) {
        this.name = name;
        this.registries = registries;
    }

    public String getName() {
        return name;
    }

    public List<Registry> getRegistries() {
        return registries;
    }

}
