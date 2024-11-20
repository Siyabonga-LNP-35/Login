/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login;
import javax.swing.*;

/**
 * Represents a task with relevant details and functionality.
 * Author: RC_Student_lab
 */

public class Login {
    private String username;
    private String password;
   

    /**
     * Prompts the user to register by entering a username, password, first name, and last name.
     * Validates the username and password according to the specified requirements.
     * @return true if the registration is successful; false otherwise.
     */
    public boolean registerUser() {
        // promt user for first name
        
        // Prompt user for username
        username = JOptionPane.showInputDialog("Enter username (must contain '_' and be no longer than 5 characters):");
        // Prompt user for password
        password = JOptionPane.showInputDialog("Enter password (8 characters, 1 uppercase, 1 number, 1 special character):");

        if (!checkUserName(username)) {
            JOptionPane.showMessageDialog(null, "Username is not correctly formatted.");
            return false;
        }

        if (!checkPasswordComplexity(password)) {
            JOptionPane.showMessageDialog(null, "Password is not correctly formatted.");
            return false;
        }

        JOptionPane.showMessageDialog(null, "User registered successfully!");
        return true;
    }

    /**
     * Prompts the user to log in by entering a username and password.
     * Checks if the entered credentials match the registered username and password.
     * @return true if login is successful; false otherwise.
     */
    public boolean loginUser() {
        // Prompt user for login credentials
        String inputUsername = JOptionPane.showInputDialog("Enter username:");
        String inputPassword = JOptionPane.showInputDialog("Enter password:");

        if (username.equals(inputUsername) && password.equals(inputPassword)) {
            JOptionPane.showMessageDialog(null, "Login successful!");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Username or password is incorrect.");
            return false;
        }
    }

    private boolean checkUserName(String username) {
        return username != null && username.contains("_") && username.length() <= 5;
    }

    private boolean checkPasswordComplexity(String password) {
        return password != null && password.length() >= 8 &&
               password.chars().anyMatch(Character::isUpperCase) &&
               password.chars().anyMatch(Character::isDigit) &&
               password.chars().anyMatch(ch -> "!@#$%^&*()".indexOf(ch) >= 0);
    }
}
