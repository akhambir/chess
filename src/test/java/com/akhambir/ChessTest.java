package com.akhambir;

import org.junit.Test;

import java.util.List;

import static com.akhambir.FigureType.PAWN;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ChessTest {

    @Test
    public void firstGame() {
        ChessGame game = new ChessGame();
        game.turn("e2e4", "vova");
        State state = game.getState();
        Figure figure = state.getFigureOn('e', 4);
        assertThat(figure.getType(), is(PAWN));
    }


    @Test
    public void gameReplay() {
        ChessGame game = new ChessGame();
        game.turn("e2e4", "vova");
        game.turn("e4e5", "vova");
        game.turn("e5e6", "vova");
        game.turn("e5e6", "vova");

        State currentState = game.getState();
        State expectedState = new State(new byte[]{});
        assertThat(currentState, is(expectedState));
    }

    @Test(expected = Exception.class)
    public void validation() {
        ChessGame game = new ChessGame();
        game.turn("e2e1", "alex");
    }

    @Test
    public void users() {
        ChessGame game = new ChessGame();
        game.registerUser("vova", Color.WHITE);
        game.registerUser("alex", Color.BLACK);

        List<String> users = game.getUsers();

        boolean check = game.isCheck("alex");
        boolean stalemate = game.isStalemate("vova");

    }

    /**
     * 0 - empty cell
     * 1x - white figure
     * 2x - black figure
     */

    /**
     * TODO
     * 1. Serialize State to array of bytes.
     * 2. Deserialize State.
     * 3. implement State.equals method.
     */
}
