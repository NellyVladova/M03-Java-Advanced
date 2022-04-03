package JavaAdvanced.E02MultidimensionalArrays;

import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];

        fillMatrix(scanner, matrix, size);
        int primarySum = getPrimaryDiagonalSum(matrix, size);
        int secondarySum = getSecondaryDiagonalSum(matrix, size);
        System.out.println(getDifference(primarySum, secondarySum));
    }

    private static int getDifference(int primarySum, int secondarySum) {
        return Math.abs(primarySum - secondarySum);
    }

    private static int getSecondaryDiagonalSum(int[][] matrix, int size) {
        int sum = 0;
        for (int row = 0; row < size; row++) {
            sum += matrix[size - 1 - row][row];
        }
        return sum;
    }

    private static int getPrimaryDiagonalSum(int[][] matrix, int size) {
        int sum = 0;
        for (int row = 0; row < size; row++) {
                sum += matrix[row][row];
        }
        return sum;
    }

    private static void fillMatrix(Scanner scanner, int[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }
}
