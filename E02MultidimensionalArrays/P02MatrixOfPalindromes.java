package JavaAdvanced.E02MultidimensionalArrays;

import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        String[][] matrix = new String[rows][cols];

        fillMatrix(matrix, rows, cols);
        printMatrix(matrix, rows, cols);
    }

    private static void printMatrix(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] matrix, int rows, int cols) {
        char symbol = 97;
        String palindromes = "";
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                palindromes = "" + symbol + (char) (symbol + col) + symbol;
                matrix[row][col] = palindromes;
            }
            symbol = (char) (symbol + 1);
        }
    }
}
