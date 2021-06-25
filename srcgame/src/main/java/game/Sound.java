/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author tom
 */
public class Sound {
    Clip clip;
    
    public void setFile(URL file_name) {
        try {
            AudioInputStream sound = AudioSystem.getAudioInputStream(file_name);
            clip = AudioSystem.getClip();
            clip.open(sound);            
        } catch(IOException | LineUnavailableException | UnsupportedAudioFileException | NullPointerException e) {
            System.err.print("Invalid file_name for .wav");
        }        
    }
    
    public static void play(String filename)
{
    try
    {
        Clip clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(new File(filename)));
        clip.start();
    }
    catch (IOException | LineUnavailableException | UnsupportedAudioFileException exc)
    {
        exc.printStackTrace(System.out);
    }
}
    
    public void loop(URL file_name) {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    public void stop(URL file_name) {
        clip.stop();
    }
    
    
}
