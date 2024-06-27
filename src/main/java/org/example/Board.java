package org.example;

public class Board {
    private char[][] board;

    public Board() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }
    public boolean isPositionEmpty(int row, int col) {
        return board[row][col] == ' ';
    }
    public void placeTic(Player player, int row, int col) {
        if (isPositionEmpty(row, col)) {
            board[row][col] = player.getSymbol();
        }
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println("---------");
        }
    }
    public char[][] getBoard() {
        return board;
    }
    public boolean checkWin(char symbol) {
        return false;
    }

    public boolean isBoardFull() {
        return false;
    }
}
