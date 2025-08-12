package com.example.cadastrousuario.controllers;

import com.example.cadastrousuario.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity getUsers() {
         var allUsers = userRepository.findAll();
         System.out.println(allUsers);
         return ResponseEntity.ok(allUsers);
    }

    @GetMapping("/by-email")
    public ResponseEntity getUserByEmail(@RequestParam String email) {
        var user =  userRepository.findByEmail(email);
        System.out.println(user);

        if(user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }






}
