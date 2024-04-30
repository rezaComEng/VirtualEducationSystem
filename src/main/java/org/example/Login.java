package org.example;

import com.formdev.flatlaf.FlatClientProperties;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Login extends JPanel {

    public Login () {
        init();
    }

    private void init () {
        setLayout( new MigLayout("fill,insets 20" , "[center]","[center]"));
        txtUsername = new JTextField();
        txtPassword = new JPasswordField();
        chRememberMe = new JCheckBox("Remember me");
        chRememberMe.putClientProperty(FlatClientProperties.STYLE,"" +
                "font:B Nazanin +1");
        cmdLogin = new JButton("Login");

        setBackground(new Color(176, 14, 14, 157));

        putClientProperty(FlatClientProperties.STYLE,"" +
                "arc:40;" +
                "[dark]background:lighten(@background,10%);" +
                "[light]background:darken(@background,10%);");

        JPanel panel = new JPanel(new MigLayout("wrap,fillx,insets 35 45 30 45","fill,250:280"));
        panel.putClientProperty(FlatClientProperties.STYLE,"" +
                "arc:50;" +
                "[light]background:darken(@background,3%);" +
                "[dark]background:lighten(@background,3%);");

        txtPassword.putClientProperty(FlatClientProperties.STYLE , "" +
                "showRevealButton:true;" +
                "font:B Nazanin;");


        cmdLogin.putClientProperty(FlatClientProperties.STYLE,"" +
                "[light]background:darken(@background,10%);" +
                "[dark]background:lighten(@background,10%);" +
                "borderWidth:0;" +
                "focusWidth:0;" +
                "innerFocusWidth:0");


        cmdLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        chRememberMe.setCursor(new Cursor(Cursor.HAND_CURSOR));

        txtUsername.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Enter your username or email");
        txtUsername.putClientProperty(FlatClientProperties.STYLE,"" +
                "font:B Nazanin +2");
        txtPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Enter your password");
        txtPassword.putClientProperty(FlatClientProperties.STYLE,"" +
                "font:B Nazanin +2");

        JLabel lbTitle = new JLabel("Welcome back!");
        JLabel description = new JLabel("please sign in to access yout account");
        lbTitle.putClientProperty(FlatClientProperties.STYLE , "" +
                "font:bold B Nazanin +10");
        description.putClientProperty( FlatClientProperties.STYLE , "" +
                "[light]foreground:lighten(@foreground,30%);" +
                "[dark]foreground:darken(@foreground,30%);" +
                "font:B Nazanin;");

        panel.add(lbTitle);
        panel.add(description);
        panel.add(new JLabel("Username"),"gapy 8");
        panel.add(txtUsername);
        panel.add(new JLabel("Password"),"gapy 8");
        panel.add(txtPassword);
        panel.add(chRememberMe,"grow 0");
        panel.add(cmdLogin,"gapy 10");
        panel.add(creatSignupLabel(),"gapy 10");
        add(panel);
    }

    private Component creatSignupLabel () {
        JPanel panel= new JPanel( new FlowLayout(FlowLayout.CENTER,0,0)) ;
        panel.putClientProperty(FlatClientProperties.STYLE,"" +
                "background:null");

        JButton cmdRegister = new JButton("<html><a href=\"#\">Sign up</a></html>");
        cmdRegister.putClientProperty(FlatClientProperties.STYLE,"" +
                "border:3,3,3,3");
        cmdRegister.setContentAreaFilled(false);
        cmdRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmdRegister.addActionListener(e -> {
            System.out.println("Go sing up form");
            new SignUp();
        });
        JLabel label = new JLabel("Don`t have an account ?");
        label.putClientProperty(FlatClientProperties.STYLE,"" +
                "[light]foreground:lighten(@foreground,30%);" +
                "[dark]foreground:darken(@foreground,30%)");
        panel.add(label);
        panel.add(cmdRegister);
        return panel ;
    }

    private JTextField txtUsername ;
    private JPasswordField txtPassword;
    private JCheckBox chRememberMe ;
    private JButton cmdLogin ;


//    public void init () {
//        Scanner input = new Scanner(System.in);
//        System.out.println("insert your position\n" +
//                "1) Student\n" +
//                "2) teacher\n" +
//                "3) manager");
//        int choice ;
//        while (true) {
//            choice = input.nextInt();
//            if (!(choice >= 1 && choice <= 3)) System.out.println("entered number is invalid please try again");
//            else break;
//        }
//        switch (choice) {
//            case 1 :
//                getInfo(UserRole.STUDENT);
//                break;
//            case 2 :
//                getInfo(UserRole.TEACHER);
//                break;
//            case 3 :
//                getInfo(UserRole.MANAGER);
//                break;
//        }
//    }

    private void getInfo (UserRole userRole) {
        int index = -1 ;
        int ID;
        Scanner input = new Scanner(System.in) ;
        if (userRole.userMode.equals( UserRole.STUDENT.userMode )) {
            System.out.println("Enter your student ID");
            while (true) {
                ID = input.nextInt();
                for (int i=0 ; i<Person.UserLength ; i++) {
                    if (Person.Users[i] instanceof Student) {
                        if (Person.Users[i].getEducationalID() == ID){
                            index = i ;
                            break;
                        }
                    }
                }
                if (index == -1) System.out.println("student ID not found, please search again");
                else break;
            }
        }
        else {
            System.out.println("Enter your educational ID");

            while (true) {
                ID = input.nextInt();
                for (int i=0 ; i<Person.UserLength ; i++) {
                    if (!(Person.Users[i] instanceof Student)) {
                        if (Person.Users[i].getEducationalID() == ID){
                            index = i ;
                            break;
                        }
                    }
                }
                if (index == -1) System.out.println("educational ID not found, please search again");
                else break;
            }
        }
        System.out.println("Enter your password ID");
        String password ;
        while (true) {
            password = input.next();
            if (password.equals(Person.Users[index].getPassword())) {
//                Person.Users[index].userPage ;
                break;
            }
            else System.out.println("password is wrong");
        }
    }
}
