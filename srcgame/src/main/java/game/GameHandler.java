/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author tom
 */
public class GameHandler {

    ActionHandler actHandler1 = new ActionHandler1(this);
    ActionHandler actHandler2 = new ActionHandler2(this);
    ActionHandler actHandler3 = new ActionHandler3(this);
    ActionHandler inventHandler = new InventoryHandler(this);

    Day_Form form = new Day_Form(this);
    InventoryDialog inv = new InventoryDialog(form, true, this);
    DayDescription day = new DayDescription(this);
    Day1 day1 = new Day1(this);
    Day2 day2 = new Day2(this);
    Day3 day3 = new Day3(this);

    public Player getPlayer() {
        return player;
    }

    private final Player player = new Player(this);
}
