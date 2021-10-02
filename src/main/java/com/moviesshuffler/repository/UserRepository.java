package com.moviesshuffler.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.moviesshuffler.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Modifying
    @Query("update User user set user.vetoAvailable = true")
    void resetAllUsersVeto();
}
