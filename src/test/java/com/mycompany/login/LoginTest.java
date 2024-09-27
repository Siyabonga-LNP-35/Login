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
        Login login = new Login("Alice", "Smith", "user_", "Password123!");
        assertTrue(login.checkUserName(), "Username should be valid with 5 characters and an underscore");
    }
    // Testing invalid username (missing underscore)
    @Test
    public void testCheckUserName_MissingUnderscore() {
        Login login = new Login("Alice", "Smith", "user1", "Password123!");
        assertFalse(login.checkUserName(), "Username should be invalid if missing an underscore");
    }
    // Testing invalid username (too long)
    @Test
    public void testCheckUserName_TooLong() {
        Login login = new Login("Alice", "Smith", "userlong", "Password123!");
        assertFalse(login.checkUserName(), "Username should be invalid if longer than 5 characters");
    }
    
    // Testing valid password complexity
    @Test
    public void testCheckPasswordComplexity_Valid() {
        Login login = new Login("Alice", "Smith", "user_", "Password123!");
        assertTrue(login.checkPasswordComplexity(), "Password should be valid");
    }
    // Testing invalid password (missing special character)
    @Test
    public void testCheckPasswordComplexity_MissingSpecialChar() {
        Login login = new Login("Alice", "Smith", "user_", "Password123");
        assertFalse(login.checkPasswordComplexity(), "Password should be invalid without special character");
    }
    
     // Testing invalid password (missing capital letter)
    @Test
    public void testCheckPasswordComplexity_MissingCapitalLetter() {
        Login login = new Login("Alice", "Smith", "user_", "password123!");
        assertFalse(login.checkPasswordComplexity(), "Password should be invalid without a capital letter");
    }
}