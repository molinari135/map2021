/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import db.DialogHandler;
import java.awt.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JLabel;
import type.NPC;

/**
 *
 * @author giaco
 */
public class PoliceStation extends DayDescription {

    public PoliceStation(GameHandler gh) {
        super(gh);
    }
    
  NPC person = new NPC();
  List<String> A_palck,C_melch = new ArrayList<>(); 

    public void chooseSuspected() {
        gh.getForm().detectiveSinistra[15].setVisible(true);
        gh.getForm().icon[15].setVisible(false);
        gh.getForm().textButton[15].setVisible(true);
        gh.getForm().textBox[15].setVisible(true);
        gh.getForm().textAreaBox2[15].setVisible(false);
        gh.getForm().textAreaBox[15].setVisible(true);
        gh.getForm().dialogueButton1[15].setVisible(true);
        gh.getForm().dialogueButton2[15].setVisible(true);
        gh.getForm().dialogueButton3[15].setVisible(true);
        gh.getForm().dialogueButton4[15].setVisible(true);
        gh.getForm().detectiveDestra[15].setVisible(!true);
        gh.getForm().dialogueButton1[15].setSelected(false);
        gh.getForm().dialogueButton2[15].setSelected(false);
        gh.getForm().dialogueButton3[15].setSelected(false);
        gh.getForm().dialogueButton4[15].setSelected(false);
        gh.getForm().textButton[15].setActionCommand("continueTextScene" + 15);
        gh.getForm().textAreaBox[15].setText("Scegli chi vuoi interrogare?");
        
        gh.getForm().dialogueButton1[15].setText("Nessuno");
        gh.getForm().dialogueButton2[15].setText("Arthur");
        gh.getForm().dialogueButton1[15].setBounds(410, 780, 600, 50);
        gh.getForm().dialogueButton2[15].setBounds(960, 780, 600, 50);
        gh.getForm().dialogueButton3[15].setText("Basil Blake");
        gh.getForm().dialogueButton4[15].setText("Mark Gaskell e Josephine Turner");
        gh.getForm().dialogueButton1[15].addActionListener(gh.getActHandler3());
        gh.getForm().dialogueButton1[15].setActionCommand("");
        gh.getForm().dialogueButton2[15].addActionListener(gh.getActHandler3());
        gh.getForm().dialogueButton2[15].setActionCommand("scelta2a_bantry");
        gh.getForm().dialogueButton3[15].addActionListener(gh.getActHandler3());
        gh.getForm().dialogueButton3[15].setActionCommand("scelta3basil");
        gh.getForm().dialogueButton4[15].addActionListener(gh.getActHandler3());
        gh.getForm().dialogueButton4[15].setActionCommand("scelta4markjosephine");

    }
    
    public void setSuspectedFalse(int bgNum) {
        gh.getDay().closeTextBox(15);
        Component[] object = gh.getForm().bgPanel[15].getComponents();
        object[bgNum].setVisible(false);
    }

    public void setSuspectedTrue(int bgNum) {
        Component[] object = gh.getForm().bgPanel[15].getComponents();
        gh.getDay().closeTextBox(15);
        object[bgNum].setVisible(true);
    }
   
}
