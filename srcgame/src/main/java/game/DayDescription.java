package game;

import java.util.ArrayList;
import java.util.List;
import type.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rino
 */
public class DayDescription {

    private final List<Room> rooms = new ArrayList<>();

    private final List<Item> inventory = new ArrayList<>();

    private final List<NPC> npc = new ArrayList<>();

    

    public List<Room> getRooms() {
        return rooms;
    }

  
    public List<Item> getInventory() {
        return inventory;
    }

    public List<NPC> getNPC() {
        return npc;
    }
    
}
