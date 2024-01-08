package com.busta.restapi.services;

import com.busta.restapi.exceptions.DuplicateUserException;
import com.busta.restapi.repository.UserRepository;
import com.busta.restapi.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        Boolean userExist=userRepository.existsByEmail(user.getEmail());
        if(userExist){
            throw new DuplicateUserException("user with email already exists");
        }
        return userRepository.save(user);
    }

    public User findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
