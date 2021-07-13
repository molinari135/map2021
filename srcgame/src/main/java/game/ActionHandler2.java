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
public class ActionHandler2 extends ActionHandler {
    Day2 day2 = new Day2();
    DayDescription d2;

    NPC prestcot, j_turner, r_starr, c_jefferson, m_gaskell = new NPC();
    List<String> Prestcot, J_Turner, Ramon, Jeff, Mark = new ArrayList<>();

    public ActionHandler2(DayDescription d2) {
        this.d2 = d2;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String eventCommand = e.getActionCommand();

        switch (eventCommand) {
            case "goToReceptionFromHall":
                d2.goToSceneXtoY(9, 8);  //HALL -> RECEPTION
                break;

            case "goToHallFromReception":
                d2.goToSceneXtoY(8, 9);  //RECEPTION -> HALL
                break;

            case "StaircaseUP2":
                d2.goToSceneXtoY(9, 10); //HALL -> SUP
                break;

            case "StaircaseDown2":
                d2.goToSceneXtoY(10, 9); //CORRIDOIO SUP -> HALL
                break;

            case "goToRoomFromCorridor":
                d2.goToSceneXtoY(10, 11); //CORRID. -> CAMERA LETTO
                break;

            case "goToCorridor":
                d2.goToSceneXtoY(11, 10);  //CAMERA LETTO -> CORRID.
                break;

            case "goToVeranda":
                d2.goToSceneXtoY(11, 12);  //VERANDA
                break;

            case "goToRoomFromVeranda":
                d2.goToSceneXtoY(12, 10); //VERANDA -> CAMERA LETTO
                break;

            case "openInventory":
                d2.form.inv.setVisible(true);
                break;

            case "KnockRoom":
                day2.knockRoom();
                break;
            case "continueTextScene7":
                d2.closeTextBox(7);
                break;
            case "continueTextScene8":
                d2.closeTextBox(8);
                break;

            case "continueTextScene9":
                d2.closeTextBox(9);
                break;

            case "continueTextScene10":
                d2.closeTextBox(10);
                break;

            case "continueTextScene11":
                d2.closeTextBox(11);
                break;

            case "continueTextScene12":
                d2.closeTextBox(12);
                break;

            case "continueDialog8":
                d2.continueDialogue(8);
                break;

            case "continueDialog9":
                d2.continueDialogue(9);
                break;

            case "continueDialog10":
                d2.continueDialogue(10);
                break;

            case "continueDialog11":
                d2.continueDialogue(11);
                break;

            case "continueDialog12":
                d2.continueDialogue(12);
                break;
            case "closeTextScene8":
                d2.closeTextBox(8);
                break;

            case "closeTextScene9":
                d2.closeTextBox(9);
                break;

            case "closeTextScene10":
                d2.closeTextBox(10);
                break;

            case "closeTextScene11":
                d2.closeTextBox(11);
                break;

            case "closeTextScene12":
                d2.closeTextBox(12);
                break;

            case "ObserveOwner":
                d2.observeNPC(8, prestcot, "prestcot");
                break;

            case "ObserveRamon":
                d2.observeNPC(9, r_starr, "r_starr");
                break;

            case "ObserveJosephine":
                d2.observeNPC(9, j_turner, "j_turner");
                break;

            case "ObserveJefferson":
                d2.observeNPC(11, c_jefferson, "c_jefferson");
                break;

            case "ObserveMark":
                d2.observeNPC(12, m_gaskell, "m_gaskell");
                break;

            case "TalkOwner":
                try {
                d2.talkNPC(8, "prestcot.txt", Prestcot, "/IconPrestcot.png", "prestcot", false,this);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "TalkRamon":
                try {
                d2.talkNPC(9, "r_starr.txt", Ramon, "/IconRamon.png", "r_starr", false,this);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "TalkJosephine":
                try {
                d2.talkNPC(9, "j_turner.txt", J_Turner, "/IconJosephine.png", "j_turner", false,this);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "TalkJefferson":
                try {
                d2.talkNPC(11, "c_jefferson.txt", Jeff, "/IconJeff.png", "c_jefferson", false,this);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "TalkMark":
                try {
                d2.talkNPC(12, "m_gaskell.txt", Mark, "/IconMark.png", "m_gaskell", false,this);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta1prestcot": 
                try {
                d2.choice1(8, "prestcot", "prestcot.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2prestcot": 
                try {
                d2.choice2(8, "prestcot", "prestcot.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta3prestcot": 
                try {
                d2.choice3(8, "prestcot", "prestcot.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta4prestcot": 
                try {
                d2.choice4(8, "prestcot", "prestcot.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta1j_turner": 
                try {
                d2.choice1(9, "j_turner", "j_turner.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2j_turner": 
                try {
                d2.choice2(9, "j_turner", "j_turner.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta3j_turner": 
                try {
                d2.choice3(9, "j_turner", "j_turner.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta4j_turner": 
                try {
                d2.choice4(9, "j_turner", "j_turner.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta1r_starr": 
                try {
                d2.choice1(9, "r_starr", "r_starr.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2r_starr": 
                try {
                d2.choice2(9, "r_starr", "r_starr.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta3r_starr": 
                try {
                d2.choice3(9, "r_starr", "r_starr.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta4r_starr": 
                try {
                d2.choice4(9, "r_starr", "r_starr.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta1c_jefferson": 
                try {
                d2.choice1(11, "c_jefferson", "c_jefferson.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2c_jefferson": 
                try {
                d2.choice2(11, "c_jefferson", "c_jefferson.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta3c_jefferson": 
                try {
                d2.choice3(11, "c_jefferson", "c_jefferson.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta4c_jefferson": 
                try {
                d2.choice4(11, "c_jefferson", "c_jefferson.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta1m_gaskell": 
                try {
                d2.choice1(12, "m_gaskell", "m_gaskell.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2m_gaskell": 
                try {
                d2.choice2(12, "m_gaskell", "m_gaskell.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta3m_gaskell": 
                try {
                d2.choice3(12, "m_gaskell", "m_gaskell.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta4m_gaskell": 
                try {
                d2.choice4(12, "m_gaskell", "m_gaskell.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

        }

    }
}
