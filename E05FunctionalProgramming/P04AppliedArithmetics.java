package JavaAdvanced.E05FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P04AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listWithNumbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();
        Function<List<Integer>, List<Integer>> add = list -> list.stream().map(num -> num += 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> multiply = list -> list.stream().map(num -> num *= 2).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> subtract = list -> list.stream().map(num -> num -= 1).collect(Collectors.toList());
        Consumer<List<Integer>> printNumbers = list -> list.forEach(num -> System.out.print(num + " "));

        while (!command.equals("end")) {
            switch (command) {
                case "add":
                    listWithNumbers = add.apply(listWithNumbers);
                    break;
                case "multiply":
                    listWithNumbers = multiply.apply(listWithNumbers);
                    break;
                case "subtract":
                    listWithNumbers = subtract.apply(listWithNumbers);
                    break;
                case "print":
                    printNumbers.accept(listWithNumbers);
                    System.out.println();
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
