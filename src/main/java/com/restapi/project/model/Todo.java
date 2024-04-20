package com.restapi.project.model;

import com.restapi.project.entity.ToDoEntity;
import com.restapi.project.entity.UserEntity;

public class Todo {

    private Long id;
    private String title;
    private boolean completed;
    private Long userId;


    public static Todo toModel(ToDoEntity toDoEntity) {
        Todo todo = new Todo();
        todo.setId(toDoEntity.getId());
        todo.setCompleted(toDoEntity.isCompleted());
        todo.setTitle(toDoEntity.getTitle());
        todo.setUserId(toDoEntity.getUser().getId());

        return todo;
    }

    public Todo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
