package JavaAdvanced.AdvancedExams.E19February2022;

import java.util.Scanner;

public class P02PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = 8;
        String[][] matrix = new String[size][size];
        int whiteRow = 0;
        int whiteCol = 0;
        int blackRow = 0;
        int blackCol = 0;
        boolean whiteIsQueen = false;
        boolean blackIsQueen = false;
        boolean whiteCaptured = false;
        boolean blackCaptured = false;

        fillMatrix(scanner, matrix, size);

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col].equals("w")) {
                    whiteRow = row;
                    whiteCol = col;
                }
                if (matrix[row][col].equals("b")) {
                    blackRow = row;
                    blackCol = col;
                }
            }
        }

        while (true) {
            if (whiteRow - 1 == blackRow && whiteCol + 1 == blackCol) {
                matrix[blackRow][blackCol] = "-";
                whiteRow = blackRow;
                whiteCol = blackCol;
                whiteCaptured = true;
                break;
            }
            if (whiteRow - 1 == blackRow && whiteCol - 1 == blackCol) {
                matrix[blackRow][blackCol] = "-";
                whiteRow = blackRow;
                whiteCol = blackCol;
                whiteCaptured = true;
                break;
            }
            if(whiteRow - 1 >= 0){
                whiteRow--;
            }
            if (blackRow + 1 == whiteRow && blackCol + 1 == whiteCol) {
                matrix[whiteRow][whiteCol] = "-";
                blackRow = whiteRow;
                blackCol = whiteCol;
                blackCaptured = true;
                break;
            }
            if (blackRow + 1 == whiteRow && blackCol - 1 == whiteCol) {
                matrix[whiteRow][whiteCol] = "-";
                blackRow = whiteRow;
                blackCol = whiteCol;
                blackCaptured = true;
                break;
            }
            if(blackRow + 1 < size){
                blackRow++;
            }
            if(whiteRow == 0){
                whiteIsQueen = true;
                break;
            }
            if(blackRow == size - 1){
                blackIsQueen = true;
                break;
            }
        }
        if(whiteIsQueen) {
            String whitePosition = getPosition(matrix, whiteRow, whiteCol);
            System.out.printf("Game over! White pawn is promoted to a queen at %s.\n", whitePosition);
        }
        if(blackIsQueen) {
            String blackPosition = getPosition(matrix, blackRow, blackCol);
            System.out.printf("Game over! Black pawn is promoted to a queen at %s.\n", blackPosition);
        }
        if(whiteCaptured){
            String whitePosition = getPosition(matrix, whiteRow, whiteCol);
            System.out.printf("Game over! White capture on %s.\n", whitePosition);
        }
        if(blackCaptured){
            String blackPosition = getPosition(matrix, whiteRow, whiteCol);
            System.out.printf("Game over! Black capture on %s.\n", blackPosition);
        }
    }

    private static String getPosition(String[][] matrix, int row, int col) {
        int realRow = 0;
        char realCol = ' ';
        String position = "";
        switch (row){
            case 0:
                realRow = 8;
                break;
            case 1:
                realRow = 7;
                break;
            case 2:
                realRow = 6;
                break;
            case 3:
                realRow = 5;
                break;
            case 4:
                realRow = 4;
                break;
            case 5:
                realRow = 3;
                break;
            case 6:
                realRow = 2;
                break;
            case 7:
                realRow = 1;
                break;
        }
        switch (col){
            case 0:
                realCol = 'a';
                break;
            case 1:
                realCol = 'b';
                break;
            case 2:
                realCol = 'c';
                break;
            case 3:
                realCol = 'd';
                break;
            case 4:
                realCol = 'e';
                break;
            case 5:
                realCol = 'f';
                break;
            case 6:
                realCol = 'g';
                break;
            case 7:
                realCol = 'h';
                break;
        }
        position = realCol + String.valueOf(realRow);
        return position;
    }

    private static void fillMatrix(Scanner scanner, String[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            String[] input = scanner.nextLine().split("");
            for (int col = 0; col < size; col++) {
                matrix[row][col] = input[col];
            }
        }
    }
}

