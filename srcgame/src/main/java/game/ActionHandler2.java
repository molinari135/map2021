/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import type.NPC;
import type.Room;

/**
 *
 * @author tom
 */
public class ActionHandler2 implements ActionListener {

    Day2_Form d2;

    NPC dolly, j_marple, corpse, lorrimer, a_bantry, haydock, b_blake = new NPC();
    Room ballRoom, hallwayHM, reception, jeffersonRoom, balcony = new Room();

    public ActionHandler2(Day2_Form d2) {
        this.d2 = d2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            String eventCommand = e.getActionCommand();

            switch (eventCommand) {
                case "goToReceptionFromHall":
                    d2.goToScene1();  //HALL -> RECEPTION
                    break;

                case "goToHallFromReception":
                    d2.goToScene2FromScene1();  //RECEPTION -> HALL
                    break;

                case "StaircaseUP2":
                    d2.goToScene3FromScene2(); //HALL -> SUP
                    break;

                case "StaircaseDown2":
                    d2.goToScene2FromScene3(); //CORRIDOIO SUP -> HALL
                    break;

                case "goToRoomFromCorridor":
                    d2.goToScene4FromScene3();  //CORRID. -> CAMERA LETTO
                    break;

                case "goToCorridor":
                    d2.goToScene3FromScene4();  //CAMERA LETTO -> CORRID.
                    break;

                case "KnockRoom":
                    d2.knockRoom();
                    break;

                case "goToVeranda":
                    d2.goToScene5();  //VERANDA
                    break;

                case "goToRoomFromVeranda":
                    d2.goToScene4FromScene5(); //VERANDA -> CAMERA LETTO
                    break;

                case "openInventory":
                    d2.inv.setVisible(true);
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
                    d2.observeOwner();
                    break;

                case "ObserveRamon":
                    d2.observeRamon();
                    break;

                case "ObserveJosephine":
                    d2.observeJosephine();
                    break;

                case "ObserveJefferson":
                    d2.observeJefferson();
                    break;

                case "ObserveMark":
                    d2.observeMark();
                    break;

                case "TalkOwner":
                    d2.talkOwner();
                    break;

                case "TalkRamon":
                    d2.talkRamon();
                    break;

                case "TalkJosephine":
                    d2.talkJosephine();
                    break;

                case "TalkJefferson":
                    d2.talkJefferson();
                    break;

                case "TalkMark":
                    d2.talkMark();
                    break;

                case "scelta1owner":
                    d2.choice1Owner();
                    break;

                case "scelta2owner":
                    d2.choice2Owner();
                    break;

                case "scelta3owner":
                    d2.choice3Owner();
                    break;

                case "scelta4owner":
                    d2.choice4Owner();
                    break;

                case "scelta1josephine":
                    d2.choice1Josephine();
                    break;

                case "scelta2josephine":
                    d2.choice2Josephine();
                    break;

                case "scelta3josephine":
                    d2.choice3Josephine();
                    break;

                case "scelta4josephine":
                    d2.choice4Josephine();
                    break;

                case "scelta1ramon":
                    d2.choice1Ramon();
                    break;

                case "scelta2ramon":
                    d2.choice2Ramon();
                    break;

                case "scelta3ramon":
                    d2.choice3Ramon();
                    break;

                case "scelta4ramon":
                    d2.choice4Ramon();
                    break;

                case "scelta1jefferson":
                    d2.choice1Jefferson();
                    break;

                case "scelta2jefferson":
                    d2.choice2Jefferson();
                    break;

                case "scelta3jefferson":
                    d2.choice3Jefferson();
                    break;

                case "scelta4jefferson":
                    d2.choice4Jefferson();
                    break;

                case "scelta1mark":
                    d2.choice1Mark();
                    break;

                case "scelta2mark":
                    d2.choice2Mark();
                    break;

                case "scelta3mark":
                    d2.choice3Mark();
                    break;

                case "scelta4mark":
                    d2.choice4Mark();
                    break;

                case "TakeDress":
                    d2.takeDress();
                    break;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ActionHandler2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
