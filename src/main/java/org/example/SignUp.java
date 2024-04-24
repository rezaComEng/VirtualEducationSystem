package org.example;

import java.util.Scanner;

public class SignUp {

    public SignUp () {
        init();
    }

    private void init () {
        Scanner input = new Scanner(System.in);
        System.out.println("insert your position\n" +
                "1) Student\n" +
                "2) teacher\n" +
                "3) manager");
        int choice ;
        while (true) {
            choice = input.nextInt();
            if ( !(choice>=1 && choice<=3) ) System.out.println("entered number is invalid please try again");
            else break;
        }
        switch (choice) {
            case 1 :
                Person.Users[Person.UserLength++] = new Student();
                break;
            case 2 :
                Person.Users[Person.UserLength++] = new Teacher();
                break;
            case 3 :
                Person.Users[Person.UserLength++] = new Manager();
                break;
        }
    }

}
