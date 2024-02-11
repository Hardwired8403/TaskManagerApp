package com.example.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
  @Test
  public void testTaskCreation() {
    Task task = new Task("Test Task", "This is a test task");
    assertNotNull(task);
    assertEquals("Test Task", task.getName());
    assertEquals("This is a test task", task.getDescription());
    assertFalse(task.isCompleted());
  }

  @Test
  public void testTaskCompletion() {
    Task task = new Task("Test Task", "This is a test task");
    assertFalse(task.isCompleted());
    task.setCompleted(true);
    assertTrue(task.isCompleted());
  }

  @Test
  public void testEqualsAndHashCode() {
    Task task1 = new Task("Task 1", "Description 1");
    Task task2 = new Task("Task 1", "Description 1");
    Task task3 = new Task("Task 2", "Description 2");

    assertEquals(task1, task2);
    assertNotEquals(task1, task3);

    assertEquals(task1.hashCode(), task2.hashCode());
    assertNotEquals(task1.hashCode(), task3.hashCode());
  }
}
