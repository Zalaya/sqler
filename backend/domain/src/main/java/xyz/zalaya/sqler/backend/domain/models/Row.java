package xyz.zalaya.sqler.backend.domain.models;

import xyz.zalaya.sqler.backend.domain.annotations.Entity;

import java.util.ArrayList;
import java.util.List;

@Entity
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
