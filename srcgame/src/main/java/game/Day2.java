/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import type.NPC;

import java.awt.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author giaco
 */
public class Day2 extends DayDescription {

    public Day2(GameHandler gh) {
        super(gh);
    }

    NPC prestcot, j_turner, r_starr, c_jefferson, m_gaskell = new NPC();
    List<String> Prestcot, J_Turner, Ramon, Jeff, Mark = new ArrayList<>();

    public void takeDress() {
        Component[] object = gh.form.bgPanel[2].getComponents();
        object[21].setVisible(false);
        gh.form.inv.getItem_3().setIcon(new ImageIcon(getClass().getResource("/dress1.png")));
    }

    public void knockRoom() {
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                    getClass().getClassLoader().getResource("Knocking-on-door.wav")
            );
            clip.open(inputStream);
            clip.start();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            System.err.println(e.getMessage());
        }

        gh.form.textBox[3].setVisible(true);
        gh.form.textAreaBox[3].setVisible(true);
        gh.form.textButton[3].setVisible(true);
        //TODO file
        gh.form.textAreaBox[3].setText("Prego, chiunque lei sia può entrare, se una bella ragazza anche ben volentieri.");
    }

}
