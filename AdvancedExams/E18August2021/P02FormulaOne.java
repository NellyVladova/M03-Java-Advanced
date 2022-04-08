package JavaAdvanced.AdvancedExams.E18August2021;

import java.util.Scanner;

public class P02FormulaOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int countOfCommands = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];
        int myRow = 0;
        int myCol = 0;
        boolean finishIsReached = false;

        fillMatrix(scanner, matrix, size);

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(matrix[row][col].equals("P")){
                    myRow = row;
                    myCol = col;
                }
            }
        }

        matrix[myRow][myCol] = ".";
        for (int i = 0; i < countOfCommands; i++) {
            String direction = scanner.nextLine();

            switch (direction){
                case "up":
                    myRow--;
                    break;
                case "down":
                    myRow++;
                    break;
                case "left":
                    myCol--;
                    break;
                case "right":
                    myCol++;
                    break;
            }

            if(myRow < 0){
                myRow = size - 1;
            }else if(myRow >= size){
                myRow = 0;
            }
            if(myCol < 0){
                myCol = size - 1;
            }else if(myCol >= size){
                myCol = 0;
            }
            if(matrix[myRow][myCol].equals("B")){
                if(direction.equals("up")) {
                    myRow--;
                } else if (direction.equals("down")) {
                    myRow++;
                } else if (direction.equals("left")) {
                    myCol--;
                } else if (direction.equals("right")) {
                    myCol++;
                }
            } else if (matrix[myRow][myCol].equals("T")) {
                if(direction.equals("up")) {
                    myRow++;
                } else if (direction.equals("down")) {
                    myRow--;
                } else if (direction.equals("left")) {
                    myCol++;
                } else if (direction.equals("right")) {
                    myCol--;
                }
            }
            if(myRow < 0){
                myRow = size - 1;
            }else if(myRow >= size){
                myRow = 0;
            }
            if(myCol < 0){
                myCol = size - 1;
            }else if(myCol >= size){
                myCol = 0;
            }
            if(matrix[myRow][myCol].equals("F")){
                matrix[myRow][myCol] = "P";
                finishIsReached = true;
                break;
            }
        }
        if(finishIsReached){
            System.out.println("Well done, the player won first place!");
        }else {
            System.out.println("Oh no, the player got lost on the track!");
            matrix[myRow][myCol] = "P";
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
