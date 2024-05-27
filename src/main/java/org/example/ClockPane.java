package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;

public class ClockPane extends JPanel {
    private JLabel clock ;
    private Date date ;

    public Date getDate() {
        return date;
    }

    public ClockPane() {
        setOpaque(false);
        setLayout(new BorderLayout());
        clock = new JLabel();
        clock.setHorizontalAlignment(JLabel.CENTER);
        clock.setFont(UIManager.getFont("Label.font").deriveFont(Font.BOLD, 10f));
        tickTock();
        add(clock);

        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tickTock();
            }
        });

        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.setInitialDelay(0);
        timer.start();
    }
    public void tickTock() {
        date = new Date();
        clock.setText(DateFormat.getDateTimeInstance().format(date));
    }
}
