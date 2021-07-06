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
                d1.goToScene2();
                break;
                
            case "goToDRoomFromCorridor": 
                d1.goToScene1();
                break;
                
            case "EastRoomCorridor1":
                d1.goToScene1();
                break;
        }
    }

}
