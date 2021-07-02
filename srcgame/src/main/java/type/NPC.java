/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package type;

/**
 *
 * @author giaco
 */
public class NPC {
    private int id;   
    private String name;    
    private String surname;   
    private String description; //show when you click on the object 
    private int room;
    private boolean visible;

    //For primary character
    public NPC(int id, String name, String surname, String description, int room, boolean clickable) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.description = description;
        this.room = room;
        this.visible = visible;
        
    }
    
    public void setId(int id) {
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
    
    public void setRoom(int room) {
        this.room = room;
    }
    
    public void isVisible(boolean visible) {
        this.visible = visible;
    }
    
    public int getId() {
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
    
    public int getRoom() {
        return room;
    }
    
    public boolean getVisible() {
        return visible;
    }
}
