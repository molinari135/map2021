/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.util.Iterator;
import java.util.List;
import type.Item;
import type.NPC;
import type.Place;
import type.Room;

/**
 *
 * @author ester
 */
public class DataHandler {
    public static NPC NpcFinder(List<NPC> list, String string) {
        Iterator<NPC> iterator = list.iterator();
        while(iterator.hasNext()) {
            NPC npc = iterator.next();
            if (npc.getId().equals(string)) {
                return npc;
            }
        }
        return null;
    }
    
    public static Room RoomFinder(List<Room> list, String string) {
        Iterator<Room> iterator = list.iterator();
        while(iterator.hasNext()) {
            Room room = iterator.next();
            if (room.getId().equals(string)) {
                return room;
            }
        }
        return null;
    }
    
    // ATTENZIONE! Il nome deve essere preciso, altrimenti va tolto l'id int
    public static Place PlaceFinder(List<Place> list, String string) {
        Iterator<Place> iterator = list.iterator();
        while(iterator.hasNext()) {
            Place place = iterator.next();
            if (place.getName().equals(string)) {
                return place;
            }
        }
        return null;
    }
    
    public static Item ItemFinder(List<Item> list, String string) {
        Iterator<Item> iterator = list.iterator();
        while(iterator.hasNext()) {
            Item item = iterator.next();
            if (item.getId().equals(string)) {
                return item;
            }
        }
        return null;
    }
}

