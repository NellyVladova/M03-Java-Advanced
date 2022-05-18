package JavaAdvanced.L05FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class P4AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        Function<String, Double> parser = Double::parseDouble;
        UnaryOperator<Double> priceWithVAT = price -> price * 1.2;
        Consumer<Double> print = e -> System.out.printf("%.2f\n", e);

        System.out.println("Prices with VAT:");
        Arrays.stream(input).map(parser).map(priceWithVAT).forEach(print);
    }
}
