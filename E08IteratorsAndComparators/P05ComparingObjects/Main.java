package JavaAdvanced.E08IteratorsAndComparators.P05ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Person> personsList = new ArrayList<>();
        int peopleCount = 0;
        while (!input.equals("END")) {
            String name = input.split("\\s+")[0];
            int age = Integer.parseInt(input.split("\\s+")[1]);
            String town = input.split("\\s+")[2];

            Person person = new Person(name, age, town);
            personsList.add(person);
            peopleCount++;

            input = scanner.nextLine();
        }
        int n = Integer.parseInt(scanner.nextLine());
        int indexOfThePerson = n - 1;
        if(indexOfThePerson < 0 || indexOfThePerson > personsList.size() - 1){
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Person searchedPerson = personsList.get(indexOfThePerson);
        personsList.remove(searchedPerson);

        int equalPeopleCount = 0;
        for (Person person : personsList){
            if(person.compareTo(searchedPerson) == 0){
                equalPeopleCount++;
            }
        }

        if (equalPeopleCount == 0){
            System.out.println("No matches");
        }else {
            System.out.printf("%d %d %d", equalPeopleCount + 1, peopleCount - (equalPeopleCount + 1), peopleCount);
        }
    }
}
