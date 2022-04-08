package JavaAdvanced.AdvancedExams.E20February2021;

import java.util.Scanner;

public class P02Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];
        String[] commands = scanner.nextLine().split(",");
        int sapperRow = 0;
        int sapperCol = 0;
        int bombCounter = 0;
        boolean endOfTheGame = false;
        boolean allBombsFound = false;

        fillMatrix(scanner, matrix, size);

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(matrix[row][col].equals("s")){
                    sapperRow = row;
                    sapperCol = col;
                }
            }
        }
        int allBombsInTheField = findAllBombs(matrix, size);

        matrix[sapperRow][sapperCol] = "+";
        for (int i = 0; i < commands.length; i++) {
            String direction = commands[i];
            switch (direction){
                case "up":
                    sapperRow--;
                    break;
                case "down":
                    sapperRow++;
                    break;
                case "left":
                    sapperCol--;
                    break;
                case "right":
                    sapperCol++;
                    break;
            }

            if(sapperRow >= 0 && sapperRow < size && sapperCol >= 0 && sapperCol < size){
                if(matrix[sapperRow][sapperCol].equals("e")){
                    endOfTheGame = true;
                }else if (matrix[sapperRow][sapperCol].equals("B")){
                    bombCounter++;
                    matrix[sapperRow][sapperCol] = "+";
                    System.out.println("You found a bomb!");
                }
            }else {
                switch (direction){
                    case "up":
                        sapperRow++;
                        break;
                    case "down":
                        sapperRow--;
                        break;
                    case "left":
                        sapperCol++;
                        break;
                    case "right":
                        sapperCol--;
                        break;
                }
            }

            if(bombCounter == allBombsInTheField){
                allBombsFound = true;
            }
            if(endOfTheGame || allBombsFound){
                break;
            }
        }
        if(allBombsFound){
            System.out.println("Congratulations! You found all bombs!");
        }
        if(endOfTheGame){
            System.out.printf("END! %d bombs left on the field\n", allBombsInTheField - bombCounter);
        }
        if(!allBombsFound && !endOfTheGame){
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", allBombsInTheField - bombCounter, sapperRow, sapperCol);
        }

    }

    private static int findAllBombs(String[][] matrix, int size) {
        int bombCount = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(matrix[row][col].equals("B")){
                    bombCount++;
                }
            }
        }
        return bombCount;
    }

    private static void printMatrix(String[][] presentsMatrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(presentsMatrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scanner, String[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int col = 0; col < size; col++) {
                matrix[row][col] = input[col];
            }
        }
    }
}
