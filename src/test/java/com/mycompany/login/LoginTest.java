/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.login;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    private Login login = new Login();

    @Test
    public void testValidUsername() {
        assertTrue(login.checkUserName("user_")); // Valid username
    }

    @Test
    public void testInvalidUsername() {
        assertFalse(login.checkUserName("user")); // Missing underscore
        assertFalse(login.checkUserName("user__name")); // Too long
    }

    @Test
    public void testValidPassword() {
        assertTrue(login.checkPasswordComplexity("Passw0rd!")); // Valid password
    }

    @Test
    public void testInvalidPassword() {
        assertFalse(login.checkPasswordComplexity("password")); // No uppercase, digit, or special character
        assertFalse(login.checkPasswordComplexity("Password1")); // Missing special character
    }

    @Test
    public void testSuccessfulLogin() {
        // Simulate user registration
        login.username = "user_"; // Set valid username directly
        login.password = "Passw0rd!"; // Set valid password directly

        // Simulate successful login
        assertTrue(login.loginUser());
    }

    @Test
    public void testFailedLogin() {
        // Simulate user registration
        login.username = "user_"; // Set valid username directly
        login.password = "Passw0rd!"; // Set valid password directly

        // Simulate failed login
        login.username = "wrong_user";
        assertFalse(login.loginUser());
    }
}
