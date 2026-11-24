package com.example.identity_service.config;

import com.example.identity_service.entity.UserCredential;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomeUserDetails implements UserDetails {
    private String username;
    private String password;

    public CustomeUserDetails(UserCredential userCredential){
        this.username = userCredential.getName();
        this.password =userCredential.getPassword();
    }

    /// @return
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    /// @return
    @Override
    public @Nullable String getPassword() {
        return password;
    }

    /// @return
    @Override
    public String getUsername() {
        return username;
    }

    /// @return
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /// @return
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /// @return
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /// @return
    @Override
    public boolean isEnabled() {
        return true;
    }
}
