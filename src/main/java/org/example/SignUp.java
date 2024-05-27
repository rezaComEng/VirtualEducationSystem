package org.example;


import com.formdev.flatlaf.FlatClientProperties;
import net.miginfocom.swing.MigLayout;
import org.example.userinfo.Manager;
import org.example.userinfo.Person;
import org.example.userinfo.Student;
import org.example.userinfo.Teacher;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;

public final class SignUp extends JPanel {

    private JButton singUpButton ;
    private JRadioButton[] userModeBtns = new JRadioButton[3];
    private ButtonGroup buttonGroup ;
    private JPanel userModePane ;
    private JPanel titlePane ;

    private JTextField name ;
    private JTextField lastName ;

    private JTextField email ;
    private JTextField repass ;

    private JTextField id ;

    private JTextField phoneNum ;

    private UserMode userMode ;

    private int changePage ;
    private JPanel mainPane ;

    public SignUp () {
        init();
    }

    private void init () {
        setSize(800,500);
        setLayout( new MigLayout("fillx,insets 20" , "[center]","[center]"));

        createUserModePane();
        createTitlePane();

        mainPane = new JPanel();
        mainPane.putClientProperty(FlatClientProperties.STYLE,"" +
                "arc:50;" +
                "[light]background:darken(@background,3%);" +
                "[dark]background:lighten(@background,3%);");
        mainPane.setLayout( new MigLayout("wrap,insets 30 45 30 45","fill,250:280","[center]"));


        createComponents();

        addComponents(changePage);

        add(mainPane);
    }

    private void createComponents () {
        txtUsername= new JTextField();
        txtUsername.setPreferredSize(new Dimension(400,20));
        txtUsername.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Enter your username") ;
        txtUsername.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON,true) ;

        txtPassword = new JPasswordField();
        txtPassword.setPreferredSize(new Dimension(400,20));
        txtPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Enter your password") ;
        txtPassword.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON,true) ;
        txtPassword.putClientProperty(FlatClientProperties.STYLE , "" +
                "showRevealButton:true;" +
                "font:B Nazanin;");

        name = new JTextField();
        name.setPreferredSize(new Dimension(400,20));
        name.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Enter your name");
        name.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON,true);

        lastName = new JTextField();
        lastName.setPreferredSize(new Dimension(400,20));
        lastName.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Enter your lastname");
        lastName.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON,true) ;

        email = new JTextField();
        email.setPreferredSize(new Dimension(400,20));
        email.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Enter your Email");
        email.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON,true) ;

        phoneNum = new JTextField();
        phoneNum.setPreferredSize(new Dimension(400,20));
        phoneNum.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Enter your Phone Number");
        phoneNum.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON,true) ;

        repass = new JTextField();
        repass.setPreferredSize(new Dimension(400,20));
        repass.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Enter your password again");
        repass.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON,true) ;

        id = new JTextField();
        id.setPreferredSize(new Dimension(400,20));
        id.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Enter your educationalID");
        id.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON,true) ;


        singUpButton= new JButton("submit");

        singUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ObjectOutputStream user ;
                try {
                    user = new ObjectOutputStream(new FileOutputStream("user.bin",true));
                    if (changePage == 0 ) {
                        if (checkSubmit(changePage))
                            addComponents( ++changePage );
                    } else if (changePage == 1) {
                        if (checkSubmit(changePage))
                            addComponents( ++changePage );
                    } else if (changePage == 2) {
                        if (checkSubmit(changePage)){
                            System.out.println(userMode.getUserMode());
                            if ( userMode.getUserMode().equals("student")){
                                Person.Users.addLast(new Student(name.getText(), lastName.getText(), txtUsername.getText(),
                                        email.getText(), phoneNum.getText() , String.valueOf(txtPassword.getPassword()), String.valueOf(txtPassword.getPassword()), Integer.parseInt(id.getText())) ) ;
                                user.writeObject(Person.Users.getLast());
                            }
                            if ( userMode.getUserMode().equals("teacher"))
                                Person.Users.addLast( new Teacher(name.getText(), lastName.getText(), txtUsername.getText(),
                                        email.getText(), phoneNum.getText() , String.valueOf(txtPassword.getPassword()), String.valueOf(txtPassword.getPassword()), Integer.parseInt(id.getText())) ) ;
                            user.writeObject(Person.Users.getLast());
                            if ( userMode.getUserMode().equals("manager"))
                                Person.Users.addLast( new Manager(name.getText(), lastName.getText(), txtUsername.getText(),
                                        email.getText(), phoneNum.getText() , String.valueOf(txtPassword.getPassword()), String.valueOf(txtPassword.getPassword()), Integer.parseInt(id.getText())) ) ;
                            user.writeObject(Person.Users.getLast());

                        }
                        EventQueue.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                new UserFrame(Person.Users.getLast()).setVisible(true);
                            }
                        });
                        Main.mainFrame.setVisible(false);

                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }

    private boolean checkSubmit (int changePage) {
        boolean sw = true ;
        if (changePage == 0) {
            if (Person.isWordValid(name.getText())) {
                if (name.getBorder() != null)
                    name.setBorder( new LineBorder( Color.GREEN ));
            } else {
                name.setBorder( new LineBorder( Color.RED ));
                sw = false ;
            }
            if (Person.isWordValid(lastName.getText())) {
                if (lastName.getBorder() != null)
                    lastName.setBorder( new LineBorder( Color.GREEN ));
            } else {
                lastName.setBorder( new LineBorder( Color.RED ));
                sw = false ;
            }
        }
        else if ( changePage == 1 ) {
            if ( Person.isUserValid(txtUsername.getText())) {
                if (txtUsername.getBorder() != null)
                    txtUsername.setBorder( new LineBorder( Color.GREEN ));
            } else {
                txtUsername.setBorder( new LineBorder( Color.RED ));
                sw = false ;
            }
            if ( Person.isEmailValid(email.getText())) {
                if (email.getBorder() != null )
                    email.setBorder( new LineBorder(Color.GREEN));
            } else {
                email.setBorder(new LineBorder(Color.RED));
                sw = false ;
            }
            if (buttonGroup.getSelection() != null) {
                if (userModePane.getBorder() != null)
                    userModePane.setBorder( new LineBorder(Color.GREEN));
            } else {
                userModePane.setBorder( new LineBorder(Color.RED));
                sw = false ;
            }
        } else if (changePage == 2) {
            if (Person.isPhoneValid(phoneNum.getText())) {
                if (phoneNum.getBorder() != null)
                    phoneNum.setBorder( new LineBorder( Color.GREEN ));
            } else {
                phoneNum.setBorder( new LineBorder( Color.RED ));
                sw = false ;
            }
            if (Person.isPassValid(String.valueOf(txtPassword.getPassword()))) {
                if (txtPassword.getBorder() != null)
                    txtPassword.setBorder( new LineBorder( Color.GREEN ));
            } else {
                txtPassword.setBorder( new LineBorder( Color.RED ));
                sw = false ;
            }
            if ( repass.getText().equals(String.valueOf(txtPassword.getPassword()))) {
                if (txtPassword.getBorder() != null)
                    txtPassword.setBorder( new LineBorder( Color.GREEN ));
            } else {
                txtPassword.setBorder( new LineBorder( Color.RED ));
                sw = false ;
            }
            if ( !id.getText().isEmpty() ) {
                if (id.getBorder() != null)
                    id.setBorder( new LineBorder( Color.GREEN ));
            } else {
                id.setBorder( new LineBorder( Color.RED ));
                sw = false ;
            }
        }
        return sw ;
    }

    private void addComponents (int changePage) {
        if (changePage == 0) {
            mainPane.removeAll();

            mainPane.add(titlePane,"align center");

            mainPane.add( new JLabel("name"),"grow 0");
            mainPane.add( name ,"grow 0" );

            mainPane.add( new JLabel("lastname"),"grow 0");
            mainPane.add( lastName ,"grow 0" );

            mainPane.add(singUpButton,"gapy 20");
        } else if (changePage == 1) {
            mainPane.removeAll();

            mainPane.add(titlePane,"align center");

            mainPane.add( new JLabel("username"),"grow 0");
            mainPane.add( txtUsername ,"grow 0" );

            mainPane.add( new JLabel("Email"),"gapy 10");
            mainPane.add( email ,"grow 0");

            mainPane.add(userModePane,"align center");

            mainPane.add(singUpButton,"gapy 20");
        } else if (changePage == 2) {
            mainPane.removeAll();

            mainPane.add(titlePane,"align center");

            mainPane.add( new JLabel("Phone number"),"grow 0");
            mainPane.add( phoneNum ,"grow 0" );

            mainPane.add( new JLabel("password"),"grow 0");
            mainPane.add( txtPassword ,"grow 0" );

            mainPane.add( new JLabel("repass"),"grow 0");
            mainPane.add( repass ,"grow 0" );

            mainPane.add( new JLabel("educationalID"),"grow 0");
            mainPane.add( id ,"grow 0" );

            mainPane.add(singUpButton,"gapy 20");
        }
    }


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

        userModeBtns[0] = new JRadioButton("Student");
        userModeBtns[1] = new JRadioButton("Teacher");
        userModeBtns[2] = new JRadioButton("Manager");


        buttonGroup = new ButtonGroup();

        buttonGroup.add(userModeBtns[0]);
        buttonGroup.add(userModeBtns[1]);
        buttonGroup.add(userModeBtns[2]);

        userModeBtns[0].addActionListener(e -> {
            userMode = UserMode.STUDENT ;
        });
        userModeBtns[1].addActionListener( e -> {
            userMode = UserMode.TEACHER ;
        });
        userModeBtns[2].addActionListener( e -> {
            userMode = UserMode.MANAGER ;
        });

        userModePane = new JPanel();

        userModePane.setOpaque(false);
        userModePane.setLayout( new MigLayout("wrap3"));
        userModePane.add(new JLabel("chose youe mode"),"alignx center,wrap,span 3 1");
        userModePane.add(userModeBtns[0]);
        userModePane.add(userModeBtns[1]);
        userModePane.add(userModeBtns[2]);
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
