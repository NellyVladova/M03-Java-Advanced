package JavaAdvanced.E02MultidimensionalArrays;

import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        String[][] matrix = new String[rows][cols];

        fillMatrix(scanner, matrix, rows, cols);

        String command = scanner.nextLine();
        while (!command.equals("END")){

            if(!validateCommand(command, rows, cols)){
                System.out.println("Invalid input!");
            }else {
                String[] commandParts = command.split("\\s+");
                int row1 = Integer.parseInt(commandParts[1]);
                int col1 = Integer.parseInt(commandParts[2]);
                int row2 = Integer.parseInt(commandParts[3]);
                int col2 = Integer.parseInt(commandParts[4]);

                String firstToSwap = matrix[row1][col1];
                String secondToSwap = matrix[row2][col2];

                matrix[row1][col1] = secondToSwap;
                matrix[row2][col2] = firstToSwap;

                printMatrix(matrix, rows, cols);

            }
            command = scanner.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean validateCommand(String command, int rows, int cols) {
        String[] comParts = command.split("\\s+");

        if(!comParts[0].equals("swap")){
            return false;
        }
        if (comParts.length != 5) {
            return false;
        }

        int r1 = Integer.parseInt(comParts[1]);
        int c1 = Integer.parseInt(comParts[2]);
        int r2 = Integer.parseInt(comParts[3]);
        int c2 = Integer.parseInt(comParts[4]);

        if(r1 < 0 || r1 >= rows || c1 < 0 || c1 >= cols || r2 < 0 || r2 >= rows || c2 < 0 || c2 >= cols){
            return false;
        }
        return true;
    }

    private static void fillMatrix(Scanner scanner, String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = input[col];
            }
        }
    }
}
