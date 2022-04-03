package JavaAdvanced.E02MultidimensionalArrays;

import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String pattern = input[1];
        int[][] matrix = new int[size][size];

        if (pattern.equals("A")) {
            patternA(matrix, size);
        } else if (pattern.equals("B")) {
            patternB(matrix, size);
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void patternB(int[][] matrix, int size) {
        int count = 1;
        for (int col = 0; col < size; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = count;
                    count++;
                }
            } else {
                for (int row = size - 1; row >= 0; row--) {
                    matrix[row][col] = count;
                    count++;
                }
            }
        }
    }

    public static void patternA(int[][] matrix, int size) {
        int count = 1;
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                matrix[row][col] = count;
                count++;
            }
        }
    }
}
