package game;

import db.DataHandler;
import static game.Main.listItem;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import type.Item;

/**
 *
 * @author tom
 */
public class Player {

    GameHandler gh;
    private ArrayList<Item> inventory;

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public Player(GameHandler gh) {
        this.gh = gh;
        this.inventory = new ArrayList<>();

    }

    public void addToInventory(int i, Item item) {
        ListIterator<Item> it = inventory.listIterator();
        boolean isPresent = false;

        if (inventory.size() > 0) {
            while (it.hasNext() || isPresent == true) {
                Item item1 = it.next();
                if (item1.getId().equals(item.getId())) {
                    isPresent = true;
                }
            }

        } else if (inventory.isEmpty()) {
            inventory.add(0, item);     
            isPresent = true;
            System.out.println(item.getName() + " | size: " + inventory.size());
        }

        if (!isPresent) {
            inventory.add(i,item);
            System.out.println(item.getName() + "  " + inventory.size());
        }
    }   

}