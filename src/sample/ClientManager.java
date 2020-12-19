package sample;

import java.util.ArrayList;
import java.util.Collections;

public class ClientManager {
    ArrayList<Client> clients = new ArrayList<>();

    public ArrayList<Client> getClients(){
        return clients;
    }

    public boolean addClient(Client client){
        if(!clients.contains(client)){
            clients.add(client);
            return true;
        }
        return false;
    }

    public boolean removeClientByName(String name){
        for(int i = 0; i < clients.size(); i++){
            if(clients.get(i).getName().equals(name)){
                clients.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean removeClientByPosition(int position){
        if(position > -1 && position <= clients.size()) {
            clients.remove(position);
            return true;
        }
        return false;
    }

    public double getAllElectricityTotal(){
        double total = 0;
        for(Client client : clients){
            total += client.getCostOfElectricity();
        }
        return total;
    }
    public double getAllNaturalGasTotal(){
        double total = 0;
        for(Client client: clients){
            total +=client.getCostOfGas();
        }
        return total;
    }
    public double getAllWaterTotal(){
        double total = 0;
        for(Client client: clients){
            total += client.getCostOfWater();
        }
        return total;
    }
    public double getAllSewageTotal(){
        double total = 0;
        for(Client client: clients){
            total += client.getCostOfSewage();
        }
        return total;
    }
    public double getTotal(){
        double total = 0;
        for(Client client : clients){
            total+=client.getTotalCost();
        }
        return total;
    }
    public void sortByName(){
        //NameComparator nameComparator = new NameComparator();
        //Collections.sort(new NameComparator(), clients);
    }
}
