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

/**
 *
 * @author giaco
 */
public class ActionHandlerPS extends ActionHandler {

    GameHandler gh;

    public ActionHandlerPS(GameHandler gh) {
        this.gh = gh;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String eventCommand = e.getActionCommand();

        switch (eventCommand) {
            case "openInventory":
                gh.inv.setVisible(true);
                break;
            case "enterPoliceStation":
                gh.day.goToSceneXtoY(13, 14);
                break;

            case "goToReceptionFromStation":
                gh.day.goToSceneXtoY(14, 8);
                break;
            case "goToInterrogation":
                gh.day.goToSceneXtoY(14, 15);
                break;
            case "goToStationFromInterrogation":
                gh.day.goToSceneXtoY(15, 14);
                break;
            case "continueTextScene14":
                gh.day.closeTextBox(14);
                break;
            case "continueTextScene15":
                gh.day.closeTextBox(15);
                break;

            case "continueDialog14":
                gh.day.continueDialogue(14);
                break;

            case "continueDialog15":
                gh.day.continueDialogue(15);
                break;
            case "continueDialogFinaletrue":
            {
                try {
                    gh.day.continueFinalDialogue(15,true,"true_ending.txt");
                } catch (IOException ex) {
                    Logger.getLogger(ActionHandlerPS.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;

            case "continueDialogFinalefalse1":
            {
                try {
                    gh.day.continueFinalDialogue(15,false,"b_blake_ending.txt");
                } catch (IOException ex) {
                    Logger.getLogger(ActionHandlerPS.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;
            case "continueDialogFinalefalse2":
            {
                try {
                    gh.day.continueFinalDialogue(15,false,"a_bantry_ending.txt");
                } catch (IOException ex) {
                    Logger.getLogger(ActionHandlerPS.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;

            case "continueTrueEnding":
                gh.day.continueTrueEnding(16);
                break;
            case "continueFalseEnding":
                gh.day.continueFalseEnding(17);
                break;
            case "closeTextScene14":
                gh.day.closeTextBox(14);
                break;

            case "closeTextScene15":
                gh.day.closeTextBox(15);
                break;
           
            case "ObserveMelchett":
                gh.day.observeNPC(14, gh.day3.person, "c_melchett");
                break;

            case "ObservePalck":
                gh.day.observeNPC(14, gh.day3.person, "a_palk");
                break;

            case "ObserveBasil":
                gh.day.observeNPC(15, gh.day3.person, "b_blake");
                break;

            case "ObserveJefferson":
                gh.day.observeNPC(15, gh.day3.person, "c_jefferson");
                break;
            
            case "TalkMelchett":
                try {
                gh.day.talkNPC(14, "c_melchett.txt", gh.day3.A_palck, "/IconMelchett.png", "c_melchett", true, this);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "TalkPalck":
                try {
                gh.day.talkNPC(14, "palk.txt", gh.day3.C_melch, "/IconPalk.png", "palk", false, this);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "TalkBasil":
                    try {
                gh.day.talkNPCLast(15, "b_blake_ending.txt", "/IconBlake.png", "b_blake", true, this,"false1");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;
            case "TalkJefferson":
                    try {
                gh.day3.talkNPCLast(15, "b_blake_ending.txt", "/IconJeff.png", "c_jefferson", true, this,"false2");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "TalkMarkJosephine":
                    try {
                gh.day3.talkNPCLast(15, "true_ending.txt", "/IconJosephine.png", "m_j_gaskell", true, this,"true");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta1palk": 
                try {
                gh.day.choice1(14, "palk", "palk.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2palk": 
                try {
                gh.day.choice2(14, "palk", "palk.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta3palk": 
                try {
                gh.day.choice3(14, "palk", "palk.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta1c_melchett": 
                try {
                gh.day.choice1(14, "c_melchett", "c_melchett.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2c_melchett": 
                try {
                gh.day.choice2(14, "c_melchett", "c_melchett.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta3c_melchett": 
                try {
                gh.day.choice3(14, "c_melchett", "c_melchett.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "chooseSuspected":
                gh.day3.chooseSuspected();
                break;

           
            case "scelta2jefferson":
                gh.day3.setSuspectedFalse(16);
                gh.day3.setSuspectedFalse(17);
                gh.day3.setSuspectedTrue(15);

                break;

            case "scelta3basil":
                gh.day3.setSuspectedFalse(15);
                gh.day3.setSuspectedFalse(17);
                gh.day3.setSuspectedTrue(16);
                break;

            case "scelta4markjosephine":
                gh.day3.setSuspectedFalse(16);
                gh.day3.setSuspectedFalse(15);
                gh.day3.setSuspectedTrue(17);

                break;

        }
    }

}
