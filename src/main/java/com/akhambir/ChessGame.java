package com.akhambir;

import java.util.List;

public class ChessGame {
    private State currentState = new State();


    public Response turn(String turn, String vova) {
        currentState = currentState.move(turn);
        return null;
    }

    public State getState() {
        return currentState;
    }

    public boolean registerUser(String userId, Color white) {
        return false;
    }

    public List<String> getUsers() {
        return null;
    }

    public boolean isCheck(String alex) {
        return false;
    }

    public boolean isStalemate(String vova) {
        return false;
    }
}
