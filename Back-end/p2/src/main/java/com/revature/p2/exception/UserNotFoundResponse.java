package com.revature.p2.exception;

public class UserNotFoundResponse {
    private String userNotFound;

    public UserNotFoundResponse(String userNotFound) {
        this.userNotFound = userNotFound;
    }

    public String getUserNotFound() {
        return userNotFound;
    }

    public void setUserNotFound(String userNotFound) {
        this.userNotFound = userNotFound;
    }
}
