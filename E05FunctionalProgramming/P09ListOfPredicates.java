package JavaAdvanced.E05FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class P09ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        BiFunction<Integer, List<Integer>, Boolean> isDivisible = ((num, list) -> {
            for (int numberInList : list) {
                if (num % numberInList != 0) {
                    return false;
                }
            }
            return true;
        });

        for (int i = 1; i <= number; i++) {
            if (isDivisible.apply(i, numbersList)) {
                System.out.print(i + " ");
            }
        }
    }
}
