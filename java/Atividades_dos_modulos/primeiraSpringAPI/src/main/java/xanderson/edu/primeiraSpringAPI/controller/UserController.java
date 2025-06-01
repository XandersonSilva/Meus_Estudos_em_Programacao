package xanderson.edu.primeiraSpringAPI.controller;

import java.util.List;

import xanderson.edu.primeiraSpringAPI.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import xanderson.edu.primeiraSpringAPI.repository.UserRepository;

@RestController
public class UserController {
    @Autowired
    private UserRepository repository;

    @GetMapping("/users")
    public List<User> getUsers(){
        return repository.listAll();
    }

    @GetMapping("/user/{id}")
    public User getOne(@PathVariable("id") Integer id){
        return repository.finById(id);
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable("id") Integer id){
        repository.remove(id);
    }
    
    @PostMapping("/user")
    public void postUser(@RequestBody User user){
        repository.save(user);
    }
}
