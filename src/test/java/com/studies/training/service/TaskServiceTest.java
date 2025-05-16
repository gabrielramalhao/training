package com.studies.training.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import com.studies.training.dto.TaskDTO;
import com.studies.training.model.Task;

import jakarta.persistence.EntityManager;

@ActiveProfiles("test")
public class TaskServiceTest {

    @Autowired
    EntityManager entityManager;

    @Autowired
    TaskService service;

    @Test
    @DisplayName("Should return expectation date less than now")
    void conclusionExpectacionSuccess() {
        TaskDTO data = new TaskDTO(null, "Limpar a casa", "Arrumar tudo", "23-12-2025");
        createTask(data);

        assertEquals("A atividade ainda possui tempo para ser concluída.",
                service.compareConclusionExpectation(data.id()));
    }

    private Task createTask(TaskDTO data) {
        Task newTask = new Task(data);
        entityManager.persist(newTask);
        return newTask;
    }
}
