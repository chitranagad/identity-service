package com.example.identity_service.repository;

import com.example.identity_service.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCredentialRepository extends JpaRepository<UserCredential, Integer> {
}
