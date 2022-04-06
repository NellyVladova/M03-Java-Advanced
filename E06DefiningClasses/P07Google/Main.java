package JavaAdvanced.E06DefiningClasses.P07Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Person> personsData = new HashMap<>();
        while (!input.equals("End")) {
            String[] infoParts = input.split("\\s+");
            String personName = infoParts[0];
            String secondElement = infoParts[1];
            if (!personsData.containsKey(personName)) {
                personsData.put(personName, new Person());
            }
            switch (secondElement){
                case "company":
                    String companyName = infoParts[2];
                    String department = infoParts[3];
                    double salary = Double.parseDouble(infoParts[4]);
                    Company company = new Company(companyName, department, salary);
                    personsData.get(personName).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = infoParts[2];
                    String pokemonType = infoParts[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    personsData.get(personName).getPokemonList().add(pokemon);
                        break;
                case "parents":
                    String parentName = infoParts[2];
                    String parentBirthday = infoParts[3];
                    Parent parent = new Parent(parentName, parentBirthday);
                    personsData.get(personName).getParentList().add(parent);
                    break;
                case "children":
                    String childrenName = infoParts[2];
                    String childrenBirthday = infoParts[3];
                    Children children = new Children(childrenName, childrenBirthday);
                    personsData.get(personName).getChildrenList().add(children);
                    break;
                case "car":
                    String carModel = infoParts[2];
                    int carSpeed = Integer.parseInt(infoParts[3]);
                    Car car = new Car(carModel, carSpeed);
                    personsData.get(personName).setCar(car);
                    break;
            }

            input = scanner.nextLine();
        }
        String name = scanner.nextLine();
        System.out.println(name);
        Person infoOfThePerson = personsData.get(name);
        System.out.println(infoOfThePerson);
    }
}
