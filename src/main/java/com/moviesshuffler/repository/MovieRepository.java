package com.moviesshuffler.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.moviesshuffler.model.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer>{
    @Override
    @Query("select movie from Movie movie left join fetch movie.user")
    Iterable<Movie> findAll();
    
    List<Movie> findByUserId(Integer userId);
}
