package type;

/**
 *
 * @author rino
 */
public class Room {

    private String id;
    private String name;
    private String description;  
    private int floor;  
    private int place;
    
    public Room() {
        
    }
    
    public Room(String id, String name, String description, int floor, int place) {
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

    public void setPlace(int place) {
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
    
    public int getPlace() {
        return place;
    }
    
}