/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import type.Item;
import type.NPC;
import type.Place;
import type.Room;

/**
 *
 * @author ester
 */
public class DBTest {
    List<NPC> npcList, npcListGH, npcListMH, npcListPS = new ArrayList<NPC>();
    List<Room> roomList = new ArrayList<Room>();
    List<Item> itemList, itemListGH, itemListMH = new ArrayList<Item>();
    List<Place> placeList = new ArrayList<Place>();
    NPC d_bantry, c_jefferson, c_melchett = new NPC();
    Room library, ballRoom, policeOffice = new Room();
    Item autopsy, w_dress, mark_bill = new Item();
    Place gh, mh, ps = new Place();
        
    @Test
    @DisplayName("Test di connessione")
    public void connessioneDB() {
        try {
            System.out.println(" >>> Connessione al database");
            DBgame.getIstance().connect();
        } catch (SQLException ex) {
            System.err.println(ex.getSQLState() + ": " + ex.getMessage());
        }
    }
    
    @Test
    @DisplayName("Creazione table")
    public void createTables() {
        connessioneDB();
        System.out.println(" >>> Creazione delle table");
        System.out.println("    > Creazione table NPC");
        DBgame.getIstance().tableManager(DBgame.CREATE_TABLE_NPC);
        System.out.println("    > Creazione table Room");
        DBgame.getIstance().tableManager(DBgame.CREATE_TABLE_ROOM);
        System.out.println("    > Creazione table Item");
        DBgame.getIstance().tableManager(DBgame.CREATE_TABLE_ITEM);
        System.out.println("    > Creazione table Place");
        DBgame.getIstance().tableManager(DBgame.CREATE_TABLE_PLACE);
    }
    
    @Test
    @DisplayName("Svuota table")
    public void clearTables() {
        createTables();
        System.out.println(" >>> Pulizia delle table");
        System.out.println("    > Pulizia table NPC");
        DBgame.getIstance().tableManager(DBgame.CLEAR_TABLE_NPC);
        System.out.println("    > Pulizia table Room");
        DBgame.getIstance().tableManager(DBgame.CLEAR_TABLE_ROOM);
        System.out.println("    > Pulizia table Item");
        DBgame.getIstance().tableManager(DBgame.CLEAR_TABLE_ITEM);
        System.out.println("    > Pulizia table Place");
        DBgame.getIstance().tableManager(DBgame.CLEAR_TABLE_PLACE);
    }
    
    @Test
    @DisplayName("Popolamento table")
    public void insertTables() {
        clearTables();
        System.out.println(" >>> Popolamento delle table");
        System.out.println("     > Inserimento dati in NPC");
        DBgame.getIstance().tableManager(DBgame.ALL_NPC);
        System.out.println("     > Inserimento dati in Room");
        DBgame.getIstance().tableManager(DBgame.ALL_ROOM);
        System.out.println("     > Inserimento dati in Item");
        DBgame.getIstance().tableManager(DBgame.ALL_ITEM);
        System.out.println("     > Inserimento dati in Place");
        DBgame.getIstance().tableManager(DBgame.ALL_PLACE);
    }
    
    @Test
    @DisplayName("Riempimento delle liste")
    public void createListsFromTables() {   
        try {
            insertTables();
            System.out.println(" >>> Popolamento delle table");
            System.out.println("     > Inserimento dati nella lista di NPC");
            npcList = DBgame.getIstance().getNpcList();
            System.out.println("     > Inserimento dati nella lista di Room");
            roomList = DBgame.getIstance().getRoomList();
            System.out.println("     > Inserimento dati nella lista di Item");
            itemList = DBgame.getIstance().getItemList();
            System.out.println("     > Inserimento dati nella lista di Place");
            placeList = DBgame.getIstance().getPlaceList();
        } catch (SQLException ex) {
            Logger.getLogger(DBTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    @DisplayName("Controllo delle liste")
    public void checkListData() {
        createListsFromTables();
        System.out.println(" >>> Controllo dei dati nelle liste");
        System.out.println("    > Cerca Dolly Bantry, Conway Jefferson, Colonnello Melchett");
        d_bantry = DataHandler.NpcFinder(npcList, "d_bantry");
        c_jefferson = DataHandler.NpcFinder(npcList, "c_jefferson");
        c_melchett = DataHandler.NpcFinder(npcList, "c_melchett");
        
        System.out.println("    > Cerca Biblioteca, Sala da ballo, Ufficio della polizia");
        library = DataHandler.RoomFinder(roomList, "library");
        ballRoom = DataHandler.RoomFinder(roomList, "ballRoom");
        policeOffice = DataHandler.RoomFinder(roomList, "policeOffice");
        
        System.out.println("    > Cerca Autopsia, Vestito bianco, Estratto conto di Mark");
        autopsy = DataHandler.ItemFinder(itemList, "autopsy");
        w_dress = DataHandler.ItemFinder(itemList, "w_dress");
        mark_bill = DataHandler.ItemFinder(itemList, "mark_bill");
        
        System.out.println("    > Cerca Gossington Hall, Majestic Hotel, Stazione di polizia");
        gh = DataHandler.PlaceFinder(placeList, "gh");
        mh = DataHandler.PlaceFinder(placeList, "mh");
        ps = DataHandler.PlaceFinder(placeList, "ps");
                
        System.out.println("    > Controlla Dolly Bantry");
        assertAll("d_bantry", 
                () -> assertEquals("Dolly", d_bantry.getName()),
                () -> assertEquals("Bantry", d_bantry.getSurname()),
                () -> assertEquals("diningRoom", d_bantry.getRoom()));
        System.out.println("    > Controlla Conway Jefferson");
        assertAll("c_jefferson",
                () -> assertEquals("Conway", c_jefferson.getName()),
                () -> assertEquals("Jefferson", c_jefferson.getSurname()),
                () -> assertEquals("jeffersonRoom", c_jefferson.getRoom()));
        System.out.println("    > Controlla Colonnello Melchett");
        assertAll("c_melchett",
                () -> assertEquals("Colonnello", c_melchett.getName()),
                () -> assertEquals("Melchett", c_melchett.getSurname()),
                () -> assertEquals("policeOffice", c_melchett.getRoom()));
        
        System.out.println("    > Controlla Biblioteca");
        assertAll("library",
                () -> assertEquals("Biblioteca", library.getName()),
                () -> assertEquals("gh", library.getPlace()));
        System.out.println("    > Controlla Sala da ballo");
        assertAll("ballRoom",
                () -> assertEquals("Sala da ballo", ballRoom.getName()),
                () -> assertEquals("mh", ballRoom.getPlace()));
        System.out.println("    > Controlla Uffici della polizia");
        assertAll("policeOffice",
                () -> assertEquals("Uffici della polizia", policeOffice.getName()),
                () -> assertEquals("ps", policeOffice.getPlace()));
    }
    
    @Test
    @DisplayName("Controllo delle liste con il join")
    public void checkJoinedTables() {
        insertTables();
        
        itemListGH = DBgame.getIstance().joinManagerItem("gh");
        assertEquals(2, itemListGH.size());
        itemListMH = DBgame.getIstance().joinManagerItem("mh");
        assertEquals(4, itemListMH.size());
        
        npcListGH = DBgame.getIstance().joinManagerNpc("gh");
        assertEquals(7, npcListGH.size());
        npcListMH = DBgame.getIstance().joinManagerNpc("mh");
        assertEquals(5, npcListMH.size());
        npcListPS = DBgame.getIstance().joinManagerNpc("ps");
        assertEquals(2, npcListPS.size());
        
    }
    
    @Test
    @DisplayName("Fine connessione db")
    public void disconnectDB() {
        try {
            System.out.println(" >>> Disconnessione dal database");
            DBgame.getIstance().disconnect();
        } catch (SQLException ex) {
            System.err.println(ex.getSQLState() + ": " + ex.getMessage());
        }
        
    }
}