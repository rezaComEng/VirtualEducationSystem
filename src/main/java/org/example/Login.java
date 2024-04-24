package org.example;

import java.util.Scanner;

public class Login {



    public Login () {
        init();

    }

    public void init () {
        Scanner input = new Scanner(System.in);
        System.out.println("insert your position\n" +
                "1) Student\n" +
                "2) teacher\n" +
                "3) manager");
        int choice ;
        do {
            choice = input.nextInt();
            if ( !(choice>=1 && choice<=3) ) System.out.println("entered number is invalid please try again");
        } while (choice>=1 && choice<=3) ;

    }
}
