package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePage {

    @FXML
    public void MaintenanceButton(ActionEvent event) throws IOException {
        Parent maintenancePageParent = FXMLLoader.load(getClass().getResource("maintenance.fxml"));
        Stage maintenancePageStage = Main.window;
        maintenancePageStage.setScene(new Scene(maintenancePageParent, 800, 600));
        maintenancePageStage.setTitle("Maintenance Page");
        maintenancePageStage.show();
    }

    public void CalibrationButton(ActionEvent event) throws IOException {
        Parent maintenancePageParent = FXMLLoader.load(getClass().getResource("calibration.fxml"));
        Stage maintenancePageStage = Main.window;
        maintenancePageStage.setScene(new Scene(maintenancePageParent, 800, 600));
        maintenancePageStage.setTitle("Calibration Page");
        maintenancePageStage.show();
    }

    public void RepairButton(ActionEvent event) throws IOException {
        Parent maintenancePageParent = FXMLLoader.load(getClass().getResource("repair.fxml"));
        Stage maintenancePageStage = Main.window;
        maintenancePageStage.setScene(new Scene(maintenancePageParent, 800, 600));
        maintenancePageStage.setTitle("Repair Page");
        maintenancePageStage.show();
    }

    public void EquipmentButton(ActionEvent event) throws IOException {
        Parent maintenancePageParent = FXMLLoader.load(getClass().getResource("equipment.fxml"));
        Stage maintenancePageStage = Main.window;
        maintenancePageStage.setScene(new Scene(maintenancePageParent, 800, 600));
        maintenancePageStage.setTitle("Equipment Page");
        maintenancePageStage.show();
    }

    public void VendorButton(ActionEvent event) throws IOException {
        Parent maintenancePageParent = FXMLLoader.load(getClass().getResource("vendor.fxml"));
        Stage maintenancePageStage = Main.window;
        maintenancePageStage.setScene(new Scene(maintenancePageParent, 800, 600));
        maintenancePageStage.setTitle("Vendor Page");
        maintenancePageStage.show();
    }

    public void DepartmentButton(ActionEvent event) throws IOException {
        Parent maintenancePageParent = FXMLLoader.load(getClass().getResource("department.fxml"));
        Stage maintenancePageStage = Main.window;
        maintenancePageStage.setScene(new Scene(maintenancePageParent, 800, 600));
        maintenancePageStage.setTitle("Department Page");
        maintenancePageStage.show();
    }

    public void SummaryButton(ActionEvent event) throws IOException {
        Parent maintenancePageParent = FXMLLoader.load(getClass().getResource("summary.fxml"));
        Stage maintenancePageStage = Main.window;
        maintenancePageStage.setScene(new Scene(maintenancePageParent, 800, 600));
        maintenancePageStage.setTitle("Summary Page");
        maintenancePageStage.show();
    }

    public void LogoutButton(ActionEvent event) throws IOException {
        Parent maintenancePageParent = FXMLLoader.load(getClass().getResource("login.fxml"));
        Stage maintenancePageStage = Main.window;
        maintenancePageStage.setScene(new Scene(maintenancePageParent, 800, 600));
        maintenancePageStage.setTitle("Login Page");
        maintenancePageStage.show();
    }
}
