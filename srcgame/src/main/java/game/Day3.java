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
public class Day3 extends DayDescription {

    public Day3(GameHandler gh) {
        super(gh);
    }
    
  NPC person = new NPC();
  List<String> A_palck,C_melch = new ArrayList<>(); 

    public void chooseSuspected() {
        gh.form.detectiveSinistra[15].setVisible(true);
        gh.form.icon[15].setVisible(true);
        gh.form.textButton[15].setVisible(true);
        gh.form.textBox[15].setVisible(true);
        gh.form.textAreaBox[15].setVisible(true);
        gh.form.dialogueButton1[15].setVisible(true);
        gh.form.dialogueButton2[15].setVisible(true);
        gh.form.dialogueButton3[15].setVisible(true);
        gh.form.dialogueButton4[15].setVisible(true);
        gh.form.detectiveDestra[15].setVisible(!true);
        gh.form.dialogueButton1[15].setSelected(false);
        gh.form.dialogueButton2[15].setSelected(false);
        gh.form.dialogueButton3[15].setSelected(false);
        gh.form.dialogueButton4[15].setSelected(false);
        gh.form.textButton[15].setActionCommand("continueTextScene" + 15);
        gh.form.textAreaBox[15].setText("Scegli chi vuoi interrogare?");
        
        gh.form.dialogueButton1[15].setText("Rino");
        gh.form.dialogueButton2[15].setText("Jefferson");
        gh.form.dialogueButton1[15].setBounds(410, 780, 600, 50);
        gh.form.dialogueButton2[15].setBounds(960, 780, 600, 50);
        gh.form.dialogueButton3[15].setText("Basil Blake");
        gh.form.dialogueButton4[15].setText("Mark Gaskell e Josephine Turner");
        gh.form.dialogueButton1[15].addActionListener(gh.actHandler3);
        gh.form.dialogueButton1[15].setActionCommand("scelta1rino");
        gh.form.dialogueButton2[15].addActionListener(gh.actHandler3);
        gh.form.dialogueButton2[15].setActionCommand("scelta2jefferson");
        gh.form.dialogueButton3[15].addActionListener(gh.actHandler3);
        gh.form.dialogueButton3[15].setActionCommand("scelta3basil");
        gh.form.dialogueButton4[15].addActionListener(gh.actHandler3);
        gh.form.dialogueButton4[15].setActionCommand("scelta4markjosephine");

    }
    
    public void setSuspectedFalse(int bgNum){
        Component[] object = gh.form.bgPanel[15].getComponents();
        object[bgNum].setVisible(false);
    }
    
    public void setSuspectedTrue(int bgNum){
        Component[] object = gh.form.bgPanel[15].getComponents();
        gh.day.closeTextBox(15);
        object[bgNum].setVisible(true);
    }
    public void talkNPCLast(int bgNum, String fileName, String iconName, String id, Boolean labelSx, ActionHandler actHandler) throws IOException {
        i = 0;
        readFile(fileName);
        npcListD = DialogHandler.SelectDialogOption(file, DialogHandler.DIALOG_FINAL_START, DialogHandler.DIALOG_FINAL_END);
        gh.form.textButton[bgNum].setVisible(true);
        gh.form.textBox[bgNum].setVisible(true);
        gh.form.textAreaBox[bgNum].setVisible(true);
        gh.form.textAreaBox2[bgNum].setVisible(true);
        gh.form.icon[bgNum].setVisible(true);
        setIcon(bgNum, iconName);
        gh.form.textAreaBox[bgNum].setText(npcListD.get(i));
        gh.form.textAreaBox2[bgNum].setText(npcListD.get(i + 1));
        gh.form.textButton[bgNum].setActionCommand("continueDialog" + bgNum);
        gh.form.textButton[bgNum].setText("Continua");
        
    }
}
