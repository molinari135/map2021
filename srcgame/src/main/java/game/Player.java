package game;

import java.util.ArrayList;
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

    public void addToInventory(Item item) {
        ListIterator<Item> it = inventory.listIterator();
        boolean isPresent = false;

        if (inventory.size() > 0) {
            while (it.hasNext()) {
                if (it.next().getId().equals(item.getId())) {
                    isPresent = true;
                }
            }

        } else if (inventory.isEmpty()) {
            inventory.add(item);
            isPresent = true;            
        }

        if (!isPresent) {
            inventory.add(item);           
        }
    }

}
