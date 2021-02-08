/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herudi.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import herudi.PraticiensAccounts.Praticien;
import herudi.PraticiensAccounts.PraticienAccounts;
import herudi.animations.FadeInUpTransition;
import herudi.config.config2;
import static herudi.menu.accounts;
import static herudi.menu.dataP;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author BLACKCAT
 */
public class SupprimerController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         new FadeInUpTransition(myPane).play();
        // TODO
        
    }    
    
    @FXML
    private JFXTextField txtId;
    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextArea txtAddress;
    @FXML
    private JFXTextField txtSpeciality;
    @FXML
    private JFXTextField txtHospital;
    @FXML
    private JFXTextField txtPhone;
    @FXML
    private JFXTextField txtUserName;
    @FXML
    private JFXPasswordField txtPass;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXTextField txtFirstName;
    @FXML
    AnchorPane myPane;
    
    @FXML
    private JFXButton btnSave;
    
    
    
        private void clear(){
        txtId.clear();
       
        txtUserName.clear();
        txtPass.clear();
     
        
    }
    
     @FXML
    private void Save(ActionEvent event) throws IOException, ClassNotFoundException {
       
       if (txtUserName.getText().isEmpty()) {
            config2.dialog(Alert.AlertType.ERROR, "UserName Not Empty");
            txtUserName.requestFocus();
        }else if (txtPass.getText().isEmpty()) {
            config2.dialog(Alert.AlertType.ERROR, "PassWord Not Empty");
            txtPass.requestFocus();
        
        }
        else{
            
            /// Remplir la liste des comptes.
            Praticien p = new Praticien();
  
            p.setUserName(txtUserName.getText());
            p.setPassWrod(txtPass.getText());
           
            accounts = dataP.lireDonnees();
            Praticien f = new Praticien();
            boolean find = false;
            int l = 0;
            while(l<accounts.listePraticiens.size())
            {
                if(accounts.listePraticiens.get(l).getUserName().equals(p.getUserName())&& accounts.listePraticiens.get(l).getPassWrod().equals(p.getPassWrod()))
                {
                  find = true; 
                  f = accounts.listePraticiens.get(l);
                }
                l++;
            }
            if(find)
            {
        accounts.listePraticiens.remove(f);
        dataP.ecrireDonnees(accounts.listePraticiens);
        User a = new User(p.getId(),p.getUserName(),p.getName(),p.getFirstName(),p.getSpeciality(),p.getHospital(),p.getAddress(),p.getTel(),p.getPassWrod());
        ObservableList<User> users = FXCollections.observableArrayList();
        PraticienAccounts praticiens = null;
        praticiens = accounts;
        for (int i = 0; i < praticiens.listePraticiens.size(); i++) {
            
                     users.add(new User(praticiens.listePraticiens.get(i).getId(),
                     praticiens.listePraticiens.get(i).getUserName(),
                     praticiens.listePraticiens.get(i).getFirstName(),
                     praticiens.listePraticiens.get(i).getName(),
                     praticiens.listePraticiens.get(i).getSpeciality(),   
                     praticiens.listePraticiens.get(i).getHospital(),
                     praticiens.listePraticiens.get(i).getAddress(),
                     praticiens.listePraticiens.get(i).getTel()  ,
                     praticiens.listePraticiens.get(i).getPassWrod()
                            ));
        }

            final TreeItem<User> root = new RecursiveTreeItem<>(users, RecursiveTreeObject::getChildren);
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/herudi/view/Praticiens.fxml"));
            Parent myPanel = (Parent)myLoader.load();
           
            PraticienController m = (PraticienController)myLoader.getController();
            m.getTreeview().setRoot(root);
            m.getTreeview().setShowRoot(false);
            clear();
            config2.dialog(Alert.AlertType.CONFIRMATION, "Success Delete. . .");
            }
            else
            {
                 config2.dialog(Alert.AlertType.ERROR, "Element Doesn't Exist. . .");
            }
        }
        

}
    
}
