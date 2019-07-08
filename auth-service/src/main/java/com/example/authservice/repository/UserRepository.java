package com.example.authservice.repository;

import com.example.authservice.model.AppUser;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<AppUser, String> {

    AppUser findByName(String name);

    @Query(
            value = "SELECT * FROM User",
            nativeQuery = true
    )
    List<AppUser> getAllUser();

}
