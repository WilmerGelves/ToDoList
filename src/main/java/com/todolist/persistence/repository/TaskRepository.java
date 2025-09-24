package com.todolist.persistence.repository;


import com.todolist.persistence.entity.Task;
import com.todolist.persistence.enums.Priority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository  extends JpaRepository<Task, Long> {
    List<Task> findByPriority(Priority priority);
    List<Task> findByCompleted(boolean completed);
}
