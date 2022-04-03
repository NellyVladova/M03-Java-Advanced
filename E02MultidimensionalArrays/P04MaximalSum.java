package JavaAdvanced.E02MultidimensionalArrays;

import java.util.Scanner;

public class P04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int[][] matrix = new int[rows][cols];

        fillMatrix(scanner, matrix, rows, cols);
        int maxSum = Integer.MIN_VALUE;
        int startRow = 0;
        int startCol = 0;
        int currentSum = 0;


        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                currentSum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                        + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    startRow = row;
                    startCol = col;
                }
            }
            currentSum = 0;
        }
        System.out.println("Sum = " + maxSum);
        printMatrix(matrix, startRow, startCol);
    }

    private static void printMatrix(int[][] matrix, int startRow, int startCol) {
        for (int row = startRow; row <= startRow + 2; row++) {
            for (int col = startCol; col <= startCol + 2; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scanner, int[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }
}
