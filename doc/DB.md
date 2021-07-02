# Istruzioni DB

1. [Introduzione](#introduzione)
2. [Creare una classe che gestisce il database](#creare-una-classe-che-gestisce-il-database)
3. [Connessione al database](#connessione-al-database)
4. [Creazione delle table](#creazione-delle-table)
5. [Inizializzazione delle table](#inizializzazione-delle-table)
6. [Inserimento dei valori nelle table](#inserimento-dei-valori-nelle-table)
7. [Creazione query di base](#creazione-query-di-base)
8. [Stampa dei dati di una table](#stampa-dei-dati-di-una-table)

## Introduzione
Se si sta usando [Maven](https://maven.apache.org), nel file `pom.xml` vanno aggiunte le seguenti righe:
```xml
<dependencies>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <version>1.4.200</version>
        </dependency>
    </dependencies>
```

## Creare una classe che gestisce il database
Per evitare di utilizzare il database come un oggetto di una classe, occorre scrivere il seguente codice:
```java
import java.sql.Connection;

public class Database {
  private static Database istance;
  private Connection connection;
  
  private Database() {
  
  }
  
  public static Database getIstance() {
    if (istance == null) {
      istance = new Database();
    }
    return istance;
  }
}
```

In questo modo, quando si vorrà chiamare il database nel `main` basterà scrivere:
```java
public static void main(String args[]) {
  Database.getIstance();
}
```

## Connessione al database
Per connettersi al database conviene usare il metodo `connect`
```java
import java.util.Properties;
import java.sql.DriverManager;

public void connect() throws SQLException {
  Properties dbprops = new Properties();
  dbprops.setProperty("user", "user");
  dbprops.setProperty("password", "password");
  connection = DriverManager.getConnection("jdbc:h2:./resources/db/store", dbprops);
}
```

Questo tipo di connessione necessita di un `user` e una `password` a scelta.
Per far disconnettere il database alla chiusura del programma, bisogna usare `disconnect`:
```java
public void disconnect() throws SQLException {
  if (connection != null) {
    connection.close();
  }
}
```

Entrambi i metodi vanno usati nel `main` nel seguente modo:
```java
public static void main(String args[]) {
  Database.getIstance().connect();
  // Connessione al db effettuata
  Database.getIstance().disconnect();
  // Connessione interrotta
}
```

## Creazione delle table
Per creare e gestire le table si può creare il metodo `tableManager` che consente di:
- Creare una table;
- Inizializzare una table;
- Riempire una table con dei valori.

```java
import java.sql.PreparedStatement;

public void tableManager(String query) {
  try {
    Statement stm = connection.createStatement();
    stm.executeUpdate(query);
    stm.close();
  } catch (SQLException ex) {
    System.err.println(ex.getSQLState() + ": " + ex.getMessage());
```

Dove `query` è una stringa, ad esempio se si vuole inserire la table `npc`, basta scrivere:
```java
// inserimento valori
public static final String CREATE_TABLE_NPC =
            "CREATE TABLE IF NOT EXISTS npc("
            + "npcId INT PRIMARY KEY,"
            + "name VARCHAR(50),"
            + "surname VARCHAR(50),"
            + "desc VARCHAR(1024),"
            + "room INT,"
            + "clickable BOOLEAN,"
            + "foreign key(room) references room(roomId)";
```

## Inizializzazione delle table
Richiamando la funzione `tableManager`, se si vuole inizializzare una table basta passare al parametro `query` la stringa:
```java
public static final String CLEAR_NPC = "TRUNCATE TABLE npc";
```

## Inserimento dei valori nelle table
Richiamando la funzione `tableManager`, se si vogliono inserire dei valori in una table basta passare al parametro `query` la stringa:
```java
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
```

Con le query è anche possibile inserire i dati contenuti negli attributi di un oggetto nel seguente modo:
```java
import java.sql.PreparedStatement;

public static final String INSERT_NPC = 
            "INSERT INTO npc VALUES"
            + "(?, ?, ?, ?, ?, ?)";

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
```

## Creazione query di base
La gestione delle query viene effettuata dai metodi che contengono `ResultSet`:
```java
import java.sql.Statement;
import java.sql.ResultSet;

public void simpleQuery() throws SQLExcpetion {
  Statement stm = connection.createStatement();
  ResultSet rs = stm.executeQuery(//String query);
  while(rs.next()) {
   // Per ottenere un intero si usa rs.getInt();
   // Per ottenere una stringa si usa rs.getString();
   // Per gli altri tipi di dati, controllare la documentazione
  }
  
  rs.close();
  stm.close();
}
```

## Stampa dei dati di una table
Quando si vuole stampare solo alcune colonne di una table basta fare una query con `SELECT`:
```java
public void simpleQuery() throws SQLExcpetion {
  Statement stm = connection.createStatement();
  ResultSet rs = stm.executeQuery("SELECT id, name, surname FROM npc");
  while(rs.next()) {
    int id = rs.getId("npcId");
    String name = rs.getString("name");
    String surname = rs.getString("surname");
    
    System.out.print("ID: " + id);
    System.out.print("Name: " + name);
    System.out.println("Surname: " + surname);
  }
  
  rs.close();
  stm.close();
}
```

Si può anche effettuare un `SELECT * FROM [tableName]`:
```java
public void simpleQuery() throws SQLExcpetion {
  Statement stm = connection.createStatement();
  ResultSet rs = stm.executeQuery("SELECT * FROM npc");
  while(rs.next()) {
    int id = rs.getId("npcId");
    String name = rs.getString("name");
    String surname = rs.getString("surname");
    String description = rs.getString("description");
    int room = rs.getInt("room");
    boolean clickable = rs.getBoolean("clickable");
    
    System.out.print("ID: " + id);
    System.out.print("Name: " + name);
    System.out.print("Surname: " + surname);
    System.out.print("Description: " + description);
    System.out.print("Room: " + room);
    System.out.println("Clickable: " + clickable);
  }
  
  rs.close();
  stm.close();
}
```

Nel caso in cui si volesse stampare tutto con una sola stringa, si può optare per questo sistema:
```java
public String simpleQuery() throws SQLExcpetion {
  String str1 = "", str2 = "";
  Statement stm = connection.createStatement();
  ResultSet rs = stm.executeQuery("SELECT * FROM npc");
  while(rs.next()) {
    int id = rs.getId("npcId");
    String name = rs.getString("name");
    String surname = rs.getString("surname");
    String description = rs.getString("description");
    int room = rs.getInt("room");
    boolean clickable = rs.getBoolean("clickable");
    
    str1 = ("ID: " + id + " - Name: " + name + " - Surname: " + surname + 
            "\nDescription: " + description + " - Room: " + room + " - Clickable: " + clickable);
    str2 = str2 + str1;
  }
  
  rs.close();
  stm.close();
  return str2;
}
```
