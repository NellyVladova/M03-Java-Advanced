package JavaAdvanced.AdvancedExams.E22Feb2020;

import java.util.Scanner;

public class P02ReVolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int countOfCommands = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];
        int playerRow = 0;
        int playerCol = 0;

        boolean finishIsReached = false;

        fillMatrix(scanner, matrix, size);

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(matrix[row][col].equals("f")){
                    playerRow = row;
                    playerCol = col;
                }
            }
        }
        matrix[playerRow][playerCol] = "-";
        for (int i = 0; i < countOfCommands; i++) {
            String direction = scanner.nextLine();

            switch (direction){
                case "up":
                    playerRow--;
                    break;
                case "down":
                    playerRow++;
                    break;
                case "left":
                    playerCol--;
                    break;
                case "right":
                    playerCol++;
                    break;
            }

            if(playerRow < 0){
                playerRow = size - 1;
            }else if(playerRow >= size){
                playerRow = 0;
            }
            if(playerCol < 0){
                playerCol = size - 1;
            }else if(playerCol >= size){
                playerCol = 0;
            }
            if(matrix[playerRow][playerCol].equals("B")){
                if(direction.equals("up")) {
                    playerRow--;
                } else if (direction.equals("down")) {
                    playerRow++;
                } else if (direction.equals("left")) {
                    playerCol--;
                } else if (direction.equals("right")) {
                    playerCol++;
                }
            } else if (matrix[playerRow][playerCol].equals("T")) {
                if(direction.equals("up")) {
                    playerRow++;
                } else if (direction.equals("down")) {
                    playerRow--;
                } else if (direction.equals("left")) {
                    playerCol++;
                } else if (direction.equals("right")) {
                    playerCol--;
                }
            }
            if(playerRow < 0){
                playerRow = size - 1;
            }else if(playerRow >= size){
                playerRow = 0;
            }
            if(playerCol < 0){
                playerCol = size - 1;
            }else if(playerCol >= size){
                playerCol = 0;
            }
            if(matrix[playerRow][playerCol].equals("F")){
                matrix[playerRow][playerCol] = "f";
                finishIsReached = true;
                break;
            }
        }
        if(finishIsReached){
            System.out.println("Player won!");
        }else {
            matrix[playerRow][playerCol] = "f";
            System.out.println("Player lost!");
        }

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
