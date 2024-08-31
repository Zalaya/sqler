package core.main.java.domain.model.cell;

import core.main.java.domain.model.cell.vo.CellType;
import core.main.java.domain.model.cell.vo.CellValue;
import shared.main.java.domain.annotation.Entity;

@Entity
public class Cell {

    private final CellValue value;
    private final CellType type;

    public Cell(String value, String type) {
        this.value = new CellValue(value);
        this.type = new CellType(type);
    }

    public Cell(String value) {
        this.value = new CellValue(value);
        this.type = new CellType("None");
    }

    public String getValue() {
        return value.getValue();
    }

    public String getType() {
        return type.getValue();
    }

}
