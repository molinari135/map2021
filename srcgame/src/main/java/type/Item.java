/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package type;


/**
 *
 * @author rino
 */
public class Item {
    private int id;
    private String name;
    private String description;
    private boolean collectable;
    private int room;

    public Item() {
        
    }
    
    public Item(int id, String name, String description, boolean collectable, int room) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.collectable = collectable;
        this.room = room;
    }

    public void setId(int id) {
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
    
    public void setRoom(int room) {
        this.room = room;
    }
    
    public int getId() {
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

    public int getRoom() {
        return room;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
    
