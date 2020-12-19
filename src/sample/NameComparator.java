package sample;

import java.util.Comparator;

public class NameComparator implements Comparator<Client> {

    public int compare (Client a, Client b){
        return a.getName().compareTo(b.getName());
    }
}
