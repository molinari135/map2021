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

    private final ActionHandler actHandler1;
    private final ActionHandler actHandler2;
    private final ActionHandler actHandler3;
    private final Day_Form form;
    private final InventoryDialog inv;
    private final DayDescription day;
    private final GossingtonHall day1;
    private final MajesticHotel day2;
    private final PoliceStation day3;
    private final Player player;

    public GameHandler() {
        this.actHandler1 = new ActionHandlerGH(this);
        this.actHandler2 = new ActionHandlerMH(this);
        this.actHandler3 = new ActionHandlerPS(this);
        this.form = new Day_Form(this);
        this.inv = new InventoryDialog(form, true, this);
        this.day = new DayDescription(this);
        this.day1 = new GossingtonHall(this);
        this.day2 = new MajesticHotel(this);
        this.day3 = new PoliceStation(this);
        this.player = new Player(this);

    }

    public ActionHandler getActHandler1() {
        return actHandler1;
    }

    public ActionHandler getActHandler2() {
        return actHandler2;
    }

    public ActionHandler getActHandler3() {
        return actHandler3;
    }

    public Day_Form getForm() {
        return form;
    }

    public InventoryDialog getInv() {
        return inv;
    }

    public DayDescription getDay() {
        return day;
    }

    public GossingtonHall getDay1() {
        return day1;
    }

    public MajesticHotel getDay2() {
        return day2;
    }

    public PoliceStation getDay3() {
        return day3;
    }

    public Player getPlayer() {
        return player;
    }

}
