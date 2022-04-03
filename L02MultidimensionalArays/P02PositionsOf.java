package JavaAdvanced.L02MultidimensionalArays;

import java.util.Scanner;

public class P02PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int[][] matrix = new int[rows][cols];

        fillMatrix(scanner, matrix, rows, cols);

        int numberForSearching = Integer.parseInt(scanner.nextLine());;

        searchNumber(matrix, rows, cols, numberForSearching);

    }

    private static void searchNumber(int[][] matrix, int rows, int cols, int number) {
        boolean isFound = false;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if(matrix[row][col] == number){
                    isFound = true;
                    System.out.printf("%d %d\n", row, col);
                }
            }
        }
        if(!isFound){
            System.out.println("not found");
        }
    }

    public static void fillMatrix(Scanner scanner, int[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(input[col]);
            }
        }
    }
}
