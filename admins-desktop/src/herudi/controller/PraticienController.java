/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herudi.controller;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import herudi.PraticiensAccounts.PraticienAccounts;
import herudi.animations.FadeInUpTransition;
import herudi.config.config;
import herudi.config.config2;
import static herudi.menu.dataP;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import org.springframework.context.ApplicationContext;

/**
 * FXML Controller class
 *
 * @author Herudi
 */
public class PraticienController implements Initializable {
    
    
     Stage prevStage = new Stage();

    public void setPrevStage(Stage stage) {
        this.prevStage = stage;
    }
    
   public void afficherComptes() throws ClassNotFoundException {
               ///// Id Column
        JFXTreeTableColumn<User, String> id = new JFXTreeTableColumn<>("ID");
        id.setPrefWidth(150);
        id.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                return param.getValue().getValue().getId();
            }
        });
        ////////////// UserName Column
        JFXTreeTableColumn<User, String> userName = new JFXTreeTableColumn<>("Nom d'utilisateur");
        userName.setPrefWidth(150);
        userName.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                return param.getValue().getValue().getUserName();
            }
        });
        ///// Password Column
        JFXTreeTableColumn<User, String> pass = new JFXTreeTableColumn<>("Mot de Passe");
        pass.setPrefWidth(150);
        pass.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                return param.getValue().getValue().getPass();
            }
        });
        /////////////// FirstName Column
        JFXTreeTableColumn<User, String> firstName = new JFXTreeTableColumn<>("Nom");
        firstName.setPrefWidth(150);
        firstName.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                return param.getValue().getValue().getFirstName();
            }
        });
        ////////////Name Column
        JFXTreeTableColumn<User, String> name = new JFXTreeTableColumn<>("Prenom");
        name.setPrefWidth(150);
        name.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                return param.getValue().getValue().getName();
            }
        });
        ////// Speciality Column
        JFXTreeTableColumn<User, String> speciality = new JFXTreeTableColumn<>("Specialité");
        speciality.setPrefWidth(150);
        speciality.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                return param.getValue().getValue().getSpeciality();
            }
        });
        ////////// Hospital Column
        JFXTreeTableColumn<User, String> hospital = new JFXTreeTableColumn<>("Hopital");
        hospital.setPrefWidth(150);
        
        hospital.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                return param.getValue().getValue().getHospital();
            }
        });
       ///////// Address Column
        JFXTreeTableColumn<User, String> address = new JFXTreeTableColumn<>("Adresse");
        address.setPrefWidth(150);
        address.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                return param.getValue().getValue().getAddress();
            }
        });
        /// Phone Column
        JFXTreeTableColumn<User, String> phone = new JFXTreeTableColumn<>("Phone");
        phone.setPrefWidth(150);
        phone.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                return param.getValue().getValue().getTelephone();
            }
        });
        ///// Load data into JFXTreeTableView
        ObservableList<User> users = FXCollections.observableArrayList();
        PraticienAccounts praticiens = null;

        praticiens = dataP.lireDonnees();
    
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
        treeview.getColumns().setAll(id,userName,pass,firstName,name,speciality,hospital,address,phone);
        treeview.setRoot(root);
        treeview.setShowRoot(false);

    }

    @FXML
    private JFXTreeTableView<User> treeview;   

    public JFXTreeTableView<User> getTreeview() {
        return treeview;
    }

    public void setTreeview(JFXTreeTableView<User> treeview) {
        this.treeview = treeview;
    }
    
    
    @FXML
    AnchorPane myPane;
    @FXML
    private ImageView imgLoad;
    @FXML
    private ProgressBar bar;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
       {
       
        System.out.println("hi there");
        selectWithService();
        try {
            
            afficherComptes();
            
// TODO
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PraticienController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }   
    
    
    

    
    
    
 
    
   
    private void selectWithService(){
            imgLoad.setVisible(true);
            imgLoad.setVisible(false);
            new FadeInUpTransition(myPane).play();
       
    }
    
  
    @FXML
    private void aksiBack(ActionEvent event) {
        myPane.setOpacity(0);
        new FadeInUpTransition(myPane).play();
    }
   
      
}
