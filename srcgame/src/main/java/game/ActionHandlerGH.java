/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * ActionHandler specifico della prima location del gioco, che fa override dell' unico
 * metodo dell'interfaccia ActionListener nonchè della sua superclasse ActionHandler
 * 
 *
 * @author tom
 */
public class ActionHandlerGH extends ActionHandler {

    GameHandler gh;

    public ActionHandlerGH(GameHandler gh) {
        this.gh = gh;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String eventCommand = e.getActionCommand();

        switch (eventCommand) {
            case "goToCorridorFromDRoom":
                gh.getDay().goToSceneXtoY(1, 2);  //DINING ROOM -> CORRIDOIO INF.
                break;

            case "WestRoomCorridor1":
                gh.getDay().goToSceneXtoY(2, 1);  //CORRIDOIO INF -> DINING ROOM
                break;

            case "EastRoomCorridor1":
                gh.getDay().goToSceneXtoY(2, 3);  //LIVING ROOM
                break;

            case "goToCorridorFromLRoom":
                gh.getDay().goToSceneXtoY(3, 2); //LIVING ROOM -> CORRIDOIO
                break;

            case "StaircaseUP1":
                gh.getDay().goToSceneXtoY(2, 4); //CORRIDOIO INF -> SUP                
                break;

            case "StaircaseDown1":
                gh.getDay().goToSceneXtoY(4, 2); //CORRIDOIO SUP -> INF
                gh.getDay().checkInventory(2, 2, 16);
                break;

            case "WestRoomCorridor2":
                gh.getDay().goToSceneXtoY(4, 5);  //STUDY
                break;

            case "EastRoomCorridor2":
                gh.getDay().goToSceneXtoY(4, 6); //LIBRARY
                break;

            case "goToCorridorFromStudy":
                gh.getDay().goToSceneXtoY(5, 4); //STUDIO -> CORRIDOIO SUP.
                break;

            case "goToCorridorFromLibrary":
                gh.getDay().goToSceneXtoY(6, 4); //LIBRARY -> CORRIDOIO SUP.
                break;

            case "goToHotel":
                gh.getDay().goToSceneXtoY(2, 7);
                break;

            case "openInventory":
                gh.getInv().setVisible(true);
                break;

            case "continueTextScene1":
                gh.getDay().closeTextBox(1);
                break;

            case "continueTextScene2":
                gh.getDay().closeTextBox(2);
                break;

            case "continueTextScene3":
                gh.getDay().closeTextBox(3);
                break;

            case "continueTextScene4":
                gh.getDay().closeTextBox(4);
                break;

            case "continueTextScene5":
                gh.getDay().closeTextBox(5);
                break;

            case "continueTextScene6":
                gh.getDay().closeTextBox(6);
                break;

            case "continueDialog1d_bantry":
                gh.getDay().continueDialogue(1,"Dolly");
                break;
                
            case "continueDialog1j_marple":
                gh.getDay().continueDialogue(1,"Jane");
                break;

            case "continueDialog2":
                gh.getDay().continueDialogue(2,"");
                break;

            case "continueDialog3lorrimer":
                gh.getDay().continueDialogue(3,"Lorrimer");
                break;

            case "continueDialog5b_blake":
                gh.getDay().continueDialogue(5,"Basil");
                break;
                
            case "continueDialog5a_bantry":
                gh.getDay().continueDialogue(5,"ABantry");
                break;

            case "continueDialog6haydock":
                gh.getDay().continueDialogue(6,"Haydoc");
                break;

            case "ObserveDiningRoom":
                gh.getDay().observeSceneX(2, gh.getDay1().rooms, "diningRoom");
                break;

            case "ObserveLivingRoom":
                gh.getDay().observeSceneX(2, gh.getDay1().rooms, "livingRoom");
                break;

            case "ObserveStudy":
                gh.getDay().observeSceneX(4, gh.getDay1().rooms, "studio");
                break;

            case "ObserveLibrary":
                gh.getDay().observeSceneX(4, gh.getDay1().rooms, "library");
                break;

            case "ObserveDolly":
                gh.getDay().observeNPC(1, gh.getDay1().person, "d_bantry");
                break;

            case "TalkDolly": 
                try {
                gh.getDay().talkNPC(1, "d_bantry.txt", gh.getDay1().D_bantry, "/IconDollyB.png", "d_bantry", true, this);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta1d_bantry": 
                try {
                gh.getDay().choice1(1, "d_bantry", "d_bantry.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2d_bantry": 
                try {
                gh.getDay().choice2(1, "d_bantry", "d_bantry.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta3d_bantry": 
                try {
                gh.getDay().choice3(1, "d_bantry", "d_bantry.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta4d_bantry": 
                try {
                gh.getDay().choice4(1, "d_bantry", "d_bantry.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "ObserveJane":
                gh.getDay().observeNPC(1, gh.getDay1().person, "j_marple");
                break;

            case "TalkJane": 
                try {
                gh.getDay().talkNPC(1, "j_marple.txt", gh.getDay1().Jane_marple, "/IconMarple.png", "j_marple", false, this);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta1j_marple": 
                try {
                gh.getDay().choice1(1, "j_marple", "j_marple.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta2j_marple": 
                try {
                gh.getDay().choice2(1, "j_marple", "j_marple.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta3j_marple": 
                try {
                gh.getDay().choice3(1, "j_marple", "j_marple.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta4j_marple": 
                try {
                gh.getDay().choice4(1, "j_marple", "j_marple.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "ObserveLorrimer":
                gh.getDay().observeNPC(3, gh.getDay1().person, "lorrimer");
                break;

            case "TalkLorrimer": 
                try {
                gh.getDay().talkNPC(3, "lorrimer.txt", gh.getDay1().Lorri, "/IconLorrimer.png", "lorrimer", true, this);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta1lorrimer": 
                try {
                gh.getDay().choice1(3, "lorrimer", "lorrimer.txt");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta2lorrimer": 
                try {
                gh.getDay().choice2(3, "lorrimer", "lorrimer.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta3lorrimer": 
                try {
                gh.getDay().choice3(3, "lorrimer", "lorrimer.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta4lorrimer": 
                try {
                gh.getDay().choice4(3, "lorrimer", "lorrimer.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "ObserveBasil":
                gh.getDay().observeNPC(5, gh.getDay1().person, "b_blake");
                break;

            case "TalkBasil": 
                try {
                gh.getDay().talkNPC(5, "b_blake.txt", gh.getDay1().Basil, "/IconBlake.png", "b_blake", true, this);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta1b_blake": 
                try {
                gh.getDay().choice1(5, "b_blake", "b_blake.txt");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta2b_blake": 
                try {
                gh.getDay().choice2(5, "b_blake", "b_blake.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta3b_blake": 
                try {
                gh.getDay().choice3(5, "b_blake", "b_blake.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta4b_blake": 
                try {
                gh.getDay().choice4(5, "b_blake", "b_blake.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "ObserveABantry":
                gh.getDay().observeNPC(5, gh.getDay1().person, "a_bantry");
                break;

            case "TalkABantry": 
                try {
                gh.getDay().talkNPC(5, "a_bantry.txt", gh.getDay1().Arthur, "/IconArthur.png", "a_bantry", false, this);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta1a_bantry": 
                try {
                gh.getDay().choice1(5, "a_bantry", "a_bantry.txt");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2a_bantry": 
                try {
                gh.getDay().choice2(5, "a_bantry", "a_bantry.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta3a_bantry": 
                try {
                gh.getDay().choice3(5, "a_bantry", "a_bantry.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta4a_bantry": 
                try {
                gh.getDay().choice4(5, "a_bantry", "a_bantry.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "ObserveHaydoc":
                gh.getDay().observeNPC(6, gh.getDay1().person, "haydock");
                break;

            case "TalkHaydoc": 
                try {
                gh.getDay().talkNPC(6, "haydock.txt", gh.getDay1().Doc, "/IconDoc.png", "haydock", false, this);                

            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta1haydock": 
                try {
                gh.getDay().choice1(6, "haydock", "haydock.txt");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "scelta2haydock": 
                try {
                gh.getDay().choice2(6, "haydock", "haydock.txt");                
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta3haydock": 
                JOptionPane.showMessageDialog(gh.getForm(), "Hai ricevuto [AUTOPSIA] dalla dottoressa Haydock", "Novità Inventario", JOptionPane.WARNING_MESSAGE);
                try {
                gh.getDay().choice3(6, "haydock", "haydock.txt");                
                gh.getDay1().takeAutopsy();
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "scelta4haydock": 
                try {
                gh.getDay().choice4(6, "haydock", "haydock.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActionHandlerGH.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case "ObserveBody":
                gh.getDay().observeNPC(6, gh.getDay1().person, "corpse");
                break;

            case "AnalizeBody":
                JOptionPane.showMessageDialog(gh.getForm(), "Ispezionando il cadavere, hai ottenuto [VESTITO BIANCO]", "Novità Inventario", JOptionPane.WARNING_MESSAGE);
                gh.getDay1().analizeBody();
                break;

        }
    }
}
