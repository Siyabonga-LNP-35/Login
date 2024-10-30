/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login;

/**
 *
 * @author RC_Student_lab
 */
public class Login {
    private String storedUsername; // Registered username
    private String storedPassword; // Registered password
    private String firstName;      // User's first name
    private String lastName;       // User's last name

    // Default constructor
    public Login() {}
/**
     * Checks if the username is valid.
     * Username must contain an underscore and be 5 characters or less.
     */
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }
    /**
     * Checks if the password is strong.
     * Password must be at least 8 characters, with a capital letter, a number, and a special character.
     */

    public boolean checkPasswordComplexity(String password) {
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*\\d.*") &&
               password.matches(".*[!@#$%^&*].*");
    }
/**
     * Registers the user if the username and password are valid.
     * Stores the username, password, and user's first and last name.
     */
    public String registerUser(String username, String password, String firstName, String lastName) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted. Please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted. Please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.";
        }
        this.storedUsername = username;
        this.storedPassword = password;
        this.firstName = firstName;
        this.lastName = lastName;
        return "User successfully registered.";
    }
    /**
     * Checks if the entered username and password match the stored ones.
     */
    public boolean loginUser(String username, String password) {
        return username.equals(storedUsername) && password.equals(storedPassword);
    }
/**
     * Returns a welcome message if login is successful, otherwise an error message.
     */
    public String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
