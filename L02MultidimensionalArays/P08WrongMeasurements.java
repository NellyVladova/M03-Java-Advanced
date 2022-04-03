package JavaAdvanced.L02MultidimensionalArays;

import java.util.Arrays;
import java.util.Scanner;

public class P08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][];
        int[][] resultMatrix = new int[rows][];

        fillMatrixAndReturnCols(scanner, matrix, rows);
        int colSize = matrix[0].length;

        String[] numCoordinate = scanner.nextLine().split("\\s+");
        int numRow = Integer.parseInt(numCoordinate[0]);
        int numCol = Integer.parseInt(numCoordinate[1]);
        int wrongNumber = matrix[numRow][numCol];
        for (int row = 0; row < rows; row++) {
            resultMatrix[row] = matrix[row].clone();
            for (int col = 0; col < colSize; col++) {
                if (matrix[row][col] == wrongNumber) {
                    resultMatrix[row][col] = sumOfNearestElements(matrix, row, col, wrongNumber);
                }
            }
        }
        printMatrix(resultMatrix, rows, colSize);
    }
    private static void printMatrix(int[][] subMatrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(subMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int sumOfNearestElements(int[][] matrix, int row, int col, int wrongNum) {
        int sum = 0;
        if (col - 1 >= 0 && matrix[row][col - 1] != wrongNum) {
            sum += matrix[row][col - 1];
        }
        if (col + 1 < matrix[0].length && matrix[row][col + 1] != wrongNum) {
            sum += matrix[row][col + 1];
        }
        if (row - 1 >= 0 && matrix[row - 1][col] != wrongNum) {
            sum += matrix[row - 1][col];
        }
        if (row + 1 < matrix.length && matrix[row + 1][col] != wrongNum) {
            sum += matrix[row + 1][col];
        }
        return sum;
    }

    private static void fillMatrixAndReturnCols(Scanner scanner, int[][] matrix, int rows) {
        for (int row = 0; row < rows; row++) {
            int[] rowData = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = rowData;
        }
    }

}
