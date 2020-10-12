package org.tutoring.db.connectivity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements ResultMapper, RowMapper<Book> {
    @Override
    public Book newItem(ResultSet rs) throws SQLException {
        return new Book(rs.getString("Title"));
    }

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Book(rs.getString("Title"));
    }
}
