/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author tom
 */
public class DiningRoom {
    
        JPanel panel = new JPanel();
        JLabel background = new JLabel();            
        JButton continua = new JButton();
        JLabel chat = new JLabel();
        JFrame frame;
        
    public DiningRoom(JFrame frame) {      
        
        this.frame = frame;
        
        panel.setBounds(0, 0, 1920, 1080);        
        panel.setLayout(null);
        
        /*chat.setBounds(300, 600, 1300, 400);
        chat.setIcon(new ImageIcon(getClass().getResource("/text_box.png"))); 
        panel.add(chat);*/
        
        background.setBounds(0, 0, 1920, 1080);
        background.setIcon(new ImageIcon(getClass().getResource("/diningroommod.png")));   
        panel.add(background);      
                
        frame.add(panel);
    }

}
