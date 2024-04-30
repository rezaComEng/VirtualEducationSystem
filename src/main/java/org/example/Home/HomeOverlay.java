package org.example.Home;

import com.formdev.flatlaf.FlatClientProperties;
import net.miginfocom.layout.AC;
import net.miginfocom.swing.MigLayout;
import org.example.Login;
import org.example.SignUp;
import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.base.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeOverlay extends JPanel {

    private MediaPlayerFactory playerFactory ;
    private EmbeddedMediaPlayer player ;
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

    public void initOverlay(JFrame frame) {

        player.overlay().set(new WindowOverlay(frame));

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

        public WindowOverlay (JFrame frame) {
            super(frame);
            init () ;
        }

        private void init () {
            setBackground(new Color(192, 24, 24,50));
            setLayout(new BorderLayout());

            add(new Panel());
        }
    }
    private class Panel extends JPanel {

        private Login loginPanel = new Login();

        public Panel (){
            init();
        }

        private void init () {
            setOpaque(false);
            setLayout(new MigLayout("fill,insets 10 100 10 100","fill","[grow 0][]"));
            header();
            description();
        }

        private void header () {
            JPanel header = new JPanel();
            header.setLayout( new MigLayout("fill","[]push[][]"));
            header.setOpaque(false);

            JLabel title = new JLabel("virtual education system");
            title.putClientProperty(FlatClientProperties.STYLE,"" +
                    "font:bold +15");

            JButton login = new JButton("Login");
            JButton signUp = new JButton("SignUp");
            JButton home = new JButton("Home");
            JButton back = new JButton("Back");
            login.setCursor(new Cursor(Cursor.HAND_CURSOR));
            login.setBackground(new Color(0x57C594));
            login.setForeground(new Color(1));
            signUp.setCursor(new Cursor(Cursor.HAND_CURSOR));
            signUp.setBackground(new Color(0x57C594));
            signUp.setForeground(new Color(1));
            home.setCursor(new Cursor(Cursor.HAND_CURSOR));
            home.setBackground(new Color(0x57C594));
            home.setForeground(new Color(1));
            back.setCursor(new Cursor(Cursor.HAND_CURSOR));
            back.setBackground(new Color(0x57C594));
            back.setForeground(new Color(1));

            header.add(title,"push");

            header.add(login);
            header.add(signUp);
            header.add(home);
            header.add(back);

            signUp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new SignUp();
                }
            });
            login.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    add(loginPanel);
                    revalidate();
                }
            });
            add(header,"wrap,span 2 1");
        }

        private void description  () {
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
            add(panel,"width 50%!");
        }
    }

}
