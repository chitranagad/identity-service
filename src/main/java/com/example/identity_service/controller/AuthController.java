package com.example.identity_service.controller;

import com.example.identity_service.entity.UserCredential;
import com.example.identity_service.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserCredential user){
        return authService.saveUser(user);
    }
    @GetMapping("/token")
    public String getToken(UserCredential userCredential){
     return authService.generateToken(userCredential.getName());
    }

    @GetMapping("/validate")
    public String validatedToken(@RequestParam("token") String token){
     authService.validateToken(token);
     return "Token is valid";
    }
}
