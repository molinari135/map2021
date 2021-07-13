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
    Day_Form form = new Day_Form(this);
    
    DayDescription day = new DayDescription(this);
    Day1 day1 = new Day1(this);
    Day2 day2 = new Day2(this);
    
}
