package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {

    public static Person[] Users = new Person[100] ;
    public static int UserLength ;
    private String firstname;
    private String lastname;
    private String username;
    private String fieldOfStudy;
    private int educationalID;
    private String email;
    private String phoneNumber;
    private String position;
    private String password;
    private String repeatedPassword;

    public void Ask(){
        System.out.println("Do you have an account(login) or you want to sign up?");
        Scanner input = new Scanner(System.in);
        String answer = input.next();
        if(answer.equals("login")){
            System.out.println("Insert your Eductional ID");
            int ID = input.nextInt() ;
//            if(isIDvalid(ID)){
//
//            }

        }
    }

    private boolean checkIsWord (char word) {
        if ( (word >= 'a' && word<='z') || (word >= 'A' && word<='Z') )
            return true ;
        else return false ;
    }

    public void setFirstName(String firstname){
        int i;
        for(i = 0; firstname.length() < 19 && i < firstname.length() ;i ++){
            if( !checkIsWord( firstname.charAt(i) ) )
                break;
        }
        if(i == firstname.length())
            this.firstname = firstname;
        else 
            System.out.println("Invalid firstname");
    }
    public String getFirstName(){
        return firstname;
    }

    public void setLastName(String lastname){
        int i;
        for(i = 0;lastname.length() < 19 && i < lastname.length();i ++){
            if(!checkIsWord( lastname.charAt(i) )){
                break;
            }
        }
        if(i == lastname.length())
            this.lastname = lastname;
        else 
            System.out.println("Invalid lastname");

    }
    public String getLastname(){
        return firstname;
    }

    public void setFieldOfStudy(String fieldOfStudy){
        int i;
        for(i = 0;fieldOfStudy.length() < 19 && i < fieldOfStudy.length();i ++){
            if( !checkIsWord( fieldOfStudy.charAt(i) ) ){
                break;
            }
        }
        if(i == fieldOfStudy.length())
            this.fieldOfStudy = fieldOfStudy;
        else
            System.out.println("Invalid fieldOfStudy");

    }
    public String getFieldOfStudy(){
        return fieldOfStudy;
    }

    public void setUsername(String username) {
        int i;
        for(i = 0;username.length() > 4 && username.length() < 13 && i < username.length();i ++){
            if( !checkIsWord( username.charAt(i) ) || (username.charAt(i) >= '0' && username.charAt(i) <= '9') ){
                break;
            }
        }
        if(i == username.length())
            this.username = username;
        else 
            System.out.println("Invalid username");
    }
    public String getUsername(){
        return username;
    }

    public void setPassword(String password) {
        int i;
        for(i = 0; password.length() > 7 && password.length() < 13 && i < password.length() ;i ++){
            if( !checkIsWord( password.charAt(i) ) || (password.charAt(i) >= '0' && password.charAt(i) <= '9')){
                break;
            }
        }
        if(i == password.length())
            this.password = password;
        else 
            System.out.println("Invalid password");
    }
    public String getPassword(){
        return password;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber.length() == 11 && phoneNumber.startsWith("09"))
            this.phoneNumber = phoneNumber;
        else
            System.out.println("Invalid phonenumber");
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(isEmailValid(email))
            this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }
    public static boolean isEmailValid(String email) {
        final String regexEmail = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA_Z0-9_+&*-]+)*@(?:[a-zA-Z-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regexEmail);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}