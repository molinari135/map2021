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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import type.Item;
import type.NPC;
import type.Place;
import type.Room;

/**
 * <h1> Classe DBgame </h1>
 * <h2> JDBC con database h2 </h2>
 * La classe presenta i metodi per effettuare operazioni su database.
 * Crea la table per gli oggetti di tipo:
 * <ul>
 * <li> Place
 * <li> Item
 * <li> Room
 * <li> NPC
 * </ul>
 * I metodi in questa classe permettono di effettuare:
 * <ul>
 * <li>Connessione al database
 * <li>Disconnessione al database
 * <li>Gestione delle table
 * <li>Gestione dei join tra table
 * <li>Generazione delle liste di oggetti dal database
 * </ul>
 * @author ester
 */
public class DBgame {

    /**
     * Crea una table per le mappe dei luoghi del gioco
     */
    public static final String CREATE_TABLE_PLACE =
            "CREATE TABLE IF NOT EXISTS place("
            + "placeId VARCHAR(2) PRIMARY KEY,"         // numero che identifica una location
            + "name VARCHAR(50),"                   // nome della location da mostrare a schermo
            + "desc VARCHAR(1024),"                 // descrizione della location
            + "chapter BOOLEAN)";                    // giornata in cui si pu accedere (da rimuovere?)
    
    /**
     * Crea una table per gli oggetti del gioco
     */
    public static final String CREATE_TABLE_ITEM =
            "CREATE TABLE IF NOT EXISTS item("
            + "itemId VARCHAR(50) PRIMARY KEY,"     // nome che itentifica l'oggetto 
            + "name VARCHAR(50),"                   // nome dell'oggetto da mostrare a schermo
            + "desc VARCHAR(1024),"                 // descrizione dell'oggetto
            + "collectable BOOLEAN,"                // true se si pu mettere nell'inventario, false altrimenti
            + "room VARCHAR(50))";                  // nome che identifica la stanza in cui  presente l'oggetto
    
    /**
     * Crea una table per le stanze di ogni mappa del gioco
     */
    public static final String CREATE_TABLE_ROOM =
            "CREATE TABLE IF NOT EXISTS room("
            + "roomId VARCHAR(50) PRIMARY KEY,"     // nome che identifica la stanza
            + "name VARCHAR(50),"                   // nome della stanza da mostrare a schermo
            + "desc VARCHAR(1024),"                 // descrizione della stanza
            + "floor INT(1),"                       // piano su cui  presente la stanza
            + "place VARCHAR(2))";                      // codice della location a cui appartiene la stanza
    
    /**
     * Crea una table per i personaggi non giocabili
     */
    public static final String CREATE_TABLE_NPC =
            "CREATE TABLE IF NOT EXISTS npc("
            + "npcId VARCHAR(50) PRIMARY KEY,"      // nome che identifica un personaggio
            + "name VARCHAR(50),"                   // nome del personaggio da mostrare a schermo
            + "surname VARCHAR(50),"                // cognome del personaggio da mostrare a schermo
            + "desc VARCHAR(1024),"                 // descrizione del personaggio
            + "room VARCHAR(50),"                   // stanza in cui  presente il personaggio
            + "talked BOOLEAN)";                    // true se si ha gi parlato, false altrimenti
    
    /**
     * Elimina i dati della table <code>place</code> senza cancellarne lo schema
     */
    public static final String CLEAR_TABLE_PLACE = "TRUNCATE TABLE place";

    /**
     * Elimina i dati della table <code>item</code> senza cancellarne lo schema
     */
    public static final String CLEAR_TABLE_ITEM = "TRUNCATE TABLE item";

    /**
     * Elimina i dati della table <code>room</code> senza cancellarne lo schema
     */
    public static final String CLEAR_TABLE_ROOM = "TRUNCATE TABLE room";

    /**
     * Elimina i dati della table <code>npc</code> senza cancellarne lo schema
     */
    public static final String CLEAR_TABLE_NPC = "TRUNCATE TABLE npc";
    
    /**
     * Effettua l'unione della table <code>npc</code> con la table <code>room</code> per ricavare il nome della mappa a cui appartiene
     */
    public static final String NPC_ROOM = "SELECT npc.*, room.place FROM npc JOIN room ON npc.room = room.roomId";

    /**
     * Effettua l'unione della table <code>item</code> con la table <code>room</code> per ricavare il nome della mappa a cui appartiene
     */
    public static final String ITEM_ROOM = "SELECT item.*, room.place FROM item JOIN room ON item.room = room.roomId";
    
    /**
     * Inserisce tutti i dati delle mappe nella table <code>place</code> del database
     */
    public static final String ALL_PLACE =
            "INSERT INTO place VALUES"
            + "('gh', 'Gossington Hall', 'Villa in cui viene rinvenuto il cadavere, propriet� dei signori Bantry.', false),"
            + "('mh', 'Majestic Hotel', 'Luogo di lavoro della vittima, posto apprezzato per le vacanze in famiglia.', false),"
            + "('ps', 'Stazione di polizia', 'Sede centrale della polizia della contea.', false)";

    /** 
     * Inserisce tutti i dati delle mappe nella table <code>item</code> del database
     */
    public static final String ALL_ITEM =
            "INSERT INTO item VALUES"
            + "('white_dress', 'Vestito bianco', 'Lo indossava la vittima rinvenuta nella biblioteca dei Bantry.', true, 'library'),"
            + "('ball_dress', 'Vestito da ballo', 'Indossato da Ruby Keene durante i balli al Majestic Hotel.', true, 'ballRoom'),"
            + "('autopsy', 'Autopsia', 'La ragazza risulta morta per strangolamento tra le dieci e la mezzanotte dopo esser stata sedata.', true, 'library'),"
            + "('broken_nail', 'Unghia spezzata', 'Sembra essere di una giovane ragazza, era per terra.', true, 'ballRoom'),"
            + "('adoption_doc', 'Testamento di adozione', 'Pratiche che affermano le trattative per adottare Ruby Keene da parte di Conway Jefferson.', true, 'jeffersonRoom'),"
            + "('mark_bill', 'Estratto conto di Mark Gaskell', 'Risulta che Mark sia indebitato in seguito a giocate fallimentari con grandi somme di denaro.', true, 'balcony')";

    /**
     * Inserisce tutti i dati delle mappe nella table <code>room</code> del database
     */
    public static final String ALL_ROOM =
            "INSERT INTO room VALUES"
            + "('hallwayGH1', 'Corridoio (GH1)', 'Corridoio del piano terra di Gossingston Hall.', 0, 'gh'),"
            + "('hallwayGH2', 'Corridoio (GH2)', 'Corridoio del primo piano di Gossington Hall.', 0, 'gh'),"
            + "('hallwayHM', 'Corridoio (HM)', 'Corridoio del primo piano.', 1, 'gh')," 
            + "('diningRoom', 'Sala da pranzo', 'Sala da pranzo della famiglia Bantry, situata nella lussuosa e imponente Gossington Hall.', 0, 'gh'),"
            + "('livingRoom', 'Salotto', 'Qui sta il salotto. Ci sono quei mobili marrone scuro che hai sempre odiato e delle orribili sedie.', 0, 'gh'),"
            + "('library', 'Biblioteca', 'La biblioteca della casa. Gli scaffali sono pieni di libri, ci sono molti gialli.', 1, 'gh'),"
            + "('studio', 'Studio', 'Lo studio del signor Arthur Bantry. Sembra in perfetto ordine.', 1, 'gh'),"           
            + "('reception', 'Reception', 'Reception del Majestic. Ha quello stile di una volta.', 0, 'mh'),"
            + "('ballRoom', 'Sala da ballo', 'La sala pi� frequentata della struttura. Ci sono dei tavoli per il bridge.', 0, 'mh'),"                                  
            + "('jeffersonRoom', 'Stanza di Jefferson', 'Pare sia la suite del signor Jefferson. Ha una veranda.', 1, 'mh'),"
            + "('balcony', 'Veranda', 'Sta un piccolo balcone con un tavolino e delle sedie.', 1, 'mh'),"
            + "('policeOffice', 'Uffici della polizia', 'Ci sono degli agenti intenti nel svolgere il loro lavoro.', 3, 'ps'),"
            + "('interrogationRoom', 'Sala interrogatori', 'Ecco la sala interrogatori della stazione di polizia.', 3, 'ps')";

    /**
     * Inserisce tutti i dati delle mappe nella table <code>npc</code> del database
     */
    public static final String ALL_NPC =
            "INSERT INTO npc VALUES"
            + "('a_bantry', 'Arthur', 'Bantry', 'Colonnello e possessore della villa; sua moglie si chiama Dolly.', 'studio', false),"
            + "('d_bantry', 'Dolly', 'Bantry', 'Moglie di Arthur e cara amica di Miss Marple.', 'diningRoom', false),"            
            + "('lorrimer', 'Lorrimer', '(Maggiordomo)', 'Fedele maggiordomo dei Bantry.', 'livingRoom', false),"
            + "('j_marple', 'Jane', 'Marple', 'Amica di Dolly appassionata di crimini e pettegolezzi.', 'diningRoom', false),"            
            + "('haydock', 'Dottoressa', 'Haydock', 'Medico legale che si occupa delle autopsie.', 'library', false),"            
            + "('corpse', 'Ruby', 'Keene', 'Vittima rinvenuta nella biblioteca dei Bantry.', 'library', false),"
            + "('j_turner', 'Josephine', 'Turner', 'Cugina della vittima e dipendente del Majestic.', 'ballRoom', false),"
            + "('r_starr', 'Ram�n', 'Starr', 'Ballerino del Majestic.', 'ballRoom', false),"
            + "('c_jefferson', 'Conway', 'Jefferson', 'Ospite della struttura; ha una suite.', 'jeffersonRoom', false),"
            + "('m_gaskell', 'Mark', 'Gaskell', 'Genero di Conway dai modi scontrosi.', 'balcony', false),"
            + "('prestcot', 'Signor', 'Prestcot', 'Proprietario della struttura dove lavorava la vittima.', 'reception', false),"
            + "('b_blake', 'Basil', 'Blake', 'Uomo che lavora nel mondo cinematografico; odiato dal signor Bantry.', 'studio', false),"
            + "('a_palk', 'Agente', 'Palk', 'Sottoposto della stazione di polizia della contea', 'policeOffice', false),"
            + "('c_melchett', 'Colonnello', 'Melchett', 'Capo della polizia della contea', 'policeOffice', false)";
    
    /**
     * Serve per controllare se sono state inserite solo lettere nei metodi con input.
     * <br>Viene impiegato per le ricerche nel database.
     */
    public static final String INPUT_REGEX = "[a-zA-Z]+";
    
    private static DBgame istance;
    private Connection connection;
    
    private DBgame() {
        
    }
    
    /**
     * Fornisce un database.
     * <br>Se non esiste, lo crea.
     * @return Un oggetto di tipo DBgame.
     */
    public static DBgame getIstance() {
        if (istance == null) {
            istance = new DBgame();
        }
        return istance;
    }
    
    /**
     * Permette di connettersi al database locato nella cartella resources/db/store.
     * @throws SQLException Eccezione fornita dal database.
     */
    public void connect() throws SQLException {
        Properties dbprops = new Properties();
        dbprops.setProperty("user", "map2021");
        dbprops.setProperty("password", "admin");
        connection = DriverManager.getConnection("jdbc:h2:./src/main/resources/store", dbprops);
    }
    
    /**
     * Permette di effettuare la disconnessione al database.
     * @throws SQLException Eccezione fornita dal database.
     */
    public void disconnect() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    /**
     * Si occupa delle query che necessitano del metodo <code>executeUpdate</code>
     * @param query Una delle query statiche presenti nella classe.
     */
    public void tableManager(String query) {
        try {
            Statement stm = connection.createStatement();
            stm.executeUpdate(query);
            stm.close();
        } catch (SQLException ex) {
            System.err.println(ex.getSQLState() + ": " + ex.getMessage());
        }
    }
    
    /**
     * Si occupa della query che effettua il join tra <code>npc</code> e <code>room</code>.
     * @param placeCode Codice della mappa; accetta "gh", "mh", "ps".
     * @return Una lista con tutti gli npc di una mappa.
     */
    public List<NPC> joinManagerNpc(String placeCode) {
        List<NPC> npcList = new ArrayList<NPC>();
        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(NPC_ROOM);
            Pattern pattern = Pattern.compile(INPUT_REGEX);
            Matcher matcher = pattern.matcher(placeCode);
            while (rs.next()) {
                if (matcher.matches()) {
                    if (rs.getString("place").equals(placeCode)) {
                        NPC npc = new NPC();
                        npc.setId(rs.getString("npcId"));
                        npc.setName(rs.getString("name"));
                        npc.setDescription(rs.getString("desc"));
                        npc.setSurname(rs.getString("surname"));
                        npc.setRoom(rs.getString("room"));
                        npc.isTalked(rs.getBoolean("talked"));
                        npcList.add(npc);
                    }    
                }                                     
            }
            
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            System.err.println(ex.getSQLState() + ": " + ex.getMessage());
        }      
        return npcList;
    }
    
    /**
     * Si occupa della query che effettua il join tra <code>item</code> e <code>room</code>.
     * @param placeCode Codice della mappa; accetta "gh", "mh", "ps".
     * @return Una lista con tutti gli oggetti di una mappa.
     */
    public List<Item> joinManagerItem(String placeCode) {
        List<Item> itemList = new ArrayList<Item>();
        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(ITEM_ROOM);
            Pattern pattern = Pattern.compile(INPUT_REGEX);
            Matcher matcher = pattern.matcher(placeCode);
            while (rs.next()) {
                if (matcher.matches()) {
                    if (rs.getString("place").equals(placeCode)) {
                        Item item = new Item();
                        item.setId(rs.getString("itemId"));
                        item.setName(rs.getString("name"));
                        item.setDescription(rs.getString("desc"));
                        item.setRoom(rs.getString("room"));
                        itemList.add(item);
                    }    
                }                                          
            }
            
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            System.err.println(ex.getSQLState() + ": " + ex.getMessage());
        }      
        return itemList;
    }
    
    /*
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
            System.out.println(" - Player is here: " + chapter);
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
            String map = rs.getString("place");
    
            System.out.print("ID: " + id);
            System.out.print(" - Name: " + name);
            System.out.println(" Description: " + description);
            System.out.print("Floor: " + floor);
            System.out.println(" - Place (id): " + map);
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
        Place place = new Place();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM place WHERE LOWER(name) LIKE LOWER('%" + query + "%')");
        while(rs.next()) {
            place.setId(rs.getString("placeId"));
            place.setName(rs.getString("name"));
            place.setDescription(rs.getString("desc"));
            place.setChapter(rs.getBoolean("chapter"));
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
            room.setPlace(rs.getString("place"));
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
    */

    /**
     * Fornisce tutte le mappe in un'unica lista.
     * @return Una lista con tutte le mappe del gioco.
     * @throws SQLException Eccezione fornita dal database.
     */

    
    public List<Place> getPlaceList() throws SQLException {
        
        List<Place> placeList = new ArrayList<Place>();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM place");
        while (rs.next()) {
            Place place = new Place();
            place.setId(rs.getString("placeId"));
            place.setName(rs.getString("name"));
            place.setDescription(rs.getString("desc"));
            place.setChapter(rs.getBoolean("chapter"));
            placeList.add(place);
        }
        rs.close();
        stm.close();
        return placeList;
    }
    
    /**
     * Fornisce tutti gli oggetti in un'unica lista.
     * @return Una lista con tutti gli oggetti presenti nel gioco.
     * @throws SQLException Eccezione fornita dal database.
     */
    public List<Item> getItemList() throws SQLException {
        
        List<Item> itemList = new ArrayList<Item>();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM item");
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
    
    /**
     * Fornisce tutte le stanze in un'unica lista.
     * @return Una lista con tutte le stanze di ogni mappa presenti nel gioco.
     * @throws SQLException Eccezione fornita dal database.
     */
    public List<Room> getRoomList() throws SQLException {
        
        List<Room> roomList = new ArrayList<Room>();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM room");
        while (rs.next()) {
            Room room = new Room();
            room.setId(rs.getString("roomId"));
            room.setName(rs.getString("name"));
            room.setDescription(rs.getString("desc"));
            room.setFloor(rs.getInt("floor"));
            room.setPlace(rs.getString("place"));
            roomList.add(room);
        }
        rs.close();
        stm.close();
        return roomList;
    }
    
    /**
     * Fornisce tutti gli npc in un'unica lista
     * @return Una lista con tutti i personaggi del gioco.
     * @throws SQLException Eccezione fornita dal database.
     */
    public List<NPC> getNpcList() throws SQLException {
        List<NPC> npcList = new ArrayList<NPC>();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM npc");
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