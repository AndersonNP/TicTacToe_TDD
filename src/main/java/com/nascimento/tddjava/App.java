package com.nascimento.tddjava;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        startGame();

    }

    private static void startGame(){

        TicTacToe ticTacToe = new TicTacToe();
        String retorno = iniciarTurno(ticTacToe);
        System.out.println(retorno);

    }

    private static String iniciarTurno(TicTacToe ticTacToe){
        String retorno = "No winner";
        while(retorno.equals("No winner")){

            int x = solicitarCoordenada("X");
            int y = solicitarCoordenada("Y");

            retorno = ticTacToe.play(x,y,"USER");
            ticTacToe.printBoard();
        }

        return retorno;
    }


    private static int solicitarCoordenada(String eixo){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Insira o valor de " + eixo + ":");
        return entrada.nextInt();
    }

}
