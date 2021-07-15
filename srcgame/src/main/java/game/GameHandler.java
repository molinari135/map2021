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

    ActionHandler actHandler1 = new ActionHandlerGH(this);
    ActionHandler actHandler2 = new ActionHandlerMH(this);
    ActionHandler actHandler3 = new ActionHandlerPS(this);
    ActionHandler inventHandler = new InventoryHandler(this);

    Day_Form form = new Day_Form(this);
    InventoryDialog inv = new InventoryDialog(form, true, this);
    DayDescription day = new DayDescription(this);
    GossingtonHall day1 = new GossingtonHall(this);
    MajesticHotel day2 = new MajesticHotel(this);
    PoliceStation day3 = new PoliceStation(this);

    public Player getPlayer() {
        return player;
    }

    private final Player player = new Player(this);
}
