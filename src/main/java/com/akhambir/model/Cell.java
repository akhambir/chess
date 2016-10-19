package com.akhambir.model;

import static com.akhambir.util.Validator.isEvenRowAndEvenColumn;
import static com.akhambir.util.Validator.isOddRowAndOddColumn;

public class Cell {
    private Figure figure;
    private int row;
    private char column;

    public Cell(int row, char column) {
        this.row = row;
        this.column = column;
    }

    public boolean isWhite(Cell cell) { // TODO I think it's can be implemented much stylishly (easier)
        return !isOddRowAndOddColumn(cell) && !isEvenRowAndEvenColumn(cell);
    }

    public boolean isBlack(Cell cell) {
        return isOddRowAndOddColumn(cell) || isEvenRowAndEvenColumn(cell);
    }

    public Figure getFigure() {
        return figure;
    }

    public int getRow() {
        return row;
    }

    public char getColumn() {
        return column;
    }

    public static Cell of(int row, char column) {
        return new Cell(row, column);
    }
}
