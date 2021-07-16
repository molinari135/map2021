
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package type;

/**
 * Classe che rappresenta la generica location
 *
 * @author ester
 */
public class Place {
    private String id;
    private String name;
    private String description;
    private boolean chapter;
    
    public Place() {
        
    }
    
    public Place(String id, String name, String description, boolean chapter) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.chapter = chapter;
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
    
    public void setChapter(boolean chapter) {
        this.chapter = chapter;
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
    
    public boolean getChapter() {
        return chapter;
    }
}
