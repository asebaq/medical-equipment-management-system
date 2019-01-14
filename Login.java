package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login {

    @FXML
    private Label loginLabel;

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private void LoginButton(ActionEvent event) throws IOException {
        if (isValid()) {
            loginLabel.setText("");
            Parent homePageParent = FXMLLoader.load(getClass().getResource("home_page.fxml"));
            Stage homePageStage = Main.window;
            homePageStage.setScene(new Scene(homePageParent, 800, 600));
            homePageStage.setTitle("Home Page");
            homePageStage.show();
        } else {
            username.clear();
            password.clear();
            loginLabel.setText("Login Failed");
        }
    }

    private boolean isValid() {
        boolean result = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/medical_equipment?autoReconnect=true&useSSL=false", "root", "as7313");
            //here medical_equipment is database name, root is username and as7313 is password
            System.out.println("Opened database successfully");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users where username = " + "'" + username.getText() + "'"
            + "and password = " + "'" + password.getText() + "'" );
            while (rs.next()){
                if (rs.getString("username") != null
                        && rs.getString("password") != null) {
                    result = true;
                }
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return result;
    }
}

