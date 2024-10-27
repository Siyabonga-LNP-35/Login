/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.login;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

/**
 *
 * @author RC_Student_lab
 */
public class TaskTest {
    
    public TaskTest() {
    }
    


    @Test
    public void testTaskDescriptionLength() {
        // Success case: Task description under 50 characters
        Task task1 = new Task("Login Feature", "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
        assertTrue(task1.checkTaskDescription(task1.taskDescription), "Description within 50 characters should succeed");

        // Failure case: Task description over 50 characters
        Task task2 = new Task("Add Task Feature", "This description is intentionally made too long to test if the validation works as expected by exceeding 50 characters", "Mike Smith", 10, "Doing");
        assertFalse(task2.checkTaskDescription(task2.taskDescription), "Description over 50 characters should fail");
    }

    @Test
    public void testTaskDescriptionMessage() {
        Task task1 = new Task("Login Feature", "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");

        if (task1.checkTaskDescription(task1.taskDescription)) {
            assertEquals("Task successfully captured", "Task successfully captured");
        } else {
            assertEquals("Please enter a task description of less than 50 characters", "Please enter a task description of less than 50 characters");
        }
    }

    @Test
    public void testTaskIDFormat() {
        // Expected format: First 2 letters of task name, task number, last 3 letters of developer name
        Task task1 = new Task("Login Feature", "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
        assertEquals("LO:0:SON", task1.createTaskID("Login Feature", 0, "Robyn Harrison"), "TaskID format for task 1");

        Task task2 = new Task("Add Task Feature", "Create Add Task feature to add task users", "Mike Smith", 10, "Doing");
        assertEquals("AD:1:ITH", task2.createTaskID("Add Task Feature", 1, "Mike Smith"), "TaskID format for task 2");
    }

    @Test
    public void testTotalHoursAccumulation() {
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Login Feature", "Create Login to authenticate users", "Robyn Harrison", 8, "To Do"));
        tasks.add(new Task("Add Task Feature", "Create Add Task feature to add task users", "Mike Smith", 10, "Doing"));

        int totalHours = tasks.stream().mapToInt(Task::getTaskDuration).sum();
        assertEquals(18, totalHours, "Total hours should be 18");

        // Additional data test with 5 tasks of durations 10, 12, 55, 11, and 1
        ArrayList<Task> additionalTasks = new ArrayList<>();
        additionalTasks.add(new Task("Task1", "Description1", "Dev1", 10, "To Do"));
        additionalTasks.add(new Task("Task2", "Description2", "Dev2", 12, "To Do"));
        additionalTasks.add(new Task("Task3", "Description3", "Dev3", 55, "To Do"));
        additionalTasks.add(new Task("Task4", "Description4", "Dev4", 11, "To Do"));
        additionalTasks.add(new Task("Task5", "Description5", "Dev5", 1, "To Do"));

        int totalAdditionalHours = additionalTasks.stream().mapToInt(Task::getTaskDuration).sum();
        assertEquals(89, totalAdditionalHours, "Total hours for additional data should be 89");
    }
}
