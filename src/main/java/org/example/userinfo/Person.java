package org.example.userinfo;

import org.example.UserMode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person implements Serializable {
    public static ArrayList<Person> Users = new ArrayList<Person>() ;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String phoneNumber;
    private String password;
    private String repeatedPassword;
    private UserMode userMode ;

    public Person(String firstname, String lastname, String username, String email, String phoneNumber, UserMode userRole, String password, String repeatedPassword, int educationalID) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userMode = userRole;
        this.password = password;
        this.repeatedPassword = repeatedPassword;
        this.educationalID = educationalID;
    }

    private int educationalID ;

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
        Pattern pattern = Pattern.compile("09[0-9]{9}");
        Matcher matcher = pattern.matcher(phone) ;
        return matcher.find();
    }

    public void setPhoneNumber(String phoneNumber) {
        if( isPhoneValid(phoneNumber) )
            this.phoneNumber = phoneNumber;
        else
            System.out.println("Invalid phoneNumber");
    }

    public static boolean isEmailValid(String email) {
        final String regexEmail = "^[a-zA-Z0-9.]+@(?:[a-zA-Z-]+\\.)+.[a-z]{1,4}$";
        Pattern pattern = Pattern.compile(regexEmail);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void setEmail(String email) {
        if(isEmailValid(email))
            this.email = email;
    }

    public void addUser (Person user) {
        Users.addLast( user );

    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }

    public void setEducationalID(int educationalID) {
        this.educationalID = educationalID;
    }

    public String getFirstName(){
        return firstname;
    }
    public String getLastname(){
        return firstname;
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
    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public int getEducationalID() {
        return educationalID;
    }

    public UserMode getUserMode() {
        return userMode;
    }
}