package JavaAdvanced.E06DefiningClasses.P05CarSalesman;

public class Engine {
    private String engineModel; //+
    private int power; //+
    private int displacement;
    private String efficiency;

    public Engine(String engineModel, int power) {
        this.engineModel = engineModel;
        this.power = power;
        this.displacement = 0;
        this.efficiency = "n/a";
    }

    public Engine(String engineModel, int power, int displacement) {
        this.engineModel = engineModel;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = "n/a";
    }

    public Engine(String engineModel, int power, String efficiency) {
        this.engineModel = engineModel;
        this.power = power;
        this.efficiency = efficiency;
        this.displacement = 0;
    }

    public Engine(String engineModel, int power, int displacement, String efficiency) {
        this.engineModel = engineModel;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getEngineModel() {
        return this.engineModel;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Power: " + this.power + "\n");
        if(this.displacement == 0){
            sb.append("Displacement: n/a\n");
        }else {
            sb.append("Displacement: " + this.displacement + "\n");
        }
        sb.append("Efficiency: " + this.efficiency);
        return sb.toString();
    }
}
