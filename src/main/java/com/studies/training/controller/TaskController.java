package com.studies.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studies.training.dto.TaskDTO;
import com.studies.training.model.Task;
import com.studies.training.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping
    public ResponseEntity<List<Task>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/{id}/check")
    public ResponseEntity<Task> checkedTask(@PathVariable long id) {
        return ResponseEntity.ok(service.checkedTask(id));
    }

    @GetMapping("/{id}/conclusion")
    public ResponseEntity<String> compareConclusionExpectation(@PathVariable long id) {
        return ResponseEntity.ok(service.compareConclusionExpectation(id));
    }

    @PostMapping
    public ResponseEntity<Task> insert(@Valid @RequestBody TaskDTO task) {
        var obj = service.insert(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable long id) {
        service.remove(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@Valid @RequestBody TaskDTO task, @PathVariable long id) {
        return ResponseEntity.ok(service.update(task, id));
    }
}
