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
    }
}
