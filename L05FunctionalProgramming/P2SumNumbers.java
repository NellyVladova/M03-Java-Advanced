package JavaAdvanced.L05FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P2SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        Function<String, Integer> parsingNumbers = Integer::parseInt;

        List<Integer> numbers = Arrays.stream(input).map(parsingNumbers).collect(Collectors.toList());
        System.out.println("Count = " + numbers.size());

        int sum = Arrays.stream(input).mapToInt(Integer::parseInt).sum();
        System.out.println("Sum = " + sum);
    }
}
