package xyz.zalaya.sqler.backend.domain.models;

/**
 * Represents a registry in a table.
 * It is contained in a {@link Row} or a {@link Column}.
 */
public class Registry {

    private final String value;

    public Registry(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
