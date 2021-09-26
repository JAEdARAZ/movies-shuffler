package com.moviesshuffler.controller;

import com.moviesshuffler.model.Movie;

public interface IMoviesController {
    Iterable<Movie> getMovies();
    Movie pickRandomly();
}
