package org.example.userinfo;

import org.example.UserMode;
import org.example.lesson.Lesson;
import org.example.question.Question;

import java.util.ArrayList;
import java.util.Scanner;

public class Teacher extends Person{

    public ArrayList<Question> quizzes = new ArrayList<Question>();
    public ArrayList<Lesson> lessons = new ArrayList<Lesson>();

    public Teacher(String firstname, String lastname, String username, String email, String phoneNumber, String password, String repeatedPassword, int educationalID) {
        super(firstname, lastname, username, email, phoneNumber, UserMode.TEACHER, password, repeatedPassword, educationalID);
    }
//    public void addLesson (Lesson newLesson) {
//        lessons.addLast(new Lesson() );
//    }

    public void removeLesson (Lesson extraLesson) {
        lessons.removeIf( lesson -> lesson.equals(extraLesson)) ;
    }

    public void addQuiz (Question question) {
        quizzes.addLast(question);
    }

    public void removeQuiz (Question extraQuiz) {
        quizzes.removeIf( question -> question.equals(extraQuiz) );
    }

}
