package com.akhambir.model;

public class Move {
    private int fromRow;
    private char fromColumn;
    private int toRow;
    private char toColumn;

    public Move(int fromRow, char fromColumn, int toRow, char toColumn) {
        this.fromRow = fromRow;
        this.fromColumn = fromColumn;
        this.toRow = toRow;
        this.toColumn = toColumn;
    }

    public int getFromRow() {
        return fromRow;
    }

    public char getFromColumn() {
        return fromColumn;
    }

    public int getToRow() {
        return toRow;
    }

    public char getToColumn() {
        return toColumn;
    }

    public Cell getCellFrom() {
        return Cell.of(fromRow, fromColumn);
    }

    public Cell getCellTo() {
        return Cell.of(toRow, toColumn);
    }
}
