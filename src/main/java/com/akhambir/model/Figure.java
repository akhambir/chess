package com.akhambir.model;

import static com.akhambir.util.Validator.checkFigureValue;
import static com.akhambir.model.Figure.FigureType.*;

public class Figure {
    private byte value;

    public Figure(byte value) {
        checkFigureValue(value);
        this.value = value;
    }

    public boolean isWhite(byte value) {
        checkFigureValue(value);
        return value > 1 && value < 7; // TODO refactor magic numbers
    }

    public boolean isBlack(byte value) {
        checkFigureValue(value);
        return value > 6 && value < 14; //TODO refactor magic numbers
    }

    public FigureType getType() {
        return FIGURES[(value - 1) % 6]; //TODO refactor magic numbers
    }

    public static Figure of(byte figureValue) {
        return new Figure(figureValue);
    }

    public enum FigureType {
        KING, QUEEN, HORSE, ROOK, BISHOP, KNIGHT, PAWN;
    }
    private static final FigureType[] FIGURES = { KING, QUEEN, HORSE, ROOK, BISHOP, KNIGHT, PAWN };
}
