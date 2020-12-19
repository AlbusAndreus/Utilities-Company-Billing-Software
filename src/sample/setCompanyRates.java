package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class setCompanyRates {
    static Label electricityPerUnitLabel, naturalGasPerUnitLabel, waterPerUnitLabel, sewageDrainCostPerUnitLabel;
    static TextField electricityPerUnitField, naturalGasPerUnitField, waterPerUnitField, sewageDrainPerUnitField;
    static Button submit;
    static Pane rates;
    static Stage window;
    public static void display() {
        window = new Stage();
        window.setTitle("Set Company Rates");
        GridPane gp = new GridPane();
        rates = new Pane();
        electricityPerUnitLabel = new Label("Electricity Price:");
        electricityPerUnitLabel.relocate(50,50);
        electricityPerUnitField = new TextField();
        electricityPerUnitField.relocate(150,50);

        naturalGasPerUnitLabel = new Label("Natural Gas Price:");
        naturalGasPerUnitLabel.relocate(50,100);
        naturalGasPerUnitField = new TextField();
        naturalGasPerUnitField.relocate(150,100);

        waterPerUnitLabel = new Label("Water Price:");
        waterPerUnitLabel.relocate(50,150);
        waterPerUnitField = new TextField();
        waterPerUnitField.relocate(150,150);

        sewageDrainCostPerUnitLabel = new Label("Septic Drainage:");
        sewageDrainCostPerUnitLabel.relocate(50,200);
        sewageDrainPerUnitField = new TextField();
        sewageDrainPerUnitField.relocate(150,200);

        submit = new Button("Submit");
        submit.relocate(200,250);
        submit.setOnAction(new SubmitButtonHandler());

        rates.getChildren().addAll(submit, electricityPerUnitField, electricityPerUnitLabel, waterPerUnitField, waterPerUnitLabel, naturalGasPerUnitField, naturalGasPerUnitLabel, sewageDrainCostPerUnitLabel, sewageDrainPerUnitField);

        gp.getChildren().addAll(rates);
        window.setScene(new Scene(gp, 400,400));
        window.show();
    }
    public static class SubmitButtonHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            Main.theCompany.setElectricityRate(Double.parseDouble(electricityPerUnitField.getText()));
            Main.theCompany.setGasRate(Double.parseDouble(naturalGasPerUnitField.getText()));
            Main.theCompany.setWaterRate(Double.parseDouble(waterPerUnitField.getText()));
            Main.theCompany.setSepticDrainageRate(Double.parseDouble(sewageDrainPerUnitField.getText()));
            window.close();
        }
    }


}
