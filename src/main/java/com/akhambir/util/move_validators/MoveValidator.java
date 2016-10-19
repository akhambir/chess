package com.akhambir.util.move_validators;

import com.akhambir.model.GameState;
import com.akhambir.model.Move;

public interface MoveValidator {
    boolean validate(GameState gameState, Move move);
}
