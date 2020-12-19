package sample;

public class Company {
    static double electricityRate;
    static double gasRate;
    static double waterRate;
    static double septicDrainageRate;

    public Company(){

    }
    public Company(double electricityRate, double gasRate, double waterRate){
        this.electricityRate = electricityRate;
        this.gasRate = gasRate;
        this.waterRate = waterRate;
    }

    public static double getElectricityRate() {
        return electricityRate;
    }

    public void setElectricityRate(double electricityRate) {
        this.electricityRate = electricityRate;
    }

    public static double getGasRate() {
        return gasRate;
    }

    public void setGasRate(double gasRate) {
        this.gasRate = gasRate;
    }

    public static double getWaterRate() {
        return waterRate;
    }

    public void setWaterRate(double waterRate) {
        this.waterRate = waterRate;
    }

    public static double getSepticDrainageRate(){
        return septicDrainageRate;
    }

    public void setSepticDrainageRate(double septicDrainageRate){
        this.septicDrainageRate = septicDrainageRate;
    }
}
