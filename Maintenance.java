package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Maintenance {

    @FXML
    private MenuButton colorMenuButton;

    @FXML
    private MenuButton frequencyMenuButton;

    @FXML
    private TextField equipmentID;

    @FXML
    private TextArea notesTextField;

    @FXML
    private DatePicker startDate;

    @FXML
    private DatePicker nextDate;

    @FXML
    private void colorMenu(ActionEvent event) throws  IOException{
        MenuItem menuItem = (MenuItem) event.getSource();
        colorMenuButton.setText(menuItem.getText());
    }

    @FXML
    private void frequencyMenu(ActionEvent event) throws  IOException{
        MenuItem menuItem = (MenuItem) event.getSource();
        frequencyMenuButton.setText(menuItem.getText());
    }

    @FXML
    private void saveButton(ActionEvent event) throws IOException {

        String notes;
        if(notesTextField.getText() == null || notesTextField.getText().isEmpty()){
            notes = "NULL";
        } else {
            notes = notesTextField.getText();
        }

        String query = "INSERT INTO calibration VALUES (NULL, "
                + frequencyMenuButton.getText() + ", \'"
                + startDate.getValue() + "\', "
                + colorMenuButton.getText() + ", "
                + notes + ", "
                + equipmentID.getText() + ");";
        Main.insertStatement(query);

        System.out.println(query);

        Parent homePageParent = FXMLLoader.load(getClass().getResource("home_page.fxml"));
        Stage homePageStage = Main.window;
        homePageStage.setScene(new Scene(homePageParent, 800, 600));
        homePageStage.setTitle("Home Page");
        homePageStage.show();
    }

    @FXML
    private void deleteButton(ActionEvent event) throws IOException{
        equipmentID.clear();
        notesTextField.clear();
    }


    @FXML
    private void backButton(ActionEvent event) throws IOException{
        Parent homePageParent = FXMLLoader.load(getClass().getResource("home_page.fxml"));
        Stage homePageStage = Main.window;
        homePageStage.setScene(new Scene(homePageParent, 800, 600));
        homePageStage.setTitle("Home Page");
        homePageStage.show();
    }
}
