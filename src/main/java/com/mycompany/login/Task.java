/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;
/**
 *
 * @author RC_Student_lab
 */
public class Task {
    private String taskName;
    String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskID;
    private String taskStatus;
    private static int taskCounter = 0;

    // Constructor
    public Task(String taskName, String taskDescription, String developerDetails, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskID = createTaskID(taskName, taskCounter++, developerDetails);
    }

    public boolean checkTaskDescription(String description) {
        return description.length() <= 50;
    }

    public String createTaskID(String taskName, int taskNumber, String developer) {
        return taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + developer.substring(developer.length() - 3).toUpperCase();
    }

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

    public int getTaskDuration() {
        return taskDuration;
    }
}
