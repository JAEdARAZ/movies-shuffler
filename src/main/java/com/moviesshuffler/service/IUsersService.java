package com.moviesshuffler.service;

import com.moviesshuffler.model.User;

public interface IUsersService {
    void vetoPick(Integer userId);
    Iterable<User> getAllUsers();
    void restartVetos();
}
