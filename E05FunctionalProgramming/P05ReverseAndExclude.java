package JavaAdvanced.E05FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listWithNumbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int number = Integer.parseInt(scanner.nextLine());
        Collections.reverse(listWithNumbers);
        Predicate<Integer> division = num -> num % number == 0;
        listWithNumbers.removeIf(division);
        listWithNumbers.forEach(num -> System.out.print(num + " "));
    }
}
