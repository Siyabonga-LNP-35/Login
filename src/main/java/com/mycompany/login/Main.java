/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.login;

import java.util.Scanner;
/**
 *
 * @author RC_Student_lab
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
          Scanner sc = new Scanner(System.in);
            
        // Registration of the user and Prompt user for information
        System.out.println("Enter your first name:");
        String firstName = sc.nextLine();
        
        System.out.println("Enter your last name:");
        String lastName = sc.nextLine();
        
        System.out.println("Enter your username (must contain an underscore and be no more than 5 characters):");
        String username = sc.nextLine();
        
        System.out.println("Enter your password (must be at least 8 characters, contain a capital letter, a number, and a special character):");
        String password = sc.nextLine();
        
        Login user = new Login(firstName, lastName, username, password);
        
        String registrationMessage = user.registerUser();
        System.out.println(registrationMessage);
        
        if (registrationMessage.equals("Username and password successfully captured.")) {
            // know the user can Login
            System.out.println("Enter your username to log in:");
            String enteredUsername = sc.nextLine();
            
            System.out.println("Enter your password:");
            String enteredPassword = sc.nextLine();
            //user successfully loggedIn
            boolean isLoggedIn = user.loginUser(enteredUsername, enteredPassword);
            System.out.println(user.returnLoginStatus(isLoggedIn));
              
          }
        
    }
    
}