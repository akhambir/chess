package com.akhambir.model;

import java.util.Optional;

import static com.akhambir.util.Validator.checkCellState;
import static com.akhambir.util.Validator.checkRowAndColumnState;
import static java.lang.String.format;

public class GameState {
    private byte[] state = new byte[64];

    public GameState(byte[] state) {
        if (state != null && state.length == 64) {
            for(int i = 0; i < state.length; i++) {
                this.state[i] = checkCellState(state[i], format("Wrong sell state. state[%d] = %d ", i, state[i]));
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

    private static int getIndex(int row, char columnChar) {
        int column = columnChar - 'a';
        checkRowAndColumnState(row, column);
        row--;
        column--;
        return row * 8 + column;
    }

    private static int getIndex(Cell cell) {
        return getIndex(cell.getRow(), cell.getColumn());
    }


    public static GameState of(GameState oldState, Move move) {
        GameState newState = new GameState(oldState.state);
        byte figure =  newState.state[getIndex(move.getCellFrom())];
        newState.state[getIndex(move.getCellFrom())] = 0;
        newState.state[getIndex(move.getCellTo())] = figure;
        return new GameState(oldState.state);
    }
}