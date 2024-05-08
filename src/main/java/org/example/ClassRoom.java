package org.example;

public class ClassRoom {
    private String title;
    private static Teacher teacherOfClass;
    private static Student[] students= new Student[100];
    private static int numberOfStudents=0;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static void setTeacherOfClass(Teacher teacherOfClass) {
        ClassRoom.teacherOfClass = teacherOfClass;
    }

    public static Teacher getTeacherOfClass() {
        return teacherOfClass;
    }

    public static void addStudent(Student student){
        students[numberOfStudents++]=student;
    }


}
