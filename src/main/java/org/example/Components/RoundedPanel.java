package org.example.Components;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.util.Animator;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedPanel extends JPanel {

    Animator animator = new Animator(500);

    {
        setOpaque(false);
        animator.setResolution(5);
        animator.addTarget(new Animator.TimingTarget() {
            @Override
            public void timingEvent(float v) {
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(getBackground());
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fill( new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),20 ,20));
        g2.dispose();
        super.paint(g);
    }
}
