package JavaAdvanced.L05FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P3CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> upperWords = e -> Character.isUpperCase(e.charAt(0));
        Consumer<String> print = System.out::println;
        List<String> uppercaseWords = Arrays.stream(scanner.nextLine().split("\\s+"))
                            .filter(upperWords).collect(Collectors.toList());

        System.out.println(uppercaseWords.size());
        uppercaseWords.forEach(print);
    }
}
