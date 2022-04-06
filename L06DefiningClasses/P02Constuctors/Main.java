package JavaAdvanced.L06DefiningClasses.P02Constuctors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Car car;
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            if(input.length == 1){
                car = new Car(input[0]);
            }else {
                car = new Car(input[0], input[1], Integer.parseInt(input[2]));
            }
            car.printCarInfo();
        }
    }
}
