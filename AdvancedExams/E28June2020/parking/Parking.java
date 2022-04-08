package JavaAdvanced.AdvancedExams.E28June2020.parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car){
        if(data.size()< capacity){
            data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model){
        for(Car car : data){
            if(car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)){
                data.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar(){
        Car latestCar = null;

        for (Car car : this.data) {
            if (latestCar == null || latestCar.getYear() < car.getYear()) {
                latestCar = car;
            }
        }

        return latestCar;
    }

    public Car getCar(String manufacturer, String model){
        for (Car car : this.data){
            if(car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)){
                return car;
            }
        }
        return null;
    }

    public int getCount(){
        return data.size();
    }

    public String getStatistics(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The cars are parked in ").append(this.type).append(":\n");
        for (Car car : this.data){
            stringBuilder.append(car.toString()).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}

