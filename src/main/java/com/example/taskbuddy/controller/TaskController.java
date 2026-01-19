package com.example.taskbuddy.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taskbuddy.model.Task;
import com.example.taskbuddy.service.TaskService;

// API layer (REST)
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // POST - Create
    @PostMapping
    public Task create(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    // GET - Read all
    @GetMapping
    public List<Task> getAll() {
        return taskService.getAllTasks();
    }

    // GET - Read by id
    @GetMapping("/{id}")
    public Task getById(@PathVariable int id) {
        return taskService.getTaskById(id);
    }

    // PUT - Update
    @PutMapping("/{id}")
    public Task update(@PathVariable int id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return taskService.deleteTask(id)
                ? "Task deleted"
                : "Task not found";
    }
}
