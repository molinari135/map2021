/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package type;

/**
 * Classe che rappresenta la generica stanza
 *
 * @author giaco
 */
public class Room {

    private String id;
    private String name;
    private String description;  
    private int floor;  
    private String place;
    
    public Room() {
        
    }
    
    public Room(String id, String name, String description, int floor, String place) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.floor = floor;
        this.place = place;
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
    
    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setPlace(String place) {
        this.place = place;
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

    public int getFloor() {
        return floor;
    }
    
    public String getPlace() {
        return place;
    }
    
}