/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login;

/**
 *
 * @author RC_Student_lab
 */
public class Login {
      //Declarations 
    
   private final String firstName;
   private final String lastName;
   private final String username;
   private final String password;
   
   // Prompt user for information
    public Login(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
    // Method to check the username format
    public boolean checkUserName() {
        return username.contains("_") && username.length() <= 5;
    }
    // Method to check password complexity
    public boolean checkPasswordComplexity() {
        boolean hasUpperCase = false, hasDigit = false, hasSpecialChar = false;
        if (password.length() >= 8) {
            for (char c : password.toCharArray()) {
                if (Character.isUpperCase(c)) hasUpperCase = true;
                if (Character.isDigit(c)) hasDigit = true;
                if (!Character.isLetterOrDigit(c)) hasSpecialChar = true;
            }
            return hasUpperCase && hasDigit && hasSpecialChar;
        }
        return false;
    }
     //Method to register user 
    
    public String  registerUser(){
        if (!checkUserName()){
            return "Username is not correctly formatted, please ensure that the usename contains an underscore and is no more than 5 characters in length.";         
        }else if (!checkPasswordComplexity()){
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and spercial character.";
        }
        return "Username and password successfully captured.";
    }
    
}



