package org.example;

import com.formdev.flatlaf.FlatClientProperties;
import net.miginfocom.swing.MigLayout;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class User {
    private static UserPane userPane = new UserPane() ;

    public static UserPane getUserPane() {
        return userPane;
    }

    private Person person ;


    public static class UserPane extends JPanel {

        public Person userPerson;

        public UserPane () {
            init();
        }

        private void init () {
            setPreferredSize(new Dimension(500,500));
            setLayout( new MigLayout("fill","[grow 0]","[grow 0][]"));
            setBackground(new Color(32, 155, 108, 50));

            add(initMenu());
        }

        private @NotNull JMenuBar initMenu () {
            JMenuBar menuBar = new JMenuBar();
            menuBar.setName("menu");


            menuBar.setSize(getWidth(),40);
            JMenuItem profileMenu = new JMenu("profile");
            JMenuItem lessonsMenu = new JMenu("Lessons");

            menuBar.add(profileMenu);
            menuBar.add(lessonsMenu);
            menuBar.setVisible(true);
            return menuBar ;
        }
    }

}
