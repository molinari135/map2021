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
import java.util.Properties;

/**
 *
 * @author ester
 */
public class DBgame {
    public static final String CREATE_TABLE_MAP =
            "CREATE TABLE IF NOT EXISTS map("
            + "mapId INT(1) PRIMARY KEY,"
            + "name VARCHAR(50),"
            + "desc VARCHAR(1024),"
            + "chapter INT(1))";
    
    public static final String CREATE_TABLE_ITEM =
            "CREATE TABLE IF NOT EXISTS item("
            + "itemId INT(2) PRIMARY KEY,"
            + "name VARCHAR(50),"
            + "desc VARCHAR(1024),"
            + "collectable BOOLEAN,"
            + "room INT(3))";
    
    public static final String CREATE_TABLE_ROOM =
            "CREATE TABLE IF NOT EXISTS room("
            + "roomId INT(3) PRIMARY KEY,"
            + "name VARCHAR(50),"
            + "desc VARCHAR(1024),"
            + "north INT(3),"
            + "south INT(3),"
            + "east INT(3),"
            + "west INT(3),"
            + "floor INT(1),"
            + "map INT(1))";
    
    public static final String CREATE_TABLE_NPC =
            "CREATE TABLE IF NOT EXISTS npc("
            + "npcId INT(2) PRIMARY KEY,"
            + "name VARCHAR(50),"
            + "surname VARCHAR(50),"
            + "desc VARCHAR(1024),"
            + "room INT(3),"
            + "visible BOOLEAN)";
    
    public static final String CLEAR_TABLE_MAP = "TRUNCATE TABLE map";
    public static final String CLEAR_TABLE_ITEM = "TRUNCATE TABLE item";
    public static final String CLEAR_TABLE_ROOM = "TRUNCATE TABLE room";
    public static final String CLEAR_TABLE_NPC = "TRUNCATE TABLE npc";
    
    public static final String ALL_MAP =
            "INSERT INTO map VALUES"
            + "(1, 'Gossington Hall', 'Villa in cui viene rinvenuto il cadavere, proprietà dei signori Bantry', 1),"
            + "(2, 'Chatsworth', 'Villa di Basil Blake, impiegato nel mondo cinematografico', 1),"
            + "(3, 'Majestic Hotel', 'Luogo di lavoro della vittima, posto apprezzato per le vacanze in famiglia', 2),"
            + "(4, 'Stazione di polizia', 'Sede centrale della polizia della contea', 0),"
            + "(5, 'Cava di Venn', 'Grotta sperduta conosciuta da pochi del posto', 4)";

    public static final String ALL_ITEM =
            "INSERT INTO item VALUES"
            + "(1, 'Vestito bianco', 'Lo indossava la vittima rinvenuta nella biblioteca', true, 1),"
            + "(2, 'Vestito da ballo', 'Indossato da Ruby Keene durante i balli al Majestic Hotel', true, 1),"
            + "(3, 'Autopsia di Ruby Keene', 'La ragazza risulta morta per strangolamento tra le dieci e la mezzanotte', true, 1),"
            + "(4, 'Autopsia aggiornata', 'La vittima era stata sedata prima di venire strangolata', true, 1),"
            + "(5, 'Unghie tagliate', 'Trovate nella stanza di Ruby Keene', true, 1),"
            + "(6, 'Unghia spezzata', 'Trovata da Peter Carmody, presenta le tracce di una sciarpa', true, 1),"
            + "(7, 'Sciarpa rovinata', 'Apparteneva a Josephine Turner, usata per spezzare una unghia di Ruby Keene per fargliele tagliare', true, 1),"
            + "(8, 'Testamento di adozione', 'Pratiche che affermano la conclusione delle trattative per adottare Ruby Keene da parte di Conway Jefferson', true, 1),"
            + "(9, 'Estratto conto di Mark Gaskell', 'Risulta che Mark sia indebitato in seguito a giocate fallimentari con grandi somme di denaro', true, 1),"
            + "(10, 'Bottone camicetta degli Scout', 'Apparteneva alla divisa da Scout di Pamela Reeves, viene trovato nella macchina bruciata', true, 1),"
            + "(11, 'Auto di George Bartlett', 'Viene denunciata la scomparsa da Bartlett stesso e viene ritrovata bruciata', true, 1)";

    public static final String ALL_ROOM =
            "INSERT INTO room VALUES"
            + "(101, 'Corridoio 1', 'Corridorio', 102, null, 1, 2, 0, 1),"
            + "(102, 'Corridoio 2', 'Corridoio', 103, 101, 2, 3, 0, 1),"
            + "(1, 'Sala da pranzo', 'Sala da pranzo della famiglia Bantry, situata nella lussuosa e imponente Gossington Hall.', null, 101, null, null, 0, 1),"
            + "(2, 'Salotto', 'Ti trovi nel salotto. Ci sono quei mobili marrone scuro che hai sempre odiato e delle orribili sedie.', null, 101, null, null, 0, 1),"
            + "(3, 'Cucina', 'Ti trovi nella solita cucina. Mobili bianchi, maniglie azzurre, quello strano lampadario che adoravi tanto quando eri piccolo.', null, 102, null, null, 0, 1),"
            + "(4, 'Biblioteca', 'Sei nella Biblioteca. Scaffali pieni di libri.... chissa dove sono nascosti gli hentai...', null, 102, null, null, 0, 1),"
            + "(103, 'Corridoio 3', 'Corridoio', 104, 102, 5, 6, 0, 1),"
            + "(104, 'Corridoio 4', 'Corridoio', null, 103, 8, 7, 0, 1),"
            + "(5, 'Camera da letto', 'Sei nella camera da letto dei signori Bantry, il letto è stato appena rifatto...', null, 103, null, null, 1, 1),"
            + "(6, 'Studio', 'Sei nello studio del signor Arthur Bantry, nel cassetto della scrivania sta una calibro 50 per ammazzarsi', null, 103, null, null, 1, 1),"
            + "(7, 'Guardaroba', 'Sei nel guardaroba, qui di solito si nascondono pezzi di umani...', null, 104, null, null, 1, 1),"
            + "(8, 'Bagno', 'Sei nel bagno. Quanto tempo passato qui dentro...meglio non pensarci...', null, 104, null, null, 1, 1),"
            + "(9, 'Reception', 'Ve la fate voi', 10, null, null, 11, 0, 2),"
            + "(10, 'Salone', 'Ve la fate voi', 105, 9, null, null, 1, 2),"
            + "(11, 'Campo da tennis', 'Ve la fate voi', null, 9, null, null, 0, 2),"
            + "(105, 'Corridoio 5', 'Corridoio', 106, 10, null, null, 2, 2),"
            + "(106, 'Corridoio 6', 'Corridoio', null, 105, null, 13, 2, 2)"
            + "(12, 'Camera da letto', 'Ve la fate voi', 13, null, null, null, 2, 2),"
            + "(13, 'Stanza di Jefferson', 'Ve la fate voi', 14, 106, null, 12, 2, 2),"
            + "(14, 'Veranda', 'Ve la fate voi', null, 13, null, null, 2, 2),"
            + "(107, 'Corridoio 7', 'Corridoio', 108, null, 16, 15, 0, 0),"
            + "(108, 'Corridoio 8', 'Corridoio', null, 107, 18, 17, 0, 0),"
            + "(15, 'Schedario', 'Contiene tutte le informazioni', null, 107, null, null, 0, 0),"
            + "(16, 'Uffici', 'Uffici della polizia', null, 107, null, null, 0, 0),"
            + "(17, 'Sala interrogatori', ';)', null, 108, null, null, 0, 0),"
            + "(18, 'Ufficio capo', 'Ufficio del capo della pula', null, 108, null, null, 0, 0)";

    public static final String ALL_NPC =
            "INSERT INTO npc VALUES"
            + "(1, 'Arthur', 'Bantry', 'Colonnello e possessore della villa', 6, true),"
            + "(2, 'Dolly', 'Bantry', 'Moglie di Arthur e cara amica di Miss Marple', 1, true),"
            + "(3, 'Domestica', 'Lucy', 'Domestica che gestisce la cucina', 3, true),"
            + "(4, 'Signor', 'Lorrimer', 'Maggiordomo dei Bantry', 3, true),"
            + "(5, 'Jane', 'Marple', 'Amica di Dolly appassionata di crimini', 1, true),"
            + "(6, 'Colonnello', 'Melchett', 'Capo della polizia del Radfordshire', 2, true),"
            + "(7, 'Dottor', 'Haydock', 'Medico legale che accerta la morte della vittima', 4, true),"
            + "(8, 'Agente', 'Palk', 'Agente di polizia che raggiunge per primo il luogo del delitto', 4, true),"
            + "(9, 'Domestica', 'Mary', 'Domestica che gestisce le pulizie', 5, true),"
            + "(10, 'Ruby', 'Keene', 'Vittima trovata nella biblioteca dei Bantry', 4, false),"
            + "(11, 'Josephine', 'Turner', 'Cugina della vittima', 10, true),"
            + "(12, 'Ramòn', 'Starr', 'Ballerino e istruttore di tennis', 11, true),"
            + "(13, 'Conway', 'Jefferson', 'Ospite invalido', 12, true),"
            + "(14, 'Adelaide', 'Jefferson', 'Nuora di Conway', 13, true),"
            + "(15, 'Mark', 'Gaskell', 'Genero di Conway', 12, true),"
            + "(16, 'Rosamund', 'Jefferson', 'Figlia deceduta di Conway e moglie di Mark', 0, false),"
            + "(17, 'Frank', 'Jefferson', 'Figlio deceduto di Conway e padre di Peter', 0, false),"
            + "(18, 'Peter', 'Carmody', 'Nipote di Conway appassionato di polizieschi', 14, true),"
            + "(19, 'George', 'Bartlett', 'Ospite che aveva ballato con la vittima', 10, true),"
            + "(20, 'Signor', 'Prestcot', 'Proprietario', 9, true),"
            + "(21, 'Hugo', 'McLean', 'Fidanzato di Adelaide', 11, true),"
            + "(22, 'Basil', 'Blake', 'Uomo che lavora nel mondo cinematografico e possessore della villa', 0, true),"
            + "(23, 'Dinah', 'Lee', 'Fidanzata di Basil', 0, true),"
            + "(24, 'Pamela', 'Reeves', 'Vittima trovata nella macchina bruciata', 0, false),"
            + "(25, 'Florence', 'Small', 'Testimone delle vicende avvenute prima della scomparsa di Pamela', 17, true)";
    
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
    
    // Map
    public void printNpc() throws SQLException {
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM npc");
        while(rs.next()) {
            int id = rs.getInt("npcId");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String description = rs.getString("desc");
            int room = rs.getInt("room");
            boolean visible = rs.getBoolean("visible");
    
            System.out.print("ID: " + id);
            System.out.print(" - Name: " + name);
            System.out.println(" - Surname: " + surname);
            System.out.print(" Description: " + description);
            System.out.print(" - Room: " + room);
            System.out.println(" - Visible: " + visible);
        }
  
        rs.close();
        stm.close();
    }
    
    
}
