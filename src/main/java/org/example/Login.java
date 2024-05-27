package org.example;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.util.Animator;
import com.formdev.flatlaf.util.UIScale;
import net.miginfocom.swing.MigLayout;
import org.example.Home.MainFrame;
import org.example.userinfo.Person;
import org.example.userinfo.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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

        userModeBtns[0] = new JRadioButton("student");
        userModeBtns[1] = new JRadioButton("teacher");
        userModeBtns[2] = new JRadioButton("manager");

        userModeBtns[0].addActionListener( e -> {
            userMode = UserMode.STUDENT ;
        });
        userModeBtns[1].addActionListener( e -> {
            userMode = UserMode.TEACHER ;
        });
        userModeBtns[2].addActionListener( e -> {
            userMode = UserMode.MANAGER ;
        });

        buttonGroup = new ButtonGroup();

        buttonGroup.add(userModeBtns[0]);
        buttonGroup.add(userModeBtns[1]);
        buttonGroup.add(userModeBtns[2]);


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
                    EventQueue.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new UserFrame(Person.Users.getLast()).setVisible(true);
                        }
                    });
                    Main.mainFrame.setVisible(false);
                }
            }
        });

        JPanel userQuestion = new JPanel();
        userQuestion.setOpaque(false);
        userQuestion.setLayout( new MigLayout("wrap3"));
        userQuestion.add(new JLabel("chose youe mode"),"alignx center,wrap,span 3 1");
        userQuestion.add(userModeBtns[0]);
        userQuestion.add(userModeBtns[1]);
        userQuestion.add(userModeBtns[2]);

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
        ObjectInputStream userFile = null ;
        try {
            userFile = new ObjectInputStream(new FileInputStream("user.bin"));
            Object user  = null ;
            while ( true ) {
                user = userFile.readObject() ;
                if ( user == null ) break ;

                if ( user instanceof Person ) {
                    user = ( Person ) user ;
                    Person.Users.add((Person) user);
                }


            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException();
        } finally {
            try {
                userFile.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        boolean result1 =false;
        Person p = null ;
        for (Person person : Person.Users) {
            if ( person.getUsername().equals( txtUsername.getText() ) ) {
                p = person ;
                result1 = true;
                break;
            }
        }
        if (result1) {
            if (String.valueOf(txtPassword.getPassword()).equals(p.getPassword())) {
                if ( buttonGroup.getSelection() != null ){
                    if ( userMode.getUserMode().equals(p.getUserMode().getUserMode()))
                        return true ;
                } else {
                    warningError.setText("inter your current Mode");
                }
            } else {
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
    private JRadioButton[] userModeBtns = new JRadioButton[3];
    private UserMode userMode ;
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

//    private void getInfo (UserRole userRole) {
//        int index = -1 ;
//        int ID;
//        Scanner input = new Scanner(System.in) ;
//        if (userRole.getUserMode().equals( UserRole.STUDENT.getUserMode() )) {
//            System.out.println("Enter your student ID");
//            while (true) {
//                ID = input.nextInt();
//                for (int i=0 ; i<Person.UserLength ; i++) {
//                    if (Person.Users[i] instanceof Student) {
//                        if (Person.Users[i].getEducationalID() == ID){
//                            index = i ;
//                            break;
//                        }
//                    }
//                }
//                if (index == -1) System.out.println("student ID not found, please search again");
//                else break;
//            }
//        }
//        else {
//            System.out.println("Enter your educational ID");
//
//            while (true) {
//                ID = input.nextInt();
//                for (int i=0 ; i<Person.UserLength ; i++) {
//                    if (!(Person.Users[i] instanceof Student)) {
//                        if (Person.Users[i].getEducationalID() == ID){
//                            index = i ;
//                            break;
//                        }
//                    }
//                }
//                if (index == -1) System.out.println("educational ID not found, please search again");
//                else break;
//            }
//        }
//        System.out.println("Enter your password ID");
//        String password ;
//        while (true) {
//            password = input.next();
//            if (password.equals(Person.Users[index].getPassword())) {
////                Person.Users[index].userPage ;
//                break;
//            }
//            else System.out.println("password is wrong");
//        }
//    }
}
