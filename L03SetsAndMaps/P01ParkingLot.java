package JavaAdvanced.L03SetsAndMaps;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> parkingLotSet = new LinkedHashSet<>();
        String input = scanner.nextLine();
        while (!input.equals("END")){
            String[] comParts = input.split(", ");
            String command = comParts[0];
            String carNumber = comParts[1];

            if(command.equals("IN")){
                parkingLotSet.add(carNumber);
            } else if (command.equals("OUT")) {
                parkingLotSet.remove(carNumber);
            }

            input = scanner.nextLine();
        }
        if(parkingLotSet.isEmpty()){
            System.out.println("Parking Lot is Empty");
            return;
        }
        for (String s : parkingLotSet) {
            System.out.println(s);
        }
    }
}
