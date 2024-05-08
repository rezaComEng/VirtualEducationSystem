package org.example.Home;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {
    public static HomeOverlay homeOverlay ;

    public MainFrame () {
        init () ;
    }

    private void init () {
        setTitle("Home");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200,704);
        setResizable(false);
        setLocationRelativeTo(null);
        homeOverlay = new HomeOverlay();

        setContentPane(homeOverlay);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                homeOverlay.play();
                homeOverlay.initOverlay();
            }

            @Override
            public void windowClosing(WindowEvent e) {
                homeOverlay.stop();
            }
        });

        setVisible(true);
    }
}
