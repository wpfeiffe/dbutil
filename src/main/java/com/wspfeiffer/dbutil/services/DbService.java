package com.wspfeiffer.dbutil.services;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbService {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public DbService(final NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<UserAccount> runSql(String sql) {
        return jdbcTemplate.query(sql, (rs, rowNum) -> new UserAccount(rs.getLong("id"), rs.getInt("version"),
                                                                       rs.getString("username"), rs.getString("email"),
                                                                       rs.getString("first_name"),
                                                                       rs.getString("last_name"),
                                                                       rs.getBoolean("active"),
                                                                       rs.getLong("organization_id")));
    }

    public static class UserAccount {

        public long id;
        public int version;
        public String userName;
        public String email;
        public String firstName;
        public String lastName;
        public Boolean active;
        public long organizationId;

        public UserAccount(final long id, final int version, final String userName, final String email, final String firstName, final String lastName, final Boolean active, final long organizationId) {
            this.id = id;
            this.version = version;
            this.userName = userName;
            this.email = email;
            this.firstName = firstName;
            this.lastName = lastName;
            this.active = active;
            this.organizationId = organizationId;
        }

        @Override
        public String toString() {
            return "UserAccount{" +
                    "id=" + id +
                    ", version=" + version +
                    ", userName='" + userName + '\'' +
                    ", email='" + email + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", active=" + active +
                    ", organizationId=" + organizationId +
                    '}';
        }
    }
}
