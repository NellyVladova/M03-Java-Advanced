package JavaAdvanced.L05FunctionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class P06FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int lowerBound = Integer.parseInt(input[0]);
        int upperBound = Integer.parseInt(input[1]);
        String evenOrOdd = scanner.nextLine();
        List<Integer> numbers = new ArrayList<>();

        Consumer<Integer> print = e -> System.out.print(e + " ");
        Predicate<Integer> findNumbers;

        if (evenOrOdd.equals("odd")) {
            findNumbers = e -> e % 2 != 0;
        } else {
            findNumbers = e -> e % 2 == 0;
        }
        for (int i = lowerBound; i <= upperBound; i++) {
            numbers.add(i);
        }
        numbers.stream().filter(findNumbers).forEach(print);
    }
}
