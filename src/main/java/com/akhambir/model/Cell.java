package com.akhambir.model;

public class Cell {
    private Figure figure;
    private char cellChar;
    private int cellNumber;

    public boolean isBlack() {
        return false; // TODO implement algorithm for color definition
    }

    public boolean isWhite() {
        return false; // TODO same for white
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }
}
