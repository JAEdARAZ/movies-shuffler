package com.moviesshuffler.service;

import java.util.List;

import com.moviesshuffler.model.User;

public interface IUsersService {
    List<User> restartVetos(boolean withVeto);
    void vetoPick(Integer userId);
    Iterable<User> getAllUsers();
}
