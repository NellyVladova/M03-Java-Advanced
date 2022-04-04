package JavaAdvanced.L03SetsAndMaps;

import java.util.*;

public class P07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, LinkedHashMap<String, List<String>>> destinations = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            destinations.putIfAbsent(continent, new LinkedHashMap<>());
            destinations.get(continent).putIfAbsent(country, new ArrayList<>());
            destinations.get(continent).get(country).add(city);
        }

        destinations.forEach((continent, countries) -> {
            System.out.println(continent + ":");
            countries.forEach((country, cities) -> {
                System.out.printf("  %s -> %s\n", country, String.join(", ", cities));
            });
        });
    }
}
