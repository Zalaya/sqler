package core.main.java.domain.model;

import shared.main.java.domain.annotation.Entity;

import java.util.List;

@Entity
public class Row {

    private final List<Cell> cellList;

    public Row(List<Cell> cellList) {
        this.cellList = cellList;
    }

    public List<Cell> getCellList() {
        return cellList;
    }

}
