package JavaAdvanced.AdvancedExams.E17Dec2019;

import java.util.Scanner;

public class P2PresentDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            //50/100
        int presentsCount = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());
        String[][] presentsMatrix = new String[size][size];
        int santaRow = 0;
        int santaCol = 0;
        boolean santaIsOut = false;
        boolean noMorePresents = false;

        fillMatrix(scanner, presentsMatrix, size);

        for (int row = 0; row < size; row++) {//get santa's position
            for (int col = 0; col < size; col++) {
                if (presentsMatrix[row][col].equals("S")) {
                    santaRow = row;
                    santaCol = col;
                }
            }
        }
        int goodChildrenInStart = findGoodChildren(presentsMatrix, size);
        String direction = scanner.nextLine();
        presentsMatrix[santaRow][santaCol] = "-";
        while (!direction.equals("Christmas morning")) {
            switch (direction) {
                case "up":
                    santaRow--;
                    break;
                case "down":
                    santaRow++;
                    break;
                case "left":
                    santaCol--;
                    break;
                case "right":
                    santaCol++;
                    break;
            }
            if (santaRow >= 0 && santaRow < size && santaCol >= 0 && santaCol < size) {
                if (presentsMatrix[santaRow][santaCol].equals("V")) {
                    //good child
                    if (presentsCount > 0) {
                        presentsMatrix[santaRow][santaCol] = "-";
                        presentsCount--;
                    } else {
                        noMorePresents = true;
                    }
                } else if (presentsMatrix[santaRow][santaCol].equals("X")) {
                    //bad child
                    presentsMatrix[santaRow][santaCol] = "-";
                } else if (presentsMatrix[santaRow][santaCol].equals("C")) {
                    //cookie
                    presentsMatrix[santaRow][santaCol] = "-";
                    if (presentsCount >= 4) {
                        if (santaRow - 1 >= 0 && !presentsMatrix[santaRow - 1][santaCol].equals("-")) {
                            presentsMatrix[santaRow - 1][santaCol] = "-";
                            presentsCount--;
                        }else {
                            santaIsOut = true;
                        }
                        if (santaRow + 1 < size && !presentsMatrix[santaRow + 1][santaCol].equals("-")) {
                            presentsMatrix[santaRow + 1][santaCol] = "-";
                            presentsCount--;
                        }else {
                            santaIsOut = true;
                        }
                        if (santaCol -1 >= 0 && !presentsMatrix[santaRow][santaCol - 1].equals("-")) {
                            presentsMatrix[santaRow][santaCol - 1] = "-";
                            presentsCount--;
                        }else {
                            santaIsOut = true;
                        }
                        if (santaCol + 1 < size && !presentsMatrix[santaRow][santaCol + 1].equals("-")) {
                            presentsMatrix[santaRow][santaCol + 1] = "-";
                            presentsCount--;
                        }else {
                            santaIsOut = true;
                        }
                    } else {
                        noMorePresents = true;
                    }
                }
            }else {
                santaIsOut = true;
            }
            if (santaIsOut) {
                break;
            }
            if (presentsCount == 0) {
                noMorePresents = true;
            }
            if (noMorePresents) {
                break;
            }
            direction = scanner.nextLine();
        }
        presentsMatrix[santaRow][santaCol] = "S";
        int goodChildrenInEnd = findGoodChildren(presentsMatrix, size);
        if (santaIsOut || noMorePresents) {
            System.out.println("Santa ran out of presents!");
        }
        printMatrix(presentsMatrix, size);
        if (noMorePresents) {
            System.out.printf("No presents for %d nice kid/s.\n", goodChildrenInEnd);
        } else {
            System.out.printf("Good job, Santa! %d happy nice kid/s.\n", goodChildrenInStart);
        }
    }

    private static int findGoodChildren(String[][] presentsMatrix, int size) {
        int goodChildrenCounter = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (presentsMatrix[row][col].equals("V")) {
                    goodChildrenCounter++;
                }
            }
        }
        return goodChildrenCounter;
    }

    private static void printMatrix(String[][] presentsMatrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(presentsMatrix[row][col] + " ");
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
