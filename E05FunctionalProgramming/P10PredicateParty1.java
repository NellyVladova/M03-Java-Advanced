package JavaAdvanced.E05FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P10PredicateParty1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guestsNames = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("Party!")) {
            Predicate<String> predicate = null;
            String[] inputParts = input.split("\\s+");
            String command = inputParts[0];
            String option = inputParts[1];
            String criteria = inputParts[2];

            if (option.equals("StartsWith")) {
                predicate = x -> x.startsWith(criteria);
            } else if (option.equals("EndsWith")) {
                predicate = x -> x.endsWith(criteria);
            } else if (option.equals("Length")) {
                predicate = x -> x.length() == Integer.parseInt(criteria);
            }else {
                //contains
            }
            if (command.equals("Double")) {
                List<String> toPut = new ArrayList<>();
                for (String guest : guestsNames) {
                    if (predicate.test(guest)) {
                        toPut.add(guest);
                    }
                }
                guestsNames.addAll(toPut);
            } else if (command.equals("Remove")) {
                List<String> toRemove = new ArrayList<>();
                for (String guest : guestsNames) {
                    if (predicate.test(guest)) {
                        toRemove.add(guest);
                    }
                }
                guestsNames.removeAll(toRemove);
            }
            input = scanner.nextLine();
        }
        if (guestsNames.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            List<String> newGuestList = guestsNames.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
            System.out.println(String.join(", ", newGuestList) + " are going to the party!");
        }
    }
}
