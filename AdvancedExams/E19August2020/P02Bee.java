package JavaAdvanced.AdvancedExams.E19August2020;

import java.util.Scanner;

public class P02Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];
        int beeRow = 0;
        int beeCol = 0;
        int pollinatedFlowers = 0;
        boolean beeGetLost = false;

        fillMatrix(scanner, matrix, size);

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(matrix[row][col].equals("B")){
                    beeRow = row;
                    beeCol = col;
                }
            }
        }
        matrix[beeRow][beeCol] = ".";
        String direction = scanner.nextLine();
        while (!direction.equals("End")){
            switch (direction){
                case "up":
                    beeRow--;
                    break;
                case "down":
                    beeRow++;
                    break;
                case "left":
                    beeCol--;
                    break;
                case "right":
                    beeCol++;
                    break;
            }
            if(beeRow >= 0 && beeRow < size && beeCol >= 0 && beeCol < size){
                if(matrix[beeRow][beeCol].equals("f")){
                    pollinatedFlowers++;
                    matrix[beeRow][beeCol] = ".";
                }else if(matrix[beeRow][beeCol].equals("O")){
                    matrix[beeRow][beeCol] = ".";
                    switch (direction){
                        case "up":
                            beeRow--;
                            break;
                        case "down":
                            beeRow++;
                            break;
                        case "left":
                            beeCol--;
                            break;
                        case "right":
                            beeCol++;
                            break;
                    }
                    if(beeRow >= 0 && beeRow < size && beeCol >= 0 && beeCol < size){
                        if(matrix[beeRow][beeCol].equals("f")){
                            pollinatedFlowers++;
                        }
                        matrix[beeRow][beeCol] = ".";
                    }else {
                        beeGetLost = true;
                    }
                }
            }else {
                beeGetLost = true;
            }
            if(beeGetLost){
                break;
            }

            direction = scanner.nextLine();
        }
        if(beeGetLost){
            System.out.println("The bee got lost!");
        }else {
            matrix[beeRow][beeCol] = "B";
        }
        if(pollinatedFlowers < 5){
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more\n", 5 - pollinatedFlowers);
        }else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!\n", pollinatedFlowers);
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
