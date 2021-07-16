package type;


/**
 * Classe TYPE che rappresenta un generico oggetto
 * 
 * @author giaco
 *
 */
public class Item {
    private String id;
    private String name;
    private String description;
    private boolean collectable;
    private String room;

    public Item() {
        
    }
    
    public Item(String id, String name, String description, boolean collectable, String room) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.collectable = collectable;
        this.room = room;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void isCollectable(boolean collectable) {
        this.collectable = collectable;
    }
    
    public void setRoom(String room) {
        this.room = room;
    }
    
    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    
    public boolean getCollectable() {
        return collectable;
    }

    public String getRoom() {
        return room;
    }
}