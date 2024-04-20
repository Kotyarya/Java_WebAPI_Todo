package com.restapi.project.controller;

import com.restapi.project.entity.ToDoEntity;
import com.restapi.project.exception.UserNotFoundException;
import com.restapi.project.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;


    @PostMapping
    public ResponseEntity create(@RequestBody ToDoEntity toDo, @RequestParam Long userId) {
        try {
            return ResponseEntity.ok(todoService.create(toDo, userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity complete(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(todoService.complete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
