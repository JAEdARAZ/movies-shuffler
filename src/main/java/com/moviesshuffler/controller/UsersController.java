package com.moviesshuffler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviesshuffler.model.Movie;
import com.moviesshuffler.model.User;
import com.moviesshuffler.service.IMoviesService;
import com.moviesshuffler.service.IUsersService;

@RestController
@RequestMapping("/users")
public class UsersController implements IUsersController{

    @Autowired
    private IMoviesService moviesService;
    
    @Autowired
    private IUsersService usersService;

    @GetMapping("")
    public Iterable<User> getUsers(){
        return usersService.getAllUsers();
    }
    
    @Override
    @GetMapping("{userId}/movies")
    public List<Movie> getUserMovies(@PathVariable Integer userId) {
        return moviesService.getMoviesByUserId(userId);
    }

    @Override
    @PostMapping("{userId}/veto")
    public void vetoPick(@PathVariable Integer userId) {
        usersService.vetoPick(userId);
    }
    
}
