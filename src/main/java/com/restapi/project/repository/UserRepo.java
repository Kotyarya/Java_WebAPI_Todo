package com.restapi.project.repository;

import com.restapi.project.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo  extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
