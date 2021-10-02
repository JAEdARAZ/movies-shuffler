package com.moviesshuffler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.moviesshuffler.model.Movie;
import com.moviesshuffler.service.IMoviesService;

@RestController
@RequestMapping("/movies")
public class MoviesController implements IMoviesController {

    @Autowired
    private IMoviesService moviesService;

    @Override
    @GetMapping("")
    public @ResponseBody Iterable<Movie> getMovies() {
        return moviesService.getAllMovies();
    }

    @Override
    @GetMapping("/pick")
    public Movie pickRandomly() {
        return moviesService.pickRandomly();
    }
    
    @PostMapping("/{movieId}/confirm")
    public void confirmPick(@PathVariable Integer movieId) {
        moviesService.confirmPick(movieId);
    }

}
