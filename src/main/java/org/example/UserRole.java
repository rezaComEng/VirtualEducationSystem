package org.example;

public enum UserRole {
    STUDENT ("student"),
    TEACHER ("teacher"),
    MANAGER ("manager");

    public String userMode ;
    UserRole(String userMode) {
        this.userMode =  userMode ;
    }
}
