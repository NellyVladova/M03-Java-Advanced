package JavaAdvanced.L05FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P1SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        List<String> evenNumbers = Arrays.stream(input).map(Integer::parseInt)
                .filter(el -> el % 2 == 0)
                .map(Object::toString)
                .collect(Collectors.toList());

        System.out.print(String.join(", ", evenNumbers));
        System.out.println();
        evenNumbers = evenNumbers.stream().map(Integer::parseInt).sorted()
                .map(Object::toString).collect(Collectors.toList());
        System.out.print(String.join(", ", evenNumbers));
    }
}
