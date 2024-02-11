package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Task;

public class TaskController {
  private List<Task> taskList;

  public TaskController() {
    this.taskList = new ArrayList<>();
  }

  public void addTask(Task task) {
    taskList.add(task);
  }

  public void removeTask(Task task) {
    taskList.remove(task);
  }

  public List<Task> getAllTasks() {
    return new ArrayList<>(taskList);
  }

  public void markTaskCompleted(Task task, boolean completed) {
    task.setCompleted(completed);
  }
}
