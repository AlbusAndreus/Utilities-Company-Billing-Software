package sample;

import java.util.Comparator;

public class TotalCostComparator implements Comparator<Client> {
    public int compare(Client a, Client b){
        if(a.getTotalCost() < b.getTotalCost()) return -1;
        if(a.getTotalCost() > b.getTotalCost()) return 1;
        return 0;
    }
}
