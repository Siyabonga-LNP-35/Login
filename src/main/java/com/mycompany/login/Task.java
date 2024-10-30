/*
 * Class to represent a Task with details like name, developer, duration, and status.
 */

package com.mycompany.login;

/**
 * Represents a task with relevant details and functionality.
 * Author: RC_Student_lab
 */
public class Task {
    private String taskName;          // Name of the task
    String taskDescription;           // Description of the task
    private String developerDetails;   // Name of the developer
    private int taskDuration;          // Duration of the task in hours
    private String taskID;             // Unique ID for the task
    private String taskStatus;         // Status of the task (e.g., To Do, Doing, Done)
    private static int taskCounter = 0; // Counter to keep track of task numbers

    // Constructor to initialize a new task
    public Task(String taskName, String taskDescription, String developerDetails, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskID = createTaskID(taskName, taskCounter++, developerDetails); // Generate task ID
    }

    /**
     * Checks if the task description is 50 characters or less.
     */
    public boolean checkTaskDescription(String description) {
        return description.length() <= 50;
    }

    /**
     * Creates a unique task ID using the task name, task number, and developer details.
     */
    public String createTaskID(String taskName, int taskNumber, String developer) {
        return taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + developer.substring(developer.length() - 3).toUpperCase();
    }

    /**
     * Displays task details in a dialog box.
     */
    public void printTaskDetails() {
        String details = "Task Status: " + taskStatus + "\n" +
                         "Developer: " + developerDetails + "\n" +
                         "Task Number: " + (taskCounter - 1) + "\n" +
                         "Task Name: " + taskName + "\n" +
                         "Description: " + taskDescription + "\n" +
                         "Task ID: " + taskID + "\n" +
                         "Duration: " + taskDuration + " hours";
        javax.swing.JOptionPane.showMessageDialog(null, details);
    }

    /**
     * Gets the duration of the task in hours.
     */
    public int getTaskDuration() {
        return taskDuration;
    }
}

