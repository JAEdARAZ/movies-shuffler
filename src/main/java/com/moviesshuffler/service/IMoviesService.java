package com.moviesshuffler.service;

import java.util.List;

import com.moviesshuffler.model.Movie;

public interface IMoviesService {
    Iterable<Movie> getAllMovies();
    List<Movie> getMoviesByUserId(Integer userId);
    Movie pickRandomly();
}
