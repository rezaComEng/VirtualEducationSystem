package org.example.userinfo;


import org.example.UserMode;

import java.util.Scanner;

public class Manager extends Person{


    public Manager(String firstname, String lastname, String username, String email, String phoneNumber,String password, String repeatedPassword, int educationalID) {
        super(firstname, lastname, username, email, phoneNumber, UserMode.MANAGER, password, repeatedPassword, educationalID);
    }

//    public void makeManager () {
//        Scanner input = new Scanner(System.in);
//        System.out.println("enter your educationalID :");
//        int educationalID ;
//        while (true) {
//            educationalID = input.nextInt();
//            if ( String.valueOf(educationalID).length() == 4 ) {
//                boolean isOkay = true;
//                for (Person person : Person.Users) {
//                    if (person instanceof Manager) {
//                        if (person.getEducationalID() == educationalID) isOkay = false ;
//                    }
//                }
//                if (isOkay) {
//                    setEducationalID(educationalID);
//                    break;
//                } else System.out.println("EducationalID has been used by another user, try again");
//            }
//            else System.out.println("The length of the educational ID must be 4, try again");
//        }
//        setUserRole(UserRole.MANAGER);
//    }
}
