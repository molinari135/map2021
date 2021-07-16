package game;

import db.DataHandler;
import static game.Main.listItem;
import type.Item;
import type.NPC;

import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import type.Room;

/**
 *
 * @author 
 */

public class GossingtonHall extends DayDescription {

    public GossingtonHall(GameHandler gh) {
        super(gh);
    }

    NPC person = new NPC();
    Item element = new Item();
    Room rooms = new Room();
    List<String> D_bantry, Jane_marple, Lorri, Corp, Arthur, Doc, Basil = new ArrayList<>();

    public void analizeBody() {               
        
        gh.getInv().getItem_2().setVisible(true);
        gh.getInv().getItem_2().setIcon(new ImageIcon(getClass().getResource("/dress1.png")));
        gh.getInv().getItem_2().setText("");
                
        element = DataHandler.ItemFinder(listItem, "white_dress");
        gh.getPlayer().addToInventory(element);
    }

    public void takeAutopsy() {        
        
        gh.getInv().getItem_1().setVisible(true);
        gh.getInv().getItem_1().setIcon(new ImageIcon(getClass().getResource("/doc_autopsia.png")));
        gh.getInv().getItem_1().setText("");
        
        element = DataHandler.ItemFinder(listItem, "autopsy");        
        gh.getPlayer().addToInventory(element);
    }

}