/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @BeforeEach
    public void setUp() {
        Main.tasks.clear(); // Clear tasks before each test
    }

    @Test
    public void testAddSingleTask() {
        Task task = new Task("Feature", "Implement feature", "DevTwo", 8, 1, "Doing");
        Main.tasks.add(task);

        assertEquals(1, Main.tasks.size());
        assertEquals("Feature", Main.tasks.get(0).getTaskName());
        assertEquals("Doing", Main.tasks.get(0).getStatus());
    }
}
