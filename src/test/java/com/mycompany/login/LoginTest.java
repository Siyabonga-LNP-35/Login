/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.login;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */


public class LoginTest {

    @Test
    public void testCheckUserName_Success() {
        // Valid username
        Login login = new Login();
        String username = "kyl_1";
        assertTrue(login.checkUserName(username), "Username with underscore and 5 characters should pass validation");
    }

    @Test
    public void testCheckUserName_Failure() {
        // Invalid username
        Login login = new Login();
        String username = "kyle!!!!!!";
        assertFalse(login.checkUserName(username), "Username without underscore or more than 5 characters should fail validation");
    }

    @Test
    public void testCheckPasswordComplexity_Success() {
        // Valid password
        Login login = new Login();
        String password = "Ch&&sec@ke99!";
        assertTrue(login.checkPasswordComplexity(password), "Password meeting all complexity requirements should pass validation");
    }

    @Test
    public void testCheckPasswordComplexity_Failure() {
        // Invalid password
        Login login = new Login();
        String password = "password";
        assertFalse(login.checkPasswordComplexity(password), "Password not meeting complexity requirements should fail validation");
    }

    @Test
    public void testRegisterUser_Success() {
        // Valid registration
        Login login = new Login();
        String result = login.registerUser("kyl_1", "Ch&&sec@ke99!", "Kyle", "Smith");
        assertEquals("User successfully registered.", result, "Valid registration should succeed");
    }

    @Test
    public void testRegisterUser_FailureUsername() {
        // Invalid username
        Login login = new Login();
        String result = login.registerUser("kyle!!!!!!", "Ch&&sec@ke99!", "Kyle", "Smith");
        assertEquals("Username is not correctly formatted. Please ensure that your username contains an underscore and is no more than 5 characters in length.", result, "Invalid username should return error message");
    }

    @Test
    public void testRegisterUser_FailurePassword() {
        // Invalid password
        Login login = new Login();
        String result = login.registerUser("kyl_1", "password", "Kyle", "Smith");
        assertEquals("Password is not correctly formatted. Please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.", result, "Invalid password should return error message");
    }

    @Test
    public void testReturnLoginStatus_Success() {
        // Successful login
        Login login = new Login();
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "Kyle", "Smith");
        String result = login.returnLoginStatus("kyl_1", "Ch&&sec@ke99!");
        assertEquals("Welcome Kyle Smith, it is great to see you again.", result, "Successful login should return welcome message");
    }

    @Test
    public void testReturnLoginStatus_Failure() {
        // Failed login
        Login login = new Login();
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "Kyle", "Smith");
        String result = login.returnLoginStatus("kyl_1", "wrongpass");
        assertEquals("Username or password incorrect, please try again.", result, "Failed login should return error message");
    }
}
