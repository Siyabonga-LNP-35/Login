/*
 * Class to represent a Task with details like name, developer, duration, and status.
 */

package com.mycompany.login;
import com.mycompany.login.Task;
/**
 * Represents a task with relevant details and functionality.
 * Author: RC_Student_lab
 */
public class Task {
    private String taskName;
    private String taskDescription;
    private String developer;
    private int duration;
    private String taskID;
    private String status;

    /**
     * Constructor for the Task class.
     * Generates a task ID based on task name, developer name, and task number.
     * @param taskName the name of the task.
     * @param taskDescription a brief description of the task.
     * @param developer the developer assigned to the task.
     * @param duration the estimated duration of the task in hours.
     * @param taskNumber the unique number assigned to the task.
     * @param status the current status of the task.
     */
    public Task(String taskName, String taskDescription, String developer, int duration, int taskNumber, String status) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developer = developer;
        this.duration = duration;
        this.status = status;
        this.taskID = generateTaskID(taskName, developer, taskNumber);
    }

    /**
     * Generates a unique Task ID using the task name, task number, and developer name.
     * @param taskName the name of the task.
     * @param developer the developer assigned to the task.
     * @param taskNumber the unique number assigned to the task.
     * @return a unique Task ID.
     */
    private String generateTaskID(String taskName, String developer, int taskNumber) {
        return taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + developer.substring(developer.length() - 3).toUpperCase();
    }

    // Getters for task properties
    public String getDeveloper() {
        return developer;
    }

    public String getTaskName() {
        return taskName;
    }

    public int getDuration() {
        return duration;
    }

    public String getStatus() {
        return status;
    }

    /**
     * Displays the full details of the task.
     * @return a formatted string with task details.
     */
    public String displayTaskDetails() {
        return "Task ID: " + taskID +
               "\nTask Name: " + taskName +
               "\nDeveloper: " + developer +
               "\nDuration: " + duration +
               "\nStatus: " + status +
               "\n---------------------------";
    }

    /**
     * Checks if the task description is no longer than 50 characters.
     * @return true if the description is valid, false otherwise.
     */
    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }
}
