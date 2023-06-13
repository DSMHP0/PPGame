/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DAVID
 */
public class InicioController implements Initializable {

    @FXML
    private Button btnExit;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnOptions;
    @FXML
    private Button btnCredits;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }  
    
    @FXML
    public void jugar(ActionEvent event) {
        try{
           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/perfilUsuarioView.fxml"));
            Parent root = loader.load();

            PerfilUsuarioController controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest((e) -> {
                controlador.closeWindows();
            });

            Stage myStage = (Stage) this.btnPlay.getScene().getWindow();
            myStage.close();
         
        }catch(IOException e){
            System.err.println(e);
        }
    }   
    
     @FXML
    public void opciones(ActionEvent event) {
        try{
           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/settingsGameView.fxml"));
            Parent root = loader.load();

            SettingsGameController controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest((e) -> {
                controlador.closeWindows();
            });

            Stage myStage = (Stage) this.btnOptions.getScene().getWindow();
            myStage.close();
         
        }catch(IOException e){
            System.err.println(e);
        }
    }   
    
    @FXML
    public void creditos(ActionEvent event) {
        
    }   
    
    @FXML
    public void salir(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }    
    
    public void closeWindows(){
        Stage myStage = (Stage) this.btnPlay.getScene().getWindow();
        myStage.close();
    }
    
   
}
