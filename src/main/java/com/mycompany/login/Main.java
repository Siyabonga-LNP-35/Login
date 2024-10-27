/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.login;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 *
 * @author siyab
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Login login = new Login();
        ArrayList<Task> taskList = new ArrayList<>();
        int totalHours = 0;

        // Registration
        String username = JOptionPane.showInputDialog("Enter username (must contain an underscore and no more than 5 characters):");
        String password = JOptionPane.showInputDialog("Enter password (must contain 8 characters, a capital letter, a number, and a special character):");
        String firstName = JOptionPane.showInputDialog("Enter your first name:");
        String lastName = JOptionPane.showInputDialog("Enter your last name:");

        String registrationMessage = login.registerUser(username, password, firstName, lastName);
        JOptionPane.showMessageDialog(null, registrationMessage);

        if (!registrationMessage.equals("User successfully registered.")) {
            System.exit(0);
        }

        // Login
        username = JOptionPane.showInputDialog("Enter your username to log in:");
        password = JOptionPane.showInputDialog("Enter your password to log in:");

        String loginMessage = login.returnLoginStatus(username, password);
        JOptionPane.showMessageDialog(null, loginMessage);

        if (loginMessage.contains("incorrect")) {
            System.exit(0);
        }

        // Main menu using switch case
        while (true) {
            String[] options = {"1", "2", "3"};
            String option = (String) JOptionPane.showInputDialog(null, "Welcome to EasyKanban. Please select an option:\n1. Add Task\n2. Show Report (Coming Soon)\n3. Quit", "Menu", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            switch (option) {
                case "1":
                    int numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks would you like to add?"));
                    for (int i = 0; i < numTasks; i++) {
                        String taskName = JOptionPane.showInputDialog("Enter task name:");
                        String taskDescription = JOptionPane.showInputDialog("Enter task description (less than 50 characters):");
                        if (taskDescription.length() > 50) {
                            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.");
                            continue;
                        }
                        String developerDetails = JOptionPane.showInputDialog("Enter developer's full name:");
                        int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration (in hours):"));
                        String[] statuses = {"To Do", "Doing", "Done"};
                        String taskStatus = (String) JOptionPane.showInputDialog(null, "Select task status:", "Status", JOptionPane.QUESTION_MESSAGE, null, statuses, statuses[0]);

                        // Create and store the task
                        Task task = new Task(taskName, taskDescription, developerDetails, taskDuration, taskStatus);
                        taskList.add(task);
                        totalHours += taskDuration;

                        task.printTaskDetails();
                    }
                    JOptionPane.showMessageDialog(null, "Total task duration: " + totalHours + " hours.");
                    break;

                case "2":
                    JOptionPane.showMessageDialog(null, "Coming Soon");
                    break;

                case "3":
                    JOptionPane.showMessageDialog(null, "Exiting application.");
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid option, please try again.");
                    break;
            }
        }
    }
}