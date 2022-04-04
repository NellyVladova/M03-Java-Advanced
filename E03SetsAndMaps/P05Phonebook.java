package JavaAdvanced.E03SetsAndMaps;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, String> phoneBook = new TreeMap<>();

        while (!input.equals("search")) {
            String[] inputParts = input.split("-");
            String name = inputParts[0];
            String phoneNumber = inputParts[1];
            phoneBook.put(name, phoneNumber);

            input = scanner.nextLine();
        }
        String searching = scanner.nextLine();
        while (!searching.equals("stop")) {
            if(phoneBook.containsKey(searching)){
                System.out.printf("%s -> %s\n", searching, phoneBook.get(searching));
            }else {
                System.out.printf("Contact %s does not exist.\n", searching);
            }

            searching = scanner.nextLine();
        }
    }
}
