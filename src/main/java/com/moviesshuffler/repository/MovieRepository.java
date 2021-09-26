package com.moviesshuffler.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.moviesshuffler.model.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer>{
    List<Movie> findByUserId(Integer userId);
}
