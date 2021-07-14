package game;

import db.DataHandler;
import static game.Main.listItem;
import type.Item;
import type.NPC;

import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.List;
import type.Room;

/**
 *
 * @author rino
 */
//TODO attributi?
public class Day1 extends DayDescription {

    public Day1(GameHandler gh) {
        super(gh);
    }

    NPC person = new NPC();
    Item element = new Item();
    Room rooms = new Room();
    List<String> D_bantry, Jane_marple, Lorri, Corp, Arthur, Doc, Basil = new ArrayList<>();

    public void analizeBody() {
        gh.form.textBox[6].setVisible(true);
        gh.form.textButton[6].setVisible(true);
        gh.form.textAreaBox2[6].setVisible(true);
        gh.form.textAreaBox2[6].setText("Ispezionando il cadavere , hai ottenuto ABITO BIANCO");
        gh.inv.getItem_2().setVisible(true);
        gh.inv.getItem_2().setIcon(new ImageIcon(getClass().getResource("/dress1.png")));
        gh.inv.getItem_2().setText("");
        gh.form.textButton[6].setText("Chiudi");
        gh.form.textButton[6].setActionCommand("continueTextScene" + 6);
        
        element = DataHandler.ItemFinder(listItem, "white_dress");

        gh.getPlayer().addToInventory(1, element);
    }

    public void takeAutopsy() {
        gh.inv.getItem_1().setVisible(true);
        gh.inv.getItem_1().setIcon(new ImageIcon(getClass().getResource("/doc_autopsia.png")));
        gh.inv.getItem_1().setText("");
        
        element = DataHandler.ItemFinder(listItem, "autopsy");
        
        gh.getPlayer().addToInventory(0, element);
    }

}