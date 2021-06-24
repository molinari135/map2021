/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import type.Room;
import type.Staircase;
import utility.*;

/**
 *
 * @author giaco
 */
public class Giorno1 extends Main {
     //Rooms
        Room diningRoom = new Room(0, "Sala da Pranzo", "Sala da pranzo della famiglia Banty, situata nella lussuosa e imponente Gossington Hall",Floor.PIANO_TERRA);
        
        Room livingRoom = new Room(1, "Salotto", "Ti trovi nel salotto. Ci sono quei mobili marrone scuro che hai sempre odiato e delle orribili sedie.",Floor.PIANO_TERRA);
        
        Room kitchen = new Room(2, "Cucina", "Ti trovi nella solita cucina. Mobili bianchi, maniglie azzurre, quello strano lampadario che adoravi tanto quando eri piccolo",Floor.PIANO_TERRA);
        
        Room library = new Room(3, "Biblioteca", "Sei nel bagno. Quanto tempo passato qui dentro...meglio non pensarci...", Floor.PIANO_TERRA);
        
        Staircase staircase1 = new Staircase(4, "Scale che collegano il piano terra al primo piano");
       
        //maps
        kitchen.setEast(livingRoom);
        livingRoom.setNorth(hall);
        livingRoom.setWest(kitchen);
        hall.setSouth(livingRoom);
        hall.setWest(yourRoom);
        hall.setNorth(bathroom);
        bathroom.setSouth(hall);
        yourRoom.setEast(hall);
        getRooms().add(kitchen);
        getRooms().add(livingRoom);
        getRooms().add(hall);
        getRooms().add(bathroom);
        getRooms().add(yourRoom);
}
