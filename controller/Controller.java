package com.galvanize.h2demo.controller;

import com.galvanize.h2demo.domain.User;
import com.galvanize.h2demo.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    private final UserRepository repository;

    public Controller(UserRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/list")
    public Iterable<User> list() {
        return this.repository.findAll();
    }

    @PostMapping("/User")
    public User createUser (@RequestBody User user) {
        return this.repository.save(user);
    }

   /* @GetMapping("/User/{id}")
    public User queryUserById(@PathVariable Long id) {
        return this.repository.findById(id);

    }*/

   // @GetMapping("/users")
   // public List<User> retrieveUser()
}
