package com.nascimento.tddjava;

import java.util.Scanner;

public class App {

    private static final int MIN_COORDINATE = 1;
    private static final int MAX_COORDINATE = 3;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean modoIA = solicitarModoDeJogo(scanner);
            TicTacToe.modeIA = modoIA;
            TicTacToe ticTacToe = new TicTacToe();
            String resultado = iniciarTurno(ticTacToe, scanner);
            exibirMensagem(resultado);
        }
    }

    static boolean solicitarModoDeJogo(Scanner scanner) {
        exibirMensagem("Deseja jogar contra a IA? (s/n):");
        String resposta = scanner.nextLine().trim().toLowerCase();
        return resposta.equals("s") || resposta.equals("sim");
    }

    static String iniciarTurno(TicTacToe ticTacToe, Scanner scanner) {
        String resultado = "No winner";
        while (resultado.equals("No winner")) {
            int x = solicitarCoordenada("X", scanner);
            int y = solicitarCoordenada("Y", scanner);
            resultado = ticTacToe.play(x, y, "USER");
            ticTacToe.printBoard();
        }
        return resultado;
    }

    public static int solicitarCoordenada(String eixo, Scanner scanner) {
        int coordenada = -1;
        while (coordenada < MIN_COORDINATE || coordenada > MAX_COORDINATE) {
            exibirMensagem(String.format("Insira o valor de %s (%d-%d):", eixo, MIN_COORDINATE, MAX_COORDINATE));
            if (scanner.hasNextInt()) {
                coordenada = scanner.nextInt();
                scanner.nextLine(); // Avançar para a próxima linha
            } else {
                scanner.next(); // Descartar entrada inválida
                exibirMensagem("Entrada inválida. Por favor, insira um número.");
            }
        }
        return coordenada;
    }


    static void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
