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
                d2.talkNPC(1, "r_starr.txt", Ramon, "/IconRamon.png", "r_starr", false);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
                break;

            case "TalkJosephine":
                try {
                d2.talkNPC(1, "j_turner.txt", J_Turner, "/IconJosephine.png", "j_turner", false);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
                break;

            case "TalkJefferson":
                try {
                d2.talkNPC(1, "c_jefferson.txt", Jeff, "/IconJeff.png", "c_jefferson", false);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
                break;

            case "TalkMark":
                try {
                d2.talkNPC(1, "m_gaskell.txt", Mark, "/IconMark.png", "m_gaskell", false);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
                break;

            case "scelta1owner": 
                try {
                d2.choice1(1, "prestcot", "prestcot.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2owner": 
                try {
                d2.choice2(1, "prestcot", "prestcot.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta3owner": 
                try {
                d2.choice3(1, "prestcot", "prestcot.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta4owner": 
                try {
                d2.choice4(1, "prestcot", "prestcot.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta1josephine": 
                try {
                d2.choice1(1, "j_turner", "j_turner.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2josephine": 
                try {
                d2.choice2(1, "j_turner", "j_turner.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta3josephine": 
                try {
                d2.choice3(1, "j_turner", "j_turner.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta4josephine": 
                try {
                d2.choice4(1, "j_turner", "j_turner.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta1ramon": 
                try {
                d2.choice1(1, "r_starr", "r_starr.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2ramon": 
                try {
                d2.choice2(1, "r_starr", "r_starr.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta3ramon": 
                try {
                d2.choice3(1, "r_starr", "r_starr.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta4ramon": 
                try {
                d2.choice4(1, "r_starr", "r_starr.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta1jefferson": 
                try {
                d2.choice1(1, "c_jefferson", "c_jefferson.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2jefferson": 
                try {
                d2.choice2(1, "c_jefferson", "c_jefferson.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta3jefferson": 
                try {
                d2.choice3(1, "c_jefferson", "c_jefferson.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta4jefferson": 
                try {
                d2.choice4(1, "c_jefferson", "c_jefferson.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta1mark": 
                try {
                d2.choice1(1, "m_gaskell", "m_gaskell.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2mark": 
                try {
                d2.choice2(1, "m_gaskell", "m_gaskell.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta3mark": 
                try {
                d2.choice3(1, "m_gaskell", "m_gaskell.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta4mark": 
                try {
                d2.choice4(1, "m_gaskell", "m_gaskell.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

        }

    }
}
