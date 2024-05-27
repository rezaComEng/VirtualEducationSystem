package org.example.question;

import org.example.Exam;

import java.util.Date;

public class Question {

    private ExamMode mode ;
    private Date creationTime ;
    private Date responseTime ;
    private int score ;
    private int questionNumber ;
    private String questionText ;

    public Question(ExamMode mode, int score, int questionNumber, String questionText) {
        this.mode = mode;
        creationTime = new Date();
        this.score = score;
        this.questionNumber = questionNumber;
        this.questionText = questionText;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public int getScore() {
        return score;
    }

    public String getQuestionText() {
        return questionText;
    }

    public ExamMode getMode() {
        return mode;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public Date getResponseTime() {
        return responseTime;
    }
}
