package com.akhambir.model;

import java.util.Optional;

import static com.akhambir.Validator.checkCellState;
import static java.lang.String.format;

public class GameState {
    private byte[] state = new byte[64];

    public GameState(byte[] state) {
        if (state != null && state.length == 64) {
            for(int i = 0; i < state.length; i++) {
                this.state[i] = checkCellState(state[i], format("Wrong Cell State. State[%d] = %d ", i, state[i]));
                // TODO check number of black and white figures (no more then 16 each)
            }
        } else {
            throw new RuntimeException("Wrong state");
        }
    }

    public Optional<Figure> getFigure(int row, char column) {
        byte figureValue = state[getIndex(row, column)];
        if (figureValue == 0) {
            return Optional.empty();
        }
        return Optional.of(Figure.of(figureValue)); //TODO
    }

    private int getIndex(int row, char columnChar) {
        int column = columnChar - 'a';
        if (column < 1 || column > 8) {
            throw new RuntimeException("Wrong column value. Passed value: " + column);
        }
        if (row < 1 || row > 8) {
            throw new RuntimeException("Wrong row value. Passed value: " + row);
        }
        row--;
        column--;
        return row * 8 + column;
    }
}
