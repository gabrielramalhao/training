package com.studies.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studies.training.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
