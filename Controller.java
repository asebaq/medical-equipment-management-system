package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;


public class Controller {

    @FXML
    private Label login_label;

    @FXML
    private TextField username;

    @FXML
    private TextField password;


    public void LoginButton (ActionEvent event) throws IOException {
        if(isValid()){
            login_label.setText("Login Succeeded");
            Parent homePageParent = FXMLLoader.load(getClass().getResource("home_page.fxml"));
            Stage homePageStage = new Stage();
            homePageStage.setScene(new Scene(homePageParent, 600, 400));
            homePageStage.setTitle("Hello World");
            homePageStage.show();
        } else {
            login_label.setText("Login Failed");
        }
    }

    public boolean isValid () {
        System.out.println("Hello world!");
        return false;
    }
}
