package com.example.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.example.model.Task;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskControllerTest {
  private TaskController taskController;

  @BeforeEach
  public void setUp() {
    taskController = new TaskController();
  }

  @Test
  public void testAddTask() {
    Task task = new Task("Test Task", "This is a test task");
    taskController.addTask(task);
    List<Task> taskList = taskController.getAllTasks();
    assertEquals(1, taskList.size());
    assertTrue(taskList.contains(task));
  }

  @Test
  public void testRemoveTask() {
    Task task = new Task("Test Task", "This is a test task");
    taskController.addTask(task);
    List<Task> taskList = taskController.getAllTasks();
    assertEquals(1, taskList.size());
    taskController.removeTask(task);
    taskList = taskController.getAllTasks();
    assertTrue(taskList.isEmpty());
  }

  @Test
  public void testMarkTaskCompleted() {
    Task task = new Task("Test Task", "This is a test task");
    taskController.addTask(task);
    assertFalse(task.isCompleted());
    taskController.markTaskCompleted(task, true);
    assertTrue(task.isCompleted());
  }
}
