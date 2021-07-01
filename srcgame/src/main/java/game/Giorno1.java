/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import db.DBgame;
import java.util.ArrayList;
import java.util.List;
import type.NPC;
import type.Room;
import type.Staircase;
import utility.Floor;

/**
 *
 * @author rino
 */

//TODO attributi?
public class Giorno1 extends DayDescription {

    DayDescription day1 = new Giorno1();

    //NPCs
    List<NPC> list = new ArrayList<>();

    //ROOMS
    Staircase staircase1 = new Staircase(4, "Scale che collegano il piano terra al primo piano");   

    public void tEster(List<NPC> npc) {
        npc = DBgame.getIstance().listNPC();
    }
    
    public void createMapGH() {
        //TODO create corridoio              

        //Maps
        //primo piano
        diningRoom.setEast(livingRoom);
        diningRoom.setNorth(kitchen);
        kitchen.setSouth(diningRoom);
        kitchen.setEast(library);
        livingRoom.setNorth(library);
        livingRoom.setWest(diningRoom);
        library.setSouth(livingRoom);
        library.setWest(kitchen);
        kitchen.setNorth(staircase1);
        library.setNorth(staircase1);

        //secondo piano
        bedroom.setSouth(staircase1);
        bedroom.setEast(study);
        bedroom.setNorth(cesso);
        study.setSouth(bedroom);
        study.setEast(wardrobe);
        wardrobe.setSouth(study);
        wardrobe.setWest(cesso);
        cesso.setSouth(bedroom);
        cesso.setEast(wardrobe);

        day1.getRooms().add(diningRoom);
        day1.getRooms().add(kitchen);
        day1.getRooms().add(livingRoom);
        day1.getRooms().add(library);
        day1.getRooms().add(staircase1);
        day1.getRooms().add(bedroom);
        day1.getRooms().add(study);
        day1.getRooms().add(cesso);
        day1.getRooms().add(wardrobe);

        //NPCs
        list.get(0).setPosition(study);
        list.get(1).setPosition(diningRoom);
        list.get(2).setPosition(diningRoom);
        C_Melchett.setPosition(livingRoom);
        Domestica1.setPosition(bedroom);
        Domestica2.setPosition(kitchen);
        A_Palck.setPosition(library);
        Haydock.setPosition(library);
        Lorrimer.setPosition(kitchen);

        day1.getCharacters().add(A_Bantry);
        day1.getCharacters().add(D_Bantry);
        day1.getCharacters().add(J_Marple);
        day1.getCharacters().add(C_Melchett);
        day1.getCharacters().add(Domestica1);
        day1.getCharacters().add(Domestica2);
        day1.getCharacters().add(A_Palck);
        day1.getCharacters().add(Haydock);
        day1.getCharacters().add(Lorrimer);

    }
    
    public void startDay1() {
        
    }
}
