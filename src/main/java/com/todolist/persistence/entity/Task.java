package com.todolist.persistence.entity;

import com.todolist.persistence.enums.Priority;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title; // obligatorio

    private String description;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    private boolean completed = false;
}
