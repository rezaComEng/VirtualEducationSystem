package org.example;

public enum UserRole {
    STUDENT ("student"),
    TEACHER ("teacher"),
    MANAGER ("manager");

    private String userMode ;
    UserRole(String userMode) {
        this.userMode =  userMode ;
    }

    public String getUserMode() {
        return userMode;
    }
}
