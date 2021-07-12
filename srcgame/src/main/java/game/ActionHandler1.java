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
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author tom
 */
public class ActionHandler1 implements ActionListener {

    Day1_Form d1;
   
    public ActionHandler1(Day1_Form d1) {
        this.d1 = d1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String eventCommand = e.getActionCommand();

        switch (eventCommand) {
            case "goToCorridorFromDRoom":
                d1.goToScene2();  //DINING ROOM -> CORRIDOIO INF.
                break;

            case "WestRoomCorridor1":
                d1.goToScene1();  //CORRIDOIO INF -> DINING ROOM
                break;

            case "EastRoomCorridor1":
                d1.goToScene3();  //LIVING ROOM
                break;

            case "goToCorridorFromLRoom":
                d1.goToScene2FromLRoom(); //LIVING ROOM -> CORRIDOIO
                break;

            case "StaircaseUP1":
                d1.goToScene4(); //CORRIDOIO INF -> SUP
                break;

            case "StaircaseDown1":
                d1.goToScene2From1Floor(); //CORRIDOIO SUP -> INF
                break;

            case "WestRoomCorridor2":
                d1.goToScene5();  //STUDY
                break;

            case "EastRoomCorridor2":
                d1.goToScene6();  //LIBRARY
                break;

            case "goToCorridorFromStudy":
                d1.goToScene4FromScene5(); //STUDIO -> CORRIDOIO SUP.
                break;

            case "goToCorridorFromLibrary":
                d1.goToScene6FromScene4(); //LIBRARY -> CORRIDOIO SUP.
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

            case "continueDialog1" :
                d1.continueDialog(1);
                break;
            case "continueDialog2" :
                d1.continueDialog(2);
                break;
            case "continueDialog3" :
                d1.continueDialog(3);
                break;
            case "continueDialog5" :
                d1.continueDialog(5);
                break;
            case "continueDialog6" :
                d1.continueDialog(6);
                break;
                
            case "ObserveDiningRoom": {
                d1.observeScene1();
                break;
            }

            case "ObserveLivingRoom": {
                d1.observeScene3();
                break;
            }

            case "ObserveStudy": {
                d1.observeScene5();
                break;
            }

            case "ObserveLibrary": {
                d1.observeScene6();
                break;
            }

            case "ObserveDolly": {
                d1.observeDollyBantry();
                break;
            }
            
            case "TalkDolly":{
                try {
                    d1.talkDollyBantry();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                break;
            }
             case "scelta1d_bantry":
            {
                try {
                    d1.choice1(1,"d_bantry","d_bantry.txt");
                } catch (IOException ex) {
                    Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;



            case "scelta2d_bantry":
            {
                try {
                    d1.choice2(1, "d_bantry","d_bantry.txt");
                } catch (IOException ex) {
                    Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;


            case "scelta3d_bantry":
            {
                try {
                    d1.choice3(1, "d_bantry","d_bantry.txt");
                } catch (IOException ex) {
                    Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;


            case "scelta4d_bantry":
            {
                try {
                    d1.choice4(1, "d_bantry","d_bantry.txt");
                } catch (IOException ex) {
                    Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;


            case "ObserveJane": {
                d1.observeJaneMarple();
                break;
            }
            
            case "TalkJane":{
            try {
                d1.talkJaneMarple();
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;
            }
            
             case "scelta1j_marple":
            {
                try {
                    d1.choice1(1,"j_marple","j_marple.txt");
                } catch (IOException ex) {
                    Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;



            case "scelta2j_marple":
            {
                try {
                    d1.choice2(1, "j_marple","j_marple.txt");
                } catch (IOException ex) {
                    Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;


            case "scelta3j_marple":
            {
                try {
                    d1.choice3(1, "j_marple","j_marple.txt");
                } catch (IOException ex) {
                    Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;


            case "scelta4j_marple":
            {
                try {
                    d1.choice4(1, "j_marple","j_marple.txt");
                } catch (IOException ex) {
                    Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;

            case "ObserveLorrimer": {
                d1.observeLorrimer();
                break;
            }
            case "TalkLorrimer":{
            try {
                d1.talkLorrimer();
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;
            }
            case "scelta1lorrimer":
            {
                try {
                    d1.choice1(3,"lorrimer","lorrimer.txt");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
                break;


            case "scelta2lorrimer":
            {
                try {
                    d1.choice2(3, "lorrimer","lorrimer.txt");
                } catch (IOException ex) {
                    Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;


            case "scelta3lorrimer":
            {
                try {
                    d1.choice3(3, "lorrimer","lorrimer.txt");
                } catch (IOException ex) {
                    Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;


            case "scelta4lorrimer":
            {
                try {
                    d1.choice4(3, "lorrimer","lorrimer.txt");
                } catch (IOException ex) {
                    Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;
             case "ObserveBasil": {
                d1.observeBasil();
                break;
            }
            case "TalkBasil":{
            try {
                d1.talkBasil();
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;
            }
            case "scelta1b_blake":
            {
                try {
                    d1.choice1(5,"b_blake","b_blake.txt");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
                break;


            case "scelta2b_blake":
            {
                try {
                    d1.choice2(5,"b_blake","b_blake.txt");
                } catch (IOException ex) {
                    Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;


            case "scelta3b_blake":
            {
                try {
                    d1.choice3(5,"b_blake","b_blake.txt");
                } catch (IOException ex) {
                    Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;


            case "scelta4b_blake":
            {
                try {
                    d1.choice4(5,"b_blake","b_blake.txt");
                } catch (IOException ex) {
                    Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
             case "ObserveABantry": {
                d1.observeABantry();
                break;
            }
            case "TalkABantry":{
            try {
                d1.talkABantry();
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;
            }
            case "scelta1a_bantry":
            {
                try {
                    d1.choice1(5,"a_bantry","a_bantry.txt");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
                break;


            case "scelta2a_bantry":
            {
                try {
                    d1.choice2(5,"a_bantry","a_bantry.txt");
                } catch (IOException ex) {
                    Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;


            case "scelta3a_bantry":
            {
                try {
                    d1.choice3(5,"a_bantry","a_bantry.txt");
                } catch (IOException ex) {
                    Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;


            case "scelta4a_bantry":
            {
                try {
                    d1.choice4(5,"a_bantry","a_bantry.txt");
                } catch (IOException ex) {
                    Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
             case "ObserveHaydoc": {
                d1.observeHaydoc();
                break;
            }
            case "TalkHaydoc":{
            try {
                d1.talkHaydoc();
                
            } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;
            }
            
            case "scelta1haydock":
            {
                try {
                    d1.choice1(6,"haydock","haydock.txt");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
                break;


            case "scelta2haydock":
            {
                try {
                    d1.choice2(6,"haydock","haydock.txt");
                } catch (IOException ex) {
                    Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;


            case "scelta3haydock":
            {
                try {
                    d1.choice3(6,"haydock","haydock.txt");
                } catch (IOException ex) {
                    Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;


            case "scelta4haydock":
            {
                try {
                    d1.choice4(6,"haydock","haydock.txt");
                } catch (IOException ex) {
                    Logger.getLogger(ActionHandler1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;
            
             case "ObserveBody": {
                d1.observeBody();
                break;
            }
            case "AnalizeBody":{
            
                d1.analizeBody();
            
            break;
            }
            
        }
    }
}

            
