package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Repair {

    @FXML
    private TextField equipmentID;

    @FXML
    private TextField failure;

    @FXML
    private TextField repair;

    @FXML
    private TextField parts;

    @FXML
    private TextField price;

    @FXML
    private TextField userID;

    @FXML
    private TextField notesTextField;

    @FXML
    private DatePicker date;

    @FXML
    private DatePicker failureDate;

    @FXML
    private RadioButton okay;

    @FXML
    private RadioButton notOkay;

    @FXML
    private void saveButton(ActionEvent event) throws IOException {

        String status;
        if (okay.isSelected()) {
            status = okay.getText();
        } else if (notOkay.isSelected()) {
            status = notOkay.getText();
        } else {
            status = "NULL";
        }

        String notes;
        if(notesTextField.getText() == null || notesTextField.getText().isEmpty()){
            notes = "NULL";
        } else {
            notes = notesTextField.getText();
        }

        String query = "INSERT INTO repairs VALUES (NULL, "
                + equipmentID.getText() + ", "
                + failure.getText() + ", \'"
                + failureDate.getValue() + "\', "
                + repair.getText() + ", \'"
                + date.getValue() + "\', "
                + userID.getText() + ", "
                + parts.getText() + ", "
                + price.getText() + ", "
                + status + ", "
                + notes + ");";

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
        failure.clear();
        repair.clear();
        parts.clear();
        price.clear();
        userID.clear();
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
