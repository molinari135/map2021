package type;

import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author giaco
 */
public class NPC {
    private String id;   
    private String name;    
    private String surname;   
    private String description; //show when you click on the object 
    private String room;
    private boolean talked;

    public NPC() {
        
    }
    
    //For primary character
    public NPC(String id, String name, String surname, String description, String room, boolean talked) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.description = description;
        this.room = room;
        this.talked = talked;
        
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setRoom(String room) {
        this.room = room;
    }
    
    public void isTalked(boolean talked) {
        this.talked = talked;
    }
    
    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getRoom() {
        return room;
    }
    
    public boolean getTalked() {
        return talked;
    }
}