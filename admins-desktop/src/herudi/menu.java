/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herudi;



import AdminsAccounts.AdminAccounts;
import AdminsAccounts.DataAdmins;
import herudi.PraticiensAccounts.DataPraticien;
import herudi.PraticiensAccounts.PraticienAccounts;

import java.io.File;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Herudi
 */
public class menu extends Application {
    public static String motDePasseAdmin =null;
    public static AdminAccounts  admins;
    public static PraticienAccounts accounts;
    public static DataAdmins     dataA;
    public static DataPraticien  dataP;
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("/herudi/view/splash.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        
        launch(args);
    }
    
}
