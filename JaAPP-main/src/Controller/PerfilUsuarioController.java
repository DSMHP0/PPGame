/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.io.IOException;
import static java.lang.Double.max;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DAVID
 */
public class PerfilUsuarioController implements Initializable {

    @FXML
    private Button btnSiguiente;
    private Button btnAnterior;
    
    @FXML
    private TextField txtNickName;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtNickName.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
           
        }));

    }    
    
    public void closeWindows(){
        try{
           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/inicioView.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();
           
            Stage myStage = (Stage) this.btnSiguiente.getScene().getWindow();
            myStage.close();
         
        }catch(IOException e){
            System.err.println(e);
        }
    }
    
    public boolean isNameValid() {
        Boolean v = false;
        
        if ((txtNickName.getText().trim() == null) || (txtNickName.getText().isEmpty())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("No ha diligenciado los campos requeridos");
            alert.showAndWait(); 
        }else{
            v = true;
        }
        
        return v;
    }
    
    
    @FXML
    public void siguiente(ActionEvent event) {
        try{
           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/TematicasView.fxml"));
            Parent root = loader.load();

            TematicasController controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            if(isNameValid() == true){
                stage.setScene(scene);
                stage.show();

                stage.setOnCloseRequest((e) -> {
                    controlador.closeWindows();
                });

                Stage myStage = (Stage) this.btnSiguiente.getScene().getWindow();
                myStage.close();
            }
           
        }catch(IOException e){
            System.err.println(e);
        }
    }
    
    @FXML
    public void anterior(ActionEvent event){
       try{
           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/inicioView.fxml"));
            Parent root = loader.load();

            InicioController controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();
            
            stage.setOnCloseRequest((e) -> {
                    controlador.closeWindows();
                });

                Stage myStage = (Stage) this.btnSiguiente.getScene().getWindow();
                myStage.close();
           
        }catch(IOException e){
            System.err.println(e);
        } 
    }
    
}
