package org.example;

import java.util.Scanner;

public class Utils {

    public void UserPanel () {
        Scanner input = new Scanner(System.in);
        System.out.println("What do you want to do?");
        System.out.println("1) Login");
        System.out.println("2) Sing Up");

        int choice ;
        do {
            choice = input.nextInt();
            if ( !(choice>=1 && choice<=2) ) System.out.println("entered number is invalid please try again");
        } while (choice>=1 && choice<=2);
    }

}
