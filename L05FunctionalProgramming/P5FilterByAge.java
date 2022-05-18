package JavaAdvanced.L05FunctionalProgramming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class P5FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> personsInfo = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputLine = scanner.nextLine().split(", ");
            personsInfo.put(inputLine[0], Integer.parseInt(inputLine[1]));
        }
        String olderOrYounger = scanner.nextLine();
        int limitAge = Integer.parseInt(scanner.nextLine());
        String outputInfo = scanner.nextLine();

        BiPredicate<Integer, Integer> ageFilter;
        if(olderOrYounger.equals("older")){
            ageFilter = (personAge, age) -> personAge >= age;
        }else {
            ageFilter = (personAge, age) -> personAge <= age;
        }
        Consumer<Map.Entry<String, Integer>> printType;
        if(outputInfo.equals("name")){
            printType = e -> System.out.println(e.getKey());
        }else if(outputInfo.equals("age")){
            printType = e -> System.out.println(e.getValue());
        }else {
            printType = e -> System.out.println(e.getKey() + " - " + e.getValue());
        }

        personsInfo.entrySet().stream()
                .filter(person -> ageFilter.test(person.getValue(), limitAge))
                .forEach(printType);
    }
}
