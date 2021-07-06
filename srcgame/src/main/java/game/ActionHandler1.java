/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                
            case "apri inventario":
                new InventoryDialog(d1, true).setVisible(true);
        }

    }

}
