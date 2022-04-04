package JavaAdvanced.E03SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P07FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        Map<String, String> personsEmails = new LinkedHashMap<>();

        while (!name.equals("stop")) {
            String email = scanner.nextLine();
            if(!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")){
                personsEmails.put(name, email);
            }

            name = scanner.nextLine();
        }
        personsEmails.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        });
    }
}
