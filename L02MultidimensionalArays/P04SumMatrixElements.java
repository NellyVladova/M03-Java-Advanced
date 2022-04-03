package JavaAdvanced.L02MultidimensionalArays;

import java.util.Scanner;

public class P04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int[][] numberMatrix = new int[rows][cols];

        fillMatrix(scanner, numberMatrix, rows, cols);

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(getSum(numberMatrix, rows, cols));
    }

    private static int getSum(int[][] matrix, int rows, int cols) {
        int sum = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                sum += matrix[row][col];
            }
        }
        return sum;
    }

    public static void fillMatrix(Scanner scanner, int[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            String[] input = scanner.nextLine().split(", ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(input[col]);
            }
        }
    }
}
