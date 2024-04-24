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
        while (true) {
            choice = input.nextInt();
            if (!(choice >= 1 && choice <= 3)) System.out.println("entered number is invalid please try again");
            else break;
        }
        switch (choice) {
            case 1 :
                getInfo(UserRole.STUDENT);
                break;
            case 2 :
                getInfo(UserRole.TEACHER);
                break;
            case 3 :
                getInfo(UserRole.MANAGER);
                break;
        }
    }

    private void getInfo (UserRole userRole) {
        int index = -1 ;
        int ID;
        Scanner input = new Scanner(System.in) ;
        if (userRole.userMode.equals( UserRole.STUDENT.userMode )) {
            System.out.println("Enter your student ID");
            while (true) {
                ID = input.nextInt();
                for (int i=0 ; i<Person.UserLength ; i++) {
                    if (Person.Users[i] instanceof Student) {
                        if (Person.Users[i].getEducationalID() == ID){
                            index = i ;
                            break;
                        }
                    }
                }
                if (index == -1) System.out.println("student ID not found, please search again");
                else break;
            }
        }
        else {
            System.out.println("Enter your educational ID");

            while (true) {
                ID = input.nextInt();
                for (int i=0 ; i<Person.UserLength ; i++) {
                    if (!(Person.Users[i] instanceof Student)) {
                        if (Person.Users[i].getEducationalID() == ID){
                            index = i ;
                            break;
                        }
                    }
                }
                if (index == -1) System.out.println("educational ID not found, please search again");
                else break;
            }
        }
        System.out.println("Enter your password ID");
        String password ;
        while (true) {
            password = input.next();
            if (password.equals(Person.Users[index].getPassword())) {
//                Person.Users[index].userPage ;
                break;
            }
            else System.out.println("password is wrong");
        }
    }
}
