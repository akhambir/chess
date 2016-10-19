package com.akhambir.model;

import com.akhambir.util.move_validators.MoveValidator;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Game {
    private Deque<GameState> gameStates = new LinkedList<>();
    private List<MoveValidator> moveValidators = new ArrayList<>();



    public GameState move(Move move) {
        GameState oldState = gameStates.peekFirst();
        for(MoveValidator validator: moveValidators) {
            validator.validate(oldState, move);
        }
        GameState newState = GameState.of(oldState, move);
        gameStates.push(newState);
        return newState;
    }
}
