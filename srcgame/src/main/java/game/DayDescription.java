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

    private final List<NPC> characters = new ArrayList<>();

    private Room currentRoom;

    public List<Room> getRooms() {
        return rooms;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public List<NPC> getCharacters() {
        return characters;
    }

}
