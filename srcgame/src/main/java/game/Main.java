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
 * Classe principale, che si occupa di avviare il database e la prima schermata
 * del gioco.
 *
 * @author giaco
 */
public class Main {

    /**
     *
     */
    public static List<NPC> listNPC = new ArrayList<NPC>();

    /**
     *
     */
    public static List<Room> listRoom = new ArrayList<Room>();

    /**
     *
     */
    public static List<Item> listItem = new ArrayList<Item>();

    /**
     *
     */
    public static List<Place> listPlace = new ArrayList<Place>();

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        new Start().setVisible(true);        

        try {

            DBgame.getIstance().connect();
            System.out.println("\n >>> Connessione al database...\n");
            DBgame.getIstance().tableManager(DBgame.CREATE_TABLE_NPC);
            DBgame.getIstance().tableManager(DBgame.CLEAR_TABLE_NPC);
            DBgame.getIstance().tableManager(DBgame.ALL_NPC);
            System.out.println("\n >>> Fine inserimento NPC <<<\n");
            DBgame.getIstance().tableManager(DBgame.CREATE_TABLE_PLACE);
            DBgame.getIstance().tableManager(DBgame.CLEAR_TABLE_PLACE);
            DBgame.getIstance().tableManager(DBgame.ALL_PLACE);
            System.out.println("\n >>> Fine inserimento Map <<<\n");
            DBgame.getIstance().tableManager(DBgame.CREATE_TABLE_ITEM);
            DBgame.getIstance().tableManager(DBgame.CLEAR_TABLE_ITEM);
            DBgame.getIstance().tableManager(DBgame.ALL_ITEM);
            System.out.println("\n >>> Fine inserimento Item <<<\n");
            DBgame.getIstance().tableManager(DBgame.CREATE_TABLE_ROOM);
            DBgame.getIstance().tableManager(DBgame.CLEAR_TABLE_ROOM);
            DBgame.getIstance().tableManager(DBgame.ALL_ROOM);
            System.out.println("\n >>> Fine inserimento Room <<<\n");
           
            listPlace = DBgame.getIstance().getPlaceList();
            listItem = DBgame.getIstance().getItemList();
            listRoom = DBgame.getIstance().getRoomList();
            listNPC = DBgame.getIstance().getNpcList();
            
            DBgame.getIstance().disconnect();
            
            System.out.println("\n >>> Disconnessione dal database...\n");

        } catch (SQLException ex) {
            System.err.println(ex.getSQLState() + ": " + ex.getMessage());
        }
    }
    
    
}
