package org.example.Home;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import org.example.Login;
import org.example.SignUp;

import javax.swing.*;
import java.awt.*;
import java.awt.dnd.DropTarget;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

public class Home extends JFrame {

    public Home () {
        init () ;
    }

    private void init () {
        setTitle("Home");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200,704);
        setResizable(false);
        setLocationRelativeTo(null);

        HomeOverlay homeOverlay = new HomeOverlay();

        setContentPane(homeOverlay);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                homeOverlay.play();
                homeOverlay.initOverlay(Home.this);
            }

            @Override
            public void windowClosing(WindowEvent e) {
                homeOverlay.stop();
            }
        });

        setVisible(true);
//        Ask();
    }

//    public void Ask () {
//        Scanner input = new Scanner(System.in);
//        System.out.println("What do you want to do?" +
//                "\n1) Login" +
//                "\n2) Sing Up") ;
//        int choice ;
//        while (true) {
//            choice = input.nextInt();
//            if ( !(choice>=1 && choice<=2) ) System.out.println("entered number is invalid please try again");
//            else break;
//        }
//        switch (choice) {
//            case 1 :
//                new Login() ;
//                break ;
//            case 2 :
//                new SignUp() ;
//        }
//    }
}
