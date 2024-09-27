/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.login;

import com.mycompany.login.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class LoginTest {
    
    public LoginTest() {
    }
// Testing valid usernames
    @Test
    public void testCheckUserName_Valid() {
        Login login = new Login("Siya", "Mk", "siya_", "Password123!");
        assertTrue(login.checkUserName(), "Username should be valid with 5 characters and an underscore");
    }
    // Testing invalid username (missing underscore)
    @Test
    public void testCheckUserName_MissingUnderscore() {
        Login login = new Login("Siya", "Mk", "siya1", "Password123!");
        assertFalse(login.checkUserName(), "Username should be invalid if missing an underscore");
    }
    // Testing invalid username (too long)
    @Test
    public void testCheckUserName_TooLong() {
        Login login = new Login("Siya", "Mk", "siyalong", "Password123!");
        assertFalse(login.checkUserName(), "Username should be invalid if longer than 5 characters");
    }
    
    // Testing valid password complexity
    @Test
    public void testCheckPasswordComplexity_Valid() {
        Login login = new Login("Siya", "Mk", "siya_", "Password123!");
        assertTrue(login.checkPasswordComplexity(), "Password should be valid");
    }
    // Testing invalid password (missing special character)
    @Test
    public void testCheckPasswordComplexity_MissingSpecialChar() {
        Login login = new Login("Siya", "Mk", "siya_", "Password123");
        assertFalse(login.checkPasswordComplexity(), "Password should be invalid without special character");
    }
    
     // Testing invalid password (missing capital letter)
    @Test
    public void testCheckPasswordComplexity_MissingCapitalLetter() {
        Login login = new Login("Siya", "Mk", "siya_", "password123!");
        assertFalse(login.checkPasswordComplexity(), "Password should be invalid without a capital letter");
    }
     // Testing invalid password (less than 8 characters)
    @Test
    public void testCheckPasswordComplexity_TooShort() {
        Login login = new Login("Siya", "Mk", "siya_", "Pas12!");
        assertFalse(login.checkPasswordComplexity(), "Password should be invalid if less than 8 characters");
    }
   
     // Testing registration with valid username and password
    @Test
    public void testRegisterUser_Valid() {
        Login login = new Login("Siya", "Mk", "siya_", "Password123!");
        assertEquals("Username and password successfully captured.", login.registerUser(), "Successful registration message mismatch");
    }
    // Testing registration with invalid username
    @Test
    public void testRegisterUser_InvalidUsername() {
        Login login = new Login("Siya", "Mk", "siyalong", "Password123!");
        assertEquals("Username is not correctly formatted, please ensure that the username contains an underscore and is no more than 5 characters in length.", login.registerUser());
    }
    // Testing registration with invalid password
    @Test
    public void testRegisterUser_InvalidPassword() {
        Login login = new Login("Siya", "Mk", "siya_", "password");
        assertEquals("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and special character.", login.registerUser());
    }
   
    // Testing successful login
    @Test
    public void testLoginUser_Success() {
        Login login = new Login("Siya", "Mk", "siya_", "Password123!");
        login.registerUser();
        assertTrue(login.loginUser("siya_", "Password123!"), "Login should succeed with correct credentials");
    }
   
     // Testing failed login (wrong username)
    @Test
    public void testLoginUser_InvalidUsername() {
        Login login = new Login("Siya", "Mk", "siya_", "Password123!");
        login.registerUser();
        assertFalse(login.loginUser("wrong_user", "Password123!"), "Login should fail with incorrect username");
    }
    // Testing failed login (wrong password)
    @Test
    public void testLoginUser_InvalidPassword() {
        Login login = new Login("Siya", "Mk", "siya_", "Password123!");
        login.registerUser();
        assertFalse(login.loginUser("siya_", "WrongPassword"), "Login should fail with incorrect password");
    }
}
