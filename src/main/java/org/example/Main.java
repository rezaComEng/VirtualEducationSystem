package org.example;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import org.example.Home.MainFrame;
import org.example.question.Question;
import org.example.question.TrueFalseQuestion;

import java.awt.*;
import java.text.DateFormat;

public class Main {

    public static MainFrame mainFrame ;

    public static void main(String[] args) {
        Question q1 = new TrueFalseQuestion("Answer 1","Answer 2" ,10,1,"hello");
        System.out.println(DateFormat.getDateTimeInstance().format(q1.getCreationTime()));

        FlatMacDarkLaf.setup();

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                mainFrame = new MainFrame();
            }
        });
    }
}