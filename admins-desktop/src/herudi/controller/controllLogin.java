/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herudi.controller;

import AdminsAccounts.DataAdmins;
import herudi.animations.FadeInLeftTransition;
import herudi.animations.FadeInLeftTransition1;
import herudi.animations.FadeInRightTransition;
import herudi.config.config2;
import static herudi.menu.admins;
import static herudi.menu.dataA;
import static herudi.menu.admins;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Herudi
 */
public class controllLogin implements Initializable {
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Text lblWelcome;
    @FXML
    private Text lblUserLogin;
    @FXML
    private Text lblUsername;
    @FXML
    private Text lblPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private Text lblRudyCom;
    @FXML 
    private Label lblClose;        
    Stage stage;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            admins=dataA.lireDonnees();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(controllLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        Platform.runLater(() -> {
            new FadeInRightTransition(lblUserLogin).play();
           // new FadeInLeftTransition(lblWelcome).play();
            new FadeInLeftTransition1(lblPassword).play();
            new FadeInLeftTransition1(lblUsername).play();
            new FadeInLeftTransition1(txtUsername).play();
            new FadeInLeftTransition1(txtPassword).play();
            new FadeInRightTransition(btnLogin).play();
            lblClose.setOnMouseClicked((MouseEvent event) -> {
                Platform.exit();
                System.exit(0);
            });
        });
        // TODO
    }    

    @FXML
    private void aksiLogin(ActionEvent event) 
    {
        boolean trouve = false;
        int i=0;
        while ((i <admins.listeAdmins.size())&& trouve==false)
        {
        if (txtUsername.getText().equals(admins.listeAdmins.get(i).getUserName()) && txtPassword.getText().equals(admins.listeAdmins.get(i).getPassWrod()))
        {
            trouve=true;
            config2 c = new config2();
            c.newStage(stage, lblClose, "/herudi/view/formMenu.fxml", "Test App", true, StageStyle.UNDECORATED, false);
        }else
        {
            config2.dialog(Alert.AlertType.ERROR, "Erreur Login,Veuillez Vérifier vote Username et Password SVP !");
        }
        i++;
        }
    }
    
}
