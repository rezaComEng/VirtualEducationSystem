package org.example;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import org.example.Home.MainFrame;
import org.example.UserPage.UserFrame;

import java.awt.*;

public class Main {

    public static MainFrame mainFrame ;

    public static void main(String[] args) {
        FlatMacDarkLaf.setup();

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UserFrame().setVisible(true);
            }
        });
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                mainFrame = new MainFrame();
            }
        });
    }
}