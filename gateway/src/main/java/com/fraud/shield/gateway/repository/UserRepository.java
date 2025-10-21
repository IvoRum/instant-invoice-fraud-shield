package com.fraud.shield.gateway.repository;

import com.fraud.shield.gateway.domain.dto.User;
import com.fraud.shield.gateway.repository.mapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     *  Finds a user by their email.
     *
     * @param email the email of the user to find
     * @return the UserDTO object corresponding to the given email
     */
    public Optional<User> findUserByEmail(final String email) {
        assert email != null && !email.isBlank() : "Email must not be null or blank";

        final String sql = "SELECT * FROM user WHERE email = ?";

        return jdbcTemplate.query(sql, new Object[]{email}, new UserRowMapper())
                           .stream()
                           .findFirst();
    }
}
