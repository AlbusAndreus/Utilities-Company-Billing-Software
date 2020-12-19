package sample;

import java.util.Comparator;

public class WaterComparator implements Comparator<Client> {
    public int compare(Client a, Client b){
        if(a.getNumWaterUnitsThisMonth() < b.getNumWaterUnitsThisMonth()) return -1;
        if(a.getNumWaterUnitsThisMonth() > b.getNumWaterUnitsThisMonth()) return 1;
        return 0;
    }
}
