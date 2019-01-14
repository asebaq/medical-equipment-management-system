package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Equipment {

    @FXML
    private TextArea notesTextField;

    @FXML
    private MenuButton departmentMenuButton;

    @FXML
    private DatePicker purchaseDate;

    @FXML
    private MenuButton vendorMenuButton;

    @FXML
    private MenuButton periodMenuButton;

    @FXML
    private TextField name;

    @FXML
    private TextField serial;

    @FXML
    private TextField brand;

    @FXML
    private TextField model;

    @FXML
    private TextField price;

    @FXML
    private TextField warranty;

    @FXML
    private RadioButton yes;

    @FXML
    private RadioButton no;



    @FXML
    private void departmentMenu(ActionEvent event) throws IOException {
        MenuItem menuItem = (MenuItem) event.getSource();
        departmentMenuButton.setText(menuItem.getText());
    }

    @FXML
    private void periodMenu(ActionEvent event) throws  IOException{
        MenuItem menuItem = (MenuItem) event.getSource();
        periodMenuButton.setText(menuItem.getText());
    }

    @FXML
    private void vendorMenu(ActionEvent event) throws  IOException{
        MenuItem menuItem = (MenuItem) event.getSource();
        vendorMenuButton.setText(menuItem.getText());
    }

    @FXML
    private void saveButton(ActionEvent event) throws IOException {

        String notes;
        if(notesTextField.getText() == null || notesTextField.getText().isEmpty()){
            notes = "NULL";
        } else {
            notes = notesTextField.getText();
        }

        String serviceContact;
        if(yes.isSelected()){
            serviceContact = "1";
        } else if(no.isSelected()){
            serviceContact = "0";
        } else {
            serviceContact = "NULL";
        }

        String query = "INSERT INTO calibration VALUES ("
                + name.getText() + ", "
                + serial.getText() + ", "
                + brand.getText() + ", "
                + model.getText() + ", "
                + purchaseDate.getValue() + "\', "
                + price.getText() + ", \'"
                + warranty.getText() + ", \'"
                + periodMenuButton.getText() + ", \'"
                + departmentMenuButton.getText() + ", "
                + vendorMenuButton.getText() + ", "
                + serviceContact + ", "
                + departmentMenuButton.getText() + ", "
                + notes + ", NULL);";
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
        name.clear();
        serial.clear();
        brand.clear();
        model.clear();
        price.clear();
        warranty.clear();
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
