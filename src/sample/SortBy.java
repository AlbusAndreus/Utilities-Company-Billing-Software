package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Collections;
import java.util.List;

public class SortBy {
    static RadioButton name, numElectricityUnits, numNaturalGasUnits, numWaterUnits, numSewageDrains, totalCost;
    static Button submit;
    static ToggleGroup toggleGroup;
    public static void display(){
        Stage window = new Stage();

        GridPane gp = new GridPane();
        Pane pane = new Pane();
        GridPane.setConstraints(pane, 0,0);

        name = new RadioButton("Name");
        name.relocate(50,50);

        numElectricityUnits = new RadioButton("Electricity Units");
        numElectricityUnits.relocate(50,100);
        numElectricityUnits.setToggleGroup(toggleGroup);

        numNaturalGasUnits = new RadioButton("Natural Gas Units");
        numNaturalGasUnits.relocate(50,150);
        numNaturalGasUnits.setToggleGroup(toggleGroup);

        numWaterUnits = new RadioButton("Water Units");
        numWaterUnits.relocate(50,200);
        numWaterUnits.setToggleGroup(toggleGroup);

        numSewageDrains = new RadioButton("Sewage Drains");
        numSewageDrains.relocate(50,250);
        numSewageDrains.setToggleGroup(toggleGroup);

        totalCost = new RadioButton("Total Cost");
        totalCost.relocate(50,300);
        totalCost.setToggleGroup(toggleGroup);

        submit = new Button("Submit");
        submit.relocate(100, 350);
        submit.setOnAction(event ->{
            if(numElectricityUnits.isSelected()){
                Collections.sort(sample.Main.clientManager.getClients(), new ElectricityComparator());
            }else if (name.isSelected()){
                Collections.sort(Main.clientManager.getClients(), new NameComparator());
            }else if(numNaturalGasUnits.isSelected()){
                Collections.sort(sample.Main.clientManager.getClients(), new NaturalGasComparator());
            }else if(numWaterUnits.isSelected()){
                Collections.sort(Main.clientManager.getClients(), new WaterComparator());
            }else if (numSewageDrains.isSelected()){
                Collections.sort(Main.clientManager.getClients(), new SepticDrainageComparator());
            }else if (totalCost.isSelected()){
                Collections.sort(Main.clientManager.getClients(), new TotalCostComparator());
            }
            window.close();
        });


        pane.getChildren().addAll(name, numElectricityUnits, numNaturalGasUnits, numWaterUnits, numSewageDrains, totalCost, submit);
        gp.getChildren().addAll(pane);
        window.setScene(new Scene(gp, 400, 400));
        window.showAndWait();
    }
}
