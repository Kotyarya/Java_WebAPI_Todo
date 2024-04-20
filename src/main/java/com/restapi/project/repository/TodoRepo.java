package com.restapi.project.repository;

import com.restapi.project.entity.ToDoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<ToDoEntity, Long> {
}
