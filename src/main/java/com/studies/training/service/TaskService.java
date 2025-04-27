package com.studies.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studies.training.exceptions.IdNotFoundException;
import com.studies.training.exceptions.InvalidInputException;
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
        var obj = repository.findById(id).orElseThrow(() -> new IdNotFoundException());
        return obj;
    }

    public Task insert(Task task) {
        if (task.getName() == "" || task.getContent() == "") {
            throw new InvalidInputException();
        }
        return repository.save(task);
    }

    public void remove(long id) {
        repository.deleteById(id);
    }

    public Task update(Task task, long id) {
        var obj = repository.findById(id).orElseThrow(() -> new IdNotFoundException());
        if (task.getName() == "" || task.getContent() == "") {
            throw new InvalidInputException();
        }
        taskUpdate(obj, task);
        return repository.save(obj);
    }

    private void taskUpdate(Task entity, Task obj) {
        entity.setName(obj.getName());
        entity.setContent(obj.getContent());
    }
}
