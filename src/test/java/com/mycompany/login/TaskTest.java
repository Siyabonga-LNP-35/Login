/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.login;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class TaskTest {
    private Task task;

    @BeforeEach
    public void setUp() {
        task = new Task("Login", "Implement login feature", "DevOne", 8, 1, "To Do");
    }

    @Test
    public void testValidTaskDescription() {
        // Validate correct description length
        assertTrue(task.checkTaskDescription());
    }

    @Test
    public void testInvalidTaskDescription() {
        // Validate incorrect description length
        Task invalidTask = new Task("Feature", "This description is way too long and should fail validation", "DevTwo", 6, 2, "Doing");
        assertFalse(invalidTask.checkTaskDescription());
    }

    @Test
   public String generateTaskID(String taskName, String developer, int taskNumber) {
    return taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + developer.substring(developer.length() - 3).toUpperCase();
}

    @Test
    public void testTaskStatus() {
        // Validate task status
        assertEquals("To Do", task.getStatus());
    }
}