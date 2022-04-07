package JavaAdvanced.E08IteratorsAndComparators.P04Froggy;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersOfTheLake = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();

        Lake lake = new Lake(numbersOfTheLake);
        StringBuilder sb = new StringBuilder();

        for (Integer number : lake) {
            sb.append(number).append(", ");
        }

        System.out.println(sb.substring(0, sb.length() - 2));
    }
}
