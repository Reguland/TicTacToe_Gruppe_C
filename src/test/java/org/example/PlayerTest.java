package org.example;
import org.junit.jupiter.api.Test;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
     @Test
     public void testGetName() {
         Player player = new Player('X', "Jaca");
         assertEquals("Jaca", player.getName());
     }

     @Test
     public void testGetSymbol() {
         Player player = new Player('X', "Jaca");
         assertEquals('X', player.getSymbol());
     }

     @Test
     public void testMakeMove() {
         Board board = new Board();
         Player player = new Player('X', "Jaca");
         Scanner scanner = new Scanner("1");
         player.makeMove(board, scanner);
         assertEquals('X', board.getBoard()[0][0]);
     }

     @Test
     public void testMakeMoveInvalidInput() {
         Board board = new Board();
         Player player = new Player('X', "Jaca");
         Scanner scanner = new Scanner("a\n1");
         player.makeMove(board, scanner);
         assertEquals('X', board.getBoard()[0][0]);
     }

     @Test
     public void testMakeMoveInvalidMove() {
         Board board = new Board();
         Player player = new Player('X', "Jaca");
         Scanner scanner = new Scanner("1\n1");
         player.makeMove(board, scanner);
         assertEquals('X', board.getBoard()[0][0]);
     }

     @Test
     public void testMakeMoveSpotTaken() {
         Board board = new Board();
         Player player1 = new Player('X', "Jaca");
         Player player2 = new Player('O', "Teajay");
         Scanner scanner = new Scanner("1\n1\n2\n2");
         player1.makeMove(board, scanner);
         player2.makeMove(board, scanner);
         assertEquals('X', board.getBoard()[0][0]);
         assertEquals('O', board.getBoard()[0][1]);
     }

     @Test
     public void testMakeMoveSpotTakenInvalidInput() {
         Board board = new Board();

            Player player1 = new Player('X', "Jaca");
     }
}