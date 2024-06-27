package org.example;

import java.util.Scanner;

public class Player {
    private char symbol;
    private String name;

    public Player(char symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void makeMove(Board board, Scanner scanner) {
        int input;
        boolean isValidInput = false;

        while (!isValidInput) {
            System.out.print("\n"+name + ", make your move (choose a number 1-9):");
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                System.out.println("");
                if (input >= 1 && input <= 9) {
                    int row = (input - 1) / 3;
                    int col = (input - 1) % 3;
                    if (board.isPositionEmpty(row, col)) {
                        board.placeTic(this, row, col);
                        isValidInput = true;
                    } else {
                        System.out.println("This spot is already taken. Please choose another spot.");
                    }
                } else {
                    System.out.println("Invalid move. Please choose a number between 1 and 9.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
    }
}
