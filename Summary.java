package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Summary {

    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label repair;
    @FXML
    private Label calibrationStatus;
    @FXML
    private Label calibrationNext;
    @FXML
    private Label maintenanceStatus;
    @FXML
    private Label maintenanceNext;

    public void GetSummary() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/medical_equipment?autoReconnect=true&useSSL=false", "root", "as7313");
            //here medical_equipment is database name, root is username and as7313 is password
            System.out.println("Opened database successfully");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select start_date, color from calibration where equipment_id = " + "'" + id.getText() + "'");
            while (rs.next()) {
                calibrationNext.setText(rs.getString(1));
                calibrationStatus.setText(rs.getString(2));
            }

            rs = stmt.executeQuery("select color from maintenance where equipment_id = " + "'" + id.getText() + "'");
            while (rs.next()) {
                maintenanceStatus.setText(rs.getString(1));
            }

            rs = stmt.executeQuery("select name from equipment where equipment_id = " + "'" + id.getText() + "'");
            while (rs.next()) {
                name.setText(rs.getString(1));
            }

            rs = stmt.executeQuery("select status from repairs where equipment_id = " + "'" + id.getText() + "'");
            while (rs.next()) {
                repair.setText(rs.getString(1));
            }

            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void backButton(ActionEvent event) throws IOException {
        Parent homePageParent = FXMLLoader.load(getClass().getResource("home_page.fxml"));
        Stage homePageStage = Main.window;
        homePageStage.setScene(new Scene(homePageParent, 800, 600));
        homePageStage.setTitle("Home Page");
        homePageStage.show();
    }
}
