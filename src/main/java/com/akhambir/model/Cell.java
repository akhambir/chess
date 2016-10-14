package com.akhambir.model;

import static com.akhambir.util.Validator.isEvenRowAndEvenColumn;
import static com.akhambir.util.Validator.isOddRowAndOddColumn;

public class Cell {
    private Figure figure;
    private int row;
    private char column;

    public boolean isWhite(Cell cell) { // TODO I think it's can be implemented much stylishly (easier)
        if (isOddRowAndOddColumn(cell)) {
            return false;
        }
        if (isEvenRowAndEvenColumn(cell)) {
            return false;
        }
        return true;
    }

    public boolean isBlack(Cell cell) {
        if (isOddRowAndOddColumn(cell)) {
            return true;
        }
        if (isEvenRowAndEvenColumn(cell)) {
            return true;
        }
        return false;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public void setColumn(char column) {
        this.column = column;
    }
}
