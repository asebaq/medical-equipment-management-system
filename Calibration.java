package sample;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class Calibration {

    @FXML
    private TextField notesTextField;

    @FXML
    private MenuButton periodMenuButton;

    @FXML
    private DatePicker startDate;

    @FXML
    private MenuButton colorMenuButton;

    @FXML
    private TextField equipmentID;

    @FXML
    private void colorMenu(ActionEvent event) throws  IOException{
        MenuItem menuItem = (MenuItem) event.getSource();
        colorMenuButton.setText(menuItem.getText());
    }

    @FXML
    private void periodMenu(ActionEvent event) throws  IOException{
        MenuItem menuItem = (MenuItem) event.getSource();
        periodMenuButton.setText(menuItem.getText());
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
                + periodMenuButton.getText() + ", \'"
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
