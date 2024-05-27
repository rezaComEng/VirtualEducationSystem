package org.example.question;

public class DescriptiveQuestion extends Question {

    private String anser ;

    public DescriptiveQuestion(int score, int questionNumber, String questionText) {
        super(ExamMode.Descriptive, score, questionNumber, questionText);
    }
}
