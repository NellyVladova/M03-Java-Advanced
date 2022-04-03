package JavaAdvanced.E02MultidimensionalArrays;

import java.util.Scanner;

public class P11ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int[][] matrix = new int[rows][cols];

        fillMatrix(scanner, matrix, rows, cols);

        int row = rows - 1;
        int col = cols - 1;

        while (row != -1){
            int r = row;
            int c = col;
            while (c < cols && r >= 0){
                System.out.print(matrix[r--][c++] + " ");
            }
            System.out.println();
            col--;
            if(col == -1){
                col = 0;
                row--;
            }
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
