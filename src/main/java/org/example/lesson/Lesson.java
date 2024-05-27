package org.example.lesson;

import org.example.Exam;
import org.example.userinfo.Student;
import org.example.userinfo.Teacher;

import java.util.ArrayList;

public class Lesson {
    public ArrayList<Teacher> teachers ;
    public ArrayList<Student> students ;
    public ArrayList<Exam> exams ;
    private String name ;
    private LessonType lessonType ;
    private int unitsNumber ;

    public void viewLessonInfo () {
        String info = "Lesson Name :" + name +
                "\nLesson Type :" + lessonType.name() +
                "\nUnits number :" + unitsNumber ;
        System.out.println(info);
    }

    public Lesson(String name, LessonType lessonType, int unitsNumber) {
        teachers = new ArrayList<Teacher>();
        students = new ArrayList<Student>();
        exams = new ArrayList<Exam>();
        this.name = name;
        this.lessonType = lessonType;
        this.unitsNumber = unitsNumber;
    }

    public String getName() {
        return name;
    }

    public int getUnitsNumber() {
        return unitsNumber;
    }

    public LessonType getLessonType() {
        return lessonType;
    }
}
