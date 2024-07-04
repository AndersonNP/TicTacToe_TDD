package com.nascimento.tddjava;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {

    private ByteArrayOutputStream outContent;

    @BeforeEach
    public void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testSolicitarModoDeJogo() {
        String input = "s\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        boolean modoIA = App.solicitarModoDeJogo(new Scanner(System.in));
        assertTrue(modoIA);

        input = "sim\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        modoIA = App.solicitarModoDeJogo(new Scanner(System.in));
        assertTrue(modoIA);

        input = "n\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        modoIA = App.solicitarModoDeJogo(new Scanner(System.in));
        assertTrue(!modoIA);
    }

    @Test
    public void testSolicitarCoordenada() {
        String input = "2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        int coordenada = App.solicitarCoordenada("X", new Scanner(System.in));
        assertEquals(2, coordenada);

        input = "X\n2\n"; // Invalid input then valid input
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        coordenada = App.solicitarCoordenada("X", new Scanner(System.in));
        assertEquals(2, coordenada);

        input = "-1\n2\n"; // Invalid input then valid input
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        coordenada = App.solicitarCoordenada("X", new Scanner(System.in));
        assertEquals(2, coordenada);

        input = "5\n2\n"; // Invalid input then valid input
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        coordenada = App.solicitarCoordenada("X", new Scanner(System.in));
        assertEquals(2, coordenada);
    }

    @Test
    public void testIniciarTurno() {
        TicTacToe ticTacToe = new TicTacToe();
        String input = "1\n1\n1\n2\n2\n2\n2\n1\n3\n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);

        String resultado = App.iniciarTurno(ticTacToe, scanner);

        assertEquals("X is the winner", resultado);
    }


}
