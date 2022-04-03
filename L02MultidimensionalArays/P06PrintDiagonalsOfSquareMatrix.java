package JavaAdvanced.L02MultidimensionalArays;

import java.util.Arrays;
import java.util.Scanner;

public class P06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];

        fillMatrix(scanner, matrix, size);

        printFirstDiagonal(matrix, size);
        System.out.println();
        printSecondDiagonal(matrix, size);
    }

    private static void printSecondDiagonal(int[][] matrix, int num) {
        for (int row = 0; row < num; row++) {
            System.out.print(matrix[num - 1 - row][row] + " ");
        }
    }

    private static void printFirstDiagonal(int[][] matrix, int num) {
        for (int row = 0; row < num; row++) {
            System.out.print(matrix[row][row] + " ");
        }
    }

    public static void fillMatrix(Scanner scanner, int[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            int[] rowData = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = rowData;
        }
    }
}
