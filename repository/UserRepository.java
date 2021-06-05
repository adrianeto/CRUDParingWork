package com.galvanize.h2demo.repository;

import com.galvanize.h2demo.domain.User;
import com.galvanize.h2demo.entity.EntityUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {


        User findByEmail(String email);

        Optional<User> findById(Long id);


}
