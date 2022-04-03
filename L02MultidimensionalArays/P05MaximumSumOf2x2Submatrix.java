package JavaAdvanced.L02MultidimensionalArays;

import java.util.Scanner;

public class P05MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int[][] matrix = new int[rows][cols];
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int[][] subMatrix = new int[2][2];

        fillMatrix(scanner, matrix, rows, cols);

        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                currSum += (matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1]);
                if (currSum > maxSum) {
                    maxSum = currSum;
                    subMatrix[0][0] = matrix[row][col];
                    subMatrix[0][1] = matrix[row][col + 1];
                    subMatrix[1][0] = matrix[row + 1][col];
                    subMatrix[1][1] = matrix[row + 1][col + 1];
                }
                currSum = 0;
            }
        }
        printMatrix(subMatrix, 2);
        System.out.println(maxSum);
    }

    private static void printMatrix(int[][] subMatrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(subMatrix[row][col] + " ");
            }
            System.out.println();
        }
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
