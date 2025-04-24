package com.studies.training.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studies.training.model.Task;

@RestController
public class TaskController {

    private static final AtomicLong id = new AtomicLong();
    private final String bookName = "%s";
    private final String bookContent = "%s";

    @GetMapping("/task")
    public Task task(@RequestParam(value = "name", defaultValue = "Unnamed Book") String name, @RequestParam(value = "content", defaultValue = "") String content) {
        return new Task(id.incrementAndGet(), String.format(bookName, name), String.format(bookContent, content));
    }
}
