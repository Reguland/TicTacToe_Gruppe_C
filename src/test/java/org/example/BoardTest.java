package org.example;
import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;
public class BoardTest {
    @Test
    public void Test_isPositionEmpty_Positive() {
        Board board1 = new Board();

        assertTrue(board1.isPositionEmpty(1, 1), "Das Feld (1,1) sollte leer sein");
    }

    @Test
    public void Test_isPositionEmpty_Negativ() {
        Board board1 = new Board();

        boolean exceptionThrown = false;
        try {
            board1.isPositionEmpty(-1, 0);
        } catch (ArrayIndexOutOfBoundsException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown, "Eine ArrayIndexOutOfBoundsException sollte geworfen werden, wenn ein ungültiger Index verwendet wird");

        Board board2 = new Board();
        board2.placeTic(new Player('X', "Test"), 1, 1);

        assertFalse(board2.isPositionEmpty(1, 1), "Das Feld (1,1) sollte besetzt sein");
    }

    @Test
    public void Test_placeTic() {
        Board board = new Board();
        Player player = new Player('X', "TestPlayer");

        // Test placing a tic at an empty position
        board.placeTic(player, 1, 1);
        assertTrue(board.isPositionEmpty(1, 1) == false, "The position (1,1) should not be empty after placing a tic");

        // Test placing a tic at an already occupied position
        Player anotherPlayer = new Player('O', "AnotherPlayer");
        board.placeTic(anotherPlayer, 1, 1);
        assertNotEquals(anotherPlayer.getSymbol(), board.getBoard()[1][1], "The position (1,1) should not be changed by another player");
    }
    @Test
    public void Test_checkWin() {
        Board board = new Board();
        Player player = new Player('X', "TestPlayer");

        board.placeTic(player, 0, 0);
        board.placeTic(player, 0, 1);
        board.placeTic(player, 0, 2);
        assertTrue(board.checkWin(player.getSymbol()), "The player should win in the first row");

        board = new Board();
        board.placeTic(player, 0, 0);
        board.placeTic(player, 1, 0);
        board.placeTic(player, 2, 0);
        assertTrue(board.checkWin(player.getSymbol()), "The player should win in the first column");

        board = new Board();
        board.placeTic(player, 0, 0);
        board.placeTic(player, 1, 1);
        board.placeTic(player, 2, 2);
        assertTrue(board.checkWin(player.getSymbol()), "The player should win in the diagonal");

        board = new Board();
        board.placeTic(player, 0, 0);
        board.placeTic(player, 1, 1);
        board.placeTic(player, 2, 0);
        assertFalse(board.checkWin(player.getSymbol()), "The player should not win");
    }

}