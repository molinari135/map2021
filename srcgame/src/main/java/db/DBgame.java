/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import type.Item;
import type.NPC;
import type.Place;
import type.Room;

/**
 *
 * @author ester
 */
public class DBgame {
    public static final String CREATE_TABLE_PLACE =
            "CREATE TABLE IF NOT EXISTS place("
            + "placeId INT(1) PRIMARY KEY,"         // numero che identifica una location
            + "name VARCHAR(50),"                   // nome della location da mostrare a schermo
            + "desc VARCHAR(1024),"                 // descrizione della location
            + "chapter INT(1))";                    // giornata in cui si può accedere (da rimuovere?)
    
    public static final String CREATE_TABLE_ITEM =
            "CREATE TABLE IF NOT EXISTS item("
            + "itemId VARCHAR(50) PRIMARY KEY,"     // nome che itentifica l'oggetto 
            + "name VARCHAR(50),"                   // nome dell'oggetto da mostrare a schermo
            + "desc VARCHAR(1024),"                 // descrizione dell'oggetto
            + "collectable BOOLEAN,"                // true se si può mettere nell'inventario, false altrimenti
            + "room VARCHAR(50))";                  // nome che identifica la stanza in cui è presente l'oggetto
    
    public static final String CREATE_TABLE_ROOM =
            "CREATE TABLE IF NOT EXISTS room("
            + "roomId VARCHAR(50) PRIMARY KEY,"     // nome che identifica la stanza
            + "name VARCHAR(50),"                   // nome della stanza da mostrare a schermo
            + "desc VARCHAR(1024),"                 // descrizione della stanza
            + "floor INT(1),"                       // piano su cui è presente la stanza
            + "place INT(1))";                      // codice della location a cui appartiene la stanza
    
    public static final String CREATE_TABLE_NPC =
            "CREATE TABLE IF NOT EXISTS npc("
            + "npcId VARCHAR(50) PRIMARY KEY,"      // nome che identifica un personaggio
            + "name VARCHAR(50),"                   // nome del personaggio da mostrare a schermo
            + "surname VARCHAR(50),"                // cognome del personaggio da mostrare a schermo
            + "desc VARCHAR(1024),"                 // descrizione del personaggio
            + "room VARCHAR(50),"                   // stanza in cui è presente il personaggio
            + "talked BOOLEAN)";                    // true se si ha già parlato, false altrimenti
    public static final String JOIN_TABLE = "SELECT *"
            + "FROM npc JOIN room ON npc.room = room.roomId"
            + "AS table";
    public static final String CLEAR_TABLE_PLACE = "TRUNCATE TABLE place";
    public static final String CLEAR_TABLE_ITEM = "TRUNCATE TABLE item";
    public static final String CLEAR_TABLE_ROOM = "TRUNCATE TABLE room";
    public static final String CLEAR_TABLE_NPC = "TRUNCATE TABLE npc";
    
    public static final String ALL_PLACE =
            "INSERT INTO place VALUES"
            + "(1, 'Gossington Hall', 'Villa in cui viene rinvenuto il cadavere, proprietà dei signori Bantry.', 1),"
            + "(2, 'Majestic Hotel', 'Luogo di lavoro della vittima, posto apprezzato per le vacanze in famiglia.', 2),"
            + "(3, 'Stazione di polizia', 'Sede centrale della polizia della contea.', 0)";

    public static final String ALL_ITEM =
            "INSERT INTO item VALUES"
            + "('white_dress', 'Vestito bianco', 'Lo indossava la vittima rinvenuta nella biblioteca dei Bantry.', true, 'library'),"
            + "('ball_dress', 'Vestito da ballo', 'Indossato da Ruby Keene durante i balli al Majestic Hotel.', true, 'ballRoom'),"
            + "('autopsy', 'Autopsia', 'La ragazza risulta morta per strangolamento tra le dieci e la mezzanotte dopo esser stata sedata.', true, 'library'),"
            + "('broken_nail', 'Unghia spezzata', 'Sembra essere di una giovane ragazza, era per terra.', true, 'ballRoom'),"
            + "('adoption_doc', 'Testamento di adozione', 'Pratiche che affermano le trattative per adottare Ruby Keene da parte di Conway Jefferson.', true, 'jeffersonRoom'),"
            + "('mark_bill', 'Estratto conto di Mark Gaskell', 'Risulta che Mark sia indebitato in seguito a giocate fallimentari con grandi somme di denaro.', true, 'balcony')";

    public static final String ALL_ROOM =
            "INSERT INTO room VALUES"
            + "('hallwayGH1', 'Corridoio (GH1)', 'Corridoio del piano terra di Gossingston Hall.', 0, 1),"
            + "('hallwayGH2', 'Corridoio (GH2)', 'Corridoio del primo piano di Gossington Hall.', 0, 1),"
            + "('hallwayHM', 'Corridoio (HM)', 'Corridoio del primo piano.', 1, 2)," 
            + "('diningRoom', 'Sala da pranzo', 'Sala da pranzo della famiglia Bantry, situata nella lussuosa e imponente Gossington Hall.', 0, 1),"
            + "('livingRoom', 'Salotto', 'Qui sta il salotto. Ci sono quei mobili marrone scuro che hai sempre odiato e delle orribili sedie.', 0, 1),"
            + "('library', 'Biblioteca', 'La biblioteca della casa. Gli scaffali sono pieni di libri, ci sono molti gialli.', 1, 1),"
            + "('studio', 'Studio', 'Lo studio del signor Arthur Bantry. Sembra in perfetto ordine.', 1, 1),"           
            + "('reception', 'Reception', 'Reception del Majestic. Ha quello stile di una volta.', 0, 2),"
            + "('ballRoom', 'Sala da ballo', 'La sala più frequentata della struttura. Ci sono dei tavoli per il bridge.', 0, 2),"                                  
            + "('jeffersonRoom', 'Stanza di Jefferson', 'Pare sia la suite del signor Jefferson. Ha una veranda.', 1, 2),"
            + "('balcony', 'Veranda', 'Sta un piccolo balcone con un tavolino e delle sedie.', 1, 2)";

    public static final String ALL_NPC =
            "INSERT INTO npc VALUES"
            + "('a_bantry', 'Arthur', 'Bantry', 'Colonnello e possessore della villa; sua moglie si chiama Dolly.', 'studio', false),"
            + "('d_bantry', 'Dolly', 'Bantry', 'Moglie di Arthur e cara amica di Miss Marple.', 'diningRoom', false),"            
            + "('lorrimer', 'Lorrimer', '(Maggiordomo)', 'Fedele maggiordomo dei Bantry.', 'livingRoom', false),"
            + "('j_marple', 'Jane', 'Marple', 'Amica di Dolly appassionata di crimini e pettegolezzi.', 'diningRoom', false),"            
            + "('haydock', 'Dottor', 'Haydock', 'Medico legale che si occupa delle autopsie.', 'library', false),"            
            + "('corpse', 'Ruby', 'Keene', 'Vittima rinvenuta nella biblioteca dei Bantry.', 'library', false),"
            + "('j_turner', 'Josephine', 'Turner', 'Cugina della vittima e dipendente del Majestic.', 'ballRoom', false),"
            + "('r_starr', 'Ramòn', 'Starr', 'Ballerino del Majestic.', 'ballRoom', false),"
            + "('c_jefferson', 'Conway', 'Jefferson', 'Ospite della struttura; ha una suite.', 'jeffersonRoom', false),"
            + "('m_gaskell', 'Mark', 'Gaskell', 'Genero di Conway dai modi scontrosi.', 'balcony', false),"
            + "('prestcot', 'Signor', 'Prestcot', 'Proprietario della struttura dove lavorava la vittimaa.', 'reception', false),"
            + "('b_blake', 'Basil', 'Blake', 'Uomo che lavora nel mondo cinematografico; odiato dal signor Bantry.', 'studio', false)";
    
    private static DBgame istance;
    private Connection connection;
    
    private DBgame() {
        
    }
    
    public static DBgame getIstance() {
        if (istance == null) {
            istance = new DBgame();
        }
        return istance;
    }
    
    public void connect() throws SQLException {
        Properties dbprops = new Properties();
        dbprops.setProperty("user", "map2021");
        dbprops.setProperty("password", "admin");
        connection = DriverManager.getConnection("jdbc:h2:./resources/db/store", dbprops);
    }
    
    public void disconnect() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public void tableManager(String query) {
        try {
            Statement stm = connection.createStatement();
            stm.executeUpdate(query);
            stm.close();
        } catch (SQLException ex) {
            System.err.println(ex.getSQLState() + ": " + ex.getMessage());
        }
    }
    
    public void joinManager(String query) {
        try{
            Statement stm = connection.createStatement();
            stm.executeQuery(query);
            stm.close();
        }catch(SQLException ex) {
            System.err.println(ex.getSQLState() + ": " + ex.getMessage());
        }
    }
    public void printPlace() throws SQLException {
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM place");
        while(rs.next()) {
            String id = rs.getString("placeId");
            String name = rs.getString("name");
            String description = rs.getString("desc");
            int chapter = rs.getInt("chapter");
    
            System.out.print("ID: " + id);
            System.out.println(" - Name: " + name);
            System.out.print("Description: " + description);
            System.out.println(" - Chapter: " + chapter);
            System.out.println("");
        }
  
        rs.close();
        stm.close();
    }
    
    public void printItem() throws SQLException {
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM item");
        while(rs.next()) {
            String id = rs.getString("itemId");
            String name = rs.getString("name");
            String description = rs.getString("desc");
            String room = rs.getString("room");
            boolean collectable = rs.getBoolean("collectable");
    
            System.out.print("ID: " + id);
            System.out.println(" - Name: " + name);
            System.out.print("Description: " + description);
            System.out.print(" - Room: " + room);
            System.out.println(" - Collectable: " + collectable);
            System.out.println("");
        }
  
        rs.close();
        stm.close();
    }
    
    public void printRoom() throws SQLException {
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM room");
        while(rs.next()) {
            String id = rs.getString("roomId");
            String name = rs.getString("name");
            String description = rs.getString("desc");
            int floor = rs.getInt("floor");
            int map = rs.getInt("place");
    
            System.out.print("ID: " + id);
            System.out.print(" - Name: " + name);
            System.out.println(" Description: " + description);
            System.out.print("Floor: " + floor);
            System.out.println(" - Place: " + map);
            System.out.println("");
        }
  
        rs.close();
        stm.close();
    }
    
    public void printNpc() throws SQLException {
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM npc");
        while(rs.next()) {
            String id = rs.getString("npcId");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String description = rs.getString("desc");
            String room = rs.getString("room");
            boolean visible = rs.getBoolean("talked");
    
            System.out.print("ID: " + id);
            System.out.print(" - Name: " + name);
            System.out.println(" - Surname: " + surname);
            System.out.print("Description: " + description);
            System.out.print(" - Room: " + room);
            System.out.println(" - Talked: " + visible);
            System.out.println("");
        }
  
        rs.close();
        stm.close();
    }
    
    public Place getPlace(String query) throws SQLException {
        Place place = new Place(0, "", "", 0);
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM place WHERE LOWER(name) LIKE LOWER('%" + query + "%')");
        while(rs.next()) {
            place.setId(rs.getInt("placeId"));
            place.setName(rs.getString("name"));
            place.setDescription(rs.getString("desc"));
            place.setChapter(rs.getInt("chapter"));
        }
        rs.close();
        stm.close();
        return place;
    }
    
    public Item getItem(String query) throws SQLException {
        Item item = new Item();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM item WHERE LOWER(itemId) LIKE LOWER('%" + query + "%')");
        while(rs.next()) {
            item.setId(rs.getString("itemId"));
            item.setName(rs.getString("name"));
            item.setDescription(rs.getString("desc"));
            item.isCollectable(rs.getBoolean("collectable"));
            item.setRoom(rs.getString("room"));
        }
        rs.close();
        stm.close();
        return item;
    }
    
    public Room getRoom(String query) throws SQLException {
        Room room = new Room();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM room WHERE LOWER(roomId) LIKE LOWER('%" + query + "%')");
        while(rs.next()) {
            room.setId(rs.getString("roomId"));
            room.setName(rs.getString("name"));
            room.setDescription(rs.getString("desc"));
            room.setFloor(rs.getInt("floor"));
            room.setPlace(rs.getInt("place"));
        }
        rs.close();
        stm.close();
        return room;
    }
    
    public NPC getNpc(String query) throws SQLException {
        NPC npc = new NPC();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM npc WHERE LOWER(npcId) LIKE LOWER('%" + query + "%')");
        while(rs.next()) {
            npc.setId(rs.getString("npcId"));
            npc.setName(rs.getString("name"));
            npc.setSurname(rs.getString("surname"));
            npc.setDescription(rs.getString("desc"));
            npc.setRoom(rs.getString("room"));
            npc.isTalked(rs.getBoolean("talked"));
        }
        rs.close();
        stm.close();
        return npc;
    }
    
    public List<Place> getPlaceList() throws SQLException {
        
        List<Place> placeList = new ArrayList<Place>();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM place");
        // ResultSet rs = stm.executeQuery("SELECT * FROM room WHERE chapter IS " + "");
        while (rs.next()) {
            Place place = new Place();
            place.setId(rs.getInt("placeId"));
            place.setName(rs.getString("name"));
            place.setDescription(rs.getString("desc"));
            place.setChapter(rs.getInt("chapter"));
            placeList.add(place);
        }
        rs.close();
        stm.close();
        return placeList;
    }
    
    public List<Item> getItemList() throws SQLException {
        
        List<Item> itemList = new ArrayList<Item>();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM item");
        // ResultSet rs = stm.executeQuery("SELECT * FROM item WHERE room IS " + room + "");
        while (rs.next()) {
            Item item = new Item();
            item.setId(rs.getString("itemId"));
            item.setName(rs.getString("name"));
            item.setDescription(rs.getString("desc"));
            item.setRoom(rs.getString("room"));
            itemList.add(item);
        }
        rs.close();
        stm.close();
        return itemList;
    }
    
    public List<Room> getRoomList() throws SQLException {
        
        List<Room> roomList = new ArrayList<Room>();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM room");
        // ResultSet rs = stm.executeQuery("SELECT * FROM room WHERE place IS " + place + "");
        while (rs.next()) {
            Room room = new Room();
            room.setId(rs.getString("roomId"));
            room.setName(rs.getString("name"));
            room.setDescription(rs.getString("desc"));
            room.setFloor(rs.getInt("floor"));
            room.setPlace(rs.getInt("place"));
            roomList.add(room);
        }
        rs.close();
        stm.close();
        return roomList;
    }
    
    public List<NPC> getNpcList() throws SQLException {
        List<NPC> npcList = new ArrayList<NPC>();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM npc");
        // ResultSet rs = stm.executeQuery("SELECT * FROM npc WHERE room IS " + "");
        while (rs.next()) {
            NPC npc = new NPC();
            npc.setId(rs.getString("npcId"));
            npc.setName(rs.getString("name"));
            npc.setDescription(rs.getString("desc"));
            npc.setSurname(rs.getString("surname"));
            npc.setRoom(rs.getString("room"));
            npc.isTalked(rs.getBoolean("talked"));
            npcList.add(npc);
        }
        rs.close();
        stm.close();
        return npcList;
    }
}