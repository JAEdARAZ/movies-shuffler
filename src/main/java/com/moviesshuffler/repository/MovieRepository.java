package com.moviesshuffler.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.moviesshuffler.model.Movie;

public interface MovieRepository extends CrudRepository<Movie, Integer>{
    List<Movie> findByUserId(Integer userId);
}
