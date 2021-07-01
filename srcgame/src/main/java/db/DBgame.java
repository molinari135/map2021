/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import type.NPC;
import type.Room;

/**
 * How to refer to:
 * - NPCs:
 *  1) Artur Bantry
 *  2) Dolly Bantry
 *  3) Jane Marple
 *  4) Colonnello Melchett
 *  5) Domestica Lucy
 *  6) Domestica Mary
 *  7) Agente Palk
 *  8) Dottor Haydock
 *  9) Signor Lorrimer
 * - Places:
 *  1) Gossington Hall
 *  2) Basil Blake's House
 *  3) Hotel Majestic
 *  4) Cave
 * - Rooms
 *  1) Sala da pranzo
 *  2) Salotto
 *  3) Cucina
 *  4) Biblioteca
 *  5) Camera da letto
 *  6) Studio
 *  7) Guardaroba
 *  8) Bagno
 * 
 * @author ester
 */
public class DBgame {
    // all create table
    public static final String CREATE_TABLE_NPC =
            "CREATE TABLE IF NOT EXISTS npc("
            + "npcId INT PRIMARY KEY,"
            + "name VARCHAR(50),"
            + "surname VARCHAR(50),"
            + "desc VARCHAR(1024),"
            + "room INT,"
            + "clickable BOOLEAN,"
            + "foreign key(room) references room(roomId)";
    
    public static final String CREATE_TABLE_ROOM =
            "CREATE TABLE IF NOT EXISTS room("
            + "roomId INT PRIMARY KEY,"
            + "name VARCHAR(50),"
            + "desc VARCHAR(1024),"
            + "visible BOOLEAN,"
            + "floor INT,"
            + "map INT)";
    
    public static final String CREATE_TABLE_ITEM =
            "CREATE TABLE IF NOT EXISTS item("
            + "itemId INT PRIMARY KEY,"
            + "collectable BOOLEAN,"
            + "room INT)";
    
    public static final String CREATE_TABLE_PLACE =
            "CREATE TABLE IF NOT EXISTS place("
            + "mapId INT PRIMARY KEY,"
            + "name VARCHAR(50),"
            + "day INT)";
    
    // all insert into
    // TODO delete these
    public static final String INSERT_NPC = 
            "INSERT INTO npc VALUES"
            + "(?, ?, ?, ?, ?, ?)";
    public static final String INSERT_ROOM =
            "INSERT INTO room VALUES"
            + "(?, ?, ?, ?, ?)";
    public static final String INSERT_ITEM =
            "INSERT INTO item VALUES"
            + "(?, ?, ?)";
    public static final String INSERT_PLACE =
            "INSERT INTO place VALUES"
            + "(?, ?, ?)";
    
    // all select *
    public static final String PRINT_ALL_NPC = "SELECT * FROM npc";
    public static final String PRINT_ALL_ROOM = "SELECT * FROM room";
    public static final String PRINT_ALL_PLACE = "SELECT * FROM place";
    
    // all truncate
    public static final String CLEAR_NPC = "TRUNCATE TABLE npc";
    public static final String CLEAR_ROOM = "TRUNCATE TABLE room";
    public static final String CLEAR_ITEM = "TRUNCATE TABLE item";
    public static final String CLEAR_PLACE = "TRUNCATE TABLE place";
    
    // all insert into
    public static final String ALL_NPC =
            "INSERT INTO npc VALUES"
            + "(1, 'Arthur', 'Bantry', 'Vecchio decrepito', 6, true),"
            + "(2, 'Dolly', 'Bantry', 'Vecchia decrepita', 2, true),"
            + "(3, 'Jane', 'Marple', 'Signorina', 2, true),"
            + "(4, 'Colonnello', 'Melchett', 'Capo della polizia', 4, true),"
            + "(5, 'Domestica', 'Lucy', 'Domestica della cucina', 3, true),"
            + "(6, 'Domestica', 'Mary', 'Domestica delle mansioni', 5, true),"
            + "(7, 'Agente', 'Palk', 'Agente di polizia', 4, true),"
            + "(8, 'Dottor', 'Haydock', 'Medico legale', 4, true),"
            + "(9, 'Signor', 'Lorrimer', 'Maggiordomo di Gossington Hall', 3, true)";
    
    public static final String ALL_ROOM =
            "INSERT INTO room VALUES"
            + "(1, 'Sala da pranzo', 'Sala da pranzo della famiglia Bantry, situata nella lussuosa e imponente Gossington Hall.', true, 0, 1),"
            + "(2, 'Salotto', 'Ti trovi nel salotto. Ci sono quei mobili marrone scuro che hai sempre odiato e delle orribili sedie.', true, 0, 1),"
            + "(3, 'Cucina', 'Ti trovi nella solita cucina. Mobili bianchi, maniglie azzurre, quello strano lampadario che adoravi tanto quando eri piccolo.', true, 0, 1),"
            + "(4, 'Biblioteca', 'Sei nella Biblioteca. Scaffali pieni di libri.... chissa dove sono nascosti gli hentai...', true, 0, 1),"
            + "(5, 'Camera da letto', 'Sei nella camera da letto dei signori Bantry, il letto � stato appena rifatto...', true, 1, 1),"
            + "(6, 'Studio', 'Sei nello studio del signor Arthur Bantry, nel cassetto della scrivania c� una calibro 50 per ammazzarsi', true, 1, 1),"
            + "(7, 'Guardaroba', 'Sei nel guardaroba, qui di solito si nascondono pezzi di umani...', true, 1, 1),"
            + "(8, 'Bagno', 'Sei nel bagno. Quanto tempo passato qui dentro...meglio non pensarci...', true, 1, 1)";
    
    public static final String ALL_ITEM =
            "SELECT * FROM item";
    
    public static final String ALL_PLACE =
            "INSERT INTO place VALUES"
            + "(1, 'Gossington Hall', 1),"
            + "(2, 'Blake House', 1),"
            + "(3, 'Majestic Hotel', 2),"
            + "(4, 'Cava', 4)";
    
    // queries
    public static final String UPDATE_NPC_QUERY =
            "UPDATE npc SET clickable = ? WHERE npcId = ?";
    public static final String UPDATE_ROOM_QUERY =
            "";
    public static final String UPDATE_PLACE_QUERY =
            "";
    public static final String UPDATE_ITEM_QUERY =
            "";
    
    private static DBgame istance;
    private Connection connection;
    
    private DBgame() {
        // do not write here
    }
    
    // makes a new DB
    public static DBgame getIstance() {
        if (istance == null) {
            istance = new DBgame();
        }
        return istance;
    }
    
    // connects to the db and creates all the clean tables
    public void connect() throws SQLException {
        Properties dbprops = new Properties();
        dbprops.setProperty("user", "map2021");
        dbprops.setProperty("password", "admin");
        connection = DriverManager.getConnection("jdbc:h2:./resources/db/store", dbprops);
        tableManager(CREATE_TABLE_NPC);
        tableManager(CLEAR_NPC);
        tableManager(CREATE_TABLE_ROOM);
        tableManager(CLEAR_ROOM);
        tableManager(CREATE_TABLE_ITEM);
        tableManager(CLEAR_ITEM);
        tableManager(CREATE_TABLE_PLACE);
        tableManager(CLEAR_PLACE);
    }
    
    // disconnects the db
    public void disconnect() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
    
    // creates tables
    public void tableManager(String query) {
        try {
            Statement stm = connection.createStatement(); // request something
            stm.executeUpdate(query);
            stm.close();
        } catch (SQLException ex) {
            System.err.println(ex.getSQLState() + ": " + ex.getMessage());
        }
        
    }
    
    // updates npc table
    public void updateNpc(NPC npc) throws SQLException {
        PreparedStatement pstm = connection.prepareStatement(INSERT_NPC);
        pstm.setInt(1, npc.getId());
        pstm.setString(2, npc.getName());
        pstm.setString(3, npc.getSurname());
        pstm.setString(4, npc.getDescription());
        pstm.setBoolean(5, npc.isClickable());
        pstm.execute();
        pstm.close();
    }
    
    // updates room table
    public void updateRoom(Room room) throws SQLException {
        PreparedStatement pstm = connection.prepareStatement(INSERT_ROOM);
        pstm.setInt(1, room.getId());
        pstm.setString(2, room.getName());
        pstm.setString(3, room.getDescription());
        pstm.setBoolean(4, room.isVisible());
        pstm.setInt(5, room.getFloor());
        pstm.execute();
        pstm.close();
    }
    
    // fills a table
    public void fillTable(String query) {
        try {
            Statement stm = connection.createStatement();
            stm = connection.createStatement();
            stm.executeUpdate(query);
            stm.close();
        } catch (SQLException ex) {
            System.err.println(ex.getSQLState() + ": " + ex.getMessage());
        }
        
    }
    
    public List<NPC> listNPC() throws SQLException {
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM npc");
        List<NPC> list = new ArrayList();
        while (rs.next()) {
            NPC npc = new NPC(rs.getInt("npcId"), rs.getString("name"), rs.getString("surname"), rs.getString("description"), rs.getBoolean("clickable"));
            list.add(npc);
        }
        rs.close();
        stm.close();
        return list;
    }
    
    public List<Room> listRoom() throws SQLException {
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM room");
        List<Room> list = new ArrayList();
        while (rs.next()) {
            Room room = new Room(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            list.add(room);
        }
        rs.close();
        stm.close();
        return list;
    }
    
    public String showNPC() throws SQLException {
        String abc = "", cat = "";
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery(PRINT_ALL_NPC);
        while(rs.next()) {
            abc = "Id: " + rs.getInt(1) + " - Nome: " + rs.getString(2) + " - Cognome: " + rs.getString(3) + "\n";
            cat = cat + abc;
        }
        
        rs.close();
        stm.close();
        return cat;
    }
    
    public String showRoom() throws SQLException {
        String abc = "", cat = "";
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery(PRINT_ALL_ROOM);
        while(rs.next()) {
            abc = "Id: " + rs.getInt(1) + " - Nome: " + rs.getString(2) + " - Piano: " + rs.getString(5) + "\n";
            cat = cat + abc;
        }
        
        rs.close();
        stm.close();
        return cat;
    }
    
    public String showPlace() throws SQLException {
        String abc = "", cat = "";
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery(PRINT_ALL_PLACE);
        while(rs.next()) {
            abc = "Id: " + rs.getInt(1) + " - Nome: " + rs.getString(2) + " - Giorno: " + rs.getInt(3) + "\n";
            cat = cat + abc;
        }
        
        rs.close();
        stm.close();
        return cat;
    }
}
