package sample;

import java.util.Comparator;

public class SepticDrainageComparator implements Comparator<Client> {
    @Override
    public int compare(Client a, Client b){
        return a.getNumSepticDrainagesThisMonth() - b.getNumSepticDrainagesThisMonth();
    }
}
