/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.nio.file.Paths;
import javafx.fxml.FXML;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Sebastian Murillo
 */
public class MusicalThemes {
    
    boolean active = false;
    public MediaPlayer mediaPlayer;
    public final String file = "src/Resources/sound.mp3";
    public final Media path  = new Media(Paths.get(file).toUri().toString());
    
    public MusicalThemes() {
         
        //System.out.println(active);
        
        if(active == false){
            this.mediaPlayer = new MediaPlayer(path);
            active = true;
        }
        
        //System.out.println(active);
    }
    
    @FXML
    public void playMusicBackground(){
        this.mediaPlayer.setVolume(0.3);
        this.mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        this.mediaPlayer.play();
        System.err.println(this.mediaPlayer);
    }  
    
    @FXML
    public void stopMusicBackground(){
        //mediaPlayer.stop();
        System.err.println(this.mediaPlayer);
    }  
    
    @FXML
    public void volumeMusicBackground(double value){
        this.mediaPlayer.setVolume(value);
    }

}
