package JavaAdvanced.AdvancedExams.E28June2020;

import java.util.Scanner;

public class P02Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];
        int snakeRow = 0;
        int snakeCol = 0;
        boolean outOfBounds = false;
        int foodCount = 0;

        fillMatrix(scanner, matrix, size);

        for (int row = 0; row < size; row++) {//get snake's position
            for (int col = 0; col < size; col++) {
                if(matrix[row][col].equals("S")){
                    snakeRow = row;
                    snakeCol = col;
                }
            }
        }

        String direction = scanner.nextLine();
        matrix[snakeRow][snakeCol] = ".";
        while (!direction.equals("")){
            switch (direction){
                case "up":
                    snakeRow--;
                    break;
                case "down":
                    snakeRow++;
                    break;
                case "left":
                    snakeCol--;
                    break;
                case "right":
                    snakeCol++;
                    break;
            }
            if(snakeRow >= 0 && snakeRow < size && snakeCol >= 0 && snakeCol < size){
                if(matrix[snakeRow][snakeCol].equals("B")){
                    matrix[snakeRow][snakeCol] = ".";
                    for (int row = 0; row < size; row++) {
                        for (int col = 0; col < size; col++) {
                            if(matrix[row][col].equals("B") && row!= snakeRow && col != snakeCol){
                                //the end of the lair
                                snakeRow = row;
                                snakeCol = col;
                                matrix[snakeRow][snakeCol] = ".";
                            }
                        }
                    }
                }else if(matrix[snakeRow][snakeCol].equals("*")){
                    foodCount++;
                    matrix[snakeRow][snakeCol] = ".";
                }else {
                    matrix[snakeRow][snakeCol] = ".";
                }
            }else {
                outOfBounds = true;
            }
            if(outOfBounds || foodCount == 10){
                break;
            }

            direction = scanner.nextLine();
        }
        if(outOfBounds){
            System.out.println("Game over!");
        }else {
            matrix[snakeRow][snakeCol] = "S";
        }
        if(foodCount == 10){
            System.out.println("You won! You fed the snake.");
        }
        System.out.println("Food eaten: " + foodCount);
        printMatrix(matrix, size);
    }

    private static void printMatrix(String[][] presentsMatrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(presentsMatrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scanner, String[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            String[] input = scanner.nextLine().split("");
            for (int col = 0; col < size; col++) {
                matrix[row][col] = input[col];
            }
        }
    }
}
