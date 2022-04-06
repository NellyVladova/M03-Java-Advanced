package JavaAdvanced.E06DefiningClasses.P05CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Engine> enginesList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] inputForEngine = scanner.nextLine().split("\\s+");
            String engineModel = inputForEngine[0];
            int enginePower = Integer.parseInt(inputForEngine[1]);
            Engine engine = null;

            if(inputForEngine.length == 4) {
                int engineDisplacement = Integer.parseInt(inputForEngine[2]);
                String engineEfficiency = inputForEngine[3];
                engine = new Engine(engineModel, enginePower, engineDisplacement, engineEfficiency);
            }else if(inputForEngine.length == 3){
                try {
                    int displacement = Integer.parseInt(inputForEngine[2]);
                    engine = new Engine(engineModel, enginePower, displacement);
                }catch (NumberFormatException exception){
                    String efficiency = inputForEngine[2];
                    engine = new Engine(engineModel, enginePower, efficiency);
                }
            }else {
                engine = new Engine(engineModel, enginePower);
            }
            enginesList.add(engine);
        }

        int m = Integer.parseInt(scanner.nextLine());
        List<Car> carsList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] carInfo = scanner.nextLine().split("\\s+");
            String carModel = carInfo[0];
            String engineModel = carInfo[1];
            Car car = null;

            if(carInfo.length == 4) {
                int weight = Integer.parseInt(carInfo[2]);
                String color = carInfo[3];
                car = new Car(carModel, engineModel, weight, color);
            }else if(carInfo.length == 3){
                try {
                    int weight = Integer.parseInt(carInfo[2]);
                    car = new Car(carModel, engineModel, weight);
                }catch (NumberFormatException exception){
                    String color = carInfo[2];
                    car = new Car(carModel, engineModel, color);
                }
            }else {
                car = new Car(carModel, engineModel);
            }
            carsList.add(car);
        }

        for (Car car : carsList){
            System.out.println(car.getModel() + ":");
            System.out.println(car.getEngine() + ":");
            enginesList.forEach(engine -> {
                if(engine.getEngineModel().equals(car.getEngine())){
                    System.out.println(engine.toString());
                }
            });
            if(car.getWeight() == 0){
                System.out.println("Weight: n/a");
            }else {
                System.out.println("Weight: " + car.getWeight());
            }
            System.out.println("Color: " + car.getColor());
        }
    }
}
