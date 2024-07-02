package com.nascimento.tddjava;

import java.util.Random;

public class TicTacToe {

    private final Character[][] board = {{'\0','\0','\0'},{'\0','\0','\0'},{'\0','\0','\0'}};
    private Character lastPlayer = '\0';
    private static final int SIZE = 3;


    public String play(int x, int y, String player) {

        lastPlayer = nextPlayer();
        checkAxis(x, "X");
        checkAxis(y, "Y");
        setBox(x, y);


        if (isWin(x, y)) {
            return lastPlayer + " is the winner";
        } else if (isDraw()) {
            return "The result is draw";
        }

        if (player.equals("USER")) {
            return playAI();
        }

        return "No winner";

    }

    private String playAI(){
        String retorno;
        while (true) {
            Random gerador = new Random();
            int x = gerador.nextInt(SIZE);
            int y = gerador.nextInt(SIZE);
            if (board[x][y] == '\0') {
                retorno = play(x+1, y+1, "AI");
                break;
            }
        }
        return retorno;
    }

    public void printBoard(){
        for (int x = 0; x < SIZE; x++){
            for (int y = 0; y < SIZE; y++){
                System.out.print(" " + board[x][y] + " ");
            }
            System.out.println();
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
//            horizontal += board[i][y-1];
//            vertical   += board[x-1][i];
            horizontal += board[x-1][i];
            vertical   += board[i][y-1];
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