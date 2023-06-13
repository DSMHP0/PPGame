/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
//Librerias para musica
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
/**
/**
 *
 * @author DAVID
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        try{
            
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/InicioView.fxml"));
            Pane ventana = (Pane) loader.load();

            //show scene

            Scene scene = new Scene(ventana);
            primaryStage.setResizable(false); 
            primaryStage.setScene(scene);
            primaryStage.show();   
            
            music();
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    MediaPlayer mediaPlayer;
    public void music(){
       String file = "src/Resources/sound.mp3";
       Media url = new Media(Paths.get(file).toUri().toString());
       mediaPlayer = new MediaPlayer(url);
       mediaPlayer.setVolume(0.5);
       mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
       mediaPlayer.play();
   }  
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}