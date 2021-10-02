package com.moviesshuffler.service;

import java.util.List;
import java.util.Random;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.moviesshuffler.model.Movie;
import com.moviesshuffler.repository.MovieRepository;

@Service
public class MoviesService implements IMoviesService{

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Iterable<Movie> getAllMovies() {
        Iterable<Movie> movies =  movieRepository.findAll();
        return movies;
    }

    @Override
    public List<Movie> getMoviesByUserId(@PathVariable Integer userId) {
        return movieRepository.findByUserId(userId);
    }

    @Override
    public Movie pickRandomly() {
        List<Movie> movies = IterableUtils.toList(getAllMovies());
        return movies.get(new Random().nextInt(movies.size()));
    }

    public void confirmPick(Integer movieId) {
        movieRepository.deleteById(movieId);
    }

}
