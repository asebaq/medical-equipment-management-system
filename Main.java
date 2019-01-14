package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.rmi.server.ExportException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class Main extends Application {

    static Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        window.setTitle("Login");
        window.setScene(new Scene(root, 800, 600));
        window.show();
    }

    public static void insertStatement(String query) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/medical_equipment?autoReconnect=true&useSSL=false", "root", "as7313");
            //here medical_equipment is database name, root is username and as7313 is password

            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);

            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
