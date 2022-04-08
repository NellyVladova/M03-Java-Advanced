package JavaAdvanced.AdvancedExams.E15December2021;

import java.util.Scanner;

public class P02ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            //to be continued
        int parisEnergy = Integer.parseInt(scanner.nextLine());
        int rowsOfTheField = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[rowsOfTheField][];
        int parisRow = 0;
        int parisCol = 0;
        boolean gameOver = false;
        
        fillMatrix(scanner, matrix, rowsOfTheField);

        for (int i = 0; i < rowsOfTheField; i++) {

        }
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
            for (int col = 0; col < input.length; col++) {
                matrix[row][col] = input[col];
            }
        }
    }
}
