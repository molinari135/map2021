/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author tom
 */
public class ActionHandlerMH extends ActionHandler {

    GameHandler gh;

    public ActionHandlerMH(GameHandler gh) {
        this.gh = gh;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String eventCommand = e.getActionCommand();

        switch (eventCommand) {

            case "goToPoliceStation":
                if (gh.getPlayer().getInventory().size() == 6) {
                    gh.getDay().goToSceneXtoY(8, 13);
                } else {
                   JOptionPane.showMessageDialog(gh.getForm(),
                           "Non hai raccolto ancora abbastanze prove per recarti alla stazione di polizia.",
                           "Info", JOptionPane.ERROR_MESSAGE);
                }
                break;

            case "goToReceptionFromHall":
                gh.getDay().goToSceneXtoY(9, 8);  //HALL -> RECEPTION                
                break;

            case "goToHallFromReception":
                gh.getDay().goToSceneXtoY(8, 9);  //RECEPTION -> HALL
                break;

            case "StaircaseUP2":
                gh.getDay().goToSceneXtoY(9, 10); //HALL -> SUP
                break;

            case "StaircaseDown2":
                gh.getDay().goToSceneXtoY(10, 9); //CORRIDOIO SUP -> HALL
                break;

            case "goToRoomFromCorridor":
                gh.getDay().goToSceneXtoY(10, 11); //CORRID. -> CAMERA LETTO
                break;

            case "goToCorridor":
                gh.getDay().goToSceneXtoY(11, 10);  //CAMERA LETTO -> CORRID.
                break;

            case "goToVeranda":
                gh.getDay().goToSceneXtoY(11, 12);  //VERANDA
                break;

            case "goToRoomFromVeranda":
                gh.getDay().goToSceneXtoY(12, 11); //VERANDA -> CAMERA LETTO
                break;

            case "goToGossingtonHall":
                gh.getDay().goToSceneXtoY(8, 2);
                break;

            case "enterHotel":
                gh.getDay().goToSceneXtoY(7, 8);
                break;

            case "openInventory":
                gh.getInv().setVisible(true);
                break;

            case "KnockRoom": {
                try {
                    gh.getDay2().knockRoom();
                } catch (InterruptedException ex) {
                    Logger.getLogger(ActionHandlerMH.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;

            case "continueTextScene7":
                gh.getDay().closeTextBox(7);
                break;
            case "continueTextScene8":
                gh.getDay().closeTextBox(8);
                break;

            case "continueTextScene9":
                gh.getDay().closeTextBox(9);
                break;

            case "continueTextScene10":
                gh.getDay().closeTextBox(10);
                break;

            case "continueTextScene11":
                gh.getDay().closeTextBox(11);
                break;

            case "continueTextScene12":
                gh.getDay().closeTextBox(12);
                break;

            case "continueDialog8prestcot":
                gh.getDay().continueDialogue(8,"Owner");
                break;

            case "continueDialog9r_starr":
                gh.getDay().continueDialogue(9,"Ramon");
                break;
           case "continueDialog9j_turner":
                gh.getDay().continueDialogue(9,"Josephine");
                break;

            case "continueDialog10":
                gh.getDay().continueDialogue(10,"");
                break;

            case "continueDialog11c_jefferson":
                gh.getDay().continueDialogue(11,"Jefferson");
                break;

            case "continueDialog12m_gaskell":
                gh.getDay().continueDialogue(12,"Mark");
                break;
            case "closeTextScene8":
                gh.getDay().closeTextBox(8);
                break;

            case "closeTextScene9":
                gh.getDay().closeTextBox(9);
                break;

            case "closeTextScene10":
                gh.getDay().closeTextBox(10);
                break;

            case "closeTextScene11":
                gh.getDay().closeTextBox(11);
                break;

            case "closeTextScene12":
                gh.getDay().closeTextBox(12);
                break;

            case "ObserveOwner":
                gh.getDay().observeNPC(8, gh.getDay2().person, "prestcot");
                break;

            case "ObserveRamon":
                gh.getDay().observeNPC(9, gh.getDay2().person, "r_starr");
                break;

            case "ObserveJosephine":
                gh.getDay().observeNPC(9, gh.getDay2().person, "j_turner");
                break;

            case "ObserveJefferson":
                gh.getDay().observeNPC(11, gh.getDay2().person, "c_jefferson");
                break;

            case "ObserveMark":
                gh.getDay().observeNPC(12, gh.getDay2().person, "m_gaskell");
                break;

            case "TalkOwner":
                try {
                gh.getDay().talkNPC(8, "prestcot.txt", gh.getDay2().Prestcot, "/IconPrestcot.png", "prestcot", false, this);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "TalkRamon":
                try {
                gh.getDay().talkNPC(9, "r_starr.txt", gh.getDay2().Ramon, "/IconRamon.png", "r_starr", false, this);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "TalkJosephine":
                try {
                gh.getDay().talkNPC(9, "j_turner.txt", gh.getDay2().J_Turner, "/IconJosephine.png", "j_turner", true, this);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "TalkJefferson":
                try {
                gh.getDay().talkNPC(11, "c_jefferson.txt", gh.getDay2().Jeff, "/IconJeff.png", "c_jefferson", true, this);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "TalkMark":
                try {
                gh.getDay().talkNPC(12, "m_gaskell.txt", gh.getDay2().Mark, "/IconMark.png", "m_gaskell", true, this);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta1prestcot": 
                try {
                gh.getDay().choice1(8, "prestcot", "prestcot.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2prestcot": 
                try {
                gh.getDay().choice2(8, "prestcot", "prestcot.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta3prestcot": 
                try {
                gh.getDay().choice3(8, "prestcot", "prestcot.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta4prestcot": 
                try {
                gh.getDay().choice4(8, "prestcot", "prestcot.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta1j_turner": 
                try {
                gh.getDay().choice1(9, "j_turner", "j_turner.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2j_turner": 
                try {
                gh.getDay().choice2(9, "j_turner", "j_turner.txt");
                gh.getDay2().takeDanceDress();
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta3j_turner": 
                try {
                gh.getDay().choice3(9, "j_turner", "j_turner.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta4j_turner": 
                try {
                gh.getDay().choice4(9, "j_turner", "j_turner.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta1r_starr": 
                try {
                gh.getDay().choice1(9, "r_starr", "r_starr.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2r_starr": 
                try {
                gh.getDay().choice2(9, "r_starr", "r_starr.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta3r_starr": 
                try {
                gh.getDay().choice3(9, "r_starr", "r_starr.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta4r_starr": 
                try {
                gh.getDay().choice4(9, "r_starr", "r_starr.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta1c_jefferson": 
                try {
                gh.getDay().choice1(11, "c_jefferson", "c_jefferson.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2c_jefferson": 
                try {
                gh.getDay().choice2(11, "c_jefferson", "c_jefferson.txt");
                gh.getDay2().takeAdoptionDoc();
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta3c_jefferson": 
                try {
                gh.getDay().choice3(11, "c_jefferson", "c_jefferson.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta4c_jefferson": 
                try {
                gh.getDay().choice4(11, "c_jefferson", "c_jefferson.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta1m_gaskell": 
                try {
                gh.getDay().choice1(12, "m_gaskell", "m_gaskell.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2m_gaskell": 
                try {
                gh.getDay().choice2(12, "m_gaskell", "m_gaskell.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta3m_gaskell": 
                try {
                gh.getDay().choice3(12, "m_gaskell", "m_gaskell.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta4m_gaskell": 
                try {
                gh.getDay().choice4(12, "m_gaskell", "m_gaskell.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "takeBill":
                gh.getDay2().takeBillDoc();
                break;

            case "observeBill":
                gh.getDay().observeObjectX(12, gh.getDay2().element, "mark_bill");
                break;

        }

    }
}
