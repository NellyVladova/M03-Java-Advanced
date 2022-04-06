package JavaAdvanced.E06DefiningClasses.P03SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Car> carsList = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] carInfo = scanner.nextLine().split("\\s+");
            double fuel = Double.parseDouble(carInfo[1]);
            double fuelForOneKm = Double.parseDouble(carInfo[2]);
            Car newCar = new Car(carInfo[0], fuel, fuelForOneKm);
            carsList.put(newCar.getModel(), newCar);
        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] commandParts = command.split("\\s+");
            String carModel = commandParts[1];
            int amountOfKm = Integer.parseInt(commandParts[2]);
            boolean canMove = false;
            if (carsList.containsKey(carModel)) {
                canMove = carsList.get(carModel).canDriveThisDistance(amountOfKm);
            }
            if(!canMove){
                System.out.println("Insufficient fuel for the drive");
            }

            command = scanner.nextLine();
        }
        carsList.forEach((key, value) -> System.out.println(key + String.format(" %.2f ", value.getFuelAmount()) + value.getDistanceTraveled()));

//        for (Map.Entry<String, Car> car : carsList.entrySet()){
//            System.out.println(car);
//        }
    }
}
