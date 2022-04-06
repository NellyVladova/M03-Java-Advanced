package JavaAdvanced.E06DefiningClasses.P04RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Car> carsList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] carInfo = scanner.nextLine().split("\\s+");
            String model = carInfo[0];
            int engineSpeed = Integer.parseInt(carInfo[1]);
            int enginePower = Integer.parseInt(carInfo[2]);
            int cargoWeight = Integer.parseInt(carInfo[3]);
            String cargoType = carInfo[4];
            double tire1Pressure = Double.parseDouble(carInfo[5]);
            int tire1Age = Integer.parseInt(carInfo[6]);
            double tire2Pressure = Double.parseDouble(carInfo[7]);
            int tire2Age = Integer.parseInt(carInfo[8]);
            double tire3Pressure = Double.parseDouble(carInfo[9]);
            int tire3Age = Integer.parseInt(carInfo[10]);
            double tire4Pressure = Double.parseDouble(carInfo[11]);
            int tire4Age = Integer.parseInt(carInfo[12]);
            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tires tires = new Tires(tire1Pressure, tire1Age, tire2Pressure, tire2Age, tire3Pressure, tire3Age, tire4Pressure, tire4Age);

            Car car = new Car(model, engine, cargo, tires);
            carsList.add(car);
        }
        String typeOfCargo = scanner.nextLine();
        for (int i = 0; i < carsList.size(); i++) {
            if(carsList.get(i).getCargo().getType().equals(typeOfCargo)){
                //fragile && tire pressure < 1
                if(typeOfCargo.equals("fragile") && (carsList.get(i).getTires().getTire1Pressure() < 1 ||
                        carsList.get(i).getTires().getTire2Pressure() < 1 ||
                        carsList.get(i).getTires().getTire3Pressure() < 1 ||
                        carsList.get(i).getTires().getTire4Pressure() < 1)){
                    System.out.println(carsList.get(i).getModel());

                }else if (typeOfCargo.equals("flamable") && carsList.get(i).getEngine().getPower() > 250){
                    //flamable && engine power > 250
                    System.out.println(carsList.get(i).getModel());
                }
            }
        }
    }
}
