package com.fraud.shield.gateway.domain.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;

public class User implements UserDetails {
    private final Long id;
    private final String email;
    private final String password;
    private final Timestamp createdAt;
    private final UserRole role;

    public User(final Long id,final String email,final String password,
                final Timestamp createdAt,final UserRole role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }
}
