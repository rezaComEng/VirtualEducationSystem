package org.example.UserPage;

import net.miginfocom.swing.MigLayout;
import org.example.Components.RoundedPanel;

import javax.swing.*;
import java.awt.*;

public class UserFrame extends JFrame {

    RoundedPanel panel1 = new RoundedPanel();
    RoundedPanel panel2 = new RoundedPanel();
    RoundedPanel panel3 = new RoundedPanel();

    RoundedPanel header = new RoundedPanel();

    public UserFrame () {
        init();
    }

    private void init () {
        setTitle("user page");
        setSize(1000,600);
        setLocationRelativeTo(null);
        setLayout( null );
        setUndecorated(true);
        header.setLocation(10,10);
        panel1.setBounds(header.getHeight() + 10 ,10,150,getHeight() - 20);
        panel1.add(new JLabel("panel 1"));
        panel2.add(new JLabel("panel 2"));
        panel3.add(new JLabel("panel 3"));
        panel2.setBounds(panel1.getWidth()+panel1.getX() + 10 ,10,getWidth() - 30 - panel1.getWidth() ,180);
        panel3.setBounds(panel1.getWidth()+panel1.getX() + 10,panel2.getHeight() + panel2.getY() + 10,getWidth() - 30 - panel1.getWidth(),getHeight() - panel2.getHeight() - 30 );
        panel1.setBackground( new Color(49, 44, 44, 244));
        panel2.setBackground( new Color(49, 44, 44, 244));
        panel3.setBackground( new Color(49, 44, 44, 244));
        add(panel1);
        add(panel2);
        add(panel3);
    }



    private void createHeader () {
        header.setSize(50,getHeight()-20);

        header.setLayout( new MigLayout("fill","[][][]","center"));


    }
}
