package JavaAdvanced.AdvancedExams.E14April2021;

import java.util.Scanner;

public class P02CookingJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];
        int myRow = 0;
        int myCol = 0;
        int totalMoney = 0;
        boolean outOfBounds = false;

        fillMatrix(scanner, matrix, size);

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(matrix[row][col].equals("S")){
                    myRow = row;
                    myCol = col;
                    break;
                }
            }
        }
        String direction = scanner.nextLine();
        matrix[myRow][myCol] = "-";
        while (!direction.equals("")){
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
            if(myRow >= 0 && myRow < size && myCol >= 0 && myCol < size){
                if(matrix[myRow][myCol].equals("P")){
                    matrix[myRow][myCol] = "-";
                    for (int row = 0; row < size; row++) {
                        for (int col = 0; col < size; col++) {
                            if(matrix[row][col].equals("P") && row!= myRow && col != myCol){
                                //the end of the lair
                                myRow = row;
                                myCol = col;
                                matrix[myRow][myCol] = "-";
                            }
                        }
                    }
                }else if(!matrix[myRow][myCol].equals("-")){
                    int currMoney = Integer.parseInt(matrix[myRow][myCol]);
                    totalMoney+=currMoney;
                    matrix[myRow][myCol] = "-";
                }
            }else {
                outOfBounds = true;
            }
            if(outOfBounds || totalMoney >= 50){
                break;
            }

            direction = scanner.nextLine();
        }

        if(outOfBounds){
            System.out.println("Bad news! You are out of the pastry shop.");
        }else {
            matrix[myRow][myCol] = "S";
        }
        if(totalMoney >= 50){
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.println("Money: " + totalMoney);
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
