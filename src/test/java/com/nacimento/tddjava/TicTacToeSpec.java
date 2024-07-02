package com.nacimento.tddjava;

import com.nascimento.tddjava.TicTacToe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TicTacToeSpec {

   private TicTacToe ticTacToe;

   @BeforeEach
   public final void before(){
      ticTacToe = new TicTacToe();
   }

   @Test
   public void whenXOutsideBoardThenRuntimeException(){
      assertThrows(RuntimeException.class, () -> {
         ticTacToe.play(5, 2, "USER");
      });
   }

   @Test
   public void whenYOutsideBoardThenRuntimeException(){
      assertThrows(RuntimeException.class, () -> {
         ticTacToe.play(1,5, "USER");
      });
   }

   @Test
   public void whenOccupiedThenRuntimeException(){
      assertThrows(RuntimeException.class, () -> {
         ticTacToe.play(2,1, "USER");
         ticTacToe.play(2,1, "USER");
      });
   }

   @Test
   public void givenFirstTurnWhenNextPlayerThenX(){
      assertEquals('X', ticTacToe.nextPlayer());
   }

   @Test
   public void givenLastTurnWasXWhenNextPlayerThenO(){
      ticTacToe.play(1, 1, "USER");
      assertEquals('O',ticTacToe.nextPlayer());
   }

   @Test
   public void whenPlayThenNoWinner(){
      String actual = ticTacToe.play(1, 1, "USER");
      assertEquals("No winner", actual);
   }

   @Test
   public void whenPlayAndWholeVerticalLineThenWinner(){
      ticTacToe.play(1,1, "USER");
      ticTacToe.play(1,2, "USER");
      ticTacToe.play(2,1, "USER");
      ticTacToe.play(2,2, "USER");
      String actual = ticTacToe.play(3,1, "USER");
      assertEquals("X is the winner", actual);
   }

   @Test
   public void whenPlayAndWholeHorizontalLineThenWinner(){
      ticTacToe.play(2,1, "USER");
      ticTacToe.play(1,1, "USER");
      ticTacToe.play(3,1, "USER");
      ticTacToe.play(1,2, "USER");
      ticTacToe.play(2,2, "USER");
      String actual = ticTacToe.play(1,3, "USER");
      assertEquals("O is the winner", actual);
   }

   @Test
   public void whenPlayAndTopBottomDiagonalLineThenWinner(){
      ticTacToe.play(1,1, "USER");
      ticTacToe.play(1,2, "USER");
      ticTacToe.play(2,2, "USER");
      ticTacToe.play(1,3, "USER");
      String actual = ticTacToe.play(3,3, "USER");
      assertEquals("X is the winner", actual);
   }

   @Test
   public void whenPlayAndBottomTopDiagonalLineThenWinner(){
      ticTacToe.play(1,3, "USER");
      ticTacToe.play(1,2, "USER");
      ticTacToe.play(2,2, "USER");
      ticTacToe.play(2,3, "USER");
      String actual = ticTacToe.play(3,1, "USER");
      assertEquals("X is the winner", actual);
   }

   @Test
   public void whenAllBoxesAreFilledThenDraw(){
      ticTacToe.play(1,1, "USER");
      ticTacToe.play(1,2, "USER");
      ticTacToe.play(1,3, "USER");
      ticTacToe.play(2,1, "USER");
      ticTacToe.play(2,3, "USER");
      ticTacToe.play(2,2, "USER");
      ticTacToe.play(3,1, "USER");
      ticTacToe.play(3,3, "USER");
      String actual = ticTacToe.play(3,2, "USER");
      assertEquals("The result is draw", actual);
   }

   @Test
   public void givenDefineModeAIWhenNextPlayerThenX(){
      ticTacToe.play(1,1, "USER");
      ticTacToe.printBoard();
      assertEquals('X', ticTacToe.nextPlayer());
   }





}