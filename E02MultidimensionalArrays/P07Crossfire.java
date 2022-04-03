package JavaAdvanced.E02MultidimensionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P07Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        List<List<Integer>> matrix = new ArrayList<>();

        fillMatrix(matrix, rows, cols);

        String input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            String[] inputParts = input.split("\\s+");
            int row = Integer.parseInt(inputParts[0]);
            int col = Integer.parseInt(inputParts[1]);
            int radius = Integer.parseInt(inputParts[2]);

            for (int currRow = row - radius; currRow <= row + radius; currRow++) {
                if (indexIsValid(matrix, currRow, col) && currRow != row) {
                    matrix.get(currRow).remove(col);
                }
            }

            for (int currCol = col + radius; currCol >= col - radius; currCol--) {
                if (indexIsValid(matrix, row, currCol)) {
                    matrix.get(row).remove(currCol);
                }
            }

            matrix.removeIf(List::isEmpty);

            input = scanner.nextLine();
        }
        printMatrix(matrix);
    }

    public static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static boolean indexIsValid(List<List<Integer>> matrix, int row, int col) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static void fillMatrix(List<List<Integer>> matrix, int rows, int cols) {
        int number = 1;
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(number++);
            }
        }
    }
}
