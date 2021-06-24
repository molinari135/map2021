/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import type.*;
import utility.Floor;

/**
 *
 * @author giaco
 */
public class AllMaps {
        GameDescription giorno1 = new GameDescription();
    public void createMapGossingtonHall() {
        
        //Rooms
        Room diningRoom = new Room(0, "Sala da Pranzo", "Sala da pranzo della famiglia Banty, situata nella lussuosa e imponente Gossington Hall",Floor.PIANO_TERRA);
        
        Room livingRoom = new Room(1, "Salotto", "Ti trovi nel salotto. Ci sono quei mobili marrone scuro che hai sempre odiato e delle orribili sedie.",Floor.PIANO_TERRA);
        
        Room kitchen = new Room(2, "Cucina", "Ti trovi nella solita cucina. Mobili bianchi, maniglie azzurre, quello strano lampadario che adoravi tanto quando eri piccolo",Floor.PIANO_TERRA);
        
        Room library = new Room(3, "Biblioteca", "Sei nella Biblioteca. Scaffali pieni di libri.... chissa dove sono nascosti gli hentai...", Floor.PIANO_TERRA);
        
        Staircase staircase1 = new Staircase(4, "Scale che collegano il piano terra al primo piano");
        
        Room bedroom = new Room(5, "Camera da letto", "Sei nella camera da letto dei signori Bantry, il letto è stato appena rifatto...", Floor.PRIMO_PIANO);
 
        Room study = new Room(6, "Studio", "Sei nello studio del signor Arthur Bantry , nel cassetto della scrivania c'è una calibro 50 per ammazzarsi", Floor.PRIMO_PIANO);

        Room wardrobe = new Room(7,"Guardaroba", "Sei nel guardaroba, qui di solito si nascondono pezzi di umani.. ", Floor.PRIMO_PIANO);
        
        Room cesso = new Room(8,"ù cess", "Sei nel bagno. Quanto tempo passato qui dentro...meglio non pensarci..", Floor.PRIMO_PIANO);

        //TODO create corridoio
//maps  
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
        
        giorno1.getRooms().add(diningRoom);
        giorno1.getRooms().add(kitchen);
        giorno1.getRooms().add(livingRoom);
        giorno1.getRooms().add(library);
        giorno1.getRooms().add(staircase1);
        
        bedroom.setSouth(staircase1);
        bedroom.setEast(study);
        bedroom.setNorth(cesso);
        study.setSouth(bedroom);
        study.setEast(wardrobe);
        wardrobe.setSouth(study);
        wardrobe.setWest(cesso);
        cesso.setSouth(bedroom);
        cesso.setEast(wardrobe);
        
        giorno1.getRooms().add(bedroom);
        giorno1.getRooms().add(study);
        giorno1.getRooms().add(cesso);
        giorno1.getRooms().add(wardrobe);
        
       
    }
   
}
