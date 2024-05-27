package org.example.userinfo;

import org.example.Exam;
import org.example.InvalidIDException;
import org.example.UserMode;
import org.example.lesson.Lesson;
import org.example.question.Question;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student extends Person {
    public ArrayList<Question> quizzes = new ArrayList<Question>() ;
    public ArrayList<Lesson> lessons = new ArrayList<Lesson>();
    private int studentID ;

    public Student(String firstname, String lastname, String username, String email, String phoneNumber, String password, String repeatedPassword, int educationalID) {
        super(firstname, lastname, username, email, phoneNumber, UserMode.STUDENT , password, repeatedPassword, educationalID);
    }

    public static enum FiledOfStudy {
        computerEngineering ("computerEngineering"),
        metallurgicalEngineering ("MetallurgicalEngineering") ,
        chemicalEngineering ( "chemicalEngineering") ,
        civilEngineering ( "civilEngineering" ) ,
        ArchitecturalEngineering ( "ArchitecturalEngineering");

        private String filedOfStudy ;

        public String getFiledOfStudy() {
            return filedOfStudy;
        }

        private FiledOfStudy (String filedOfStudy) {
            this.filedOfStudy = filedOfStudy ;
        }

    }

    private FiledOfStudy fieldOfStudy;

    public void setFieldOfStudy(FiledOfStudy fieldOfStudy) {
        if(isWordValid( fieldOfStudy.getFiledOfStudy() ))
            this.fieldOfStudy = fieldOfStudy;
        else
            System.out.println("Invalid fieldOfStudy");
    }



    private void setStudentID(int studentID) {

        Pattern pattern = Pattern.compile("^[0-9]{10}$");
        Matcher matcher = pattern.matcher(String.valueOf(studentID));

        if (matcher.find())
            this.studentID=studentID;
        else
            throw new InvalidIDException("invalid format : " + studentID );
    }


}   
