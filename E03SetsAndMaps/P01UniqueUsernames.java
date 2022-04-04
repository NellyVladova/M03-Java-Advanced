package JavaAdvanced.E03SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> uniqueUsernames = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            uniqueUsernames.add(input);
        }
        for (String username : uniqueUsernames) {
            System.out.println(username);
        }
    }
}
