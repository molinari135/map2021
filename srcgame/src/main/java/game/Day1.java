/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javax.swing.ImageIcon;

/**
 *
 * @author rino
 */
//TODO attributi?
public class Day1 extends DayDescription {

    public Day1(GameHandler gh) {
        super(gh);
    }

    public void analizeBody() {
        gh.form.textBox[6].setVisible(true);
        gh.form.textButton[6].setVisible(true);
        gh.form.textAreaBox2[6].setVisible(true);
        gh.form.textAreaBox2[6].setText("Ispezionando il cadavere , hai ottenuto ABITO BIANCO");
        gh.form.inv.getItem_2().setIcon(new ImageIcon(getClass().getResource("/dress1.png")));
        gh.form.inv.getItem_2().setText("");
        gh.form.textButton[6].setText("Chiudi");
        gh.form.textButton[6].setActionCommand("continueTextScene" + 6);

    }

    public void takeAutopsy() {
        gh.form.inv.getItem_1().setIcon(new ImageIcon(getClass().getResource("/doc_autopsia.png")));
        gh.form.inv.getItem_1().setText("");
    }

}
