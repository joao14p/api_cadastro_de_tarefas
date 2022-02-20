package com.viceri.controllers;

import com.viceri.repositories.UserRepository;
import entities.Users;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository repo;

    @GetMapping
    public List<Users> listar(){
        return repo.findAll();
    }

    @PostMapping
    public Users adsUser(@RequestBody Users users){
        return repo.save(users);
    }


}
