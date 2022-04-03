package JavaAdvanced.L02MultidimensionalArays;

import java.util.Scanner;

public class P01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowsForFirst = scanner.nextInt();
        int colsForFirst = scanner.nextInt();
        int[][] firstMatrix = new int[rowsForFirst][colsForFirst];
        fillMatrix(scanner, firstMatrix, rowsForFirst, colsForFirst);

        int rowsForSecond = scanner.nextInt();
        int colsForSecond = scanner.nextInt();

        if (rowsForFirst != rowsForSecond || colsForFirst != colsForSecond) {
            System.out.println("not equal");
            return;
        }
        int[][] secondMatrix = new int[rowsForSecond][colsForSecond];
        fillMatrix(scanner, secondMatrix, rowsForSecond, colsForSecond);

        compareMatrices(firstMatrix, secondMatrix, rowsForFirst, colsForFirst);
    }

    private static void compareMatrices(int[][] matrix1, int[][] matrix2, int rows, int cols) {

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix1[row][col] != matrix2[row][col]) {
                    System.out.println("not equal");
                    return;
                }
            }
        }
        System.out.println("equal");
    }

    public static void fillMatrix(Scanner scanner, int[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }

}
