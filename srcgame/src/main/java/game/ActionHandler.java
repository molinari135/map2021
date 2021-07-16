/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe astratta che implementa l'interfaccia ActionListener per la
 * gestione degli eventi nel gioco: generica, in base alla location in cui
 * si trova il giocatore, viene chiamata la specifica sottoclasse
 * 
 * @author giaco
 */
public abstract class ActionHandler implements ActionListener {

    @Override
    public abstract void  actionPerformed(ActionEvent e);
}
