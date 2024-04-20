package com.restapi.project.service;

import com.restapi.project.entity.UserEntity;
import com.restapi.project.exception.UserAlreadyExistException;
import com.restapi.project.exception.UserNotFoundException;
import com.restapi.project.model.User;
import com.restapi.project.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UserRepo userRepo;


    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {

            if (userRepo.findByUsername(user.getUsername()) != null) {
                throw new UserAlreadyExistException("User already exist");
            }
            return userRepo.save(user);
    }

    public User getOne(Long id) throws UserNotFoundException {
        UserEntity userEntity = userRepo.findById(id).get();

        if (userEntity == null) {
            throw new UserNotFoundException("User Not Found");
        }

        return User.toModel(userEntity);
    }


    public String deleteUser(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        userRepo.deleteById(id);
        return user.getUsername();
    }
}
