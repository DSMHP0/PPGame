/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.Tematica;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DAVID
 */
public class TematicasController extends Tematica implements Initializable {

    @FXML
    private ImageView optTematica_Animales;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
    public void closeWindows(){
        try{
           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/PerfilUsuarioView.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
           
        }catch(IOException e){
            System.err.println(e);
        }
    }
    
    public void seleccionarTematica(MouseEvent me){
        
        ImageView tempImg = (ImageView) me.getTarget();
        String[] valueTem = tempImg.getId().toLowerCase().split("_");
        String Tematica = valueTem[1];

        setNombreTematica(Tematica);
            
        try{
           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/MainGameView.fxml"));
            Parent root = loader.load();

            GameController controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest((e) -> {
                controlador.closeWindows();
            });

            Stage myStage = (Stage) this.optTematica_Animales.getScene().getWindow();
            myStage.close();
         
        }catch(IOException e){
            System.err.println(e);
        }
    }
            
    
}
