package com.moviesshuffler.controller;

import java.util.List;

import com.moviesshuffler.model.Movie;

public interface IUsersController {
    List<Movie> getUserMovies(Integer userId);
    void vetoPick(Integer userId);
}
