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
                gh.getInv().setVisible(true);
                break;
            case "enterPoliceStation":
                gh.getDay().goToSceneXtoY(13, 14);
                break;

            case "goToReceptionFromStation":
                gh.getDay().goToSceneXtoY(14, 8);
                break;
            case "goToInterrogation":
                gh.getDay().goToSceneXtoY(14, 15);
                break;
            case "goToStationFromInterrogation":
                gh.getDay().goToSceneXtoY(15, 14);
                break;
            case "continueTextScene14":
                gh.getDay().closeTextBox(14);
                break;
            case "continueTextScene15":
                gh.getDay().closeTextBox(15);
                break;

            case "continueDialog14":
                gh.getDay().continueDialogue(14);
                break;

            case "continueDialog15":
                gh.getDay().continueDialogue(15);
                break;
            case "continueDialogFinaletrue":
            {
                try {
                    gh.getDay().continueFinalDialogue(15,true,"true_ending.txt");
                } catch (IOException ex) {
                    Logger.getLogger(ActionHandlerPS.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;

            case "continueDialogFinalefalse1":
            {
                try {
                    gh.getDay().continueFinalDialogue(15,false,"b_blake_ending.txt");
                } catch (IOException ex) {
                    Logger.getLogger(ActionHandlerPS.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;
                
            case "continueDialogFinalefalse2":
            {
                try {
                    gh.getDay().continueFinalDialogue(15,false,"a_bantry_ending.txt");
                } catch (IOException ex) {
                    Logger.getLogger(ActionHandlerPS.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;

            case "continueTrueEnding":
                gh.getDay().continueTrueEnding(16);
                break;
            case "continueFalseEnding":
                gh.getDay().continueFalseEnding(17);
                break;
            case "closeTextScene14":
                gh.getDay().closeTextBox(14);
                break;

            case "closeTextScene15":
                gh.getDay().closeTextBox(15);
                break;
           
            case "ObserveMelchett":
                gh.getDay().observeNPC(14, gh.getDay3().person, "c_melchett");
                break;

            case "ObservePalk":
                gh.getDay().observeNPC(14, gh.getDay3().person, "a_palk");
                break;

            case "ObserveBasil":
                gh.getDay().observeNPC(15, gh.getDay3().person, "b_blake");
                break;

            case "ObserveArthur":
                gh.getDay().observeNPC(15, gh.getDay3().person, "a_bantry");
                break;
            case "ObserveMarkJosephine":
                gh.getDay().observeNPC(15, gh.getDay3().person, "m_gaskell");
                break;
            
            case "TalkMelchett":
                try {
                gh.getDay().talkNPC(14, "c_melchett.txt", gh.getDay3().A_palck, "/IconMelchett.png", "c_melchett", true, this);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "TalkPalk":
                try {
                gh.getDay().talkNPC(14, "palk.txt", gh.getDay3().C_melch, "/IconPalk.png", "palk", false, this);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "TalkBasil":
                    try {
                gh.getDay().talkNPCLast(15, "b_blake_ending.txt", "/IconBlake.png", "b_blake", true, this,"false1");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;
            case "TalkArthur":
                    try {
                gh.getDay().talkNPCLast(15, "a_bantry_ending.txt", "/IconArthur.png", "a_bantry", true, this,"false2");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "TalkMarkJosephine":
                    try {
                gh.getDay().talkNPCLast(15, "true_ending.txt", "/IconJosephine.png", "m_j_gaskell", true, this,"true");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta1palk": 
                try {
                gh.getDay().choice1(14, "palk", "palk.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2palk": 
                try {
                gh.getDay().choice2(14, "palk", "palk.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta3palk": 
                try {
                gh.getDay().choice3(14, "palk", "palk.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta1c_melchett": 
                try {
                gh.getDay().choice1(14, "c_melchett", "c_melchett.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2c_melchett": 
                try {
                gh.getDay().choice2(14, "c_melchett", "c_melchett.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta3c_melchett": 
                try {
                gh.getDay().choice3(14, "c_melchett", "c_melchett.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "chooseSuspected":
                gh.getDay3().chooseSuspected();
                break;

           
            case "scelta2a_bantry":
                gh.getDay3().setSuspectedFalse(16);
                gh.getDay3().setSuspectedFalse(17);
                gh.getDay3().setSuspectedTrue(15);

                break;

            case "scelta3basil":
                gh.getDay3().setSuspectedFalse(15);
                gh.getDay3().setSuspectedFalse(17);
                gh.getDay3().setSuspectedTrue(16);
                break;

            case "scelta4markjosephine":
                gh.getDay3().setSuspectedFalse(16);
                gh.getDay3().setSuspectedFalse(15);
                gh.getDay3().setSuspectedTrue(17);

                break;
            case "ExitGame":
                System.exit(0);
                break;
        }
    }

}
