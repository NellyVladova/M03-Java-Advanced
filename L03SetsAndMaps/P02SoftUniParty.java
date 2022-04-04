package JavaAdvanced.L03SetsAndMaps;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Set<String> VIPGuests = new TreeSet<>();
        Set<String> regularGuests = new TreeSet<>();


        while (!input.equals("PARTY")) {
            if (input.charAt(0) < 48 || input.charAt(0) > 57) {
                //regular guest
                regularGuests.add(input);
            } else {
                //vip
                VIPGuests.add(input);
            }
            input = scanner.nextLine();
        }
        while (!input.equals("END")) {
            input = scanner.nextLine();
            if (VIPGuests.contains(input)) {
                VIPGuests.remove(input);
            } else regularGuests.remove(input);
        }
        int absentGuests = VIPGuests.size() + regularGuests.size();
        System.out.println(absentGuests);
        for (String guest : VIPGuests) {
            System.out.println(guest);
        }
        for (String guest : regularGuests) {
            System.out.println(guest);
        }
    }
}
