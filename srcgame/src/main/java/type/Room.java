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
public class Room {

    private int id;
    private String name;
    private String description;
    private int north;
    private int south;
    private int east;
    private int west;  
    private int floor;  
    private int map;
    
    public Room(int id, String name, String description, int south, int north, int east, int west, int floor, int map) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
        this.floor = floor;
        this.map = map;
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
    
    public void setNorth(int north) {
        this.north = north;
    }
    
    public void setSouth(int south) {
        this.south = south;
    }      

    public void setEast(int east) {
        this.east = east;
    }

    public void setWest(int west) {
        this.west = west;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setMap(int map) {
        this.map = map;
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

    public int getNorth() {
        return north;
    }
    
    public int getSouth() {
        return south;
    }
    
    public int getEast() {
        return east;
    }
    
    public int getWest() {
        return west;
    }
    
    public int getFloor() {
        return floor;
    }
    
    public int getMap() {
        return map;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.id;
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
        final Room other = (Room) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}