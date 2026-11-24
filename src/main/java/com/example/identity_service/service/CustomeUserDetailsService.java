package com.example.identity_service.service;

import com.example.identity_service.config.CustomeUserDetails;
import com.example.identity_service.entity.UserCredential;
import com.example.identity_service.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomeUserDetailsService implements UserDetailsService {

    @Autowired
    private UserCredentialRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserCredential> credential = repository.findByName(username);
        return credential.map(CustomeUserDetails::new).orElseThrow(()-> new UsernameNotFoundException("User not found with name "+username));
    }
}
