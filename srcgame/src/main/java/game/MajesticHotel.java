/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import db.DataHandler;
import static game.Main.listItem;
import type.NPC;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import type.Item;

/**
 *
 * @author giaco
 */
public class MajesticHotel extends DayDescription {

    public MajesticHotel(GameHandler gh) {
        super(gh);
    }

    NPC person = new NPC();
    Item element = new Item();
    List<String> Prestcot, J_Turner, Ramon, Jeff, Mark = new ArrayList<>();

    public void takeDanceDress() {        

        gh.getInv().getItem_3().setVisible(true);
        gh.getInv().getItem_3().setIcon(new ImageIcon(getClass().getResource("/dressDance.png")));
        gh.getInv().getItem_3().setText("");
        element = DataHandler.ItemFinder(listItem, "ball_dress");
        gh.getPlayer().addToInventory(element);

        gh.getInv().getItem_4().setVisible(true);
        gh.getInv().getItem_4().setIcon(new ImageIcon(getClass().getResource("/nail.png")));
        gh.getInv().getItem_4().setText("");
        element = DataHandler.ItemFinder(listItem, "broken_nail");
        gh.getPlayer().addToInventory(element);

    }

    public void takeAdoptionDoc() {
        
        gh.getInv().getItem_5().setVisible(true);
        gh.getInv().getItem_5().setIcon(new ImageIcon(getClass().getResource("/doc_adozione.png")));
        gh.getInv().getItem_5().setText("");

        element = DataHandler.ItemFinder(listItem, "adoption_doc");
        gh.getPlayer().addToInventory(element);
    }

    public void takeBillDoc() {
        
        gh.getInv().getItem_6().setVisible(true);
        gh.getInv().getItem_6().setIcon(new ImageIcon(getClass().getResource("/doc_estrattoConto.png")));
        gh.getInv().getItem_6().setText("");

        element = DataHandler.ItemFinder(listItem, "mark_bill");
        gh.getPlayer().addToInventory(element);

        gh.getForm().setVisibleObject(12, 15, false);

    }

    public synchronized void knockRoom() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Clip clip = AudioSystem.getClip();
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(MajesticHotel.this.getClass().getClassLoader().getResource("Knocking-on-door.wav"));
                clip.open(inputStream);
                clip.start();
            } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
                System.err.println(e.getMessage());
                return;
            }
            gh.getForm().textBox[10].setVisible(true);
            gh.getForm().textAreaBox[10].setVisible(true);
            gh.getForm().textButton[10].setVisible(true);
            gh.getForm().textAreaBox[10].setText("Prego, chiunque lei sia può entrare, se una bella ragazza anche ben volentieri.");
        });
        t1.start();

        if (t1.isAlive()) {
            t1.interrupt();

        }
    }
}
