package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student extends Person {
    private int studentID ;

    public Student() {
        super();
        makeStudent();
    }

    public void makeStudent () {
        Scanner input = new Scanner(System.in);
        System.out.println("enter your educationalID :");
        int educationalID ;
        while (true) {
            educationalID = input.nextInt();
            if ( String.valueOf(educationalID).length() == 10 ) {
                boolean isOkay = true;
                for (Person person : Person.Users) {
                    if (person instanceof Student) {
                        if (person.getEducationalID() == educationalID) isOkay = false ;
                    }
                }
                if (isOkay) {
                    setEducationalID(educationalID);
                    studentID = educationalID ;
                    break;
                } else System.out.println("EducationalID has been used by another user, try again");
            }
            else System.out.println("The length of the educational ID must be 10, try again");
        }
        setUserRole(UserRole.STUDENT);
    }

}   
