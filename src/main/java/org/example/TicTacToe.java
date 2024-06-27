package org.example;

import java.util.Scanner;

public class TicTacToe {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public TicTacToe() {
        this.board = new Board();
        this.player1 = new Player('X', "Jaca");
        this.player2 = new Player('O', "Teajay");
        this.currentPlayer = player1;
    }
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            board.printBoard();
            currentPlayer.makeMove(board, scanner);
            if (board.checkWin(currentPlayer.getSymbol())) {
                board.printBoard();
                System.out.println("\n"+currentPlayer.getName() + " wins!  \n\"(^.^)\" ");
                break;
            }
            if (board.isBoardFull()) {
                board.printBoard();
                System.out.println("\nIt's a draw! \n (o_O)");
                break;
            }
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }
}
