package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Main extends Application {

    Stage primaryStage;
    public static Company theCompany = new Company();
    Label nameLabel;
    TextField nameField;

    Label addressLabel, cityLabel, stateLabel, zipLabel;
    TextField addressField, cityField, stateField, zipField;

    Label phoneLabel;
    TextField phoneField;

    Label emailLabel;
    TextField emailField;



    Label electricityUnitsUsedLabel;
    TextField electricityUnitsUsedField;

    Label naturalGasUnitsUsedLabel;
    TextField naturalGasUnitsUsedField;

    Label waterUnitsUsedLabel;
    TextField waterUnitsUsedField;

    Label numSepticDrainagesLabel;
    TextField numSepticDrainagesTextField;

    Button submit, calculateBill, updateAccountView, setCompanyRates, delete, saveToText, loadFromText, sortBy, calculateCompanyTotal;

    ChoiceBox<String> veterensDiscount;

    Label electricityPrice, waterPrice, naturalGasPrice, sewagePrice, totalCost;

    Label grandTotalElectricity, grandTotalWater, grandTotalNaturalGas, grandTotalSewage, grandTotal;

    ListView<String> accountView;

    public static ClientManager clientManager;
    ArrayList<String> clientList = new ArrayList<>();

    ArrayList<String> OptionsforComboBox = new ArrayList<>();
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Utility Billing Management System");

        GridPane gp = new GridPane();
        clientManager = new ClientManager();

        //sets up clientInfo Pane for name and address
        Pane clientInfo = new Pane();
        clientInfo.setPrefSize(300,400);
        clientInfo.setMaxSize(300,400);
        GridPane.setConstraints(clientInfo, 0,0);

        nameLabel = new Label("Name");
        nameLabel.relocate(50,50);

        nameField  = new TextField();
        nameField.relocate(100, 50);

        addressLabel = new Label("Address");
        addressLabel.relocate(50, 100);
        addressField = new TextField();
        addressField.relocate(100,100);

        cityLabel = new Label("City");
        cityLabel.relocate(50,150);

        cityField = new TextField();
        cityField.relocate(100,150);
        cityField.setMaxSize(65,20);

        stateLabel = new Label("State");
        stateLabel.relocate(165,150);

        stateField = new TextField();
        stateField.relocate(200,150);
        stateField.setMaxSize(65,20);

        zipLabel = new Label("Zip");
        zipLabel.relocate(50,200);

        zipField = new TextField();
        zipField.relocate(100,200);

        OptionsforComboBox.add("Veterens Discount");
        OptionsforComboBox.add("No Veterens Discount");
        veterensDiscount = new ChoiceBox<String>(FXCollections.observableArrayList(OptionsforComboBox));
        veterensDiscount.relocate( 100,0);

        phoneLabel = new Label("Phone");
        phoneLabel.relocate(50,250);

        phoneField = new TextField();
        phoneField.relocate(100,250);

        emailLabel = new Label("Email");
        emailLabel.relocate(50,300);

        emailField = new TextField();
        emailField.relocate(100,300);


        clientInfo.getChildren().addAll(veterensDiscount, nameLabel, nameField, addressField, addressLabel, phoneLabel, phoneField, emailLabel, emailField, cityField, cityLabel, stateLabel, stateField, zipLabel, zipField);

        Pane monthlyUsage = new Pane();
        monthlyUsage.setMaxSize(400,400);
        GridPane.setConstraints(monthlyUsage, 1,0);

        electricityUnitsUsedLabel = new Label("Electricity Units Used KW/H:");
        electricityUnitsUsedLabel.relocate(50,50);
        electricityUnitsUsedField = new TextField();
        electricityUnitsUsedField.relocate(220,50);

        naturalGasUnitsUsedLabel = new Label("Natural Gas Units Used Liters:");
        naturalGasUnitsUsedLabel.relocate(50,100);
        naturalGasUnitsUsedField = new TextField();
        naturalGasUnitsUsedField.relocate(220,100);

        waterUnitsUsedLabel = new Label("Water Units Used Liters:");
        waterUnitsUsedLabel.relocate(50,150);
        waterUnitsUsedField = new TextField();
        waterUnitsUsedField.relocate(220,150);

        numSepticDrainagesLabel = new Label("Number of Septic Drainages:");
        numSepticDrainagesLabel.relocate(50,200);
        numSepticDrainagesTextField = new TextField();
        numSepticDrainagesTextField.relocate(220,200);

        submit = new Button("Submit");
        submit.relocate(100,250);
        submit.setOnAction(new SubmitButtonHandler());



        monthlyUsage.getChildren().addAll(submit, numSepticDrainagesLabel, numSepticDrainagesTextField, electricityUnitsUsedField, electricityUnitsUsedLabel, naturalGasUnitsUsedField, naturalGasUnitsUsedLabel, waterUnitsUsedField, waterUnitsUsedLabel);

        Pane bill = new Pane();
        GridPane.setConstraints(bill, 2,0);

        electricityPrice = new Label("Electricity:");
        electricityPrice.relocate(50, 50);
        naturalGasPrice = new Label("Natural Gas Price:");
        naturalGasPrice.relocate(50,100);
        waterPrice = new Label("Water Price:");
        waterPrice.relocate(50,150);
        sewagePrice = new Label("Sewage Price:");
        sewagePrice.relocate(50, 200);
        totalCost = new Label("Total Cost:");
        totalCost.relocate(50, 250);


        calculateBill = new Button("Calculate");
        calculateBill.setOnAction(new CalculateButtonHandler());
        calculateBill.relocate(50,300);



        bill.getChildren().addAll(electricityPrice, naturalGasPrice, waterPrice, calculateBill, sewagePrice, totalCost);

        Pane companyTotal = new Pane();
        GridPane.setConstraints(companyTotal, 0,1);
        companyTotal.setMaxSize(400,400);

        grandTotalElectricity = new Label("Company Total Electricity: ");
        grandTotalElectricity.relocate(50,50);

        grandTotalNaturalGas = new Label("Company Total Natural Gas: ");
        grandTotalNaturalGas.relocate(50,100);

        grandTotalWater = new Label("Company Total Water: ");
        grandTotalWater.relocate(50,150);

        grandTotalSewage = new Label("Company Total Sewage Drains: ");
        grandTotalSewage.relocate(50,200);

        grandTotal = new Label("Company Grand Total: ");
        grandTotal.relocate(50,250);

        calculateCompanyTotal = new Button("Calculate Company Total");
        calculateCompanyTotal.setOnAction(new CalculateCompanyTotalHandler());
        calculateCompanyTotal.relocate(100,300);

        companyTotal.getChildren().addAll(grandTotal,calculateCompanyTotal,grandTotalElectricity, grandTotalNaturalGas, grandTotalWater, grandTotalSewage);
        Pane display = new Pane();
        GridPane.setConstraints(display, 1,1);


        accountView = new ListView(FXCollections.observableArrayList(clientManager.getClients()));
        display.getChildren().add(accountView);
        accountView.relocate(50,80);
        accountView.setPrefSize(300,300);
        accountView.setMaxSize(300,300);

        Pane buttonPane = new Pane();
        GridPane.setConstraints(buttonPane, 2,1);

        setCompanyRates = new Button("Set Company Rates");

        setCompanyRates.relocate(50,150);
        setCompanyRates.setOnAction(actionEvent -> {
            sample.setCompanyRates.display();
        });
        updateAccountView = new Button("Update AccountView");
        buttonPane.getChildren().addAll(updateAccountView, setCompanyRates);
        updateAccountView.relocate(50,100);
        updateAccountView.setOnAction(new UpdateAccountViewHandler());

        delete = new Button("Delete");
        delete.relocate(50,200);
        delete.setOnAction(new DeleteButtonHandler());
        buttonPane.getChildren().add(delete);

        saveToText = new Button("Save To Text");
        saveToText.relocate(50,250);
        saveToText.setOnAction(new SaveToTextHandler());
        buttonPane.getChildren().add(saveToText);

        loadFromText = new Button("Load From Text");
        loadFromText.relocate(50,300);
        loadFromText.setOnAction(new loadFromTextHandler());
        buttonPane.getChildren().add(loadFromText);

        sortBy = new Button("Sort by");
        sortBy.relocate(50, 350);
        sortBy.setOnAction(new SortByHandler());
        buttonPane.getChildren().add(sortBy);

        gp.getChildren().addAll(clientInfo, monthlyUsage, bill, display, buttonPane, companyTotal);



        primaryStage.setScene(new Scene(gp, 950, 825));
        primaryStage.show();
    }
    public class SubmitButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e){
            boolean armedForces = false;
            if(veterensDiscount.getSelectionModel().getSelectedItem().equals("Veterens Discount"));
            Client client = new Client(nameField.getText(), addressField.getText(), cityField.getText(), stateField.getText(), Integer.parseInt(zipField.getText()), phoneField.getText(), emailField.getText(), Double.parseDouble(electricityUnitsUsedField.getText()), Double.parseDouble(naturalGasUnitsUsedField.getText()), Double.parseDouble(waterUnitsUsedField.getText()), Integer.parseInt(numSepticDrainagesTextField.getText()), false);
            clientManager.addClient(client);
            nameField.clear();
            addressField.clear();
            electricityUnitsUsedField.clear();
            naturalGasUnitsUsedField.clear();
            waterUnitsUsedField.clear();
            numSepticDrainagesTextField.clear();
            nameField.clear();
            addressField.clear();
            cityField.clear();
            stateField.clear();
            zipField.clear();
            emailField.clear();
            phoneField.clear();
        }
    }
    public class UpdateAccountViewHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent f){
            updateAccountView();
        }
    }

    public class CalculateButtonHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Platform.runLater(() -> {
                        String selectedName = accountView.getSelectionModel().getSelectedItems().get(0);
                        Iterator iterator = clientManager.getClients().iterator();
                        Client clientWithName = new Client();

                        while (iterator.hasNext()) {
                            Client currentClient = (Client) iterator.next();
                            if (currentClient.getName().equals(selectedName)) {
                                clientWithName = currentClient;
                            }
                        }
                        electricityPrice.setText( "Electricity Price: " + String.valueOf(clientWithName.getCostOfElectricity()));
                        naturalGasPrice.setText("Natural Gas Price: " + String.valueOf(  clientWithName.getCostOfGas()));
                        waterPrice.setText("Water Price: "  + String.valueOf(clientWithName.getCostOfWater()));
                        sewagePrice.setText("Sewage Price: " + String.valueOf(clientWithName.getCostOfSewage()));
                        totalCost.setText("Total Cost: " + String.valueOf(clientWithName.getTotalCost()));
                    });
                }
            }).start();
        }
    }
    public class DeleteButtonHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
           String name = accountView.getSelectionModel().getSelectedItem();
           int position = accountView.getSelectionModel().getSelectedIndex();
            for(int i = 0; i < clientManager.getClients().size(); i++){
                if(clientManager.getClients().get(i).getName().equals(name)) {
                    clientManager.removeClientByPosition(position);
                    break;

                }
            }

            clientList = new ArrayList(clientManager.getClients());
            accountView.setItems(FXCollections.observableArrayList(clientList));
            updateAccountView();
        }
    }
    public void updateAccountView(){
        clientList.clear();

        for(int i = 0; i < clientManager.getClients().size(); i++){
            clientList.add(clientManager.getClients().get(i).getName());
        }
        accountView.setItems(FXCollections.observableArrayList(clientList));
        clientList.clear();
    }
    public class SaveToTextHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extfilt = new FileChooser.ExtensionFilter("Text File", ".txt");
            fileChooser.setSelectedExtensionFilter(extfilt);
            File fileToSave = fileChooser.showSaveDialog(primaryStage);


            try {
                PrintWriter pw = new PrintWriter(new FileOutputStream(fileToSave));
                for (Client client : clientManager.getClients()) {
                    pw.println((client.getName() + "," + client.getAddress() + "," + client.getCity() + "," + client.getState() +"," + client.getZip()+ "," + client.getPhoneNumber() + "," + client.getEmail() + "," + client.getNumElectricityUnitsThisMonth() + "," + client.getNumNaturalGasUnitsThisMonth() + "," + client.getNumWaterUnitsThisMonth() + "," + client.getNumSepticDrainagesThisMonth() + "," + client.isArmedForcesDiscount()));
                }
                pw.close();
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }

    public class loadFromTextHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extfilt = new FileChooser.ExtensionFilter("Text File", ".txt");
            fileChooser.setSelectedExtensionFilter(extfilt);
            File loadedFile = fileChooser.showOpenDialog(primaryStage);

            try{
                BufferedReader bufferedReader = new BufferedReader(new FileReader(loadedFile));

                String line;
                while((line = bufferedReader.readLine()) != null){
                    String[] lineSplit = line.split(",");
                    Client client = new Client(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3], Integer.parseInt(lineSplit[4]), lineSplit[5], lineSplit[6], Double.parseDouble(lineSplit[7]), Double.parseDouble(lineSplit[8]), Double.parseDouble(lineSplit[9]), Integer.parseInt(lineSplit[10]), Boolean.parseBoolean(lineSplit[11]) );
                    clientManager.addClient(client);
                }
            }catch(IOException ec){
                ec.printStackTrace();
            }
        }
    }
    public class SortByHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            sample.SortBy.display();
        }
    }

    public class CalculateCompanyTotalHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            grandTotalElectricity.setText("Company Electricity Total: " + clientManager.getAllElectricityTotal());
            grandTotalNaturalGas.setText("Company Natural Gas Total: " + clientManager.getAllNaturalGasTotal());
            grandTotalWater.setText("Company Water Total: " + clientManager.getAllWaterTotal());
            grandTotalSewage.setText("Company Sewage Total: " + clientManager.getAllSewageTotal());
            grandTotal.setText("Company Total: " + clientManager.getTotal());
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
