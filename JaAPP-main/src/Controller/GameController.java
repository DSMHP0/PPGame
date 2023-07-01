/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.Palabra;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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
    private TextField KeyGame;
    
    @FXML
    private Pane pnGamePanel;
    @FXML
    private Pane pnGameVidas;
    @FXML
    private Pane pnIntentosRestantes;
    
    @FXML
    private ImageView optTematicaInGame;
    /*
    * Variables generales
    */
    
    Palabra p = new Palabra();
    private final String palabraGenerada = p.generarPalabraAleatoria();
    private final int cantLetras = palabraGenerada.length();

    int numLabels = cantLetras;
    Label[] labels = new Label[numLabels];
    
    /* -------------- */
    
    boolean gameOver = false;
    int aciertos;
    private int intentos = 5;
    
    ImageView[] vidas = new ImageView[intentos];
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        KeyGame.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));
        
        comenzarJuego();
    }    
    
    public void closeWindows(){
        Stage myStage = (Stage) this.btnCheckWord.getScene().getWindow();
        myStage.close();
         
    }
    
    public void vidas(){
        
        HBox HBoxVidas = new HBox();
    
        Image imProfile = new Image(getClass().getResourceAsStream("/Resources/Corazon.png"));
        
        for (int i = 0; i < intentos; i++) {
            vidas[i] = new ImageView(imProfile);
            vidas[i].setFitHeight(50);
            vidas[i].setFitWidth(50);
            HBoxVidas.setSpacing(5);
            HBoxVidas.getChildren().add(vidas[i]);
        }
        
        pnGameVidas.getChildren().add(HBoxVidas);
    }
     
    public void comenzarJuego(){
        char[] palabra_secreta;
        palabra_secreta = palabraGenerada.toCharArray();
        
        HBox hbox = new HBox();
        
        for (int i = 0; i < palabra_secreta.length; i++) {
            
            labels[i] = new Label("?");
            labels[i].setPrefWidth(42);
            labels[i].setPrefHeight(42);
            labels[i].setFont(new Font("System", 20));
            labels[i].setAlignment(Pos.CENTER);
            labels[i].setStyle(
                    "-fx-font-weight: Bold;"
                    + "-fx-background-color: #50242f;"
                    + "-fx-background-radius: 50;"
                    + "-fx-text-fill: #fff;"
                    + "-fx-margin: 5px;"
                    + "-fx-opacity: 4;"
            );
            
            hbox.setSpacing(5);
            hbox.getChildren().add(labels[i]);
           
        }
        
        vidas();
        pnGamePanel.getChildren().add(hbox);
        validarTematicaInGame(p.getNombreTematica());
    }
    
    public void validarTematicaInGame(String tematica){
        optTematicaInGame.setFitWidth(70);
        optTematicaInGame.setFitHeight(70);
        switch (tematica) {
            case "animales":
                Image imgTemAni = new Image(getClass().getResourceAsStream("/Resources/Animales.png"));
                optTematicaInGame.setImage(imgTemAni);
                break;
            case "comidas":
                Image imgTemCom = new Image(getClass().getResourceAsStream("/Resources/Comida.png"));
                optTematicaInGame.setImage(imgTemCom);
                break;
            case "paises":
                Image imgTemPai = new Image(getClass().getResourceAsStream("/Resources/Paises.png"));
                optTematicaInGame.setImage(imgTemPai);
                break;
            case "peliculas":
                Image imgTemPel = new Image(getClass().getResourceAsStream("/Resources/Peliculas.png"));
                optTematicaInGame.setImage(imgTemPel);
                break;
            default:
                throw new AssertionError();
        }
    }
    
    public void comprobarLetraIngresada(ActionEvent event){
        String letra = KeyGame.getText();
        if(letra.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("No ha ingresado letra, por favor diligencie el campo requerido.");
            alert.showAndWait();
        } else {
            KeyGame.clear();
        
            char letraChar = letra.charAt(0);
            boolean letraAdivinada = false;

            for (int i = 0; i < palabraGenerada.length(); i++) {
                if (palabraGenerada.charAt(i) == letraChar) {
                    letraAdivinada = true;
                    aciertos++;
                    labels[i].setText(letra);
                }
            }
            
            if (letraAdivinada == false) {
                
                if(intentos == 1){
                    gameOver = true;
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("Game Over");
                    alert.show();
                    closeWindows();
                }else{
                    
                    intentos--;
                    Label intentosRest = new Label("Intentos Restantes: " + intentos);
                    intentosRest.setFont(new Font("System", 15));
                    intentosRest.setStyle(
                                    "-fx-text-fill: #fff;" 
                                    + "-fx-font-weight: Bold;" 
                                            );
                    pnIntentosRestantes.getChildren().clear();
                    pnIntentosRestantes.getChildren().add(intentosRest);
                    pnGameVidas.getChildren().clear();
                    vidas();
                }
            }else{
                if(aciertos == cantLetras){
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("Felicidades! has adivinado la palabra.");
                    alert.show();
                    closeWindows();
                }
            }

        }
        
    }
    
    
}
