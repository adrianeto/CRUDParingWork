package com.galvanize.h2demo.controller;

import com.galvanize.h2demo.domain.User;
import com.galvanize.h2demo.entity.EntityUser;
import com.galvanize.h2demo.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/User/{id}")
    public Optional<User> queryUserById(@PathVariable Long id) {
        return this.repository.findById(id);

    }

    @PatchMapping("/update/id/{id}")
    public Optional<User> patchUpdate(@RequestBody User userInput,@PathVariable Long id) {
        User user = this.repository.findById(id).get();
        user.setEmail(userInput.getEmail());
        user.setPassword(userInput.getPassword());

        this.repository.save(user);
        return this.repository.findById(id);
    }

   /* @DeleteMapping("/User/{id}")
    public Long deleteUser(@PathVariable Long id){
        this.repository.deleteById(id);
        return this.repository.count();
    }*/
   @DeleteMapping("/User/{id}")
  // @ResponseBody
   public String delete(@PathVariable Long id) {

       this.repository.deleteById(id);
    //   return  this.repository.count();

       return new String ("{count: " + this.repository.count()+"}");
   }

   @PostMapping("/users/authenticate")
    public AuthenticatedUser authenticateUser(@RequestBody User user){
       AuthenticatedUser auth = new AuthenticatedUser();
       User userDB =  this.repository.findByEmail(user.getEmail());
       if ( userDB != null) {
           if (user.getPassword().equals(userDB.getPassword()) )
           {


               auth.setAuthenticated(true);
               auth.setUser(Arrays.asList(userDB));
               /*  {
                   "authenticated": true,
                       "user": {
                   "id": 12,
                           "email": "angelica@example.com"
               }
               }*/
           }else {
               auth.setAuthenticated(false);
           }

       }
       return auth;
   }

   public static class AuthenticatedUser {

       private boolean authenticated;

       private List<User> user;

       public List<User> getUser() {
           return user;
       }

       public void setUser(List<User> user) {
           this.user = user;
       }

       public boolean isAuthenticated() {
           return authenticated;
       }

       public void setAuthenticated(boolean authenticated) {
           this.authenticated = authenticated;
       }

   }




    // @GetMapping("/users")
   // public List<User> retrieveUser()
}
