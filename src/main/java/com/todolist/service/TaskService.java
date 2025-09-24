package com.todolist.service;

import com.todolist.persistence.entity.Task;
import com.todolist.persistence.enums.Priority;
import com.todolist.persistence.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public Task addTask(Task task) {
        if (task.getTitle() == null || task.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("El título no puede estar vacío");
        }
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getByPriority(Priority priority) {
        return taskRepository.findByPriority(priority);
    }

    public List<Task> getByStatus(boolean completed) {
        return taskRepository.findByCompleted(completed);
    }

    public Task completeTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID no encontrado"));
        task.setCompleted(true);
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new IllegalArgumentException("ID no encontrado");
        }
        taskRepository.deleteById(id);
    }
}
