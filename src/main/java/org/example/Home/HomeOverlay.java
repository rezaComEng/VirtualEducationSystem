package org.example.Home;

import com.formdev.flatlaf.FlatClientProperties;
import net.miginfocom.layout.AC;
import net.miginfocom.swing.MigLayout;
import org.example.ClockPane;
import org.example.Login;
import org.example.Main;
import org.example.SignUp;
import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.base.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;

public class HomeOverlay extends JPanel {

    public SignUp signupPanel = new SignUp();

    public HomePanel homePanel = new HomePanel();
    public MediaPlayerFactory playerFactory ;
    public EmbeddedMediaPlayer player ;
    public WindowOverlay windowOverlay ;
    public HomeOverlay () {
        init ();
    }

    private void init () {

        playerFactory = new MediaPlayerFactory();

        player = playerFactory.mediaPlayers().newEmbeddedMediaPlayer();
        Canvas canvas = new Canvas();
        player.videoSurface().set(playerFactory.videoSurfaces().newVideoSurface(canvas));
        player.events().addMediaPlayerEventListener(new MediaPlayerEventAdapter() {
            @Override
            public void timeChanged(MediaPlayer mediaPlayer, long l) {
                if ( l >= mediaPlayer.status().length() - 1000 ) {
                    mediaPlayer.controls().setPosition(0);
                }
            }
        });

        player.audio().setMute(true);


        setLayout(new BorderLayout());
        add(canvas);
    }

    public void initOverlay() {

        windowOverlay = new WindowOverlay();

        player.overlay().set(windowOverlay);

        player.overlay().enable(true);
    }

    public void play () {
        if (player.status().isPlaying())
            player.controls().stop();

        player.media().play("video\\1.mp4");
        player.controls().play();
    }

    public void stop () {
        player.controls().stop();
        player.release();
        playerFactory.release();
    }

    private class WindowOverlay extends JWindow {

        public WindowOverlay () {
            super(Main.mainFrame);
            init () ;
        }

        private void init () {
            setBackground(new Color(192, 24, 24,50));
            setLayout(new BorderLayout());

            add(homePanel);
        }
    }
    public class HomePanel extends JPanel {

        private Login loginPanel = new Login();

        public Login getLoginPanel() {
            return loginPanel;
        }

        private JPanel header = header();

        public JPanel getHeader() {
            return header;
        }

        private JPanel description = description();

        public JPanel getDescription() {
            return description;
        }

        public HomePanel (){
            init();
        }

        private void init () {
            setOpaque(false);
            setLayout(new MigLayout("fill,insets 10 100 10 100","fill","[grow 0][]"));
            addHomePage();
        }

        public void addHomePage () {
            removeAll();
            add(header,"wrap,span 2 1");
            add(description,"width 50%!");
            repaint();
        }

        public void addLoginPage () {
            removeAll();
            add(header,"wrap,span 2 1");
            add(description,"width 50%!");
            add(loginPanel,"cell 1 1");
            repaint();
        }

        public void addSignupPage () {
            removeAll();
            add(header,"wrap,span 2 1");
            add(description,"width 50%!");
            add(signupPanel,"cell 1 1");
            repaint();
        }

        private JPanel header () {
            JPanel header = new JPanel();
            header.setLayout( new MigLayout("fill","[][]push[][]"));
            header.setOpaque(false);

            JLabel title = new JLabel("virtual education system");
            title.putClientProperty(FlatClientProperties.STYLE,"" +
                    "font:bold +15");

            JButton loginBtn = new JButton("Login");
            JButton signUpBtn = new JButton("SignUp");
            JButton homeBtn = new JButton("Home");
            JButton backBtn = new JButton("Back");
            loginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            loginBtn.setBackground(new Color(0x57C594));
            loginBtn.setForeground(new Color(1));
            signUpBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            signUpBtn.setBackground(new Color(0x57C594));
            signUpBtn.setForeground(new Color(1));
            homeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            homeBtn.setBackground(new Color(0x57C594));
            homeBtn.setForeground(new Color(1));
            backBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            backBtn.setBackground(new Color(0x57C594));
            backBtn.setForeground(new Color(1));

            header.add(title);

            header.add( new ClockPane() ,"push");

            header.add(loginBtn);
            header.add(signUpBtn);
            header.add(homeBtn);
            header.add(backBtn);

            homeBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    homePanel.addHomePage();
                }
            });

            signUpBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean sw = false ;
                    for (Component component : homePanel.getComponents())
                        if (component.equals(signupPanel) ){
                            addHomePage();
                            sw = true;
                        }
                    if (!sw)
                        addSignupPage();
                    homePanel.revalidate();
                    homePanel.repaint();
                }
            });
            loginBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean sw = false ;
                    for (Component component : homePanel.getComponents())
                        if ( component.equals(loginPanel) ){
                            addHomePage();
                            sw = true;
                        }
                    if (!sw)
                        addLoginPage();
                    homePanel.revalidate();
                    homePanel.repaint();
                }
            });

            return header;
        }

        private JPanel description  () {
            JPanel panel = new JPanel();
            panel.setOpaque(false);

            panel.setLayout( new MigLayout("wrap","","[]30[]"));
            JTextPane description = new JTextPane();
            description.putClientProperty(FlatClientProperties.STYLE,"" +
                    "font:bold +2;" +
                    "border: 0,0,0,0");
            JScrollPane scrollBar = new JScrollPane(description);
            description.setBackground(new Color(104, 88, 95, 79));
            description.setEnabled(false);
            description.setText("Virtual education university sites are online " +
                    "\nplatforms that offer a wide range of courses and " +
                    "\nprograms that can be accessed remotely. These " +
                    "\nsites typically provide interactive learning " +
                    "\nmaterials, virtual classrooms, and opportunities for " +
                    "\nstudents to connect with instructors and peers.");

            panel.add(description);
            return panel ;
        }


    }

}
