package JavaAdvanced.AdvancedExams.E26June2021;

import java.util.Scanner;

public class P02Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] directions = scanner.nextLine().split(", ");
        String[][] matrix = new String[size][size];
        int length = 1;
        int snakeRow = 0;
        int snakeCol = 0;
        int food = 0;
        boolean outOfFood = false;
        boolean isDead = false;

        fillMatrix(scanner, matrix, size);

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col].equals("s")) {
                    snakeRow = row;
                    snakeCol = col;
                } else if (matrix[row][col].equals("f")) {
                    food++;
                }
            }
        }

        matrix[snakeRow][snakeCol] = "*";

        for (int i = 0; i < directions.length; i++) {
            switch (directions[i]) {
                case "up":
                    if (snakeRow - 1 >= 0) {
                        snakeRow--;
                    } else {
                        snakeRow = size - 1;
                    }
                    break;
                case "down":
                    if (snakeRow + 1 < size) {
                        snakeRow++;
                    } else {
                        snakeRow = 0;
                    }
                    break;
                case "left":
                    if (snakeCol - 1 >= 0) {
                        snakeCol--;
                    } else {
                        snakeCol = size - 1;
                    }
                    break;
                case "right":
                    if (snakeCol + 1 < size) {
                        snakeCol++;
                    } else {
                        snakeCol = 0;
                    }
                    break;
            }
            if (matrix[snakeRow][snakeCol].equals("f")) {
                matrix[snakeRow][snakeCol] = "*";
                food--;
                length++;
            } else if (matrix[snakeRow][snakeCol].equals("e")) {
                System.out.println("You lose! Killed by an enemy!");
                isDead = true;
                break;
            }
            if (food == 0) {
                System.out.printf("You win! Final python length is %d", length);
                outOfFood = true;
                break;
            }
        }
        if (!outOfFood && !isDead) {
            System.out.printf("You lose! There is still %d food to be eaten.", food);
        }
    }

    private static void fillMatrix(Scanner scanner, String[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            String[] input = scanner.nextLine().split(" ");
            for (int col = 0; col < size; col++) {
                matrix[row][col] = input[col];
            }
        }
    }
}
