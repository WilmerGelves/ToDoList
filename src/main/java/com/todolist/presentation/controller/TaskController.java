package com.todolist.presentation.controller;

import com.todolist.persistence.entity.Task;
import com.todolist.persistence.enums.Priority;
import com.todolist.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @GetMapping
    public List<Task> getAll() {
        return taskService.getAllTasks();
    }

    @GetMapping("/priority/{priority}")
    public List<Task> getByPriority(@PathVariable Priority priority) {
        return taskService.getByPriority(priority);
    }

    @GetMapping("/status/{completed}")
    public List<Task> getByStatus(@PathVariable boolean completed) {
        return taskService.getByStatus(completed);
    }

    @PutMapping("/{id}/complete")
    public Task complete(@PathVariable Long id) {
        return taskService.completeTask(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
