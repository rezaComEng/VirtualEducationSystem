package org.example;

public enum UserMode {
    STUDENT ("student"),
    TEACHER ("teacher"),
    MANAGER ("manager");

    private String userMode ;
    UserMode(String userMode) {
        this.userMode =  userMode ;
    }

    public String getUserMode() {
        return userMode;
    }
}
