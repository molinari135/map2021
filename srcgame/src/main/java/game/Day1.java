/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;


/**
 *
 * @author rino
 */

//TODO attributi?
public class Day1 extends DayDescription {  
    
    //ActionHandler1 actHandler = new ActionHandler1(this);  
    Day1_Form d1_f;
        
    public void goToScene2() {
        d1_f.bgPanel[1].setVisible(false);
        d1_f.bgPanel[2].setVisible(true);        
    }
    
/*
    DayDescription day1 = new Day1();

    NPCs
    NPC A_Bantry = new NPC(1, "Arthur", "Bantry", "Vecchio decrepito",
            "M", "nobile", true, true);
    NPC D_Bantry = new NPC(2, "Dolly", "Bantry", "Vecchia decrepita",
            "F", "nobile", true, true);
    NPC J_Marple = new NPC(3, "Jane", "Marple", "Signorina",
            "F", "helper", true, true);
    NPC C_Melchett = new NPC(4, "Colonnello", "Melchett",
            "Il capo della polizia", "M", "Colonnello", true, true);

    NPC Domestica1 = new NPC(5, "La domestica che si occupa della cucina", "domestica", true, true);
    NPC Domestica2 = new NPC(6, "La domestica che si occupa delle varie mansioni casalinghe", "domestica", true, true);

    NPC A_Palck = new NPC(7, "Agente", "Palck",
            "L'Agente di polizia", "M", "Agente", true, true);
    NPC Haydock = new NPC(8, "Il medico legale", "Medico", true, true);
    NPC Lorrimer = new NPC(8, "Il maggiordomo di Gossington Hall", "Maid", true, true);

    //ROOMS
    Room diningRoom = new Room(0, "Sala da Pranzo", "Sala da pranzo della famiglia Bantry, situata nella lussuosa e imponente Gossington Hall", Floor.PIANO_TERRA);

    Room livingRoom = new Room(1, "Salotto", "Ti trovi nel salotto. Ci sono quei mobili marrone scuro che hai sempre odiato e delle orribili sedie.", Floor.PIANO_TERRA);

    Room kitchen = new Room(2, "Cucina", "Ti trovi nella solita cucina. Mobili bianchi, maniglie azzurre, quello strano lampadario che adoravi tanto quando eri piccolo", Floor.PIANO_TERRA);

    Room library = new Room(3, "Biblioteca", "Sei nella Biblioteca. Scaffali pieni di libri.... chissa dove sono nascosti gli hentai...", Floor.PIANO_TERRA);

    Staircase staircase1 = new Staircase(4, "Scale che collegano il piano terra al primo piano");

    Room bedroom = new Room(5, "Camera da letto", "Sei nella camera da letto dei signori Bantry, il letto � stato appena rifatto...", Floor.PRIMO_PIANO);

    Room study = new Room(6, "Studio", "Sei nello studio del signor Arthur Bantry , nel cassetto della scrivania c'� una calibro 50 per ammazzarsi", Floor.PRIMO_PIANO);

    Room wardrobe = new Room(7, "Guardaroba", "Sei nel guardaroba, qui di solito si nascondono pezzi di umani.. ", Floor.PRIMO_PIANO);

    Room cesso = new Room(8, "u cess", "Sei nel bagno. Quanto tempo passato qui dentro...meglio non pensarci..", Floor.PRIMO_PIANO);*/

    /*public void createMapGH() {
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
        A_Bantry.setPosition(study);
        D_Bantry.setPosition(diningRoom);
        J_Marple.setPosition(diningRoom);
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

    }*/    
    
    public static void startDay1() {
        new Day1_Form().setVisible(true);
        //TODO Creare array di panel ecc come uomo Japan
    }
}
