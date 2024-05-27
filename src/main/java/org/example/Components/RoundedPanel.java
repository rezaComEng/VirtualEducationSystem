package org.example.Components;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedPanel extends JPanel {

    private int radius = 20 ;

    public void setRadius(int radius) {
        this.radius = radius;
        repaint();
    }

    public RoundedPanel(int radius) {
        this.radius = radius ;
    }

    public RoundedPanel () {
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(getBackground());
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fill( new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),radius ,radius));
        g2.dispose();
        super.paint(g);
    }
}
