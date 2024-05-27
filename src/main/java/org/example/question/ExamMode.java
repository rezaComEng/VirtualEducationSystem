package org.example.question;

public enum ExamMode {
    TrueFalse ("True False"),Descriptive("Descriptive"),Test("Test");
    private final String mode ;
    private ExamMode (String mode) {
        this.mode = mode ;
    }
    public String getMode() {
        return mode;
    }
}
