package com.example.cadastrousuario.controllers;

import com.example.cadastrousuario.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity getUsers() {
        var allUsers = userRepository.findAll();
        return ResponseEntity.ok(allUsers);
    }


}
