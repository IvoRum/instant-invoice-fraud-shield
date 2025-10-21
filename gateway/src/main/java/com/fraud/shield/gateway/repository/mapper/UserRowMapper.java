package com.fraud.shield.gateway.repository.mapper;

import com.fraud.shield.gateway.domain.dto.User;
import com.fraud.shield.gateway.domain.dto.UserRole;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Maps a row from the ResultSet to a UserDTO object.
 */
public class UserRowMapper implements RowMapper<User> {
    /**
     *  Maps a single row of the given ResultSet to a UserDTO object.
     *
     * @param rs     the {@code ResultSet} to map (pre-initialized for the current row)
     * @param rowNum the number of the current row
     * @return the resulting UserDTO object
     * @throws SQLException if a SQLException is encountered getting column values
     */
    @Override
    public User mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        return new User(
                rs.getLong("id"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getTimestamp("created_at"),
                rs.getString("role").isEmpty() ? null : Enum.valueOf(
                        UserRole.class,
                        rs.getString("role")
                )
        );
    }
}
