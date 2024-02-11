package com.example.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.example.controller.TaskController;
import com.example.model.Task;

public class TaskManagerApp {
  private JFrame frame;
  private TaskController taskController;
  private DefaultListModel<Task> taskListModel;
  private JList<Task> taskList;

  public TaskManagerApp() {
    taskController = new TaskController();
    initialize();
  }

  private void initialize() {
    frame = new JFrame("Task Manager");
    frame.setSize(400, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel(new BorderLayout());
    JPanel buttonPanel = new JPanel(new FlowLayout());
    JButton addButton = new JButton("Add Task");
    JButton removeButton = new JButton("Remove Task");

    taskListModel = new DefaultListModel<>();
    taskList = new JList<>(taskListModel);
    JScrollPane scrollPane = new JScrollPane(taskList);

    addButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String name = JOptionPane.showInputDialog(frame, "Enter task name");
        if (name != null && !name.isEmpty()) {
          String description = JOptionPane.showInputDialog(frame, "Enter task description:");
          Task task = new Task(name, description);
          taskController.addTask(task);
          taskListModel.addElement(task);
        }
      }
    });

    removeButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Task selectedTask = taskList.getSelectedValue();
        if (selectedTask != null) {
          taskController.removeTask(selectedTask);
          taskListModel.removeElement(selectedTask);
        } else {
          JOptionPane.showMessageDialog(frame, "Please select a task to remove");
        }
      }
    });

    buttonPanel.add(addButton);
    buttonPanel.add(removeButton);

    panel.add(scrollPane, BorderLayout.CENTER);
    panel.add(buttonPanel, BorderLayout.SOUTH);

    frame.getContentPane().add(panel);

    frame.setVisible(true);
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          new TaskManagerApp();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
}
