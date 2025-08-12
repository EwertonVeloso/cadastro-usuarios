package com.example.cadastrousuario.controllers;

import com.example.cadastrousuario.domain.RequestUser;
import com.example.cadastrousuario.domain.User;
import com.example.cadastrousuario.domain.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public ResponseEntity getUsers() {
         var allUsers = repository.findAll();
         System.out.println(allUsers);
         return ResponseEntity.ok(allUsers);
    }

    @GetMapping("/by-email")
    public ResponseEntity getUserByEmail(@RequestParam String email) {
        var user =  repository.findByEmail(email);
        System.out.println(user);

        if(user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody @Valid RequestUser data){
        User newUser = new User(data);
        repository.save(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }








}
