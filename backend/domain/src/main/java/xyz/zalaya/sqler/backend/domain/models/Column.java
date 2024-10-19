package xyz.zalaya.sqler.backend.domain.models;

import xyz.zalaya.sqler.backend.domain.annotations.Entity;
import xyz.zalaya.sqler.backend.domain.enumerators.SQLType;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Column {

    private final String name;
    private final SQLType type;
    private final List<Registry> registries;

    public Column(String name, SQLType type) {
        this.name = name;
        this.type = type;
        this.registries = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public SQLType getType() {
        return type;
    }

    public List<Registry> getRegistries() {
        return registries;
    }

    public void addRegistry(Registry registry) {
        registries.add(registry);
    }

}
