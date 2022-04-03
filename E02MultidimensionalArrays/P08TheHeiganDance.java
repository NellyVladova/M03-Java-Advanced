package JavaAdvanced.E02MultidimensionalArrays;

import java.util.Scanner;

public class P08TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // to be continued..............
        double damage = Double.parseDouble(scanner.nextLine());
        int[][] matrix = new int[15][15];
        int startRow = 7;
        int startCol = 7;
        int heroHP = 18500;
        int heiganHP = 3000000;


        while (true){
            String[] commandParts = scanner.nextLine().split("\\s+");
            String spell = commandParts[0];
            int row = Integer.parseInt(commandParts[1]);
            int col = Integer.parseInt(commandParts[2]);

            if(spell.equals("Cloud")){

            } else if (spell.equals("Eruption")) {

            }

        }
    }
}
