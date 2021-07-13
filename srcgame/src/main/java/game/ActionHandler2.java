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
    
    GameHandler gh;
    
    NPC prestcot, j_turner, r_starr, c_jefferson, m_gaskell = new NPC();
    List<String> Prestcot, J_Turner, Ramon, Jeff, Mark = new ArrayList<>();

    public ActionHandler2(GameHandler gh) {
        this.gh = gh;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String eventCommand = e.getActionCommand();

        switch (eventCommand) {
            case "goToReceptionFromHall":
                gh.day.goToSceneXtoY(9, 8);  //HALL -> RECEPTION
                break;

            case "goToHallFromReception":
                gh.day.goToSceneXtoY(8, 9);  //RECEPTION -> HALL
                break;

            case "StaircaseUP2":
                gh.day.goToSceneXtoY(9, 10); //HALL -> SUP
                break;

            case "StaircaseDown2":
                gh.day.goToSceneXtoY(10, 9); //CORRIDOIO SUP -> HALL
                break;

            case "goToRoomFromCorridor":
                gh.day.goToSceneXtoY(10, 11); //CORRID. -> CAMERA LETTO
                break;

            case "goToCorridor":
                gh.day.goToSceneXtoY(11, 10);  //CAMERA LETTO -> CORRID.
                break;

            case "goToVeranda":
                gh.day.goToSceneXtoY(11, 12);  //VERANDA
                break;

            case "goToRoomFromVeranda":
                gh.day.goToSceneXtoY(12, 10); //VERANDA -> CAMERA LETTO
                break;
                
            case "goToGossingtonHall": 
                gh.day.goToSceneXtoY(8, 2);
                break;
                
                case "enterHotel": 
                gh.day.goToSceneXtoY(7, 8);
                break;

            case "openInventory":
                gh.form.inv.setVisible(true);
                break;

            case "KnockRoom":
                gh.day2.knockRoom();
                break;
            case "continueTextScene7":
                gh.day.closeTextBox(7);
                break;
            case "continueTextScene8":
                gh.day.closeTextBox(8);
                break;

            case "continueTextScene9":
                gh.day.closeTextBox(9);
                break;

            case "continueTextScene10":
                gh.day.closeTextBox(10);
                break;

            case "continueTextScene11":
                gh.day.closeTextBox(11);
                break;

            case "continueTextScene12":
                gh.day.closeTextBox(12);
                break;

            case "continueDialog8":
                gh.day.continueDialogue(8);
                break;

            case "continueDialog9":
                gh.day.continueDialogue(9);
                break;

            case "continueDialog10":
                gh.day.continueDialogue(10);
                break;

            case "continueDialog11":
                gh.day.continueDialogue(11);
                break;

            case "continueDialog12":
                gh.day.continueDialogue(12);
                break;
            case "closeTextScene8":
                gh.day.closeTextBox(8);
                break;

            case "closeTextScene9":
                gh.day.closeTextBox(9);
                break;

            case "closeTextScene10":
                gh.day.closeTextBox(10);
                break;

            case "closeTextScene11":
                gh.day.closeTextBox(11);
                break;

            case "closeTextScene12":
                gh.day.closeTextBox(12);
                break;

            case "ObserveOwner":
                gh.day.observeNPC(8, prestcot, "prestcot");
                break;

            case "ObserveRamon":
                gh.day.observeNPC(9, r_starr, "r_starr");
                break;

            case "ObserveJosephine":
                gh.day.observeNPC(9, j_turner, "j_turner");
                break;

            case "ObserveJefferson":
                gh.day.observeNPC(11, c_jefferson, "c_jefferson");
                break;

            case "ObserveMark":
                gh.day.observeNPC(12, m_gaskell, "m_gaskell");
                break;

            case "TalkOwner":
                try {
                gh.day.talkNPC(8, "prestcot.txt", Prestcot, "/IconPrestcot.png", "prestcot", false,this);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "TalkRamon":
                try {
                gh.day.talkNPC(9, "r_starr.txt", Ramon, "/IconRamon.png", "r_starr", false,this);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "TalkJosephine":
                try {
                gh.day.talkNPC(9, "j_turner.txt", J_Turner, "/IconJosephine.png", "j_turner", false,this);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "TalkJefferson":
                try {
                gh.day.talkNPC(11, "c_jefferson.txt", Jeff, "/IconJeff.png", "c_jefferson", false,this);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "TalkMark":
                try {
                gh.day.talkNPC(12, "m_gaskell.txt", Mark, "/IconMark.png", "m_gaskell", false,this);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta1prestcot": 
                try {
                gh.day.choice1(8, "prestcot", "prestcot.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2prestcot": 
                try {
                gh.day.choice2(8, "prestcot", "prestcot.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta3prestcot": 
                try {
                gh.day.choice3(8, "prestcot", "prestcot.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta4prestcot": 
                try {
                gh.day.choice4(8, "prestcot", "prestcot.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta1j_turner": 
                try {
                gh.day.choice1(9, "j_turner", "j_turner.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2j_turner": 
                try {
                gh.day.choice2(9, "j_turner", "j_turner.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta3j_turner": 
                try {
                gh.day.choice3(9, "j_turner", "j_turner.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta4j_turner": 
                try {
                gh.day.choice4(9, "j_turner", "j_turner.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta1r_starr": 
                try {
                gh.day.choice1(9, "r_starr", "r_starr.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2r_starr": 
                try {
                gh.day.choice2(9, "r_starr", "r_starr.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta3r_starr": 
                try {
                gh.day.choice3(9, "r_starr", "r_starr.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta4r_starr": 
                try {
                gh.day.choice4(9, "r_starr", "r_starr.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta1c_jefferson": 
                try {
                gh.day.choice1(11, "c_jefferson", "c_jefferson.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2c_jefferson": 
                try {
                gh.day.choice2(11, "c_jefferson", "c_jefferson.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta3c_jefferson": 
                try {
                gh.day.choice3(11, "c_jefferson", "c_jefferson.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta4c_jefferson": 
                try {
                gh.day.choice4(11, "c_jefferson", "c_jefferson.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta1m_gaskell": 
                try {
                gh.day.choice1(12, "m_gaskell", "m_gaskell.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2m_gaskell": 
                try {
                gh.day.choice2(12, "m_gaskell", "m_gaskell.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta3m_gaskell": 
                try {
                gh.day.choice3(12, "m_gaskell", "m_gaskell.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta4m_gaskell": 
                try {
                gh.day.choice4(12, "m_gaskell", "m_gaskell.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

        }

    }
}
