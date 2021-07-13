/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import type.NPC;

/**
 *
 * @author giaco
 */
public class InventoryHandler implements ActionListener{
    InventoryDialog inv1;
    

    NPC prestcot, j_turner, r_starr, c_jefferson, m_gaskell = new NPC();
    List<String> Prestcot, J_Turner, Ramon, Jeff, Mark = new ArrayList<>();

    InventoryHandler(InventoryDialog inv1) {
        this.inv1 = inv1;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String eventCommand = e.getActionCommand();

        switch (eventCommand) {
            case "observeItem1":
                
                break;

            case "observeItem2":
                
                break;

            case "observeItem3":
                
                break;
        }
    }
}
