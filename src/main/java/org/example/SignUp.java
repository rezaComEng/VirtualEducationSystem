package org.example;


import com.formdev.flatlaf.FlatClientProperties;
import net.miginfocom.swing.MigLayout;
import org.intellij.lang.annotations.JdkConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class SignUp extends JPanel {

    public SignUp () {
        init();
    }

    private void init () {
        setSize(800,500);
        setLayout( new MigLayout("fill,insets 20" , "[center]","[center]"));

        createUserModePane();
        createTitlePane();

        JPanel mainPane = new JPanel();
        mainPane.putClientProperty(FlatClientProperties.STYLE,"" +
                "arc:50;" +
                "[light]background:darken(@background,3%);" +
                "[dark]background:lighten(@background,3%);");
        mainPane.setLayout( new MigLayout("wrap,insets 30 45 30 45","fill,250:280","[center]"));

        txtUsername= new JTextField();
        txtPassword = new JPasswordField();
        txtPassword.setPreferredSize(new Dimension(400,20));
        txtUsername.setPreferredSize(new Dimension(400,20));

        txtUsername.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Enter your username or email");
        txtUsername.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON,true);
        txtPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Enter your password");
        txtPassword.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON,true);
        txtPassword.putClientProperty(FlatClientProperties.STYLE , "" +
                "showRevealButton:true;" +
                "font:B Nazanin;");

        singUpButton= new JButton("SING UP");

        singUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buttonGroup.getSelection() != null) {
                    for (int i = 0; i < 3; i++) {
                        if (userMode[i].isSelected()) {
                            if (i==0) {
                                Person.Users[Person.UserLength++] = new Student(txtUsername.getText(),String.copyValueOf(txtPassword.getPassword()),UserRole.STUDENT,213121);
                                System.out.println(Person.Users[Person.UserLength-1].getPassword());
                            } else if (i==2) {
                                Person.Users[Person.UserLength++] = new Teacher();
                                System.out.println(Person.Users[Person.UserLength-1].getPassword());
                                System.out.println("okey");
                            }
                        }
                    }
                }
            }
        });


        mainPane.add(titlePane,"align center");

        mainPane.add( new JLabel("username"),"grow 0");
        mainPane.add( txtUsername ,"grow 0" );

        mainPane.add( new JLabel("password"),"gapy 10");
        mainPane.add( txtPassword ,"grow 0");
        mainPane.add(userModePane,"align center");

        mainPane.add(singUpButton);

        add(mainPane);
    }

    private JButton singUpButton ;

    JRadioButton[] userMode = new JRadioButton[3];
    private ButtonGroup buttonGroup ;
    private JPanel userModePane ;
    private JPanel titlePane ;
    private JTextField txtUsername ;
    private JPasswordField txtPassword ;
    private void createTitlePane () {
        titlePane = new JPanel(new MigLayout("wrap","center","center"));
        titlePane.setOpaque(false);

        JLabel txt1 = new JLabel("Sign Up Form") ;
        txt1.putClientProperty(FlatClientProperties.STYLE,"" +
                "font:B Nazanin +10;");

        JLabel txt2 = new JLabel("Make the most of your professional life") ;
        txt1.putClientProperty(FlatClientProperties.STYLE,"" +
                "font:bold +2;");
        titlePane.add(txt1);
        titlePane.add(txt2);
    }

    private void createUserModePane () {

        userMode[0] = new JRadioButton("Student");
        userMode[1] = new JRadioButton("Teacher");
        userMode[2] = new JRadioButton("Manager");

        buttonGroup = new ButtonGroup();

        buttonGroup.add(userMode[0]);
        buttonGroup.add(userMode[1]);
        buttonGroup.add(userMode[2]);

        userModePane = new JPanel();

        userModePane.setOpaque(false);
        userModePane.setLayout( new MigLayout("wrap3"));
        userModePane.add(new JLabel("chose youe mode"),"alignx center,wrap,span 3 1");
        userModePane.add(userMode[0]);
        userModePane.add(userMode[1]);
        userModePane.add(userMode[2]);
    }



//    private void init () {
//        Scanner input = new Scanner(System.in);
//        System.out.println("insert your position\n" +
//                "1) Student\n" +
//                "2) teacher\n" +
//                "3) manager");
//        int choice ;
//        while (true) {
//            choice = input.nextInt();
//            if ( !(choice>=1 && choice<=3) ) System.out.println("entered number is invalid please try again");
//            else break;
//        }
//        switch (choice) {
//            case 1 :
//                Person.Users[Person.UserLength++] = new Student();
//                break;
//            case 2 :
//                Person.Users[Person.UserLength++] = new Teacher();
//                break;
//            case 3 :
//                Person.Users[Person.UserLength++] = new Manager();
//                break;
//        }
//    }

}
