package JavaAdvanced.AdvancedExams.E20February2021.dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private List<Car> data;
    private String name;
    private int capacity;


    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car){
        if (getCount() < this.capacity) {
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model){
        for (Car car : this.data){
            if(car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)){
                this.data.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar(){
        Car latestCar = null;
        int latestYear = 0;
        for (Car car : this.data){
            if (car.getYear() > latestYear){
                latestYear = car.getYear();
                latestCar = car;
            }
        }
        return latestCar;
    }

    public Car getCar(String manufacturer, String model){
        Car carToReturn = null;
        for (Car car : this.data){
            if(car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)){
                carToReturn = car;
                break;
            }
        }
        return carToReturn;
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("The cars are in a car dealership %s:\n", this.name));
        for (Car car : this.data){
            stringBuilder.append(car.toString()).append(System.lineSeparator());
        }

        return stringBuilder.toString().trim();
    }
}
