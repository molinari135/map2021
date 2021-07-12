/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import type.NPC;

/**
 *
 * @author tom
 */
public class ActionHandler1 implements ActionListener {

    Day1_Form d1;

    //TODO SPOSTARE DA QUA, metterli in DAY 1
    NPC dolly, j_marple, corpse, lorrimer, a_bantry, haydock, b_blake = new NPC();
    List<String> D_bantry, Jane_marple, Lorri, Corp, Arthur, Doc, Basil = new ArrayList<>();

    public ActionHandler1(Day1_Form d1) {
        this.d1 = d1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String eventCommand = e.getActionCommand();

        switch (eventCommand) {
            case "goToCorridorFromDRoom":
                d1.goToSceneXtoY(1, 2);  //DINING ROOM -> CORRIDOIO INF.
                break;

            case "WestRoomCorridor1":
                d1.goToSceneXtoY(2, 1);  //CORRIDOIO INF -> DINING ROOM
                break;

            case "EastRoomCorridor1":
                d1.goToSceneXtoY(2, 3);  //LIVING ROOM
                break;

            case "goToCorridorFromLRoom":
                d1.goToSceneXtoY(3, 2); //LIVING ROOM -> CORRIDOIO
                break;

            case "StaircaseUP1":
                d1.goToSceneXtoY(2, 4); //CORRIDOIO INF -> SUP
                break;

            case "StaircaseDown1":
                d1.goToSceneXtoY(4, 2); //CORRIDOIO SUP -> INF
                break;

            case "WestRoomCorridor2":
                d1.goToSceneXtoY(4, 5);  //STUDY
                break;

            case "EastRoomCorridor2":
                d1.goToSceneXtoY(4, 6); //LIBRARY
                break;

            case "goToCorridorFromStudy":
                d1.goToSceneXtoY(5, 4); //STUDIO -> CORRIDOIO SUP.
                break;

            case "goToCorridorFromLibrary":
                d1.goToSceneXtoY(6, 4); //LIBRARY -> CORRIDOIO SUP.
                break;

            case "openInventory":
                d1.inv.setVisible(true);
                break;

            case "continueTextScene1":
                d1.closeTextBox(1);
                break;

            case "continueTextScene2":
                d1.closeTextBox(2);
                break;

            case "continueTextScene3":
                d1.closeTextBox(3);
                break;

            case "continueTextScene4":
                d1.closeTextBox(4);
                break;

            case "continueTextScene5":
                d1.closeTextBox(5);
                break;

            case "continueTextScene6":
                d1.closeTextBox(6);
                break;

            case "continueDialog1":
                d1.continueDialogue(1);
                break;

            case "continueDialog2":
                d1.continueDialogue(2);
                break;

            case "continueDialog3":
                d1.continueDialogue(3);
                break;

            case "continueDialog5":
                d1.continueDialogue(5);
                break;

            case "continueDialog6":
                d1.continueDialogue(6);
                break;

            case "ObserveDiningRoom":
                d1.observeSceneX(2, "Da qui sembra portare alla sala da pranzo di Gossington Hall.");
                break;

            case "ObserveLivingRoom":
                d1.observeSceneX(2, "Da qui sembra portare al soggiorno.");
                break;

            case "ObserveStudy":
                d1.observeSceneX(4, "Questo sembra essere lo studio del signor Bantry.");
                break;

            case "ObserveLibrary":
                d1.observeSceneX(4, "Di qui c'è l'imponente biblioteca di Gossington Hall.");
                break;

            case "ObserveDolly":
                d1.observeNPC(1, dolly, "d_bantry");
                break;

            case "TalkDolly": 
                try {
                d1.talkNPC(1, "d_bantry.txt", D_bantry, "/IconDollyB.png", "d_bantry", true);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            break;

            case "scelta1d_bantry": 
                try {
                d1.choice1(1, "d_bantry", "d_bantry.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2d_bantry": 
                try {
                d1.choice2(1, "d_bantry", "d_bantry.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta3d_bantry": 
                try {
                d1.choice3(1, "d_bantry", "d_bantry.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta4d_bantry": 
                try {
                d1.choice4(1, "d_bantry", "d_bantry.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "ObserveJane":
                d1.observeNPC(1, j_marple, "j_marple");
                break;

            case "TalkJane": 
                try {
                d1.talkNPC(1, "j_marple.txt", Jane_marple, "/IconMarple.png", "j_marple", false);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta1j_marple": 
                try {
                d1.choice1(1, "j_marple", "j_marple.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta2j_marple": 
                try {
                d1.choice2(1, "j_marple", "j_marple.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta3j_marple": 
                try {
                d1.choice3(1, "j_marple", "j_marple.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta4j_marple": 
                try {
                d1.choice4(1, "j_marple", "j_marple.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "ObserveLorrimer":
                d1.observeNPC(3, lorrimer, "lorrimer");
                break;

            case "TalkLorrimer": 
                try {
                d1.talkNPC(3, "lorrimer.txt", Lorri, "/IconLorrimer.png", "lorrimer", true);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta1lorrimer": 
                try {
                d1.choice1(3, "lorrimer", "lorrimer.txt");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta2lorrimer": 
                try {
                d1.choice2(3, "lorrimer", "lorrimer.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta3lorrimer": 
                try {
                d1.choice3(3, "lorrimer", "lorrimer.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta4lorrimer": 
                try {
                d1.choice4(3, "lorrimer", "lorrimer.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "ObserveBasil":
                d1.observeNPC(5, b_blake, "b_blake");
                break;

            case "TalkBasil": 
                try {
                d1.talkNPC(5, "b_blake.txt", Basil, "/IconBlake.png", "b_blake", true);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta1b_blake": 
                try {
                d1.choice1(5, "b_blake", "b_blake.txt");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta2b_blake": 
                try {
                d1.choice2(5, "b_blake", "b_blake.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta3b_blake": 
                try {
                d1.choice3(5, "b_blake", "b_blake.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta4b_blake": 
                try {
                d1.choice4(5, "b_blake", "b_blake.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "ObserveABantry":
                d1.observeNPC(5, a_bantry, "a_bantry");
                break;

            case "TalkABantry": 
                try {
                d1.talkNPC(5, "a_bantry.txt", Arthur, "/IconArthur.png", "a_bantry", false);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta1a_bantry": 
                try {
                d1.choice1(5, "a_bantry", "a_bantry.txt");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2a_bantry": 
                try {
                d1.choice2(5, "a_bantry", "a_bantry.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta3a_bantry": 
                try {
                d1.choice3(5, "a_bantry", "a_bantry.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta4a_bantry": 
                try {
                d1.choice4(5, "a_bantry", "a_bantry.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "ObserveHaydoc":
                d1.observeNPC(6, haydock, "haydock");
                break;

            case "TalkHaydoc": 
                try {
                d1.talkNPC(6, "haydock.txt", Doc, "/IconDoc.png", "haydock", false);
                d1.takeDress();

            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta1haydock": 
                try {
                d1.choice1(6, "haydock", "haydock.txt");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2haydock": 
                try {
                d1.choice2(6, "haydock", "haydock.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta3haydock": 
                try {
                d1.choice3(6, "haydock", "haydock.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta4haydock": 
                try {
                d1.choice4(6, "haydock", "haydock.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "ObserveBody":
                d1.observeNPC(6, corpse, "corpse");
                break;

            case "AnalizeBody":
                d1.analizeBody();
                break;

        }
    }
}
