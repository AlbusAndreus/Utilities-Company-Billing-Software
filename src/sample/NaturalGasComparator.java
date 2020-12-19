package sample;

import java.util.Comparator;

public class NaturalGasComparator implements Comparator<Client> {
    public int compare(Client a, Client b){
        if(a.getNumNaturalGasUnitsThisMonth() < b.getNumNaturalGasUnitsThisMonth()) return -1;
        if(a.getNumNaturalGasUnitsThisMonth() > b.getNumNaturalGasUnitsThisMonth()) return 1;
        return 0;
    }

}
