package sample;

import java.util.Comparator;

public class ElectricityComparator implements Comparator<Client> {
    @Override
    public int compare(Client a, Client b){
        if (a.getNumElectricityUnitsThisMonth() < b.getNumElectricityUnitsThisMonth()) return -1;
        if(a.getNumElectricityUnitsThisMonth() > b.getNumElectricityUnitsThisMonth()) return 1;
        return 0;
    }
}
