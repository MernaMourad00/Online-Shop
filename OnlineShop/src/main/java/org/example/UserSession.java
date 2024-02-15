package org.example;

public class UserSession {
    private static UserSession instance;
    private int userId;

    private UserSession() {
        // Private constructor to prevent instantiation
    }

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public void loginUser(int userId) {
        this.userId = userId;
        // Other session initialization logic if needed
    }

    public boolean isLoggedIn() {
        return userId != 0; // Assuming 0 is an invalid user ID
    }

    public int getUserId() {
        return userId;
    }

    public void logoutUser() {
        userId = 0;
}

}
