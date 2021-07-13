package game;

import java.awt.event.ActionEvent;

public class InventoryHandler extends ActionHandler {

    GameHandler gh;

    public InventoryHandler(GameHandler gh) {
        this.gh = gh;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String eventCommand = e.getActionCommand();

        switch (eventCommand) {
            case "ObserveItem_1":
                System.out.println("asd");
                gh.inv.observeItem(gh.day1.autopsy, "autopsy");

                break;
        }

    }
}
