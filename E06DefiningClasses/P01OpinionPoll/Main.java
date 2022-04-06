package JavaAdvanced.E06DefiningClasses.P01OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> over30 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            Person person = new Person(name, age);
            if(person.getAge() > 30){
                over30.add(person);
            }
        }
        over30.sort(Comparator.comparing(Person::getName));
        for (Person person : over30){
            person.printPerson();
        }
    }
}
