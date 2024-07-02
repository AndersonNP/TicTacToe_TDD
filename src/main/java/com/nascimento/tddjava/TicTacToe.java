package com.nascimento.tddjava;

public class TicTacToe {

    private Character[][] board = {{'\0','\0','\0'},{'\0','\0','\0'},{'\0','\0','\0'}};
    private Character lastPlayer = '\0';
    private static final int SIZE = 3;

    public String play(int x, int y) {
        lastPlayer = nextPlayer();
        checkAxis(x, "X");
        checkAxis(y, "Y");
        setBox(x, y);

        if(isWin(x, y)){
            return lastPlayer + " is the winner";
        } else if (isDraw()) {
            return "The result is draw";
        }else {
            return "No winner";
        }

    }

    private boolean isDraw() {
        for (int x = 0; x < SIZE;x++){
            for (int y = 0; y < SIZE;y++){
                if(board[x][y] == '\0'){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isWin(int x, int y){
        int playerTotal = (lastPlayer * SIZE);
        char horizontal, vertical, diagonal1, diagonal2;
        horizontal = vertical = diagonal1 = diagonal2 = '\0';
        for(int i = 0; i < SIZE; i++){
            horizontal += board[i][y-1];
            vertical   += board[x-1][i];
            diagonal1  += board[i][i];
            diagonal2  += board[i][SIZE - i - 1];
        }


        return     horizontal == playerTotal
                || vertical   == playerTotal
                || diagonal1  == playerTotal
                || diagonal2  == playerTotal;
    }


    private void checkAxis(int z, String axis){
        if(z < 1 || z > 3){
            throw new RuntimeException(axis + " is outside board");
        }
    }

    private void setBox(int x, int y){
        if(board[x-1][y-1].equals('X')){
            throw new RuntimeException("Box is occupied");
        }

        board[x-1][y-1] = lastPlayer;
    }

    public char nextPlayer() {

        if(lastPlayer.equals('X')){
            return 'O';
        }
        return 'X';
    }
}