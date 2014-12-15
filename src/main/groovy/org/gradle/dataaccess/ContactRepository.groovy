package org.gradle.dataaccess

import java.sql.ResultSet
import java.sql.SQLException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository

@Repository
class ContactRepository {

    @Autowired
    JdbcTemplate jdbcTemplate
    
    List<Contact> findAllContacts() {
        jdbcTemplate.query("SELECT * FROM Contact", contactMapper)
    }
    
    static final RowMapper<Contact> contactMapper = new RowMapper<Contact>() {
        public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
            Contact contact = new Contact(rs.getInt("id"), rs.getString("name"));
            return contact;
        }
    };
}
