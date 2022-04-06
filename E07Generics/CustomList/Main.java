package JavaAdvanced.E07Generics.CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> newCustomList = new CustomList<String>();

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String command = input.split("\\s+")[0];
            switch (command){
                case "Add":
                    String toAdd = input.split("\\s+")[1];
                    newCustomList.add(toAdd);
                    break;
                case "Remove":
                    int toRemoveIndex = Integer.parseInt(input.split("\\s+")[1]);
                    newCustomList.remove(toRemoveIndex);
                    break;
                case "Contains":
                    String searchedString = input.split("\\s+")[1];
                    System.out.println(newCustomList.contains(searchedString));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(input.split("\\s+")[1]);
                    int secondIndex = Integer.parseInt(input.split("\\s+")[2]);
                    newCustomList.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    String stringForChecking = input.split("\\s+")[1];
                    System.out.println(newCustomList.countGreaterThan(stringForChecking));
                    break;
                case "Max":
                    System.out.println(newCustomList.getMax());
                    break;
                case "Min":
                    System.out.println(newCustomList.getMin());
                    break;
                case "Print":
                    newCustomList.print();
                    break;
                case "Sort":
                    newCustomList.sort();
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
