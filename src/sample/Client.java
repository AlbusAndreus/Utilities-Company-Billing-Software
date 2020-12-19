package sample;

import java.util.ArrayList;

public class Client {
    String name;
    String address;
    String city;
    String state;
    int zip;
    String phoneNumber;
    String email;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhone(String phone) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    ArrayList<MonthlyBill> bills = new ArrayList<>();

    private double numElectricityUnitsThisMonth;
    private double numNaturalGasUnitsThisMonth;
    private double numWaterUnitsThisMonth;
    private int numSepticDrainagesThisMonth;

    private boolean armedForcesDiscount;

    public Client(){

    }

    public Client(String name, String address,String city, String state, int zip, String phoneNumber, String email, double numElectricityUnitsThisMonth, double numNatrualGasUnitsThisMonth, double numWaterUnitsThisMonth, int numSepticDrainagesThisMonth, boolean armedForcesDiscount){
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;

        this.phoneNumber = phoneNumber;
        this.email = email;



        this.numElectricityUnitsThisMonth = numElectricityUnitsThisMonth;
        this.numNaturalGasUnitsThisMonth = numNatrualGasUnitsThisMonth;
        this.numWaterUnitsThisMonth = numWaterUnitsThisMonth;
        this.numSepticDrainagesThisMonth = numSepticDrainagesThisMonth;
        this.armedForcesDiscount = armedForcesDiscount;
    }

    public boolean isArmedForcesDiscount() {
        return armedForcesDiscount;
    }

    public void setArmedForcesDiscount(boolean armedForcesDiscount) {
        this.armedForcesDiscount = armedForcesDiscount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public double getNumElectricityUnitsThisMonth() {
        return numElectricityUnitsThisMonth;
    }

    public void setNumElectricityUnitsThisMonth(int numElectricityUnitsThisMonth) {
        this.numElectricityUnitsThisMonth = numElectricityUnitsThisMonth;
    }

    public double getNumNaturalGasUnitsThisMonth() {
        return numNaturalGasUnitsThisMonth;
    }

    public void setNumNaturalGasUnitsThisMonth(int numNaturalGasUnitsThisMonth) {
        this.numNaturalGasUnitsThisMonth = numNaturalGasUnitsThisMonth;
    }

    public double getNumWaterUnitsThisMonth() {
        return numWaterUnitsThisMonth;
    }

    public void setNumWaterUnitsThisMonth(int numWaterUnitsThisMonth) {
        this.numWaterUnitsThisMonth = numWaterUnitsThisMonth;
    }

    public int getNumSepticDrainagesThisMonth() {
        return numSepticDrainagesThisMonth;
    }

    public void setNumSepticDrainagesThisMonth(int numSepticDrainagesThisMonth) {
        this.numSepticDrainagesThisMonth = numSepticDrainagesThisMonth;
    }
    public double getCostOfElectricity(){
        if(!armedForcesDiscount){
            return numElectricityUnitsThisMonth * Company.getElectricityRate();
        }
        return numElectricityUnitsThisMonth * Company.getElectricityRate() * 0.85;
    }
    public double getCostOfGas(){
        if(!armedForcesDiscount){
            return numNaturalGasUnitsThisMonth * Company.getGasRate();
        }
        return numNaturalGasUnitsThisMonth * Company.getGasRate() * 0.85;
    }
    public double getCostOfWater(){
        if(!armedForcesDiscount){
            return numWaterUnitsThisMonth * Company.getWaterRate();
        }
        return numWaterUnitsThisMonth * Company.getWaterRate() * 0.85;
    }
    public double getCostOfSewage(){
        if(!armedForcesDiscount){
            return numSepticDrainagesThisMonth * Company.getSepticDrainageRate();
        }
        return numSepticDrainagesThisMonth * Company.getSepticDrainageRate() * 0.85;
    }

    public double getTotalCost(){
        return getCostOfElectricity() + getCostOfGas() + getCostOfSewage() + getCostOfWater();
    }
}
