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
import type.NPC;

/**
 *
 * @author tom
 */
public class ActionHandler2 implements ActionListener {

    Day2_Form d2;

    NPC prestcot, j_turner, r_starr, c_jefferson, m_gaskell = new NPC();
    List<String> Prestcot, J_Turner, Ramon, Jeff, Mark = new ArrayList<>();

    public ActionHandler2(Day2_Form d2) {
        this.d2 = d2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String eventCommand = e.getActionCommand();

        switch (eventCommand) {
            case "goToReceptionFromHall":
                d2.goToSceneXtoY(2, 1);  //HALL -> RECEPTION
                break;

            case "goToHallFromReception":
                d2.goToSceneXtoY(1, 2);  //RECEPTION -> HALL
                break;

            case "StaircaseUP2":
                d2.goToSceneXtoY(2, 3); //HALL -> SUP
                break;

            case "StaircaseDown2":
                d2.goToSceneXtoY(3, 2); //CORRIDOIO SUP -> HALL
                break;

            case "goToRoomFromCorridor":
                d2.goToSceneXtoY(3, 4); //CORRID. -> CAMERA LETTO
                break;

            case "goToCorridor":
                d2.goToSceneXtoY(4, 3);  //CAMERA LETTO -> CORRID.
                break;

            case "goToVeranda":
                d2.goToSceneXtoY(4, 5);  //VERANDA
                break;

            case "goToRoomFromVeranda":
                d2.goToSceneXtoY(5, 4); //VERANDA -> CAMERA LETTO
                break;

            case "openInventory":
                d2.inv.setVisible(true);
                break;

            case "KnockRoom":
                d2.knockRoom();
                break;

            case "continueTextScene1":
                d2.closeTextBox(1);
                break;

            case "continueTextScene2":
                d2.closeTextBox(2);
                break;

            case "continueTextScene3":
                d2.closeTextBox(3);
                break;

            case "continueTextScene4":
                d2.closeTextBox(4);
                break;

            case "continueTextScene5":
                d2.closeTextBox(5);
                break;

            case "continueTextScene6":
                d2.closeTextBox(6);
                break;

            case "continueDialog1":
                d2.continueDialogue(1);
                break;

            case "continueDialog2":
                d2.continueDialogue(2);
                break;

            case "continueDialog3":
                d2.continueDialogue(3);
                break;

            case "continueDialog5":
                d2.continueDialogue(5);
                break;

            case "continueDialog4":
                d2.continueDialogue(4);
                break;    
            case "closeTextScene1":
                d2.closeTextBox(1);
                break;

            case "closeTextScene2":
                d2.closeTextBox(2);
                break;

            case "closeTextScene3":
                d2.closeTextBox(3);
                break;

            case "closeTextScene4":
                d2.closeTextBox(4);
                break;

            case "closeTextScene5":
                d2.closeTextBox(5);
                break;

            case "ObserveOwner":
                d2.observeNPC(1, prestcot, "prestcot");
                break;

            case "ObserveRamon":
                d2.observeNPC(2, r_starr, "r_starr");
                break;

            case "ObserveJosephine":
                d2.observeNPC(2, j_turner, "j_turner");
                break;

            case "ObserveJefferson":
                d2.observeNPC(4, c_jefferson, "c_jefferson");
                break;

            case "ObserveMark":
                d2.observeNPC(5, m_gaskell, "m_gaskell");
                break;

            case "TalkOwner":
                try {
                d2.talkNPC(1, "prestcot.txt", Prestcot, "/IconPrestcot.png", "prestcot", false);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
                break;

            case "TalkRamon":
                try {
                d2.talkNPC(2, "r_starr.txt", Ramon, "/IconRamon.png", "r_starr", false);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
                break;

            case "TalkJosephine":
                try {
                d2.talkNPC(2, "j_turner.txt", J_Turner, "/IconJosephine.png", "j_turner", false);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
                break;

            case "TalkJefferson":
                try {
                d2.talkNPC(4, "c_jefferson.txt", Jeff, "/IconJeff.png", "c_jefferson", false);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
                break;

            case "TalkMark":
                try {
                d2.talkNPC(5, "m_gaskell.txt", Mark, "/IconMark.png", "m_gaskell", false);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
                break;

            case "scelta1prestcot": 
                try {
                d2.choice1(1, "prestcot", "prestcot.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2prestcot": 
                try {
                d2.choice2(1, "prestcot", "prestcot.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta3prestcot": 
                try {
                d2.choice3(1, "prestcot", "prestcot.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta4prestcot": 
                try {
                d2.choice4(1, "prestcot", "prestcot.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta1j_turner": 
                try {
                d2.choice1(2, "j_turner", "j_turner.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2j_turner": 
                try {
                d2.choice2(2, "j_turner", "j_turner.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta3j_turner": 
                try {
                d2.choice3(2, "j_turner", "j_turner.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta4j_turner": 
                try {
                d2.choice4(2, "j_turner", "j_turner.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta1r_starr": 
                try {
                d2.choice1(2, "r_starr", "r_starr.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2r_starr": 
                try {
                d2.choice2(2, "r_starr", "r_starr.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta3r_starr": 
                try {
                d2.choice3(2, "r_starr", "r_starr.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta4r_starr": 
                try {
                d2.choice4(2, "r_starr", "r_starr.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta1c_jefferson": 
                try {
                d2.choice1(4, "c_jefferson", "c_jefferson.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2c_jefferson": 
                try {
                d2.choice2(4, "c_jefferson", "c_jefferson.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta3c_jefferson": 
                try {
                d2.choice3(4, "c_jefferson", "c_jefferson.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta4c_jefferson": 
                try {
                d2.choice4(4, "c_jefferson", "c_jefferson.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta1m_gaskell": 
                try {
                d2.choice1(5, "m_gaskell", "m_gaskell.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2m_gaskell": 
                try {
                d2.choice2(5, "m_gaskell", "m_gaskell.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta3m_gaskell": 
                try {
                d2.choice3(5, "m_gaskell", "m_gaskell.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta4m_gaskell": 
                try {
                d2.choice4(5, "m_gaskell", "m_gaskell.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

        }

    }
}
