package org.example;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import org.example.Home.Home;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        FlatMacDarkLaf.setup();
        new Home();
    }
}