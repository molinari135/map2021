package game;

import db.DataHandler;
import db.DialogHandler;
import static game.Main.listItem;
import static game.Main.listNPC;
import static game.Main.listRoom;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import type.Item;
import type.NPC;
import type.Room;

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

    GameHandler gh;

    int i = 0;

    List<String> npcListD = new ArrayList<>();

    ArrayList<String> list = new ArrayList<>();

    File file;

    public DayDescription(GameHandler gh) {
        this.gh = gh;
    }

    public void goToSceneXtoY(int x, int y) {
        gh.form.bgPanel[x].setVisible(false);
        gh.form.bgPanel[y].setVisible(true);
        closeTextBox(x);
    }

    public void observeSceneX(int x, Room room, String roomName) {
        gh.form.textBox[x].setVisible(true);
        gh.form.textAreaBox[x].setVisible(true);
        gh.form.textButton[x].setVisible(true);
        gh.form.textAreaBox2[x].setVisible(true);
        
        room = DataHandler.RoomFinder(listRoom, roomName);
        gh.form.textAreaBox[x].setText(room.getName());
        gh.form.textAreaBox2[x].setText(room.getDescription());
        gh.form.textButton[x].setActionCommand("continueTextScene" + x);
    }
    
    public void observeObjectX(int x, Item item, String itemName) {
        gh.form.textBox[x].setVisible(true);
        gh.form.textAreaBox[x].setVisible(true);
        gh.form.textButton[x].setVisible(true);
        gh.form.textAreaBox2[x].setVisible(true);
        
        item = DataHandler.ItemFinder(listItem, itemName);
        gh.form.textAreaBox[x].setText(item.getName());
        gh.form.textAreaBox2[x].setText(item.getDescription());
        gh.form.textButton[x].setActionCommand("continueTextScene" + x);
    }

    public void observeNPC(int bgNum, NPC npc, String npcName) {
        gh.form.dialogueButton1[bgNum].setVisible(false);
        gh.form.dialogueButton2[bgNum].setVisible(false);
        gh.form.dialogueButton3[bgNum].setVisible(false);
        gh.form.dialogueButton4[bgNum].setVisible(false);
        gh.form.detectiveDestra[bgNum].setVisible(false);
        gh.form.detectiveSinistra[bgNum].setVisible(false);
        gh.form.textAreaBox[bgNum].setVisible(true);
        gh.form.icon[bgNum].setVisible(false);
        gh.form.textBox[bgNum].setVisible(true);
        gh.form.textAreaBox2[bgNum].setVisible(true);
        gh.form.textButton[bgNum].setVisible(true);
       
        npc = DataHandler.NpcFinder(listNPC, npcName);
        gh.form.textAreaBox[bgNum].setText(npc.getName() + " " + npc.getSurname());
        gh.form.textAreaBox2[bgNum].setText(npc.getDescription());
        gh.form.textButton[bgNum].setActionCommand("continueTextScene" + bgNum);
    }

    public void talkNPC(int bgNum, String fileName, List<String> npc, String iconName, String id, Boolean labelSx, ActionHandler actHandler) throws IOException {
        readFile(fileName);
        npc = DialogHandler.SelectDialogOption(file, DialogHandler.DIALOG_OPTION_START, DialogHandler.DIALOG_OPTION_END);
        talkDialogue(bgNum, iconName, id, npc, labelSx, actHandler); //se bool vero, la label scelta è quella sx, destra altrimenti 
    }

    public void choice1(int bgNum, String npcName, String filename) throws FileNotFoundException, IOException {
        i = 0;
        gh.form.dialogueButton1[bgNum].setVisible(false);
        gh.form.dialogueButton2[bgNum].setVisible(false);
        gh.form.dialogueButton3[bgNum].setVisible(false);
        gh.form.dialogueButton4[bgNum].setVisible(false);
        readFile(filename);

        npcListD = DialogHandler.SelectDialogOption(file, DialogHandler.FIRST_DIALOG_START, DialogHandler.FIRST_DIALOG_END);
        System.out.println(npcListD.get(i));
        gh.form.textAreaBox[bgNum].setText(npcListD.get(i));
        gh.form.textAreaBox2[bgNum].setText(npcListD.get(i + 1));
        gh.form.textButton[bgNum].setActionCommand("continueDialog" + bgNum);
        gh.form.textButton[bgNum].setText("Continua");
    }

    public void choice2(int bgNum, String npcName, String filename) throws IOException {
        gh.form.dialogueButton1[bgNum].setVisible(false);
        gh.form.dialogueButton2[bgNum].setVisible(false);
        gh.form.dialogueButton3[bgNum].setVisible(false);
        gh.form.dialogueButton4[bgNum].setVisible(false);
        readFile(filename);

        npcListD = DialogHandler.SelectDialogOption(file, DialogHandler.SECOND_DIALOG_START, DialogHandler.SECOND_DIALOG_END);
        System.out.println(npcListD.get(i));
        gh.form.textAreaBox[bgNum].setText(npcListD.get(i));
        gh.form.textAreaBox2[bgNum].setText(npcListD.get(i + 1));
        gh.form.textButton[bgNum].setActionCommand("continueDialog" + bgNum);
        gh.form.textButton[bgNum].setText("Continua");
    }

    public void choice3(int bgNum, String npcName, String filename) throws IOException {
        gh.form.dialogueButton1[bgNum].setVisible(false);
        gh.form.dialogueButton2[bgNum].setVisible(false);
        gh.form.dialogueButton3[bgNum].setVisible(false);
        gh.form.dialogueButton4[bgNum].setVisible(false);
        readFile(filename);

        npcListD = DialogHandler.SelectDialogOption(file, DialogHandler.THIRD_DIALOG_START, DialogHandler.THIRD_DIALOG_END);
        System.out.println(npcListD.get(i));
        gh.form.textAreaBox[bgNum].setText(npcListD.get(i));
        gh.form.textAreaBox2[bgNum].setText(npcListD.get(i + 1));
        gh.form.textButton[bgNum].setActionCommand("continueDialog" + bgNum);
        gh.form.textButton[bgNum].setText("Continua");

    }

    public void choice4(int bgNum, String npcName, String filename) throws IOException {
        gh.form.dialogueButton1[bgNum].setVisible(false);
        gh.form.dialogueButton2[bgNum].setVisible(false);
        gh.form.dialogueButton3[bgNum].setVisible(false);
        gh.form.dialogueButton4[bgNum].setVisible(false);
        readFile(filename);
        npcListD = DialogHandler.SelectDialogOption(file, DialogHandler.FORTH_DIALOG_START, DialogHandler.FORTH_DIALOG_END);
        System.out.println(npcListD.get(i));
        gh.form.textAreaBox[bgNum].setText(npcListD.get(i));
        gh.form.textAreaBox2[bgNum].setText(npcListD.get(i + 1));
        gh.form.textButton[bgNum].setActionCommand("continueDialog" + bgNum);
        gh.form.textButton[bgNum].setText("Continua");
    }

    public void talkDialogue(int bgNum, String icona, String input, List<String> npcName, Boolean labelSx, ActionHandler actHandler) throws IOException {
        i = 0;
        gh.form.detectiveSinistra[bgNum].setVisible(labelSx);
        gh.form.icon[bgNum].setVisible(true);
        setIcon(bgNum, icona);
        gh.form.textButton[bgNum].setVisible(true);
        gh.form.textBox[bgNum].setVisible(true);
        gh.form.textAreaBox[bgNum].setVisible(true);
        gh.form.textAreaBox2[bgNum].setVisible(true);
        gh.form.dialogueButton1[bgNum].setVisible(true);
        gh.form.dialogueButton2[bgNum].setVisible(true);
        gh.form.dialogueButton3[bgNum].setVisible(true);
        gh.form.dialogueButton4[bgNum].setVisible(true);
        gh.form.detectiveDestra[bgNum].setVisible(!labelSx);
        gh.form.dialogueButton1[bgNum].setSelected(false);
        gh.form.dialogueButton2[bgNum].setSelected(false);
        gh.form.dialogueButton3[bgNum].setSelected(false);
        gh.form.dialogueButton4[bgNum].setSelected(false);
        gh.form.textAreaBox[bgNum].setText("");
        gh.form.textAreaBox2[bgNum].setText("");
        gh.form.textButton[bgNum].setActionCommand("continueTextScene" + bgNum);
        gh.form.dialogueButton1[bgNum].setText(npcName.get(0));
        gh.form.dialogueButton2[bgNum].setText(npcName.get(1));
        gh.form.dialogueButton3[bgNum].setText(npcName.get(2));
        gh.form.dialogueButton4[bgNum].setText(npcName.get(3));
        gh.form.dialogueButton1[bgNum].addActionListener(actHandler);
        gh.form.dialogueButton1[bgNum].setActionCommand("scelta1" + input);
        gh.form.dialogueButton2[bgNum].addActionListener(actHandler);
        gh.form.dialogueButton2[bgNum].setActionCommand("scelta2" + input);
        gh.form.dialogueButton3[bgNum].addActionListener(actHandler);
        gh.form.dialogueButton3[bgNum].setActionCommand("scelta3" + input);
        gh.form.dialogueButton4[bgNum].addActionListener(actHandler);
        gh.form.dialogueButton4[bgNum].setActionCommand("scelta4" + input);

    }

    public void continueDialogue(int bgNum) {
        gh.form.dialogueButton1[bgNum].setVisible(false);
        gh.form.dialogueButton2[bgNum].setVisible(false);
        gh.form.dialogueButton3[bgNum].setVisible(false);
        gh.form.dialogueButton4[bgNum].setVisible(false);
        i = i + 2;

        
        if (i < npcListD.size()) {
            System.out.println("CONTINUADIALOGO");
            gh.form.textAreaBox[bgNum].setText(npcListD.get(i));
            gh.form.textAreaBox2[bgNum].setText(npcListD.get(i + 1));

        } else {
            System.out.println("ESCIDIALOGO");
            gh.form.textButton[bgNum].setText("Chiudi");
            gh.form.textButton[bgNum].setActionCommand("continueTextScene" + bgNum);
            closeTextBox(bgNum);
        }

    }

    public void closeTextBox(int bgNum) {
        gh.form.textBox[bgNum].setVisible(false);
        gh.form.textAreaBox[bgNum].setVisible(false);
        gh.form.textAreaBox2[bgNum].setVisible(false);
        gh.form.textButton[bgNum].setVisible(false);
        gh.form.detectiveDestra[bgNum].setVisible(false);
        gh.form.detectiveSinistra[bgNum].setVisible(false);
        gh.form.icon[bgNum].setVisible(false);
        gh.form.dialogueButton1[bgNum].setVisible(false);
        gh.form.dialogueButton2[bgNum].setVisible(false);
        gh.form.dialogueButton3[bgNum].setVisible(false);
        gh.form.dialogueButton4[bgNum].setVisible(false);

    }

    public void setIcon(int bgNum, String Filename) {
        ImageIcon iconMini = new ImageIcon(getClass().getResource(Filename));
        gh.form.icon[bgNum].setIcon(iconMini);
    }

    public void readFile(String namefile) throws IOException {

        try {

            file = new File(DialogHandler.dir + "\\src\\main\\resources\\dialogs\\" + namefile);

        } catch (Exception e) {
            // Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }

    }
    
    public void checkInventory(int size, int bgNum, int idx) {
        if(gh.getPlayer().getInventory().size() == size) {
            gh.form.setVisibleObject(bgNum, idx, true);
        }
    }

}
