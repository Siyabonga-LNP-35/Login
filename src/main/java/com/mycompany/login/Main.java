/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.login;
import javax.swing.*;
import java.util.ArrayList;

/**
 * Represents a task with relevant details and functionality.
 * Author: RC_Student_lab
 */
public class Main {
    // Lists to store task data
public static final ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Login login = new Login();

        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        // Register and authenticate user
        if (!login.registerUser() || !login.loginUser()) {
            JOptionPane.showMessageDialog(null, "Exiting...");
            return;
        }

        // Main application loop
        boolean running = true;
        while (running) {
            // Present main menu options
            String[] options = {"Add tasks", "Show report", "Quit"};
            int choice = JOptionPane.showOptionDialog(null, "Choose an option:", "Main Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0 -> addTasks();      // Option to add tasks
                case 1 -> showReport();    // Option to show report
                case 2 -> {
                    running = false;       // Quit application
                    JOptionPane.showMessageDialog(null, "Exiting...");
                }
                default -> JOptionPane.showMessageDialog(null, "Invalid option.");
            }
        }
    }

    /**
     * Prompts the user to add multiple tasks by collecting relevant details for each task.
     */
    public static void addTasks() {
        int numTasks;
        try {
            // Prompt for the number of tasks to add
            numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks would you like to add?"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid number.");
            return;
        }

        // Loop to collect details for each task
        for (int i = 0; i < numTasks; i++) {
            String taskName = JOptionPane.showInputDialog("Enter task name:");

            // Prompt for task description with validation
            String taskDescription;
            do {
                taskDescription = JOptionPane.showInputDialog("Enter task description (max 50 characters):");
                if (taskDescription.length() > 50) {
                    JOptionPane.showMessageDialog(null, "Description too long. Enter again.");
                }
            } while (taskDescription.length() > 50);

            String developer = JOptionPane.showInputDialog("Enter developer name:");
            
            int duration;
            try {
                // Prompt for task duration
                duration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration in hours:"));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid duration.");
                return;
            }

            // Prompt for task status with predefined options
            String[] statusOptions = {"To Do", "Doing", "Done"};
            String status = (String) JOptionPane.showInputDialog(null, "Select task status:",
                    "Task Status", JOptionPane.QUESTION_MESSAGE, null, statusOptions, statusOptions[0]);

            // Create new task and add it to the list
            Task task = new Task(taskName, taskDescription, developer, duration, i, status);
            tasks.add(task);
            JOptionPane.showMessageDialog(null, "Task successfully captured!");
        }
    }

    /**
     * Displays a report of all tasks, showing tasks marked as "Done", the task with the longest duration,
     * and the full details of each task.
     */
    public static void showReport() {
        StringBuilder doneTasks = new StringBuilder("Tasks with status 'Done':\n");
        tasks.stream()
             .filter(task -> "Done".equalsIgnoreCase(task.getStatus()))
             .forEach(task -> doneTasks.append("Developer: ").append(task.getDeveloper())
                                       .append(", Task: ").append(task.getTaskName())
                                       .append(", Duration: ").append(task.getDuration()).append(" hours\n"));

        // Find and display the task with the longest duration
        Task longestTask = tasks.stream().max((t1, t2) -> Integer.compare(t1.getDuration(), t2.getDuration())).orElse(null);
        String longestTaskInfo = (longestTask != null) ? 
                "Task with longest duration: Developer: " + longestTask.getDeveloper() + ", Duration: " + longestTask.getDuration() + " hours" : 
                "No tasks available.";

        // Display full report
        StringBuilder fullReport = new StringBuilder("Full Task Report:\n");
        tasks.forEach(task -> fullReport.append(task.displayTaskDetails()).append("\n"));

        JOptionPane.showMessageDialog(null, doneTasks + "\n" + longestTaskInfo + "\n\n" + fullReport);
    }
}
