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
public class ActionHandler3 extends ActionHandler {

    GameHandler gh;

    public ActionHandler3(GameHandler gh) {
        this.gh = gh;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String eventCommand = e.getActionCommand();

        switch (eventCommand) {
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

            case "closeTextScene14":
                gh.day.closeTextBox(14);
                break;

            case "closeTextScene12":
                gh.day.closeTextBox(15);
                break;
            case "ObserveMelchett":
                gh.day.observeNPC(14, gh.day2.prestcot, "prestcot");
                break;

            case "ObservePalck":
                gh.day.observeNPC(14, gh.day2.r_starr, "r_starr");
                break;

            case "ObserveSuspected":
                
                break;
                
            case "TalkMelchett":
                try {
                gh.day.talkNPC(14, "c_melchett.txt", gh.day3.A_palck, "/IconPrestcot.png", "c_melchett", true, this);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "TalkPalck":
                try {
                gh.day.talkNPC(14, "palk.txt", gh.day3.C_melch, "/IconRamon.png", "palck", false, this);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "TalkSuspected":
             
            break;
            
             case "scelta1palck": 
                try {
                gh.day.choice1(14, "palck", "palk.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2palck": 
                try {
                gh.day.choice2(14, "palck", "palk.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta3palck": 
                try {
                gh.day.choice3(14, "palck", "palk.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta1c_melchett": 
                try {
                gh.day.choice1(14, "c_melchett", "c_melchett.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2c_melchett": 
                try {
                gh.day.choice2(14, "c_melchett", "c_melchett.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta3c_melchett": 
                try {
                gh.day.choice3(14, "c_melchett", "c_melchett.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "interroga":
                gh.day3.createInterrogation();
                break;
        }
    }

}
