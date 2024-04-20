package com.restapi.project.model;

import com.restapi.project.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class User {

    private Long id;
    private String username;
    private List<Todo> todos;

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }

    public static User toModel(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setUsername(userEntity.getUsername());
        user.setTodos(userEntity.getTodos().stream().map(Todo::toModel).collect(Collectors.toList()));
        return user;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
