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
public class Staircase extends Room {
    
    private Room up = null;
    
    private Room down = null;

    public Staircase(int id, String description) {
        super(id,description);
    }
    
    

    public Room getUp() {
        return up;
    }

    public void setUp(Room up) {
        this.up = up;
    }

    public Room getDown() {
        return down;
    }

    public void setDown(Room down) {
        this.down = down;
    }
    
    
    
}
