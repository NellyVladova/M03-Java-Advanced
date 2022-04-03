package JavaAdvanced.L02MultidimensionalArays;

import java.util.Scanner;

public class P03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows  =Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        String[][] firstMatrix = new String[rows][cols];
        String[][] secondMatrix = new String[rows][cols];

        fillMatrix(scanner, firstMatrix, rows, cols);
        fillMatrix(scanner, secondMatrix, rows, cols);

        replace(firstMatrix, secondMatrix, rows, cols);
    }

    private static void replace(String[][] firstMatrix, String[][] secondMatrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (!firstMatrix[row][col].equals(secondMatrix[row][col])) {
                    System.out.print("* ");
                }else {
                    System.out.print(firstMatrix[row][col] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void fillMatrix(Scanner scanner, String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = input[col];
            }
        }
    }
}
