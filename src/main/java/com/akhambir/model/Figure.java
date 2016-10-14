package com.akhambir.model;

import static com.akhambir.model.Figure.FigureType.*;

public class Figure {
    private byte value;

    public Figure(byte value) {
        if (value < 1 || value > 13) {
            throw new RuntimeException("Wrong figure value. Passed value: " + value);
        }
        this.value = value;
    }

    public boolean isWhite() {
        return false; //TODO
    }

    public boolean isBlack() {
        return false;
    }

    public FigureType getType() {
        return FIGURES[(value - 1) % 6];
    }

    public static Figure of(byte figureValue) {
        return new Figure(figureValue);
    }

    public enum FigureType {
        KING, QUEEN, HORSE, ROOK, BISHOP, KNIGHT, PAWN;
    }
    private static final FigureType[] FIGURES = { KING, QUEEN, HORSE, ROOK, BISHOP, KNIGHT, PAWN };
}
