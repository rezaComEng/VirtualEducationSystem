package org.example;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Teacher extends Person{


    public Teacher(String email, String password, String repeatedPassword, UserRole userRole) {
        super(email, password, repeatedPassword, userRole);
        makeTeacher();
    }

    public Teacher(String username, String password, UserRole userRole) {
        super(username, password, userRole);
        makeTeacher();
    }

    public Teacher() {
        makeTeacher();
    }

    public void makeTeacher () {
        Scanner input = new Scanner(System.in);
        System.out.println("enter your educationalID :");
        int educationalID ;
        while (true) {
            educationalID = input.nextInt();
            if ( String.valueOf(educationalID).length() == 6 ) {
                boolean isOkay = true;
                for (Person person : Person.Users) {
                    if (person instanceof Teacher) {
                        if (person.getEducationalID() == educationalID) isOkay = false ;
                    }
                }
                if (isOkay) {
                    setEducationalID(educationalID);
                    break;
                } else System.out.println("EducationalID has been used by another user, try again");
            }
            else System.out.println("The length of the educational ID must be 6, try again");
        }
        setUserRole(UserRole.TEACHER);
    }
}
