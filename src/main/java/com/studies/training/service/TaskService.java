package com.studies.training.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studies.training.dto.TaskDTO;
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

    public Task insert(TaskDTO task) {
        if (task.name() == "" || task.content() == "") {
            throw new InvalidInputException();
        }
        return repository.save(new Task(task.name(), task.content(), task.conclusionExpectacion()));
    }

    public void remove(long id) {
        var obj = repository.findById(id).orElseThrow(() -> new IdNotFoundException());
        repository.deleteById(obj.getId());
    }

    public Task checkedTask(long id) {
        var obj = repository.findById(id).orElseThrow(() -> new IdNotFoundException());
        obj.setChecked(!obj.getIsChecked());
        return repository.save(obj);
    }

    public String compareConclusionExpectation(long id) {
        var obj = repository.findById(id).orElseThrow(() -> new IdNotFoundException());
        var currentConclusionExpectation = parse(obj.getConclusionExpectacion());
        var currentTime = Instant.now();
        if (currentConclusionExpectation.isBefore(currentTime)) {
            repository.deleteById(obj.getId());
            return "A atividade venceu e será excluída.";
        }
        return "A atividade ainda possui tempo para ser concluída.";
    }

    public Task update(TaskDTO task, long id) {
        var obj = repository.findById(id).orElseThrow(() -> new IdNotFoundException());
        if (task.name() == "" || task.content() == "") {
            throw new InvalidInputException();
        }
        taskUpdate(obj, task);
        return repository.save(obj);
    }

    private void taskUpdate(Task entity, TaskDTO obj) {
        entity.setName(obj.name());
        entity.setContent(obj.content());
        entity.setConclusionExpectacion(obj.conclusionExpectacion());
    }

    private Instant parse(String dateTimeString) {
        ZoneId zoneId = ZoneId.of("GMT-3");
        DateTimeFormatter dmt = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        if (dateTimeString == null || dateTimeString.isEmpty()) {
            throw new InvalidInputException();
        }
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeString, dmt);
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        return zonedDateTime.toInstant();
    }
}
