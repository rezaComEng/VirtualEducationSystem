package org.example.question;

public class TestQuestion extends Question {

    String[] optionsText = new String[4];

    private int correctAnswer ;

    public TestQuestion(int score, int questionNumber, String questionText, String[] optionsText, int correctAnswer) {
        super(ExamMode.Test, score, questionNumber, questionText);
        this.optionsText = optionsText;
        this.correctAnswer = correctAnswer;
    }
}
