package org.example.question;

import org.example.Exam;

public class TrueFalseQuestion extends Question {
    private String correctAnswer ;
    private String wrongAnswer ;

    public TrueFalseQuestion(String correctAnswer, String wrongAnswer , int score, int questionNumber, String questionText) {
        super(ExamMode.TrueFalse , score, questionNumber, questionText);
        this.correctAnswer = correctAnswer;
        this.wrongAnswer = wrongAnswer;
    }
}
