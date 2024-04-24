package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {

    public UserPage userPage ;
    public static Person[] Users = new Person[100] ;
    public static int UserLength ;
    private String firstname;
    private String lastname;
    private String username;
    private String fieldOfStudy;
    private String email;
    private String phoneNumber;
    private String position;
    private String password;
    private String repeatedPassword;
    private UserRole userRole ;

    private int educationalID ;

    public Person() {
        makePerson();
    }

    public void makePerson () {
        Scanner input = new Scanner(System.in);
        System.out.println("enter your firstname :");
        String firstname ;
        String lastname ;
        String username ;
        String filedOfStudy ;
        String email ;
        String phoneNumber ;
        String password ;
        String repeatedPassword ;
        while (true) {
            firstname = input.next();
            if ( isWordValid(firstname) ) {
                this.firstname = firstname ;
                break;
            }
            else System.out.println("The firstname entered is invalid, try again");
        }
        System.out.println("enter your lastname :");
        while (true) {
            lastname = input.next();
            if ( isWordValid(lastname) ) {
                this.lastname= lastname ;
                break;
            }
            else System.out.println("The lastname entered is invalid, try again");
        }
        System.out.println("enter your username :");
        while (true) {
            username = input.next();
            if ( isUserValid(username) ) {
                this.username = username ;
                break;
            }
            else System.out.println("The username entered is invalid, try again");
        }
        System.out.println("enter your field of study :");
        while (true) {
            filedOfStudy = input.next();
            if ( isWordValid(filedOfStudy) ) {
                this.fieldOfStudy = filedOfStudy ;
                break;
            }
            else System.out.println("The filedOfStudy entered is invalid, try again");
        }
        System.out.println("enter your email :");
        while (true) {
            email = input.next();
            if ( isEmailValid(email) ) {
                this.email = email ;
                break;
            }
            else System.out.println("The email entered is invalid, try again");
        }
        System.out.println("enter your phone number :");
        while (true) {
            phoneNumber = input.next();
            if ( isPhoneValid(phoneNumber) ) {
                this.phoneNumber = phoneNumber ;
                break;
            }
            else System.out.println("The phone number entered is invalid, try again");
        }
        System.out.println("enter your password :");
        while (true) {
            password = input.next();
            if ( isPassValid(password) ) {
                this.password= password ;
                break;
            }
            else System.out.println("The password entered is invalid, try again");
        }
        System.out.println("repeat your password :");
        while (true) {
            repeatedPassword = input.next();
            if ( password.equals(repeatedPassword) ) {
                this.repeatedPassword = repeatedPassword ;
                break;
            }
            else System.out.println("The repeated password is not the same, try again");
        }
    }

    public static boolean isWordValid (String word) {
        Pattern pattern = Pattern.compile("^[a-zA-Z]{1,18}$");
        Matcher matcher = pattern.matcher(word);
        return matcher.find() ;
    }

    public void setFirstName(String firstname){
        if( isWordValid(firstname) )
            this.firstname = firstname;
        else
            System.out.println("Invalid firstname");
    }

    public void setLastName(String lastname){
        if( isWordValid( lastname) )
            this.lastname = lastname;
        else
            System.out.println("Invalid lastname");

    }

    public void setFieldOfStudy(String fieldOfStudy){
        if(isWordValid( fieldOfStudy ))
            this.fieldOfStudy = fieldOfStudy;
        else
            System.out.println("Invalid fieldOfStudy");

    }

    public static boolean isPassValid (String word) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{8,12}$");
        Matcher matcher = pattern.matcher(word);
        return matcher.find() ;
    }

    public void setPassword(String password) {
        if( isPassValid( password ) )
            this.password = password;
        else
            System.out.println("Invalid password");
    }

    public static boolean isUserValid (String word) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{5,12}$");
        Matcher matcher = pattern.matcher(word);
        return matcher.find() ;
    }

    public void setUsername(String username) {
        if( isUserValid( username ) )
            this.username = username;
        else
            System.out.println("Invalid username");
    }

    public static boolean isPhoneValid (String phone) {
        Pattern pattern = Pattern.compile("[0-9]{11}");
        Matcher matcher = pattern.matcher(phone) ;
        return matcher.find();
    }

    public void setPhoneNumber(String phoneNumber) {
        if( isPhoneValid(phoneNumber) )
            this.phoneNumber = phoneNumber;
        else
            System.out.println("Invalid phonenumber");
    }

    public static boolean isEmailValid(String email) {
        final String regexEmail = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z-]+\\.)+.[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regexEmail);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void setEmail(String email) {
        if(isEmailValid(email))
            this.email = email;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }

    public void setEducationalID(int educationalID) {
        this.educationalID = educationalID;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public String getFirstName(){
        return firstname;
    }
    public String getLastname(){
        return firstname;
    }
    public String getFieldOfStudy(){
        return fieldOfStudy;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public String getPosition() {
        return position;
    }
    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public int getEducationalID() {
        return educationalID;
    }
}