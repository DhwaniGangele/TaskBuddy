package com.example.taskbuddy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.taskbuddy.model.Task;

// OOPS: Abstraction (service hides internal logic)
@Service
public class TaskService {

    // COLLECTIONS: ArrayList to store tasks
    private final List<Task> tasks = new ArrayList<>();

    private int nextId = 1;

    // CRUD: Create
    public Task createTask(Task task) {
        task.setId(nextId++);
        tasks.add(task);
        return task;
    }

    // CRUD: Read all
    public List<Task> getAllTasks() {
        return tasks;
    }

    // CRUD: Read by id
    public Task getTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null; // null handling (collection topic)
    }

    // CRUD: Update
    public Task updateTask(int id, Task updatedTask) {
        Task existing = getTaskById(id);
        if (existing != null) {
            existing.setTitle(updatedTask.getTitle());
            existing.setDescription(updatedTask.getDescription());
            existing.setStatus(updatedTask.getStatus());
        }
        return existing;
    }

    // CRUD: Delete
    public boolean deleteTask(int id) {
        Task task = getTaskById(id);
        return tasks.remove(task);
    }
}
