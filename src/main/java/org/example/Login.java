package org.example;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.ui.FlatBorder;
import com.formdev.flatlaf.util.Animator;
import com.formdev.flatlaf.util.UIScale;
import com.github.weisj.jsvg.nodes.Use;
import net.miginfocom.swing.MigLayout;
import org.example.Home.HomeOverlay;
import org.example.Home.MainFrame;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Scanner;

public class Login extends JPanel {

    private Animator animator ;

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

        userMode[0] = new JRadioButton("student");
        userMode[1] = new JRadioButton("teacher");
        userMode[2] = new JRadioButton("manager");

        buttonGroup = new ButtonGroup();

        buttonGroup.add(userMode[0]);
        buttonGroup.add(userMode[1]);
        buttonGroup.add(userMode[2]);


        putClientProperty(FlatClientProperties.STYLE,"" +
                "arc:40;" +
                "[dark]background:lighten(@background,10%);" +
                "[light]background:darken(@background,10%);");

        JPanel panel = new JPanel(new MigLayout("wrap,fillx,insets 35 45 30 45","fill,250:280"));
        panel.putClientProperty(FlatClientProperties.STYLE,"" +
                "arc:50;" +
                "[light]background:darken(@background,3%);" +
                "[dark]background:lighten(@background,3%);");


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
        txtUsername.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON,true);
        txtPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Enter your password");
        txtPassword.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON,true);
        txtPassword.putClientProperty(FlatClientProperties.STYLE , "" +
                "showRevealButton:true;" +
                "font:B Nazanin +2;");

        JLabel lbTitle = new JLabel("Welcome back!");
        JLabel description = new JLabel("please sign in to access yout account");
        lbTitle.putClientProperty(FlatClientProperties.STYLE , "" +
                "font:bold B Nazanin +10");
        description.putClientProperty( FlatClientProperties.STYLE , "" +
                "[light]foreground:lighten(@foreground,30%);" +
                "[dark]foreground:darken(@foreground,30%);" +
                "font:B Nazanin;");

        cmdLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (loginCheck()) {
                    MainFrame.homeOverlay.homePanel.remove(MainFrame.homeOverlay.homePanel.getLoginPanel());
                    MainFrame.homeOverlay.homePanel.remove(MainFrame.homeOverlay.homePanel.getDescription());
                    MainFrame.homeOverlay.homePanel.add(User.getUserPane());
                    MainFrame.homeOverlay.homePanel.repaint();
                }
            }
        });

        JPanel userQuestion = new JPanel();
        userQuestion.setOpaque(false);
        userQuestion.setLayout( new MigLayout("wrap3"));
        userQuestion.add(new JLabel("chose youe mode"),"alignx center,wrap,span 3 1");
        userQuestion.add(userMode[0]);
        userQuestion.add(userMode[1]);
        userQuestion.add(userMode[2]);

        panel.add(lbTitle);
        panel.add(description);
        panel.add(new JLabel("Username"),"gapy 8");
        panel.add(txtUsername);
        panel.add(new JLabel("Password"),"gapy 8");
        panel.add(txtPassword);

        panel.add(userQuestion,"gapy 8");
        panel.add(chRememberMe,"grow 0,gapy 8");
        panel.add(cmdLogin,"gapy 10");
        panel.add(creatSignupLabel(),"gapy 10");

        warningError = new JLabel();
        warningError.setVerticalTextPosition(SwingConstants.CENTER);
        warningError.setForeground(Color.RED);
        warningError.putClientProperty(FlatClientProperties.STYLE,"" +
                "font:B Nazanin bold +2");
        panel.add(warningError);
        add(panel);
    }

    JLabel warningError;

    private boolean loginCheck () {
        boolean result1 =false;
        int i;
        for ( i=0 ; i<Person.UserLength ; i++) {
            if ( Person.Users[i].getUsername().equals( txtUsername.getText() ) ) {
                result1 = true;
                break;
            }
        }
        if (result1) {
            if (String.valueOf(txtPassword.getPassword()).equals(Person.Users[i].getPassword())) {
                if (buttonGroup.getSelection()!=null ){
                    for (int j = 0; j < 3; j++) {
                        if (userMode[j].isSelected())
                            if (userMode[j].getText().equals(Person.Users[i].getUserRole().getUserMode())) {
                                User.getUserPane().userPerson = Person.Users[i];
                                return true;
                            }
                    }
                } else {
                    warningError.setText("inter your current Mode");
                }
            } else {
                System.out.println("2");
                warningError.setText("password is wrong");
            }
        } else {
            warningError.setText("This username does not exist");
        }
        return false;
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
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    MainFrame.homeOverlay.homePanel.addSignupPage();
                }
            });
        });
        JLabel label = new JLabel("Don`t have an account ?");
        label.putClientProperty(FlatClientProperties.STYLE,"" +
                "[light]foreground:lighten(@foreground,30%);" +
                "[dark]foreground:darken(@foreground,30%)");
        panel.add(label);
        panel.add(cmdRegister);
        return panel ;
    }


    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int arc = UIScale.scale(40);
        g2.setColor(getBackground());
        g2.setComposite(AlphaComposite.SrcOver.derive(0.6f));
        g2.fill( new RoundRectangle2D.Double(0,0,getWidth(),getHeight(), arc , arc));
        g2.dispose();

        super.paint(g);
    }
    ButtonGroup buttonGroup;

    private JRadioButton[] userMode = new JRadioButton[3];
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
        if (userRole.getUserMode().equals( UserRole.STUDENT.getUserMode() )) {
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
