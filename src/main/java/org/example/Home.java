package org.example;

import java.util.Date;
import java.util.Scanner;

public class Home {

    public Home () {
        init () ;
    }

    private void init () {
        Ask();
    }

    public void Ask () {
        Scanner input = new Scanner(System.in);
        System.out.println("What do you want to do?" +
                "\n1) Login" +
                "\n2) Sing Up") ;
        int choice ;
        while (true) {
            choice = input.nextInt();
            if ( !(choice>=1 && choice<=2) ) System.out.println("entered number is invalid please try again");
            else break;
        }
        switch (choice) {
            case 1 :
                new Login() ;
                break ;
            case 2 :
                new SignUp() ;
        }
    }
}
