package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;

public class Department {

    @FXML
    private TextField name;

    @FXML
    private TextField phone;

    @FXML
    private void saveButton(ActionEvent event) throws IOException {

        String query = "INSERT INTO departments VALUES (NULL, "
                + name.getText() + ", "
                + phone.getText() + ");";

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
        phone.clear();
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
