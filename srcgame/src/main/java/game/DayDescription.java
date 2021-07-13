package game;

import db.DataHandler;
import db.DialogHandler;
import static game.Main.listNPC;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import type.NPC;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rino
 */
public class DayDescription {
        
    public Day_Form form;
    int i = 0;
    //TODO spostare in DAY1
    

    List<String> npcListD = new ArrayList<>();

    ArrayList<String> list = new ArrayList<>();

    File file;
    
    DayDescription(Day_Form form){
        this.form = form;
    }
    public void goToSceneXtoY(int x, int y) {
        form.bgPanel[x].setVisible(false);
        form.bgPanel[y].setVisible(true);
        closeTextBox(x);
    }

    public void observeSceneX(int x, String roomDesc) {
        form.textBox[x].setVisible(true);
        form.textAreaBox[x].setVisible(true);
        form.textButton[x].setVisible(true);
        //TODO file
        form.textAreaBox[x].setText(roomDesc);
    }
    
    public void observeNPC(int bgNum, NPC npc, String npcName) {
        form.dialogueButton1[bgNum].setVisible(false);
        form.dialogueButton2[bgNum].setVisible(false);
        form.dialogueButton3[bgNum].setVisible(false);
        form.dialogueButton4[bgNum].setVisible(false);
        form.detectiveDestra[bgNum].setVisible(false);
        form.detectiveSinistra[bgNum].setVisible(false);
        form.textAreaBox[bgNum].setVisible(true);
        form.icon[bgNum].setVisible(false);
        form.textBox[bgNum].setVisible(true);
        form.textAreaBox2[bgNum].setVisible(true);
        form.textButton[bgNum].setVisible(true);
        //TODO file
        npc = DataHandler.NpcFinder(listNPC, npcName);
        form.textAreaBox[bgNum].setText(npc.getName() + " " + npc.getSurname());
        form.textAreaBox2[bgNum].setText(npc.getDescription());
        form.textButton[bgNum].setActionCommand("continueTextScene" + bgNum);
    }
    
    public void talkNPC(int bgNum, String fileName, List<String> npc, String iconName, String id, Boolean labelSx,ActionHandler actHandler) throws IOException {
        readFile(fileName);
        npc = DialogHandler.SelectDialogOption(file, DialogHandler.DIALOG_OPTION_START, DialogHandler.DIALOG_OPTION_END);
        talkDialogue(bgNum, iconName, id, npc, labelSx,actHandler); //se bool vero, la label scelta è quella sx, destra altrimenti 
    }

    public void choice1(int bgNum, String npcName, String filename) throws FileNotFoundException, IOException {
        i = 0;
        form.dialogueButton1[bgNum].setVisible(false);
        form.dialogueButton2[bgNum].setVisible(false);
        form.dialogueButton3[bgNum].setVisible(false);
        form.dialogueButton4[bgNum].setVisible(false);
        readFile(filename);

        npcListD = DialogHandler.SelectDialogOption(file, DialogHandler.FIRST_DIALOG_START, DialogHandler.FIRST_DIALOG_END);
        System.out.println(npcListD.get(i));
        form.textAreaBox[bgNum].setText(npcListD.get(i));
        form.textAreaBox2[bgNum].setText(npcListD.get(i + 1));
        form.textButton[bgNum].setActionCommand("continueDialog" + bgNum);
        form.textButton[bgNum].setText("Continua");
    }

    public void choice2(int bgNum, String npcName, String filename) throws IOException {
        form.dialogueButton1[bgNum].setVisible(false);
        form.dialogueButton2[bgNum].setVisible(false);
        form.dialogueButton3[bgNum].setVisible(false);
        form.dialogueButton4[bgNum].setVisible(false);
        readFile(filename);

        npcListD = DialogHandler.SelectDialogOption(file, DialogHandler.SECOND_DIALOG_START, DialogHandler.SECOND_DIALOG_END);
        System.out.println(npcListD.get(i));
        form.textAreaBox[bgNum].setText(npcListD.get(i));
        form.textAreaBox2[bgNum].setText(npcListD.get(i + 1));
        form.textButton[bgNum].setActionCommand("continueDialog" + bgNum);
        form.textButton[bgNum].setText("Continua");
    }

    public void choice3(int bgNum, String npcName, String filename) throws IOException {
        form.dialogueButton1[bgNum].setVisible(false);
        form.dialogueButton2[bgNum].setVisible(false);
        form.dialogueButton3[bgNum].setVisible(false);
        form.dialogueButton4[bgNum].setVisible(false);
        readFile(filename);

        npcListD = DialogHandler.SelectDialogOption(file, DialogHandler.THIRD_DIALOG_START, DialogHandler.THIRD_DIALOG_END);
        System.out.println(npcListD.get(i));
        form.textAreaBox[bgNum].setText(npcListD.get(i));
        form.textAreaBox2[bgNum].setText(npcListD.get(i + 1));
        form.textButton[bgNum].setActionCommand("continueDialog" + bgNum);
        form.textButton[bgNum].setText("Continua");

    }

    public void choice4(int bgNum, String npcName, String filename) throws IOException {
        form.dialogueButton1[bgNum].setVisible(false);
        form.dialogueButton2[bgNum].setVisible(false);
        form.dialogueButton3[bgNum].setVisible(false);
        form.dialogueButton4[bgNum].setVisible(false);
        readFile(filename);
        npcListD = DialogHandler.SelectDialogOption(file, DialogHandler.FORTH_DIALOG_START, DialogHandler.FORTH_DIALOG_END);
        System.out.println(npcListD.get(i));
        form.textAreaBox[bgNum].setText(npcListD.get(i));
        form.textAreaBox2[bgNum].setText(npcListD.get(i + 1));
        form.textButton[bgNum].setActionCommand("continueDialog" + bgNum);
        form.textButton[bgNum].setText("Continua");
    }
    
    public void talkDialogue(int bgNum, String icona, String input, List<String> npcName, Boolean labelSx,ActionHandler actHandler) throws IOException {
        i = 0;
        form.detectiveSinistra[bgNum].setVisible(labelSx);
        form.icon[bgNum].setVisible(true);
        setIcon(bgNum, icona);
        form.textButton[bgNum].setVisible(true);
        form.textBox[bgNum].setVisible(true);
        form.textAreaBox[bgNum].setVisible(true);
        form.textAreaBox2[bgNum].setVisible(true);
        form.dialogueButton1[bgNum].setVisible(true);
        form.dialogueButton2[bgNum].setVisible(true);
        form.dialogueButton3[bgNum].setVisible(true);
        form.dialogueButton4[bgNum].setVisible(true);
        form.detectiveDestra[bgNum].setVisible(!labelSx);
        form.dialogueButton1[bgNum].setSelected(false);
        form.dialogueButton2[bgNum].setSelected(false);
        form.dialogueButton3[bgNum].setSelected(false);
        form.dialogueButton4[bgNum].setSelected(false);
        form.textAreaBox[bgNum].setText("");
        form.textAreaBox2[bgNum].setText("");
        form.textButton[bgNum].setActionCommand("continueTextScene" + bgNum);
        form.dialogueButton1[bgNum].setText(npcName.get(0));
        form.dialogueButton2[bgNum].setText(npcName.get(1));
        form.dialogueButton3[bgNum].setText(npcName.get(2));
        form.dialogueButton4[bgNum].setText(npcName.get(3));
        form.dialogueButton1[bgNum].addActionListener(actHandler);
        form.dialogueButton1[bgNum].setActionCommand("scelta1" + input);
        form.dialogueButton2[bgNum].addActionListener(actHandler);
        form.dialogueButton2[bgNum].setActionCommand("scelta2" + input);
        form.dialogueButton3[bgNum].addActionListener(actHandler);
        form.dialogueButton3[bgNum].setActionCommand("scelta3" + input);
        form.dialogueButton4[bgNum].addActionListener(actHandler);
        form.dialogueButton4[bgNum].setActionCommand("scelta4" + input);

    }
    
     public void continueDialogue(int bgNum) {
        form.dialogueButton1[bgNum].setVisible(false);
        form.dialogueButton2[bgNum].setVisible(false);
        form.dialogueButton3[bgNum].setVisible(false);
        form.dialogueButton4[bgNum].setVisible(false);
        i = i + 2;

        System.out.println("CONTINUADIALOGO");
        if (i < npcListD.size()) {
            form.textAreaBox[bgNum].setText(npcListD.get(i));
            form.textAreaBox2[bgNum].setText(npcListD.get(i + 1));

        } else {
            form.textButton[bgNum].setText("Chiudi");
            form.textButton[bgNum].setActionCommand("continueTextScene" + bgNum);
            closeTextBox(bgNum);
        }

    }
    
    public void closeTextBox(int bgNum) {
        form.textBox[bgNum].setVisible(false);
        form.textAreaBox[bgNum].setVisible(false);
        form.textAreaBox2[bgNum].setVisible(false);
        form.textButton[bgNum].setVisible(false);
        form.detectiveDestra[bgNum].setVisible(false);
        form.detectiveSinistra[bgNum].setVisible(false);
        form.icon[bgNum].setVisible(false);
        form.dialogueButton1[bgNum].setVisible(false);
        form.dialogueButton2[bgNum].setVisible(false);
        form.dialogueButton3[bgNum].setVisible(false);
        form.dialogueButton4[bgNum].setVisible(false);

    }
    
    public void setIcon(int bgNum, String Filename) {
        ImageIcon iconMini = new ImageIcon(getClass().getResource(Filename));
        form.icon[bgNum].setIcon(iconMini);
    }

    public void readFile(String namefile) throws IOException {

        try {

            file = new File(DialogHandler.dir + "\\src\\main\\resources\\dialogs\\" + namefile);

        } catch (Exception e) {
            // Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }

    }
   
}
