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
 * Classe che contiene metodi generici utilizzati nel codice, che si occupa 
   quindi di astrarre il più possibile le funzionalità utilizzate.
 *
 * @author
 */
public class DayDescription {

    GameHandler gh;
    DialogHandler dh = new DialogHandler();

    int i, j = 0;

    List<String> npcListD, Final = new ArrayList<>();

    ArrayList<String> list = new ArrayList<>();

    File file;

    public DayDescription(GameHandler gh) {
        this.gh = gh;
    }

    public void goToSceneXtoY(int x, int y) {
        gh.getForm().bgPanel[x].setVisible(false);
        gh.getForm().bgPanel[y].setVisible(true);
        closeTextBox(x);
    }

    public void observeSceneX(int x, Room room, String roomName) {
        gh.getForm().textBox[x].setVisible(true);
        gh.getForm().textAreaBox[x].setVisible(true);
        gh.getForm().textButton[x].setVisible(true);
        gh.getForm().textAreaBox2[x].setVisible(true);

        room = DataHandler.RoomFinder(listRoom, roomName);
        gh.getForm().textAreaBox[x].setText(room.getName());
        gh.getForm().textAreaBox2[x].setText(room.getDescription());
        gh.getForm().textButton[x].setActionCommand("continueTextScene" + x);
    }

    public void observeObjectX(int x, Item item, String itemName) {
        gh.getForm().textBox[x].setVisible(true);
        gh.getForm().textAreaBox[x].setVisible(true);
        gh.getForm().textButton[x].setVisible(true);
        gh.getForm().textAreaBox2[x].setVisible(true);

        item = DataHandler.ItemFinder(listItem, itemName);
        gh.getForm().textAreaBox[x].setText(item.getName());
        gh.getForm().textAreaBox2[x].setText(item.getDescription());
        gh.getForm().textButton[x].setActionCommand("continueTextScene" + x);
    }

    public void observeNPC(int bgNum, NPC npc, String npcName) {
        gh.getForm().dialogueButton1[bgNum].setVisible(false);
        gh.getForm().dialogueButton2[bgNum].setVisible(false);
        gh.getForm().dialogueButton3[bgNum].setVisible(false);
        gh.getForm().dialogueButton4[bgNum].setVisible(false);
        gh.getForm().detectiveDestra[bgNum].setVisible(false);
        gh.getForm().detectiveSinistra[bgNum].setVisible(false);
        gh.getForm().textAreaBox[bgNum].setVisible(true);
        gh.getForm().icon[bgNum].setVisible(false);
        gh.getForm().textBox[bgNum].setVisible(true);
        gh.getForm().textAreaBox2[bgNum].setVisible(true);
        gh.getForm().textButton[bgNum].setVisible(true);

        npc = DataHandler.NpcFinder(listNPC, npcName);
        gh.getForm().textAreaBox[bgNum].setText(npc.getName() + " " + npc.getSurname());
        gh.getForm().textAreaBox2[bgNum].setText(npc.getDescription());
        gh.getForm().textButton[bgNum].setActionCommand("continueTextScene" + bgNum);
    }

    public void talkNPC(int bgNum, String fileName, List<String> npc, String iconName, String id, Boolean labelSx, ActionHandler actHandler) throws IOException {
        npc = dh.SelectDialogOption(fileName, DialogHandler.DIALOG_OPTION_START, DialogHandler.DIALOG_OPTION_END);
        talkDialogue(bgNum, iconName, id, npc, labelSx, actHandler); //se bool vero, la label scelta è quella sx, destra altrimenti 
    }

    public void choice1(int bgNum, String npcName, String filename) throws FileNotFoundException, IOException {
        i = 0;
        gh.getForm().dialogueButton1[bgNum].setVisible(false);
        gh.getForm().dialogueButton2[bgNum].setVisible(false);
        gh.getForm().dialogueButton3[bgNum].setVisible(false);
        gh.getForm().dialogueButton4[bgNum].setVisible(false);
        npcListD = dh.SelectDialogOption(filename, DialogHandler.FIRST_DIALOG_START, DialogHandler.FIRST_DIALOG_END);
        System.out.println(npcListD.get(i));
        gh.getForm().textAreaBox[bgNum].setText(npcListD.get(i));
        gh.getForm().textAreaBox2[bgNum].setText(npcListD.get(i + 1));
        gh.getForm().textButton[bgNum].setActionCommand("continueDialog" + bgNum + npcName);
        gh.getForm().textButton[bgNum].setText("Continua");
    }

    public void choice2(int bgNum, String npcName, String filename) throws IOException {
        gh.getForm().dialogueButton1[bgNum].setVisible(false);
        gh.getForm().dialogueButton2[bgNum].setVisible(false);
        gh.getForm().dialogueButton3[bgNum].setVisible(false);
        gh.getForm().dialogueButton4[bgNum].setVisible(false);
        npcListD = dh.SelectDialogOption(filename, DialogHandler.SECOND_DIALOG_START, DialogHandler.SECOND_DIALOG_END);
        System.out.println(npcListD.get(i));
        gh.getForm().textAreaBox[bgNum].setText(npcListD.get(i));
        gh.getForm().textAreaBox2[bgNum].setText(npcListD.get(i + 1));
        gh.getForm().textButton[bgNum].setActionCommand("continueDialog" + bgNum + npcName);
        gh.getForm().textButton[bgNum].setText("Continua");
    }

    public void choice3(int bgNum, String npcName, String filename) throws IOException {
        gh.getForm().dialogueButton1[bgNum].setVisible(false);
        gh.getForm().dialogueButton2[bgNum].setVisible(false);
        gh.getForm().dialogueButton3[bgNum].setVisible(false);
        gh.getForm().dialogueButton4[bgNum].setVisible(false);

        npcListD = dh.SelectDialogOption(filename, DialogHandler.THIRD_DIALOG_START, DialogHandler.THIRD_DIALOG_END);
        System.out.println(npcListD.get(i));
        gh.getForm().textAreaBox[bgNum].setText(npcListD.get(i));
        gh.getForm().textAreaBox2[bgNum].setText(npcListD.get(i + 1));
        gh.getForm().textButton[bgNum].setActionCommand("continueDialog" + bgNum + npcName);
        gh.getForm().textButton[bgNum].setText("Continua");

    }

    public void choice4(int bgNum, String npcName, String filename) throws IOException {
        gh.getForm().dialogueButton1[bgNum].setVisible(false);
        gh.getForm().dialogueButton2[bgNum].setVisible(false);
        gh.getForm().dialogueButton3[bgNum].setVisible(false);
        gh.getForm().dialogueButton4[bgNum].setVisible(false);

        npcListD = dh.SelectDialogOption(filename, DialogHandler.FORTH_DIALOG_START, DialogHandler.FORTH_DIALOG_END);
        System.out.println(npcListD.get(i));
        gh.getForm().textAreaBox[bgNum].setText(npcListD.get(i));
        gh.getForm().textAreaBox2[bgNum].setText(npcListD.get(i + 1));
        gh.getForm().textButton[bgNum].setActionCommand("continueDialog" + bgNum + npcName);
        gh.getForm().textButton[bgNum].setText("Continua");
    }

    public void talkNPCLast(int bgNum, String fileName, String iconName, String id, Boolean labelSx, ActionHandler actHandler, String truth) throws IOException {
        i = 0;

        npcListD = dh.SelectDialogOption(fileName, DialogHandler.DIALOG_FINAL_START, DialogHandler.DIALOG_FINAL_END);

        if (i == 22) {
            i = 0;
        }
        gh.getForm().dialogueButton1[bgNum].setVisible(false);
        gh.getForm().dialogueButton2[bgNum].setVisible(false);
        gh.getForm().dialogueButton3[bgNum].setVisible(false);
        gh.getForm().dialogueButton4[bgNum].setVisible(false);
        gh.getForm().textButton[bgNum].setVisible(true);
        gh.getForm().textBox[bgNum].setVisible(true);
        gh.getForm().textAreaBox[bgNum].setVisible(true);
        gh.getForm().textAreaBox2[bgNum].setVisible(true);
        gh.getForm().icon[bgNum].setVisible(true);
        setIcon(bgNum, iconName);
        gh.getForm().textAreaBox[bgNum].setText(npcListD.get(i));
        gh.getForm().textAreaBox2[bgNum].setText(npcListD.get(i + 1));
        gh.getForm().textButton[bgNum].setActionCommand("continueDialogFinale" + truth);
        gh.getForm().textButton[bgNum].setText("Continua");

    }

    public void talkDialogue(int bgNum, String icona, String input, List<String> npcName, Boolean labelSx, ActionHandler actHandler) throws IOException {
        i = 0;
        gh.getForm().detectiveSinistra[bgNum].setVisible(labelSx);
        gh.getForm().icon[bgNum].setVisible(true);
        setIcon(bgNum, icona);
        gh.getForm().textButton[bgNum].setVisible(true);
        gh.getForm().textBox[bgNum].setVisible(true);
        gh.getForm().textAreaBox[bgNum].setVisible(true);
        gh.getForm().textAreaBox2[bgNum].setVisible(true);
        gh.getForm().dialogueButton1[bgNum].setVisible(true);
        gh.getForm().dialogueButton2[bgNum].setVisible(true);
        gh.getForm().dialogueButton3[bgNum].setVisible(true);
        gh.getForm().dialogueButton4[bgNum].setVisible(true);
        gh.getForm().detectiveDestra[bgNum].setVisible(!labelSx);
        gh.getForm().dialogueButton1[bgNum].setSelected(false);
        gh.getForm().dialogueButton2[bgNum].setSelected(false);
        gh.getForm().dialogueButton3[bgNum].setSelected(false);
        gh.getForm().dialogueButton4[bgNum].setSelected(false);
        gh.getForm().textAreaBox[bgNum].setText("");
        gh.getForm().textAreaBox2[bgNum].setText("");
        gh.getForm().textButton[bgNum].setActionCommand("continueTextScene" + bgNum);
        gh.getForm().dialogueButton1[bgNum].setText(npcName.get(0));
        gh.getForm().dialogueButton2[bgNum].setText(npcName.get(1));
        gh.getForm().dialogueButton3[bgNum].setText(npcName.get(2));
        gh.getForm().dialogueButton4[bgNum].setText(npcName.get(3));
        gh.getForm().dialogueButton1[bgNum].addActionListener(actHandler);
        gh.getForm().dialogueButton1[bgNum].setActionCommand("scelta1" + input);
        gh.getForm().dialogueButton2[bgNum].addActionListener(actHandler);
        gh.getForm().dialogueButton2[bgNum].setActionCommand("scelta2" + input);
        gh.getForm().dialogueButton3[bgNum].addActionListener(actHandler);
        gh.getForm().dialogueButton3[bgNum].setActionCommand("scelta3" + input);
        gh.getForm().dialogueButton4[bgNum].addActionListener(actHandler);
        gh.getForm().dialogueButton4[bgNum].setActionCommand("scelta4" + input);

    }

    public void continueDialogue(int bgNum, String npcName) {
        gh.getForm().dialogueButton1[bgNum].setVisible(false);
        gh.getForm().dialogueButton2[bgNum].setVisible(false);
        gh.getForm().dialogueButton3[bgNum].setVisible(false);
        gh.getForm().dialogueButton4[bgNum].setVisible(false);
        i = i + 2;

        if (i < npcListD.size()) {            
            gh.getForm().textAreaBox[bgNum].setText(npcListD.get(i));
            gh.getForm().textAreaBox2[bgNum].setText(npcListD.get(i + 1));

        } else {            
            gh.getForm().textButton[bgNum].setActionCommand("Talk" + npcName);

        }

    }

    public void closeTextBox(int bgNum) {
        gh.getForm().textBox[bgNum].setVisible(false);
        gh.getForm().textAreaBox[bgNum].setVisible(false);
        gh.getForm().textAreaBox2[bgNum].setVisible(false);
        gh.getForm().textButton[bgNum].setVisible(false);
        gh.getForm().detectiveDestra[bgNum].setVisible(false);
        gh.getForm().detectiveSinistra[bgNum].setVisible(false);
        gh.getForm().icon[bgNum].setVisible(false);
        gh.getForm().dialogueButton1[bgNum].setVisible(false);
        gh.getForm().dialogueButton2[bgNum].setVisible(false);
        gh.getForm().dialogueButton3[bgNum].setVisible(false);
        gh.getForm().dialogueButton4[bgNum].setVisible(false);

    }

    public void setIcon(int bgNum, String Filename) {
        ImageIcon iconMini = new ImageIcon(getClass().getResource(Filename));
        gh.getForm().icon[bgNum].setIcon(iconMini);
    }

    public void checkInventory(int size, int bgNum, int idx) {
        if (gh.getPlayer().getInventory().size() == size) {
            gh.getForm().setVisibleObject(bgNum, idx, true);
        }
    }

    void continueFinalDialogue(int bgNum, boolean b, String filename) throws IOException {
        i = i + 2;

        if (i < npcListD.size()) {
            gh.getForm().textAreaBox[bgNum].setText(npcListD.get(i));
            gh.getForm().textAreaBox2[bgNum].setText(npcListD.get(i + 1));

        } else {
            j = 0;
            Final = dh.SelectDialogOption(filename, DialogHandler.FINAL_START, DialogHandler.FINAL_END);
            if (b == true) {
                gh.getForm().placeDescription4[16].setText(Final.get(j));
                gh.getDay().goToSceneXtoY(15, 16);
            } else {
                gh.getForm().placeDescription4[17].setText(Final.get(j));
                gh.getDay().goToSceneXtoY(15, 17);
            }

        }
    }

    void continueTrueEnding(int bgNum) {
        j++;

        if (j < Final.size()) {            
            gh.getForm().placeDescription4[bgNum].setText(Final.get(j));

        } else {
            gh.getForm().placeDescription2[bgNum].setText("Complimenti, hai finito il gioco!");
            gh.getForm().go[bgNum].setText("Esci");
            gh.getForm().go[bgNum].setActionCommand("ExitGame");
        }

    }

    void continueFalseEnding(int bgNum) {
        j++;       

        if (j < Final.size()) {
            gh.getForm().placeDescription4[bgNum].setText(Final.get(j));
        } else {
            gh.getDay().goToSceneXtoY(bgNum, 15);
        }

    }

}
