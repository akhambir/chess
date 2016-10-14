package com.akhambir;

public class State {
    private Figure[][] currentBoard = new Figure[8][8];

    public State(Figure[][] board) {
        this.currentBoard = board;
    }

    public State() {
        currentBoard[1]['e' - 'a'] = new Pawn();
    }

    public State(byte[] bytes) {

    }

    public State move(String turn) {
        char prevColumn = turn.charAt(0);
        char prevRow = turn.charAt(1);
        char nextColumn = turn.charAt(2);
        char nextRow = turn.charAt(3);

        Figure[][] board = copy(currentBoard);

        Figure figure = board[prevRow - '1'][prevColumn - 'a'];
        board[prevRow - '1'][prevColumn - 'a'] = null;
        board[nextRow - '1'][nextColumn - 'a'] = figure;
        return new State(board);
    }

    private Figure[][] copy(Figure[][] board) {
        int h = board.length;
        int w = board[0].length;
        Figure[][] newBoard = new Figure[h][w];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                newBoard[i][j] = board[i][j];
            }
        }
        return newBoard;
    }

    public Figure getFigureOn(char column, int row) {
        return currentBoard[row-1][column - 'a'];
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append("......");
        return buf.toString();
    }
}
