package com.studies.training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studies.training.model.Task;
import com.studies.training.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public List<Task> findAll() {
        return repository.findAll();
    }

    public Task findById(long id) {
        Optional<Task> obj = repository.findById(id);
        return obj.get();
    }

    public Task insert(Task task) {
        return repository.save(task);
    }

    public void remove(long id) {
        repository.deleteById(id);
    }

    public Task update(Task task, long id) {
        var obj = repository.findById(id).orElseThrow();
        taskUpdate(obj, task);
        return repository.save(obj);
    }

    private void taskUpdate(Task entity, Task obj) {
        entity.setName(obj.getName());
        entity.setContent(obj.getContent());
    }
}
