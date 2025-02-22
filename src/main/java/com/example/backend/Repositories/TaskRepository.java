package com.example.backend.Repositories;


import com.example.backend.Domains.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
