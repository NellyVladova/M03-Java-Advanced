package JavaAdvanced.E03SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputParts = scanner.nextLine().split("\\s+");
        int linesForSetOne = Integer.parseInt(inputParts[0]);
        int linesForSetTwo = Integer.parseInt(inputParts[1]);
        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();
        Set<Integer> repeatingElements = new LinkedHashSet<>();

        for (int i = 0; i < linesForSetOne; i++) {
            int currNum = Integer.parseInt(scanner.nextLine());
            firstSet.add(currNum);
        }

        for (int i = 0; i < linesForSetTwo; i++) {
            int currNum = Integer.parseInt(scanner.nextLine());
            secondSet.add(currNum);
        }

        for (int number : firstSet){
            if(secondSet.contains(number)){
                repeatingElements.add(number);
            }
        }

        for (int element : repeatingElements){
            System.out.print(element + " ");
        }
    }
}
