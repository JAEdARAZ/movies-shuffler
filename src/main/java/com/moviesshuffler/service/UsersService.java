package com.moviesshuffler.service;

import java.util.List;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviesshuffler.model.User;
import com.moviesshuffler.repository.UserRepository;

@Service
public class UsersService implements IUsersService{

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public Iterable<User> getAllUsers() {
        Iterable<User> users = userRepository.findAll();
        return users;
    }
    
    @Override
    public void vetoPick(Integer userId) {
        User user = userRepository.findById(userId).orElse(new User());
        if(user.isVetoAvailable()) {
            user.setVetoAvailable(false);
            userRepository.save(user);
        }
    }
    
    @Override
    public void restartVetos() {
        List<User> users = IterableUtils.toList(getAllUsers());
        if (users.size() == users.stream().filter(u -> !u.isVetoAvailable()).count()) {
            userRepository.resetAllUsersVeto();
        }
    }
    
}
