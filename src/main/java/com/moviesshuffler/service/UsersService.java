package com.moviesshuffler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviesshuffler.model.User;
import com.moviesshuffler.repository.UserRepository;

@Service
public class UsersService implements IUsersService{

    @Autowired
    private UserRepository userRepository;
    
    public void vetoPick(Integer userId) {
        User user = userRepository.findById(userId).orElse(new User());
        if(user.isVetoAvailable()) {
            user.setVetoAvailable(false);
            userRepository.save(user);
        }
    }
    
}
