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
        try {
            DBgame.getIstance().connect();
        } catch(SQLException ex) {
            System.err.println(ex.getSQLState() + ": " + ex.getMessage());
        }
        
        new Start().setVisible(true);        
    }

}
