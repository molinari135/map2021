/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author tom
 */
public class Scene1 {

    JPanel panel1 = new JPanel();
    JLabel auto = new JLabel();
    JTextField data = new JTextField();
    JTextArea testoPrologo = new JTextArea();
    JButton continua = new JButton();

    JFrame frame;

    int i = 1;

    Clip clipRain;
    Clip clipJazz;
       
    GameHandler gh;
    
    public Scene1(JFrame frame, Clip clipRain, Clip clipJazz, GameHandler gh) {

        this.frame = frame;
        this.clipRain = clipRain;
        this.clipJazz = clipJazz;
        this.gh = gh;

        carSound();

        panel1.setBounds(0, 0, 1920, 1080);
        panel1.setBackground(Color.black);
        panel1.setLayout(null);
        
        auto.setBounds(30, -50, 1920, 1080);
        auto.setIcon(new ImageIcon(getClass().getResource("/car_detect_2.png")));
        panel1.add(auto);

        data.setEditable(false);
        data.setBackground(new Color(0, 0, 0));
        data.setBounds(30, 40, 700, 15);
        data.setFont(new Font("Courier New", 1, 22)); // NOI18N
        data.setForeground(new Color(255, 255, 255));
        data.setText("15 Ottobre 1982 | Ore 22:12");
        data.setBorder(null);
        panel1.add(data);

        testoPrologo.setEditable(false);
        testoPrologo.setBounds(1260, 100, 650, 750);
        testoPrologo.setBackground(new Color(0, 0, 0));

        testoPrologo.setFont(new Font("Courier New", 0, 28)); // NOI18N
        testoPrologo.setForeground(new Color(255, 255, 255));
        testoPrologo.setBorder(null);
        testoPrologo.setLineWrap(true);
        testoPrologo.setWrapStyleWord(true);
        panel1.add(testoPrologo);

        continua.setBackground(new Color(0, 0, 0));
        continua.setBounds(1750, 870, 64, 26);
        continua.setFont(new Font("Segoe UI", 2, 14)); // NOI18N
        continua.setForeground(new Color(255, 255, 255));
        continua.setText("Continua");
        continua.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED,
                Color.lightGray, Color.white, Color.lightGray, Color.white));
        continua.setContentAreaFilled(false);

        continua.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continuaActionPerformed(evt);
            }
        });
        panel1.add(continua);

        frame.add(panel1);
    }

    private void continuaActionPerformed(java.awt.event.ActionEvent evt) {

        //TODO Usare file per testi + aggiust. struttura
        String text1 = "Come era potuto succedere?\nSembrava che per lui, o lei, questo fosse soltanto un gioco.\n\n"
                + "Psicopatico del cazzo...\n";

        String text2 = "A interrompere le mie scorribande di pensieri fu l’agente Palck.\n\n"
                + "Il suo viso stanco e svigorito comparve dietro la portiera alla mia destra, "
                + "chiedendomi se fosse tutto a posto.\n\nNon poté fare a meno di notare, "
                + "dopo un’intera carriera insieme, che quello, velatamente, "
                + "era un invito a riprendere celermente le indagini:   ne avevamo tutti abbastanza.\n\n"
                + "Glielo dovevo.";

        switch (i) {
            case 1:
                testoPrologo.setText(text1);
                i++;
                break;
                
            case 2:
                testoPrologo.setText(text2);
                i++;
                break;
                
            case 3:
                frame.dispose();
                clipRain.stop();
                clipJazz.stop();
                
                gh.form.setVisible(true);
                
                break;
                
            default:
                break;
        }
    }

    public final void carSound() {
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                    getClass().getClassLoader().getResource("car_door_close.wav")
            );
            clip.open(inputStream);
            clip.start();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            System.err.println(e.getMessage());
        }
    }

}
