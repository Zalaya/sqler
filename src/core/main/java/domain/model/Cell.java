package core.main.java.domain.model;

import shared.main.java.domain.annotation.Entity;

@Entity
public class Cell {

    private final CellValue value;
    private final CellType type;

    public Cell(String value, String type) {
        this.value = new CellValue(value);
        this.type = new CellType(type);
    }

    public String getValue() {
        return value.getValue();
    }

    public String getType() {
        return type.getValue();
    }

}
