package com.example.model;

import java.util.Objects;

public class Task {
  private String name;
  private String description;
  private boolean completed;

  public Task(String name, String description) {
    this.name = name;
    this.description = description;
    this.completed = false;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isCompleted() {
    return completed;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Task task = (Task)obj;
    return completed == task.completed &&
            Objects.equals(name, task.name) &&
            Objects.equals(description, task.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, completed);
  }

  @Override
  public String toString() {
    return "Task [name=" + name + ", description=" + description + ", completed=" + completed + "]";
  }
}
