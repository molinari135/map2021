/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import db.DBgame;
import java.sql.SQLException;

/**
 *
 * @author giaco
 */
public class Main {
    
    public static void main(String[] args) {
        new Start().setVisible(true);  
        
        // test cli database
        try {
            DBgame.getIstance().connect();
            DBgame.getIstance().tableManager(DBgame.CREATE_TABLE_NPC);
            DBgame.getIstance().tableManager(DBgame.CLEAR_TABLE_NPC);
            DBgame.getIstance().tableManager(DBgame.ALL_NPC);
            //DBgame.getIstance().tableManager(DBgame.ALL_MAP);
            //DBgame.getIstance().tableManager(DBgame.ALL_ITEM);
            //DBgame.getIstance().tableManager(DBgame.ALL_ROOM);
            DBgame.getIstance().printNpc();
            DBgame.getIstance().disconnect();
            
        } catch (SQLException ex) {
            System.err.println(ex.getSQLState() + ": " + ex.getMessage());
        }
    }

}
