/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.Palabra;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DAVID
 */
public class GameController implements Initializable {

    @FXML
    private Button btnCheckWord;
    
    @FXML
    private Pane pnGamePanel;
    
    @FXML ImageView optTematicaInGame;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comenzarJuego();
    }    
    
     public void closeWindows(){
        Stage myStage = (Stage) this.btnCheckWord.getScene().getWindow();
        myStage.close();
         
    }
     
    public void comenzarJuego(){
        Palabra p = new Palabra();
        String palabraGenerada = p.generarPalabraAleatoria();
        int cantLetras = palabraGenerada.length();
        char[] palabra_secreta;
        palabra_secreta = palabraGenerada.toCharArray();
        
        HBox hbox = new HBox();
        int numLabels = cantLetras;
        Label[] labels = new Label[numLabels];
        
        for (int i = 0; i < palabra_secreta.length; i++) {
            System.out.println(palabra_secreta[i]);
            
            labels[i] = new Label(String.valueOf(palabra_secreta[i]));
            labels[i].setPrefWidth(42);
            labels[i].setPrefHeight(42);
            labels[i].setFont(new Font("System", 20));
            labels[i].setAlignment(Pos.CENTER);
            labels[i].setStyle(
                    "-fx-font-weight: Bold;"
                    + "-fx-border-color: white;"
                    + "-fx-margin: 5px;"
            );
            
            hbox.setSpacing(5);
            hbox.getChildren().add(labels[i]);
           
        }
        
        pnGamePanel.getChildren().add(hbox);
        //validarTematicaInGame(p.getNombreTematica());
        
    }
    
    public void validarTematicaInGame(String tematica){
        
    }
    
    
}
