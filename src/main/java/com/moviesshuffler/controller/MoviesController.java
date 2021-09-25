package com.moviesshuffler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.moviesshuffler.model.Movie;
import com.moviesshuffler.repository.MovieRepository;

@RestController
@RequestMapping("/movies")
public class MoviesController {
    
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("")
    public @ResponseBody Iterable<Movie> getMovies() {
        return movieRepository.findAll();
    }
    
    @GetMapping("/{userId}")
    public @ResponseBody Iterable<Movie> getMoviesByUserId(@PathVariable Integer userId) {
        return movieRepository.findByUserId(userId);
    }

}
