package JavaAdvanced.AdvancedExams.E23October2021;

import java.util.Scanner;

public class P02MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];
        int mouseRow = -1;
        int mouseCol = -1;
        int countCheese = 0;

        fillMatrix(scanner, matrix, size);

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(matrix[row][col].equals("M")){
                    mouseRow = row;
                    mouseCol = col;
                }
            }
        }

        String direction = scanner.nextLine();
        while (!direction.equals("end")) {
            matrix[mouseRow][mouseCol] = "-";
            switch(direction) {
                case "up":
                    mouseRow--;
                    break;
                case "down":
                    mouseRow++;
                    break;
                case "left":
                    mouseCol--;
                    break;
                case "right":
                    mouseCol++;
                    break;
            }
            if (mouseRow < 0 || mouseRow >= size || mouseCol < 0 || mouseCol >= size) {
                System.out.println("Where is the mouse?");
                break;
            }
            if (matrix[mouseRow][mouseCol].equals("c")) {
                countCheese++;
            } else if (matrix[mouseRow][mouseCol].equals("B")) {
                continue;
            }
            matrix[mouseRow][mouseCol] = "M";

            direction = scanner.nextLine();
        }

        if (countCheese >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!\n", countCheese);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.\n", 5 - countCheese);
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
