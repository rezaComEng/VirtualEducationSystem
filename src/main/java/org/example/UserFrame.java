package org.example;

import net.miginfocom.swing.MigLayout;
import org.example.Components.RoundedPanel;
import org.example.userinfo.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserFrame extends JFrame {
    private Person user ;
    RoundedPanel menuPanel = new RoundedPanel();
    JScrollPane panel2 = new JScrollPane();

    RoundedPanel header = new RoundedPanel();

    public UserFrame (Person user) {
        this.user = user ;
        init();
    }

    private void init () {
        setTitle("user page");
        setSize(1000,600);
        setLocationRelativeTo(null);
        setLayout( null );
        setUndecorated(true);

        createHeader();

        createMenu();


        panel2.add(new JLabel());
        panel2.setBounds(menuPanel.getWidth() + menuPanel.getX() + 10 , menuPanel.getY() ,
                getWidth() - 30 - menuPanel.getWidth() ,getHeight() - header.getHeight() - 30 );



        panel2.setBackground( new Color(49, 44, 44, 244));

        add(header);
        add(menuPanel);
        add(panel2);
    }
    
    private void createMenu () {
        menuPanel.setLayout( new MigLayout("wrap,fillx"));
        menuPanel.setBounds(10 ,header.getHeight() + 20 ,150,getHeight() - header.getHeight() - 30);
        menuPanel.add(new JLabel("menu"), "alignx center");

        menuPanel.setBackground( new Color(49, 44, 44, 244));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout( new MigLayout("wrap"));
        menuBar.setBackground( new Color(49, 44, 44, 244));

        JMenu educationalMenu = new JMenu("educational");

        JButton addStudent = new JButton("addStudent");

        JButton exercises = new JButton("exercises");
        JButton exams = new JButton("exams (Quizzes)");
        JButton homeWorks = new JButton("home works");

        exercises.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                educationalMenu.setPopupMenuVisible(false);
            }
        });
        exams.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                educationalMenu.setPopupMenuVisible(false);
                panel2.add(new UserFrame(user));
                repaint();
            }
        });

        addStudent.addActionListener( e -> {
            panel2.removeAll();
            panel2.setBackground( new Color(152, 47, 47));

            panel2.add ( new addStudent()) ;
        });


        educationalMenu.add(exercises);
        educationalMenu.add(exams);
        educationalMenu.add(homeWorks);

        menuBar.add(educationalMenu);
        menuBar.add(addStudent) ;

        menuPanel.add(menuBar,"alignx center");
    }

    private class addStudent extends JPanel {


        public addStudent ( ) {
            init();
        }

        private void init () {
            setSize(panel2.getSize());
            setLayout( new MigLayout("fillx , alignx center"));
            JLabel nameLbl = new JLabel("name" );
            nameLbl.setSize(30,100);
            add ( nameLbl );
            JTextField namefield = new JTextField();
            namefield.setBackground( new Color(215, 191, 191));
            namefield.setSize(30,100);
            add( namefield , " wrap");

            JLabel lastnameLbl = new JLabel("lastname" );
            lastnameLbl.setSize(30,100);
            add ( lastnameLbl );
            JTextField lastnamefield = new JTextField();
            lastnamefield.setSize(30,100);
            add( lastnamefield , " wrap");

            JLabel IDLbl = new JLabel("student Id" );
            IDLbl.setSize(30,100);
            add ( IDLbl );
            JTextField IdField = new JTextField();
            IDLbl.setSize(30,100);
            add( IdField , " wrap");
        }
    }

    private void createHeader () {
        header.setBounds(10,10,getWidth()-20,50);
        header.setBackground( new Color(0, 1, 1, 107));

        header.setLayout( new MigLayout("fill","[][][]","center"));

        JButton menu = new JButton() ;
        Image menuIcon = new ImageIcon("icons\\menu-icon.png").getImage().getScaledInstance(30,30,1);
        menu.setIcon( new ImageIcon( menuIcon) ) ;
        menu.addActionListener( e -> {
            if (menuPanel.getWidth() == 150) {
                menuPanel.setSize(0, menuPanel.getHeight());
                panel2.setBounds(menuPanel.getWidth() + menuPanel.getX()  , menuPanel.getY() ,
                        getWidth() - 20 - menuPanel.getWidth() ,getHeight() - header.getHeight() - 30 );
            } else {
                menuPanel.setSize(150, menuPanel.getHeight());
                panel2.setBounds(menuPanel.getWidth() + menuPanel.getX() + 10 , menuPanel.getY() ,
                        getWidth() - 30 - menuPanel.getWidth() ,getHeight() - header.getHeight() - 30 );
            }
        });

        JButton alarm = new JButton() ;
        Image alarmIcon = new ImageIcon("icons\\alarm-icon.png").getImage().getScaledInstance(30,30,1);
        alarm.setIcon( new ImageIcon( alarmIcon ) ) ;

        JButton exit = new JButton() ;
        Image exitIcon = new ImageIcon("icons\\exit-icon.png").getImage().getScaledInstance(30,30,1);
        exit.setIcon( new ImageIcon( exitIcon ) ) ;
        exit.addActionListener( e -> {
            System.exit(0);
        });

        header.add(menu,"push");
        header.add(alarm);
        header.add(exit);
    }

    private class QuizPanel extends JScrollPane {

        public QuizPanel () {
            init();
        }

        private  void init () {
            setSize(panel2.getSize());
        }
    }

}
