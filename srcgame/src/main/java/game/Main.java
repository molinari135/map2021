/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import db.DBgame;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import type.Item;
import type.NPC;
import type.Place;
import type.Room;

/**
 *
 * @author giaco
 */
public class Main {   
     public static List<NPC> listNPC = new ArrayList<NPC>();
  
    public static void main(String[] args) {
        new Start().setVisible(true);  
        
        // test cli database
        try {
            DBgame.getIstance().connect();
            System.out.println("\n >>> Connessione al database...\n");
            DBgame.getIstance().tableManager(DBgame.CREATE_TABLE_NPC);
            DBgame.getIstance().tableManager(DBgame.CLEAR_TABLE_NPC);
            DBgame.getIstance().tableManager(DBgame.ALL_NPC);
            System.out.println("\n >>> Fine inserimento NPC <<<\n");
       
            System.out.println("\n >>> Fine inserimento Map <<<\n");
            DBgame.getIstance().tableManager(DBgame.CREATE_TABLE_ITEM);
            DBgame.getIstance().tableManager(DBgame.CLEAR_TABLE_ITEM);
            DBgame.getIstance().tableManager(DBgame.ALL_ITEM);
            System.out.println("\n >>> Fine inserimento Item <<<\n");
            DBgame.getIstance().tableManager(DBgame.CREATE_TABLE_ROOM);
            DBgame.getIstance().tableManager(DBgame.CLEAR_TABLE_ROOM);
            DBgame.getIstance().tableManager(DBgame.ALL_ROOM);
            System.out.println("\n >>> Fine inserimento Room <<<\n");
            DBgame.getIstance().printNpc();
            System.out.println("\n >>> Fine stampa Npc <<<\n");
            
            System.out.println("\n >>> Fine stampa Map <<<\n");
            DBgame.getIstance().printItem();
            System.out.println("\n >>> Fine stampa Item <<<\n");
            DBgame.getIstance().printRoom();
            System.out.println("\n >>> Fine stampa Room <<<\n");
            // controllo metodi
            
            
            
            NPC a_bantry = new NPC();
            a_bantry = DBgame.getIstance().getNpc("arthur");
            System.out.println("Nome(ID): " + a_bantry.getName() + "(" + a_bantry.getId() + ")");
            
            Room cucina = new Room();
            cucina = DBgame.getIstance().getRoom("cucina");
            System.out.println("Nome(ID): " + cucina.getName() + "(" + cucina.getId() + ")");
            
            Item autopsia1 = new Item();
            autopsia1 = DBgame.getIstance().getItem("autopsia di");
            System.out.println("Nome(ID): " + autopsia1.getName() + "(" + autopsia1.getId() + ")");
            
           
            listNPC = DBgame.getIstance().getNpcList();
            // fine controllo metodi
            DBgame.getIstance().disconnect();
            System.out.println("\n >>> Disconnessione dal database...\n");
            
        } catch (SQLException ex) {
            System.err.println(ex.getSQLState() + ": " + ex.getMessage());
        }
    }

}
