package JavaAdvanced.E08IteratorsAndComparators.P06StrategyPattern;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> personsList = new ArrayList<>();
        Set<Person> sortedByName = new TreeSet<>(new NameComparator());
        Set<Person> sortedByAge = new TreeSet<>(new AgeComparator());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String name = input.split("\\s+")[0];
            int age = Integer.parseInt(input.split("\\s+")[1]);
            Person person = new Person(name, age);
            personsList.add(person);
        }
        sortedByName.addAll(personsList);
        sortedByAge.addAll(personsList);

        for (Person person : sortedByName){
            System.out.println(person);
        }
        for (Person person : sortedByAge){
            System.out.println(person);
        }
    }
}
