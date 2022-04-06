package JavaAdvanced.E06DefiningClasses.P03SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelForOneKm;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelForOneKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelForOneKm = fuelForOneKm;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public boolean canDriveThisDistance(int distance) {
        if (fuelForOneKm * distance <= fuelAmount) {
            this.fuelAmount -= this.fuelForOneKm * distance;
            this.distanceTraveled += distance;
            return true;
        }
        return false;
    }

//    @Override
//    public String toString(){
//        return model + String.format(" %.2f", fuelAmount) + " " + distanceTraveled;
//    }
}
