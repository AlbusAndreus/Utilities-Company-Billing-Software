package sample;

public class MonthlyBill {

    Client client;
    double electricityTotal;
    double gasTotal;
    double waterTotal;
    double sewageTotal;
    double grandTotal;

    public MonthlyBill(Client client, double electricityTotal, double gasTotal, double waterTotal, double sewageTotal){

        this.client = client;
        this.electricityTotal = electricityTotal;
        this.gasTotal = gasTotal;
        this.waterTotal = waterTotal;
        this.sewageTotal = sewageTotal;
        grandTotal = gasTotal + electricityTotal + waterTotal + sewageTotal;
    }

}
