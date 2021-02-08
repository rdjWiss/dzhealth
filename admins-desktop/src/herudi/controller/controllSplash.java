/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herudi.controller;

import com.sun.javafx.property.adapter.PropertyDescriptor.Listener;
import herudi.animations.FadeInLeftTransition;
import herudi.animations.FadeInRightTransition;
import herudi.animations.FadeInTransition;
import herudi.config.config;
import herudi.config.config2;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.springframework.context.ApplicationContext;

/**
 * FXML Controller class
 *
 * @author Herudi
 */
public class controllSplash implements Initializable {
    @FXML
    private Text lblWelcome;
    @FXML
    private Text lblRudy;
    @FXML
    private VBox vboxBottom;
    @FXML
    private Label lblClose;
    Stage stage;
    @FXML
    private ImageView imgLoading;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            longStart();
        } catch (InterruptedException ex) {
            Logger.getLogger(controllSplash.class.getName()).log(Level.SEVERE, null, ex);
        }
        lblClose.setOnMouseClicked((MouseEvent event) -> {
            Platform.exit();
            System.exit(0);
        });
        // TODO
    }   
    
    private void longStart() throws InterruptedException {

     
            new FadeInLeftTransition(lblWelcome).play();
            new FadeInRightTransition(lblRudy).play();
            FadeInTransition m = new FadeInTransition(vboxBottom);
            m.setInterpolator(Interpolator.EASE_BOTH);
            m.play();
  
   
            m.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                   
                    config2 config = new config2();
                    config.newStage(stage, lblClose, "/herudi/view/login.fxml", "Sample Apps", true, StageStyle.UNDECORATED, false);
                }
            });
          
     
    } 
}
