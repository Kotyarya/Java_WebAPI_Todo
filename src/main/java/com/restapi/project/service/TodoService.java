package com.restapi.project.service;

import com.restapi.project.entity.ToDoEntity;
import com.restapi.project.entity.UserEntity;
import com.restapi.project.exception.TodoNotFoundException;
import com.restapi.project.exception.UserNotFoundException;
import com.restapi.project.model.Todo;
import com.restapi.project.repository.TodoRepo;
import com.restapi.project.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;

    public Todo create(ToDoEntity toDo, Long userId) throws UserNotFoundException {

        UserEntity user = userRepo.findById(userId).get();

        if (user == null) {
            throw new UserNotFoundException("User Not Exist");
        }

        toDo.setUser(user);

        return Todo.toModel(todoRepo.save(toDo));
    }

    public Todo complete(Long id) throws TodoNotFoundException {
        ToDoEntity toDo = todoRepo.findById(id).get();

        if (toDo == null) {
            throw new TodoNotFoundException("Todo Not Found");
        }

        toDo.setCompleted(!toDo.isCompleted());
        return Todo.toModel(todoRepo.save(toDo));
    }



}
